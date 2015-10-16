package main;

public class BankSpecialCard extends SpecialCard{

	private int amount;
	public BankSpecialCard(String type, String line, int dealing) {
		super(type, line);
		amount = dealing;
	}

	public void act(Player p, int playersOut, GamePanel eng) {
		if(amount < 0) { 
			p.deductFromBank(-amount, playersOut);
		} else {
			p.addToBank(amount);
		}
	}

}
