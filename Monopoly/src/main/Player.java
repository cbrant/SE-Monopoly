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
	private String pName;
	private PlayerType pType;
	private GamePiece pPiece;
	private int bank;
	private boolean isActive;
	private Vector<Property> properties;
	// currLocation -- index into properties array in MainWindow, gives current location of player on board
	private int currLocation;
	
	private final int TOTALPROPERTIES;

	
	/// CONSTRUCTORS ///
	// set up initial default name for players
	public Player(int id, int totProps) {
		this.bank = 1200;		// TODO -- change this to something accurate!
		setpName("Player " + id);
		setpType(PlayerType.HUMAN);
		setpPiece(GamePiece.values()[id % (GamePiece.values().length)]);
		setActive(true);
		this.currLocation = 0;	// start at go!
		this.properties = new Vector<Property>();
		this.TOTALPROPERTIES = totProps;
	}
	
	// getter/setter for pName
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		// TODO -- maybe set max length so it will display okay
		this.pName = pName;
	}

	// getter for bank
	public int getBank() {
		return this.bank;
	}
	// operators on bank
	public void addToBank(int amount) {
		this.bank += amount;
	}
	public void deductFromBank(int amount) {
		this.bank -= amount;
	
		// TODO -- here we should check if the amount goes below 0, throw an error or something
		// OR we could do this from wherever we call deductFromBank
		if (this.bank <= 0) setActive(false);
	}
	
	// getter for properties
	public Vector<Property> getProperties() {
		return this.properties;
	}
	// add a property to the player's holdings
	public void addProperty(Property prop) {
		this.properties.add(prop);
	}
	
	// getter/setter for player type (human or computer)
	public PlayerType getpType() {
		return pType;
	}
	public void setpType(PlayerType pType) {
		this.pType = pType;
	}
	
	// getter/setter for player's game piece
	public GamePiece getpPiece() {
		return pPiece;
	}
	public void setpPiece(GamePiece pPiece) {
		this.pPiece = pPiece;
	}
	
	// getter for player's location on board
	public int getCurrLocation() {
		return currLocation;
	}
	// used when the player rolls the dice and moves around board
	// updates the player's position and checks if they pass go
	public void movePiece(int numMoves) {
		this.currLocation += numMoves;
		
		// check if passed go, need to restart around board
		if (this.currLocation >= this.TOTALPROPERTIES) {
			// pass go! collect money and notify
			passedGo();
			// put correct index in the data member
			this.currLocation %= this.TOTALPROPERTIES;
		}
	}

	public void passedGo() {
		// collect money
		this.addToBank(200);
		// TODO notify player of passing go 
		System.out.println("Congratulations, you passed go! Collect $200!");
	}

	public boolean isActive() {
		return isActive;
	}
	private void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
