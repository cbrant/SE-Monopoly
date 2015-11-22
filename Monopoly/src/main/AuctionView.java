package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AuctionView extends JDialog {

	private JPanel contentPane;
	//private JFrame frame;

	private GamePanel parent;

	public int currBidder;
	public int currBid;
	public int highestBidder;
	public int numPasses;
	public Property propForAuction;

	private JLabel lblPlayer, lblPlayer_1, lblPlayer_2, lblPlayer_3;
	private JLabel[] playerLabels = new JLabel[4];

	/**
	 * Create the frame.
	 */
	public AuctionView(GamePanel par, Property pfa) {
		this.setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(255, 250, 205));

		this.setBackground(new Color(255, 250, 205));
		parent = par;
		propForAuction = pfa;
		// starting bidder is the next player
		currBidder = (parent.currPlayer + 1) % 4;
		currBid = 0;
		highestBidder = -1;
		numPasses = 0;

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 20, 0, 0, 0, 0, 20 };
		gbl_contentPane.rowHeights = new int[] { 20, 0, 0, 0, 0, 0, 0, 0, 0, 20 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0,
				1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, Double.MIN_VALUE, 1.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblAuction = new JLabel("Auction");
		GridBagConstraints gbc_lblAuction = new GridBagConstraints();
		gbc_lblAuction.fill = GridBagConstraints.VERTICAL;
		gbc_lblAuction.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuction.gridx = 2;
		gbc_lblAuction.gridy = 1;
		gbc_lblAuction.gridwidth = 2;
		contentPane.add(lblAuction, gbc_lblAuction);

		JLabel lblProperty = new JLabel("Property");
		GridBagConstraints gbc_lblProperty = new GridBagConstraints();
		gbc_lblProperty.fill = GridBagConstraints.VERTICAL;
		gbc_lblProperty.insets = new Insets(0, 0, 5, 5);
		gbc_lblProperty.gridx = 2;
		gbc_lblProperty.gridy = 3;
		gbc_lblProperty.gridwidth = 2;
		contentPane.add(lblProperty, gbc_lblProperty);
		lblProperty.setText(propForAuction.getName());

		lblPlayer = new JLabel("Player 1");
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer.gridx = 1;
		gbc_lblPlayer.gridy = 5;
		contentPane.add(lblPlayer, gbc_lblPlayer);
		lblPlayer.setText(parent.getMyParent().players[0].getName());
		playerLabels[0] = lblPlayer;

		lblPlayer_1 = new JLabel("Player 2");
		GridBagConstraints gbc_lblPlayer_1 = new GridBagConstraints();
		gbc_lblPlayer_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlayer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer_1.gridx = 2;
		gbc_lblPlayer_1.gridy = 5;
		contentPane.add(lblPlayer_1, gbc_lblPlayer_1);
		lblPlayer_1.setText(parent.getMyParent().players[1].getName());
		playerLabels[1] = lblPlayer_1;

		lblPlayer_2 = new JLabel("Player 3");
		GridBagConstraints gbc_lblPlayer_2 = new GridBagConstraints();
		gbc_lblPlayer_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlayer_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer_2.gridx = 3;
		gbc_lblPlayer_2.gridy = 5;
		contentPane.add(lblPlayer_2, gbc_lblPlayer_2);
		lblPlayer_2.setText(parent.getMyParent().players[2].getName());
		playerLabels[2] = lblPlayer_2;

		lblPlayer_3 = new JLabel("Player 4");
		GridBagConstraints gbc_lblPlayer_3 = new GridBagConstraints();
		gbc_lblPlayer_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlayer_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer_3.gridx = 4;
		gbc_lblPlayer_3.gridy = 5;
		contentPane.add(lblPlayer_3, gbc_lblPlayer_3);
		lblPlayer_3.setText(parent.getMyParent().players[3].getName());
		playerLabels[3] = lblPlayer_3;

		textField = new JTextField();
		textField.setText("0");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 7;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		//textField.setText("" + propForAuction.getPrice());

		JButton btnBid = new JButton("Bid");
		GridBagConstraints gbc_btnBid = new GridBagConstraints();
		gbc_btnBid.insets = new Insets(0, 0, 5, 5);
		gbc_btnBid.gridx = 3;
		gbc_btnBid.gridy = 7;
		contentPane.add(btnBid, gbc_btnBid);
		btnBid.addActionListener(bidMade);

		JButton button = new JButton("Pass");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 8;
		gbc_button.gridwidth = 2;
		contentPane.add(button, gbc_button);
		button.addActionListener(playerPasses);

		
		this.addWindowListener(auctionOpened);
		updateBidGraphics();
		this.setVisible(true);		
	}
	
	public WindowListener auctionOpened = new WindowListener() {
		public void windowOpened(WindowEvent e) {
			if (!parent.getMyParent().players[currBidder].isHuman()) {
				compPlayerBid();
				updateBidGraphics();
			}
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

	};
	

	public ActionListener bidMade = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// numPasses = 0;
			// get player who is currently bidding

			// parse the data in the entered field
			// check this data for validity
			// (1) bid lower than currBid
			// (2) bid more than current player's bank
			// (3) not an integer
			// if either fails, give dialog saying error and return from
			// function
			// without updating current bidder
			int bid = Integer.parseInt(textField.getText()); // parse this from
																// input box
			if (!checkBidInput(bid))
				return;

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
		if (bid <= currBid) {
			// currBid will always be greater than or equal to 0
			JOptionPane.showMessageDialog(null,
					"Your bid must exceed the current highest bid!\nYour bid: $"
							+ bid + "\nHighest Bid: $" + currBid, "Bid error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// NOTE: as this is set up, no mortgaging/house selling will be able to
		// occur after the
		// auction has begun (can only use existing cash for bids)
		if (bid >= parent.getMyParent().players[currBidder].getBank()) {
			JOptionPane.showMessageDialog(
					null,
					"Insufficient funds in bank account!\nYour bid: $"
							+ bid
							+ "\nAccount Balance: $"
							+ parent.getMyParent().players[currBidder]
									.getBank(), "Bank error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public void updateBidGraphics() {
		// TODO Auto-generated method stub

		for (JLabel x : playerLabels) {
			x.setOpaque(true);
			x.setBackground(new Color(255, 250, 205));
		}

		playerLabels[currBidder].setBackground(new Color(153, 255, 153));

		if (highestBidder > -1)
			playerLabels[highestBidder].setBackground(new Color(100, 100, 200));

	}

	public void updateBid(int bid) {
		currBid = bid;
		numPasses = 0;
		highestBidder = currBidder;
	}

	public void updateBidder() {
		++numPasses;

		currBidder = (currBidder + 1) % 4;

		// check if the current bidder is a computer player, if so, have to
		// perform a bid for the computer player
		if (!parent.getMyParent().players[currBidder].isHuman()) {
			compPlayerBid();
		}

	}

	/*
	 * function: compPlayerBid() purpose: perform auction actions/decision for
	 * computer player in the game
	 */
	public void compPlayerBid() {
		updateBidGraphics();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (isEndAuction()) {
			bidWon();
			this.dispose();
		} else if (noBids()) {
			// auction window closes
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null,
					parent.getMyParent().players[currBidder].getName()
							+ " (computer) did not bid.", "Computer Bid",
					JOptionPane.INFORMATION_MESSAGE);

			// straightforward approach first so game can continue when computer
			// players in it
			// don't bid on anything
			updateBidder();

			// more advanced approach -- TODO
			// first check if the computer player wants to bid
			// int propVal =

		}

	}

	public ActionListener playerPasses = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// update to next bidder
			updateBidder();

			// check if end of auction
			if (isEndAuction()) {
				// player is given property, money gets deducted, property owner
				// gets set
				bidWon();
				// auction window closes
				dispose();
			} else if (noBids()) {
				// no one bidded for property, so remains unsold
				JOptionPane.showMessageDialog(null,
						"No one bid on this property, so it will remain"
								+ " for sale!", "No bids",
						JOptionPane.INFORMATION_MESSAGE);
				// auction window closes
				dispose();
			} else {
				// graphics update
				updateBidGraphics();
			}
		}

	};
	private JTextField textField;

	public boolean isEndAuction() {
		if (currBidder == highestBidder)
			return true;
		return false;
	}

	public boolean noBids() {
		if (numPasses == 4)
			return true;
		return false;
	}

	public void bidWon() {
		// adds the property to the highestBidder's property list
		// updates the property's owner
		// deducts currBid from the highestBidder's bank
		parent.getMyParent().players[highestBidder].deductFromBank(currBid, 0);
		parent.getMyParent().players[highestBidder].addProperty(propForAuction);

		// dialog message for the user's congratulations
		if (parent.getMyParent().players[highestBidder].isHuman()) {
			JOptionPane.showMessageDialog(null,
					parent.getMyParent().players[highestBidder].getName()
							+ ", you won the auction for "
							+ this.propForAuction.getName() + " at $"
							+ this.currBid, "Bid Won!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			// computer player won, but still show information message
			JOptionPane.showMessageDialog(null,
					parent.getMyParent().players[highestBidder].getName()
							+ " (computer) won the auction for "
							+ this.propForAuction.getName() + " at $"
							+ this.currBid, "Bid Won!",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
