package main;

public class ActionSpace extends Space{
	
	private String luxuryString = "Pay $75";
	private String incomeString = "Pay $200 or 10%";
	
	public enum ActionType {
		NOTHING,	// go, visiting jail, free parking
		CARD,
		JAIL,
		TAX		
	}
	
	private ActionType aType;
	
	public ActionSpace(String name, Space.SpaceType type, ActionSpace.ActionType aType)
	{
		super(name, type);
		this.aType = aType;
	}
	
	public void action()
	{	
		return;
	}
	
	public ActionType getAType() {
		return this.aType;
	}
	
	public String getCardDes(String luxOrIncome)
	{
		if(luxOrIncome.equals("Income Tax"))
			return incomeString;
		else
			return luxuryString;
	}

}
