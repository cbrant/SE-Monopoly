package main;

public class SpecialCard {
	
	String text = "You drew a ";
	int number;
	public SpecialCard(int i, String type)
	{
		number = i;
		text+=type+" card!\nIt is number "+i+".\nYou gain $100!!";
	}
	
	public void act(Player p) {
		p.addToBank(100);
	}
	
	public String getText() {
		return text;
	}
	
	
}
