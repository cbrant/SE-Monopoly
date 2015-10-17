package main;


public class Utility extends Property{
	
	//private static String newLine = System.getProperty("line.separator");
	
	private String cardDes = "<html><p> Pay the owner of this card 4 times the dice roll,<br> or 10 times the dice roll if two utilities are owned.</p></html>";
	
	public Utility(String name, Space.SpaceType type, int price, int[] rent, int mort, int house, Property.PropertyCategory category)
	{
		super(name, type, price, rent, mort, house, category);
	}
	
	public int getRent(int dice)
    {
        if(canBuyHouse)
            return 10*dice;
        return dice*4;
    }
	
	public String getCardDes()
	{
		return this.cardDes;
	}

}
