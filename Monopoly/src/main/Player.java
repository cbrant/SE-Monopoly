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
	private Vector<Property> properties;

	
	/// CONSTRUCTORS ///
	// set up initial default name for players
	public Player(int id) {
		setpName("Player " + id);
		setpType(PlayerType.HUMAN);
		setpPiece(GamePiece.values()[id % (GamePiece.values().length)]);
		this.properties = new Vector<Property>();
	}
	public Player() {
		this(0);	// default id for constructor is 0
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

	
	
	
}
