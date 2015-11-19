package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AuctionView extends JFrame {

	private JPanel contentPane;

	private GamePanel parent;
	
	public int currBidder;
	public int currBid;
	public int highestBidder;
	public int numPasses;
	public Property propForAuction;
	
	/**
	 * Create the frame.
	 */
	public AuctionView(GamePanel par, Property pfa) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		parent = par;
		propForAuction = pfa;
		// starting bidder is the next player
		currBidder = (parent.currPlayer + 1) % 4;
		currBid = 0;
		highestBidder = -1;
		numPasses = 0;
	}
	
	public ActionListener bidMade = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//numPasses = 0;
			// get player who is currently bidding
			
			// parse the data in the entered field
			// check this data for validity
			//	(1) bid lower than currBid
			//  (2) bid more than current player's bank
			// 	(3) not an integer
			// if either fails, give dialog saying error and return from function
			//	without updating current bidder
			int bid = 0;	// parse this from input box
			if (!checkBidInput(bid)) return;
			
			
			// move to next player
			updateBidder();
			
			// update currBid
			updateBid(bid);
			// graphics update here
			updateBidGraphics();
		}



	};
	
	public boolean checkBidInput(int bid) {
		// check that current player has enough money for this bid
		// check that this bid is greater than current bid
		// return false if either is not right
		if(bid <= currBid) {
			// currBid will always be greater than or equal to 0
			JOptionPane.showMessageDialog(null, "Your bid must exceed the current highest bid!\nYour bid: $" +
					bid +"\nHighest Bid: $"+currBid, "Bid error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// NOTE: as this is set up, no mortgaging/house selling will be able to occur after the
		//	auction has begun (can only use existing cash for bids)
		if(bid >= parent.getMyParent().players[currBidder].getBank()) {
			JOptionPane.showMessageDialog(null, "Insufficient funds in bank account!\nYour bid: $" +
					bid +"\nAccount Balance: $"+parent.getMyParent().players[currBidder].getBank(), 
					"Bank error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}


	public void updateBidGraphics() {
		// TODO Auto-generated method stub
		
	}


	public void updateBid(int bid) {
		currBid = bid;
		numPasses = 0;
	}


	public void updateBidder() {
		++numPasses;
		
		currBidder = (currBidder+1)%4;
		
		// check if the current bidder is a computer player, if so, have to
		//	perform a bid for the computer player
		if (!parent.getMyParent().players[currBidder].isHuman()) {
			compPlayerBid();
		}
		
	}
	
	/* function:	compPlayerBid()
	 * purpose:		perform auction actions/decision for computer player in the 
	 * 				game
	 */
	public void compPlayerBid() {
		if (isEndAuction()) {
			bidWon();
		}
		else if (noBids()) {
			//auction window closes -- TODO
		}
		else {
			// straightforward approach first so game can continue when computer players in it
			// don't bid on anything
			updateBidder();	
		
			// more advanced approach -- TODO
			// first check if the computer player wants to bid
			//int propVal = 


		}
		
	}

	public ActionListener playerPasses = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// update to next bidder
			updateBidder();
			
			// check if end of auction
			if (isEndAuction()) {
				// player is given property, money gets deducted, property owner gets set
				bidWon();
				// auction window closes
				// next turn is called in GamePanel.optionToBuy() after window is created
			}
			else if (noBids()) {
				// auction window closes
				// next turn is called in GamePanel.optionToBuy()
			}
			else {
				// graphics update
				updateBidGraphics();				
			}
		}
		
	};

	public boolean isEndAuction() {
		if(currBidder == highestBidder) return true;
		return false;
	}
	
	public boolean noBids() {
		if(numPasses == 4) return true;
		return false;
	}
	
	public void bidWon() {
		// adds the property to the highestBidder's property list
		// updates the property's owner
		// deducts currBid from the highestBidder's bank
		parent.getMyParent().players[highestBidder].deductFromBank(currBid,0);
		parent.getMyParent().players[highestBidder].addProperty(propForAuction);
		
		// dialog message for the user's congratulations
		if (parent.getMyParent().players[highestBidder].isHuman()) {
			JOptionPane.showMessageDialog(null, ", you won the auction for " + this.propForAuction.getName() + 
					" at $" + this.currBid, "Bid Won!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			//computer player won, but still show information message
			JOptionPane.showMessageDialog(null, " (computer) won the auction for " + this.propForAuction.getName() + 
					" at $" + this.currBid, "Bid Won!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	

}
