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
	
	/// DATA MEMBERS ///
	public final int buyingPrice;
	public final int rent;	//make this an array later to maintain rent based on numHouses
	public final PropertyCategory group;
	//public final int mortVal;
	//private int numHouses;
	//private boolean isMortgaged;
	
	/// CONSTRUCTOR ///
	// note: no default constructor
	public Property(int price, int normalRent, PropertyCategory category){
		this.buyingPrice = price;
		this.rent = normalRent;
		this.group = category;
	}
}
