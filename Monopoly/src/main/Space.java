package main;

public abstract class Space {
	
	
	public enum SpaceType{
		NORM, RR, UTIL, ACTION		
	}
	
	protected String name;
	protected SpaceType type;
	protected boolean buyable;

	public Space(String name, SpaceType type)
	{
		this.name = name;
		this.type = type;
		this.buyable = false;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public SpaceType getType()
	{
		return this.type;
	}
	
	abstract void action();
	
}
