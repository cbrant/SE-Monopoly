package main;

public class MoveSpecialCard extends SpecialCard{

	private int amount;
	public MoveSpecialCard(String type, String line, int spacenum) {
		super(type, line);
		amount = spacenum;
	}
	
	public void act(Player p, int playersOut, GamePanel eng) {
		if(amount < 0) {	//only happens on the move back 3 spaces card, no chance of going backwards passed go
			eng.movePlayer(amount);		//amount should always be -3
		} 
		else {		//instead of a distance, indicates a space (0 is go)
			int location = p.getCurrLocation();
			if(location >= amount){
				int toGo = eng.getParentFrame().spaces.size()-location;
				int toSpace = amount;
				eng.movePlayer(toGo+toSpace);
			} 
			else {
				eng.movePlayer(amount-location);
			}
		}
		eng.takeChanceAction(eng.getParentFrame().spaces.get(p.getCurrLocation()));
	}
}