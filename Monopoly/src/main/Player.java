package main;

import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.Property;

/* Class:	Player
 * Purpose:	maintains all information about a given player in a game,
 * 	including bank/money information, properties owned, player's name,
 * 	player's piece in the game, etc
 */
public class Player {

	/// PlayerType enum ///
	public enum PlayerType { 
		HUMAN, COMPUTER
	}

	/// GamePieces enum ///
	public enum GamePiece { 
		RACECAR, DOG, SHOE, HAT, THIMBLE, SHIP	
	}

	/// DATA MEMBERS ///
	private String name;
	private PlayerType pType;
	private GamePiece piece;
	private int bank;
	private ArrayList<ArrayList<Property>> ownedProperties;

	// true if the player is still playing in the game
	private boolean isActive;
	// the place the player got in the game -- 1 for first, 2 for second, etc; -1 until player exits game
	private int place;

	// currLocation -- index into properties array in MainWindow, gives current location of player on board
	private int currLocation;
	
	// jailed -- greater than 0 if the player is currently in jail, indicates number of turns left in jail
	//	if he/she doesn't pay the fine or successfully roll doubles
	private int jailed;

	// labels for GUI 
	public JLabel nameL;
	public JLabel bankL;
	public JLabel propertiesL;


	/// CONSTRUCTORS ///
	// set up initial default name for players
	public Player(int id) {
		this.bank = 1500;		

		this.nameL = new JLabel();
		this.bankL = new JLabel("$" + this.bank);
		this.propertiesL = new JLabel("None");
		
		this.jailed = 0;

		setName("Player " + id);
		setpType(PlayerType.HUMAN);
		setPiece(GamePiece.values()[id % (GamePiece.values().length)]);
		setActive(true);
		this.currLocation = 0;	// start at go!
		this.ownedProperties = new ArrayList<ArrayList<Property>>();
		setPlace(-1);
	}

