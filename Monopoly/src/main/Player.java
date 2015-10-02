package main;

import java.util.Vector;

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
		CAR, DOG, SHOE, HAT		
	}
	
	/// DATA MEMBERS ///
	private String name;
	private PlayerType pType;
	private GamePiece piece;
	private int bank;
	private boolean isActive;
	private Vector<Property> ownedProperties;
	// currLocation -- index into properties array in MainWindow, gives current location of player on board
	private int currLocation;
	
	
	/// CONSTRUCTORS ///
	// set up initial default name for players
	public Player(int id) {
		this.bank = 300;		// TODO -- change this to something accurate!
		setName("Player " + id);
		setpType(PlayerType.HUMAN);
		setPiece(GamePiece.values()[id % (GamePiece.values().length)]);
		setActive(true);
		this.currLocation = 0;	// start at go!
		this.ownedProperties = new Vector<Property>();
	}
	
	// getter/setter for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		// TODO -- maybe set max length so it will display okay
		this.name = name;
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
	}
	/* Function:	deductFromBank()
	 * Purpose:		reduce the player's bank by <amount>, returns the amount actually deducted, less than 
	 * 				<amount> if player is out of money
	 */
	public int deductFromBank(int amount) {
		if (this.bank <= amount) {
			int amountDeducted = this.bank;
			this.bank = 0;
			// TODO -- here we should check if the amount goes below 0, throw an error or something
			// OR we could do this from wherever we call deductFromBank
			setActive(false);
			System.out.println("You are out of money!");
			
			return amountDeducted;
		}
		
		this.bank -= amount;
		return amount;
	}
	
	// getter for properties
	public Vector<Property> getProperties() {
		return this.ownedProperties;
	}
	// add a property to the player's holdings
	public void addProperty(Property prop) {
		this.ownedProperties.add(prop);
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
	
	/* Function:	passedGo()
	 * Purpose:		called when the player passes all the way around the board, player gets 
	 * 				$200 and notified
	 */
	public void passedGo() {
		// collect money
		this.addToBank(200);
		// TODO notify player of passing go 
		System.out.println("You passed go! Collect $200!");
	}

	
	
	
}
