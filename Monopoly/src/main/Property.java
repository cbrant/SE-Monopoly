package main;



/* Class:	Property
 * Purpose:	maintains all information about a property object, including
 * 	constant information such as price, rent, etc and other information such
 * 	as number of houses, if it is currently mortgaged, etc
 */
public class Property {

	/// ProperyCategory enum ///
	public enum PropertyCategory {
		PURPLE, LIGHTBLUE, PINK, ORANGE, RED, YELLOW,
		GREEN, DARKBLUE, STATIONS, UTILITIES
	}
	public enum PropertyType{
		NORM, RR, UTIL, SPEC		
	}
	
	/// DATA MEMBERS ///
	private final String name;
	private final PropertyType type;
	private final int buyingPrice;
	private final int[] rent;	//make this an array later to maintain rent based on numHouses
	public final int mortVal;
	private final PropertyCategory group;
	
	// indicates the player number who owns the property -- if not yet sold, == -1
	private int owner;
	
	private int numHouses;
	//private boolean isMortgaged;
	
	/// CONSTRUCTOR ///
	// note: no default constructor
	public Property(String name, PropertyType type, int price, int[] rent, int mort, PropertyCategory category){
		this.name = name;
		this.type = type;
		this.buyingPrice = price;
		this.rent = rent;
		this.mortVal = mort;		
		this.group = category;
		this.numHouses = 0;
		this.setOwner(-1);
	}
	
	
	public void landedOn(int playerNum) {
		// first case -- not yet bought, give player option to buy
	}
	
	public String toString()
	{
		return this.name + " " + this.type + " " + this.getRent() + " " + this.group;
	}
	
	public PropertyType getType()
	{
		return this.type;
	}
	
	public int getPrice()
	{
		return this.buyingPrice;
	}
	
	public int getRent()
	{
		return this.rent[this.numHouses];
	}
	
	public PropertyCategory getCategory()
	{
		return this.group;
	}
	
	public String getName()
	{
		return this.name;
	}

	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	
}