	// getter/setter for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.nameL.setText(this.name);
	}

	// getter for bank
	public int getBank() {
		return this.bank;
	}
	/* Function:	addToBank()
	 * Purpose:		increase player's bank by <amount>
	 */
	public void addToBank(int amount) {
		this.bank += amount;
		this.bankL.setText("$" + this.bank);
	}
	/* Function:	deductFromBank()
	 * Purpose:		reduce the player's bank by <amount>, returns the amount actually deducted, less than 
	 * 				<amount> if player is out of money
	 */
	public int deductFromBank(int amount, int playersOut) {
		if (this.bank <= amount) {
			int amountDeducted = this.bank;
			this.bank = 0;
			this.bankL.setText("$" + this.bank);

			// player is out of money, so they are out of the game
			setActive(false);
			setPlace(4-playersOut);

			//System.out.println(getName() + ", you are out of money!");

			return amountDeducted;
		}

		this.bank -= amount;
		this.bankL.setText("$" + this.bank);
		return amount;
	}
	
	/* Function:	getNetWorth()
	 * Purpose:		calculate the total worth of a player (for income tax), right now
	 * 				includes the price of ownedProperties (doesn't check if mortgaged)
	 * 				and the amount of cash in the players' bank
	 * 				TODO -- when houses added, add amount for houses/hotels on each
	 * 				property
	 */
	public int getNetWorth() {
		// worth includes cash held by player and the value of their properties
		int worth = this.bank;
		
		for (int i = 0; i < this.ownedProperties.size(); ++i){
			for (int j = 0; j < this.ownedProperties.get(i).size(); ++j) {
				worth += this.ownedProperties.get(i).get(j).getPrice();
			}
		}
		
		return worth;
	}

	// getter for properties
	public ArrayList<ArrayList<Property>> getProperties() {
		return this.ownedProperties;
	}
	// add a property to the player's holdings
	public void addProperty(Property prop) {
		boolean added = false;
		boolean canBuyHouses = false;
		for(int i = 0; i < ownedProperties.size(); i++)
		{
			if(ownedProperties.get(i).get(0).getCategory() == prop.getCategory())
			{
				ownedProperties.get(i).add(prop);
				added = true;
				canBuyHouses = checkHouse(ownedProperties.get(i));
				for(int ii = 0; ii < ownedProperties.get(i).size(); ii++)
				{
					ownedProperties.get(i).get(ii).setBuyHouse(canBuyHouses);
				}
			}
		}
		if(!added)
		{
			ArrayList<Property> l = new ArrayList<Property>();
			l.add(prop);
			ownedProperties.add(l);
		}
		
		String props = "<html>";
		for(int j = 0; j< ownedProperties.size(); j++)
		{
			props += ownedProperties.get(j).get(0).getCategory().toString() + ":";
			for(int k = 0; k < ownedProperties.get(j).size(); k++)
			{
				props += ownedProperties.get(j).get(k).getName() + ", ";
			}
			props = props.substring(0,props.length()-2) + "<br>";
		}
		props += "</html>";
		this.propertiesL.setText(props);
	}
	
	public boolean checkHouse(ArrayList<Property> props)
	{
		Property p = props.get(0);
		if(p.getType() != Space.SpaceType.NORM)
			return false;
		if(p.getCategory() == Property.PropertyCategory.DARKBLUE || p.getCategory() == Property.PropertyCategory.PURPLE)
		{
			if(props.size() != 2)
				return false;
		}
		else if(props.size() != 3)
			return false;
		
		int maxHouse = 0;
		int minHouse = 0;
		for(Property pp : props)
		{
			if(pp.getNumHouses() != 0)
					return false;
		}
		return true;
	}

	// getter/setter for player type (human or computer)
	public PlayerType getpType() {
		return pType;
	}
	public void setpType(PlayerType pType) {
		this.pType = pType;
	}

	// getter/setter for player's game piece
	public GamePiece getPiece() { 
		return piece;
	}
	public void setPiece(GamePiece piece) {
		this.piece = piece;
	}

	// getter/setter for player's location on board
	public int getCurrLocation() {
		return currLocation;
	}
	public void setCurrLocation(int currLocation) {
		this.currLocation = currLocation;
	}

	// getter/setter for status in game
	public boolean isActive() {
		return isActive;
	}
	private void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	// getter/setter for place in game
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}

	/* Function:	passedGo()
	 * Purpose:		called when the player passes all the way around the board, player gets 
	 * 				$200 and notified
	 */
	public void passedGo() {
		if (!this.isActive()) return;
		// collect money
		this.addToBank(200);
		// notify player of passing go 
		JOptionPane.showMessageDialog(null, "You passed go! Collect $200.", "Passed Go", JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("You passed go! Collect $200!");
	}
	
	/* Function:	inJail()
	 * Purpose:		returns true if the player is currently in jail
	 */
	public boolean inJail() {
		return jailed > 0;
	}
	
	/* Function:	putInJail()
	 * Purpose:		called when a player either (1) rolls doubles 3 times in a row, or 
	 * 				(2) lands on the "Go to Jail" space
	 */
	public void putInJail() {
		this.jailed = 3;
	}
	
	/* Function:	stillInJail()
	 * Purpose:		called when a player was previously in jail (ie. jailed > 0), attempted
	 * 				to roll doubles to get out, and did not
	 * 				returns true if after decrementing jailed is still > 0, else returns
	 * 				false indicating that the player has to pay the fine anyways
	 */
	public boolean stillinJail() {
		if (this.jailed == 0) return false;	//note this case should not happen
		--this.jailed;
		return inJail();
	}
	
	/* Function:	outOfJail()
	 * Purpose:		when a player pays the fine or successfully rolls doubles, this function is
	 * 				called to free the player from jail
	 */
	public void outOfJail() {
		this.jailed = 0;
	}




}
