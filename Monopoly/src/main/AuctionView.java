package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
		currBidder = -1;
		//currBidder = (parent.currPlayer + 1) % 4;
		currBid = -1;
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
			
			// update currBid
			updateBid(bid);
			
			// move to next player
			updateBidder();
			// graphics update here
			updateBidGraphics();
		}



	};
	
	public boolean checkBidInput(int bid) {
		// check that current player has enough money for this bid
		// check that this bid is greater than current bid
		// return false if either is not right
		throw new NotImplementedException();
	}


	public void updateBidGraphics() {
		// TODO Auto-generated method stub
		
	}


	public void updateBid(int bid) {

	}


	public void updateBidder() {
		
	}
	
	public ActionListener playerPasses = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//++numPasses;
			
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
		// currBidder == highestBidder
		throw new NotImplementedException();
	}
	
	public boolean noBids() {
		// numPasses == 4
		throw new NotImplementedException();
	}
	
	public void bidWon() {
		// adds the property to the highestBidder's property list
		// updates the property's owner
		// deducts currBid from the highestBidder's bank
	}
	

}
