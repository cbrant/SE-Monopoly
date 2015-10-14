package main;

public class SpecialCard {
	
	String text = "You drew a ";
	String option;
	int number;
	public SpecialCard(int i, String type)
	{
		number = i;
		if(i%2==1)
			option = "lost";
		else
			option = "gain";
		text+=type+" card!\nIt is number "+i+".\nYou "+option+" $100!!";
	}
	
	public void act(Player p, int playersOut) {
		if(number%2==0)
			p.addToBank(100);
		else
			p.deductFromBank(100, playersOut);
	}
	
	public String getText() {
		return text;
	}
	
	
}
