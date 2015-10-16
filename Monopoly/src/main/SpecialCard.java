package main;

public abstract class SpecialCard {
	
	private String text = "You drew a ";
	public SpecialCard(String type, String line)
	{
		text += type + "\n"+line;
	}
	
	public abstract void act(Player p, int playersOut, GamePanel eng);
	
	public String getText() {
		return text;
	}
	
	
}
