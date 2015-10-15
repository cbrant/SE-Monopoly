package main;

public class SpecialCard {
	
	String text = "You drew a ";
	String option;
	int number;
	public SpecialCard(int i, String type)
	{
		number = i;
		if(i%3==1) {
			option = "lost";
			text+=type+" card!\nIt is number "+i+".\nYou "+option+" $100!!";
		}
		else if(i%3==2) {
			text+=type+" card!\nIt is number "+i+".\nYou move to Go!";
		}
		else {
			option = "gain";
			text+=type+" card!\nIt is number "+i+".\nYou "+option+" $100!!";
		}
	}
	
	public void act(Player p, int playersOut, GamePanel eng) {
		if(number%3==0)
			p.addToBank(100);
		else if(number%3 == 2) {
			eng.movePlayer(eng.getParentFrame().spaces.size()-p.getCurrLocation());
		}
		else
			p.deductFromBank(100, playersOut);
	}
	
	public String getText() {
		return text;
	}
	
	
}
