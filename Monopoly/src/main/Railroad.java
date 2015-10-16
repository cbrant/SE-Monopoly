package main;

public class Railroad extends Property{
	
	public Railroad(String name, Space.SpaceType type, int price, int[] rent, int mort, int house, Property.PropertyCategory category)
	{
		super(name, type, price, rent, mort, house, category);
	}
	
	public int getRent(int numRR)
	{
		if(numRR < 0 || numRR > 4)
			return rent[0];
		return rent[numRR];
	}

}
