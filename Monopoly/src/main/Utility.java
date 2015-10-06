package main;


public class Utility extends Property{
	
	
	public Utility(String name, Space.SpaceType type, int price, int[] rent, int mort, int house, Property.PropertyCategory category)
	{
		super(name, type, price, rent, mort, house, category);
	}
	
	public int getRent(int dice, boolean ownOtherUtility)
	{
		if(ownOtherUtility)
			return 10*dice;
		return dice*4;
	}

}
