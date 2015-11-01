package main;


/* Class:	Property
 * Purpose:	maintains all information about a property object, including
 * 	constant information such as price, rent, etc and other information such
 * 	as number of houses, if it is currently mortgaged, etc
 */
public class Property extends Space {

	/// ProperyCategory enum ///
	public enum PropertyCategory {
		PURPLE, LIGHTBLUE, PINK, ORANGE, RED, YELLOW,
		GREEN, DARKBLUE, RAILROAD, UTILITIES
	}
	
	/// DATA MEMBERS ///
	private final int buyingPrice;
	protected final int[] rent;	//make this an array later to maintain rent based on numHouses
	private final int mortVal;
	private int	houseCost;
	private final PropertyCategory group;
	
	// indicates the player number who owns the property -- if not yet sold, == -1
	private int owner;
	@SuppressWarnings("unused")
	private boolean forSale;
	
	private int numHouses;
	protected boolean canBuyHouse;
	private boolean isMortgaged;
	
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
		this.canBuyHouse = false;
		
		this.owner = -1;
		this.forSale = true;
		this.isMortgaged = false;
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
		if(isMortgaged)
			return 0;
		// double rent if own all of same category, but have no houses
		if (this.numHouses == 0 && this.canBuyHouse) {
			return this.rent[0]*2;
		}
		
		return this.rent[this.numHouses];
	}
	
	public int[] getRentArray()
	{
		return this.rent;
	}
	
	public int getHouseCost()
	{
		return this.houseCost;
	}
	
	public int getMortgage()
	{
		return this.mortVal;
	}
	
	public int mortgage()
	{
		int mortValue = 0;
		if(numHouses > 0)
			mortValue += numHouses*houseCost/2;
		mortValue += mortVal;
		
		numHouses = 0;
		isMortgaged = true;
		
		return mortValue;
	}
	
	public int getUnmortgaged()
	{
		int value = (int) (this.buyingPrice/2*1.1);
		return value;		
	}
	
	public int unmortgage()
	{	
		isMortgaged = false;
		return getUnmortgaged();
	}
	
	public boolean isMortgaged()
	{
		return this.isMortgaged;
	}
	
	public PropertyCategory getCategory()
	{
		return this.group;
	}
	
	public int getNumHouses()
	{
		return this.numHouses;
	}
	
	public void setNumHouses(int num)
	{
		// 5 houses indicates that a hotel is owned
		if(num > 5)	
			num = 5;
		this.numHouses = num;
	}
	
	public boolean canBuyHouse()
	{
		return this.canBuyHouse;
	}
	
	public void setBuyHouse(boolean canBuyHouse)
	{
		this.canBuyHouse = canBuyHouse;
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

