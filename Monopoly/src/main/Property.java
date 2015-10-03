package main;


// TODO -- make a Spaces class from which this will inherit
// TODO -- create another inheriting class for draw card spaces, tax space??
// TODO -- maybe have this be a parent class for each of the property types listed below
/* Class:	Property
 * Purpose:	maintains all information about a property object, including
 * 	constant information such as price, rent, etc and other information such
 * 	as number of houses, if it is currently mortgaged, etc
 */
public class Property extends Space {

	/// ProperyCategory enum ///
	public enum PropertyCategory {
		PURPLE, LIGHTBLUE, PINK, ORANGE, RED, YELLOW,
		GREEN, DARKBLUE, STATIONS, UTILITIES
	}
	
	/// DATA MEMBERS ///
	private final int buyingPrice;
	private final int[] rent;	//make this an array later to maintain rent based on numHouses
	private final int mortVal;
	private int	houseCost;
	private final PropertyCategory group;
	
	// indicates the player number who owns the property -- if not yet sold, == -1
	private int owner;
	private boolean forSale;
	
	private int numHouses;
	//private boolean isMortgaged;
	
	/// CONSTRUCTOR ///
	// note: no default constructor
	public Property(String name, Space.SpaceType type, int price, int[] rent, int mort, int houseCost, PropertyCategory category)
	{
		super(name, type);
		this.buyable = true;

		this.buyingPrice = price;
		this.rent = rent;
		this.mortVal = mort;		
		this.houseCost = houseCost;
		this.group = category;
		this.numHouses = 0;
		
		this.owner = -1;
		this.forSale = true;
	}
	
	
	public void landedOn(int playerNum) {
		// first case -- not yet bought, give player option to buy
	}
	
	public String toString()
	{
		return this.name + " " + this.type + " " + this.getRent() + " " + this.group;
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
	

	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public void action()
	{
		getRent();
	}
	
	
}

