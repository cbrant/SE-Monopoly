package main;

import java.util.Vector;

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
	private Vector<Property> ownedProperties;

	// true if the player is still playing in the game
	private boolean isActive;
	// the place the player got in the game -- 1 for first, 2 for second, etc; -1 until player exits game
	private int place;

	// currLocation -- index into properties array in MainWindow, gives current location of player on board
	private int currLocation;

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

		setName("Player " + id);
		setpType(PlayerType.HUMAN);
		setPiece(GamePiece.values()[id % (GamePiece.values().length)]);
		setActive(true);
		this.currLocation = 0;	// start at go!
		this.ownedProperties = new Vector<Property>();
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

	// getter for properties
	public Vector<Property> getProperties() {
		return this.ownedProperties;
	}
	// add a property to the player's holdings
	public void addProperty(Property prop) {
		this.ownedProperties.add(prop);
		String props = "<html>";
		for (int i = 0; i < this.ownedProperties.size(); ++i) {
			props += this.ownedProperties.get(i).getName();
			if (i < this.ownedProperties.size() -1 ) props += ", <br>";
		}
		props += "</html>";
		this.propertiesL.setText(props);
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

	// getter/setter for place in game
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}

	private void setActive(boolean isActive) {
		this.isActive = isActive;
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




}
