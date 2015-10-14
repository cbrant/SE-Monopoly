package main;

public class ActionSpace extends Space{
	
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

}
