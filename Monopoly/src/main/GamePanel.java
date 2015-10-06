package main;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel {

	private MainWindow parent;	
	
	// index of player who is currently taking a turn
	public int currPlayer;

	private JButton diceButton;
	
	// flag set when a player rolls doubles -- will roll again
	private boolean doubles;	
	// random number generator used for dice rolling
	private Random ranGen;
	
	/**
	 * Create the panel.
	 */
	public GamePanel(MainWindow par) {
		setBackground(new Color(255, 250, 205));
		this.parent = par;

		this.currPlayer = 0;
		this.ranGen = new Random(System.currentTimeMillis());
		
		setBackground(new Color(255, 250, 205));

		setBounds(100, 100, 650, 725);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton button = new JButton("");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 3;
		gbc_button.gridheight = 3;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		JButton btnNewButton_7 = new JButton("");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.gridheight = 3;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 8;
		gbc_btnNewButton_7.gridy = 2;
		add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridheight = 3;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 9;
		gbc_btnNewButton_6.gridy = 2;
		add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridheight = 3;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 10;
		gbc_btnNewButton_5.gridy = 2;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 3;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 11;
		gbc_btnNewButton_2.gridy = 2;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton = new JButton("");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 12;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 3;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 13;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridheight = 3;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 14;
		gbc_btnNewButton_3.gridy = 2;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridheight = 3;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 15;
		gbc_btnNewButton_4.gridy = 2;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.gridheight = 3;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 16;
		gbc_btnNewButton_8.gridy = 2;
		add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton button_20 = new JButton("");
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.gridheight = 3;
		gbc_button_20.gridwidth = 3;
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 17;
		gbc_button_20.gridy = 2;
		add(button_20, gbc_button_20);
		
		JButton button_1 = new JButton("");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridwidth = 3;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 5;
		add(button_1, gbc_button_1);
		
		JButton button_21 = new JButton("");
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.gridwidth = 3;
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 17;
		gbc_button_21.gridy = 5;
		add(button_21, gbc_button_21);
		
		JButton button_2 = new JButton("");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.gridwidth = 3;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 5;
		gbc_button_2.gridy = 6;
		add(button_2, gbc_button_2);
		
		JButton button_22 = new JButton("");
		GridBagConstraints gbc_button_22 = new GridBagConstraints();
		gbc_button_22.gridwidth = 3;
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 17;
		gbc_button_22.gridy = 6;
		add(button_22, gbc_button_22);
		
		JButton button_3 = new JButton("");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.gridwidth = 3;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 5;
		gbc_button_3.gridy = 7;
		add(button_3, gbc_button_3);
		
		JButton button_24 = new JButton("");
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.gridwidth = 3;
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 17;
		gbc_button_24.gridy = 7;
		add(button_24, gbc_button_24);
		
		JButton button_4 = new JButton("");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.gridwidth = 3;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 5;
		gbc_button_4.gridy = 8;
		add(button_4, gbc_button_4);
		
		JButton button_23 = new JButton("");
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.gridwidth = 3;
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 17;
		gbc_button_23.gridy = 8;
		add(button_23, gbc_button_23);
		
		JButton button_5 = new JButton("");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.gridwidth = 3;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 5;
		gbc_button_5.gridy = 9;
		add(button_5, gbc_button_5);
		
		JButton button_25 = new JButton("");
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.gridwidth = 3;
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 17;
		gbc_button_25.gridy = 9;
		add(button_25, gbc_button_25);
		
		JButton button_6 = new JButton("");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.gridwidth = 3;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 5;
		gbc_button_6.gridy = 10;
		add(button_6, gbc_button_6);
		
		JButton button_26 = new JButton("");
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.gridwidth = 3;
		gbc_button_26.insets = new Insets(0, 0, 5, 5);
		gbc_button_26.gridx = 17;
		gbc_button_26.gridy = 10;
		add(button_26, gbc_button_26);
		
		JButton button_7 = new JButton("");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.gridwidth = 3;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 5;
		gbc_button_7.gridy = 11;
		add(button_7, gbc_button_7);
		
		JButton button_27 = new JButton("");
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.gridwidth = 3;
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 17;
		gbc_button_27.gridy = 11;
		add(button_27, gbc_button_27);
		
		JButton button_8 = new JButton("");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.gridwidth = 3;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 5;
		gbc_button_8.gridy = 12;
		add(button_8, gbc_button_8);
		
		JButton button_28 = new JButton("");
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.gridwidth = 3;
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 17;
		gbc_button_28.gridy = 12;
		add(button_28, gbc_button_28);
		
		JButton button_9 = new JButton("");
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.gridwidth = 3;
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 5;
		gbc_button_9.gridy = 13;
		add(button_9, gbc_button_9);
		
		JButton button_29 = new JButton("");
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.gridwidth = 3;
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 17;
		gbc_button_29.gridy = 13;
		add(button_29, gbc_button_29);
		
		JButton button_10 = new JButton("");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.gridheight = 3;
		gbc_button_10.gridwidth = 3;
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 5;
		gbc_button_10.gridy = 14;
		add(button_10, gbc_button_10);
		
		JButton button_11 = new JButton("");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.gridheight = 3;
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 8;
		gbc_button_11.gridy = 14;
		add(button_11, gbc_button_11);
		
		JButton button_12 = new JButton("");
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.gridheight = 3;
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 9;
		gbc_button_12.gridy = 14;
		add(button_12, gbc_button_12);
		
		JButton button_13 = new JButton("");
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.gridheight = 3;
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 10;
		gbc_button_13.gridy = 14;
		add(button_13, gbc_button_13);
		
		JButton button_14 = new JButton("");
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.gridheight = 3;
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 11;
		gbc_button_14.gridy = 14;
		add(button_14, gbc_button_14);
		
		JButton button_15 = new JButton("");
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.gridheight = 3;
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 12;
		gbc_button_15.gridy = 14;
		add(button_15, gbc_button_15);
		
		JButton button_16 = new JButton("");
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.gridheight = 3;
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 13;
		gbc_button_16.gridy = 14;
		add(button_16, gbc_button_16);
		
		JButton button_17 = new JButton("");
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.gridheight = 3;
		gbc_button_17.insets = new Insets(0, 0, 5, 5);
		gbc_button_17.gridx = 14;
		gbc_button_17.gridy = 14;
		add(button_17, gbc_button_17);
		
		JButton button_18 = new JButton("");
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.gridheight = 3;
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 15;
		gbc_button_18.gridy = 14;
		add(button_18, gbc_button_18);
		
		JButton button_19 = new JButton("");
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.gridheight = 3;
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 16;
		gbc_button_19.gridy = 14;
		add(button_19, gbc_button_19);
		
		JButton button_30 = new JButton("");
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.gridwidth = 3;
		gbc_button_30.gridheight = 3;
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 17;
		gbc_button_30.gridy = 14;
		add(button_30, gbc_button_30);
		Image img = new ImageIcon(this.getClass().getResource("/dice.png")).getImage();
		
		
		

	}
	
	
	/* Handler:		diceClicked
	 * Purpose:		handles the dice button clicked event, rolls dice, moves the current player forward, and begins
	 * 				any interaction the user will have on the new space he/she has landed on
	 */
	private ActionListener diceClicked = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO -- disable dice button until enabled for next turn
			
			// roll the dice for the current player
			int d1 = diceRoll(); int d2 = diceRoll();
			if (d1 == d2) doubles = true;	//player will roll again
			
			// display the result of the dice on the screen (for now, console only)
			// TODO -- get dice results displayed on GUI
			System.out.println("You rolled " + d1 + " and " + d2 + ".");
			
			// pause for a second
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			// advance the current player's position
			movePlayer(d1+d2);		
			// TODO -- update the GUI
			
			// given the state of the current property, notify user or allow user to take action
			takeAction(parent.spaces.get(parent.players[currPlayer].getCurrLocation()));

			// going to next turn will take place in takeAction or in an event handler for an event
			//	that will be created by takeAction

		}
	};
	
	/* Function:	diceRoll()
	 * Purpose:		produce random number in range 1-6, ranGen data member seeded with time at instantiation of 
	 * 				the class
	 */
	private int diceRoll() {
		return ranGen.nextInt(6) + 1;
	}

	/* Function:	movePlayer()
	 * Purpose:		advance the current player around the board to the next space based on the dice roll
	 */
	private void movePlayer(int roll) {
		int newLoc = parent.players[currPlayer].getCurrLocation() + roll;
		// check if the player passed go
		if (newLoc >= parent.spaces.size()) {
			parent.players[currPlayer].passedGo();
		}
		// set user's location to correct index into properties array
		parent.players[currPlayer].setCurrLocation(newLoc % parent.spaces.size());
		
		// TODO -- probably don't need to print this info when done on GUI
		System.out.println("You moved " + roll + " spaces to "+ parent.spaces.get(parent.players[currPlayer].getCurrLocation()).getName());
					
	}	
	
	/* Function:	takeAction()
	 * Purpose:		given the property <prop> that the current player has landed on, give user notification or
	 * 				require response from the current player based on the property type, the owner of it, etc
	 * 				NOTE: nextTurn() is called from here for some scenarios (or called from event handlers
	 * 				built in helper functions for other scenarios) to follow event based paradigm
	 */
	private void takeAction(Space s) {
		// space is a special space -- GO, draw card, taxes, etc; not a buyable property
		if (s.getType() == Space.SpaceType.ACTION) {
			// DO NOTHING for vertical prototype	
			nextTurn();
		}
		// space is a buyable property
		else {
			Property prop = (Property) s;
			// it has not been bought yet
			if (prop.getOwner() == -1) {
				optionToBuy(prop);
			}
			// it has been bought by a different player -- current player pays rent
			else if (prop.getOwner() != currPlayer) {
				payRent(prop);
			}
			// it has been bought and the owner is the current player
			else {
				// DO NOTHING
				nextTurn();
			}
			
		}
	}

	/* Function:	optionToBuy()
	 * Purpose:		helper to takeAction(), used when a buyable property has not yet been purchased, for vertical
	 * 				prototype just offers current player to buy it or not
	 */
	private void optionToBuy(Property prop) {
		// check if the current player has enough money to buy the property
		if (parent.players[currPlayer].getBank() > prop.getPrice()) {
			// TODO -- create a dialog for user interaction instead of command line
			System.out.print("Do you want to buy " + prop.getName() + " for $" + prop.getPrice() + "? ");
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			String input = "";
			try {
				input = b.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// **TODO -- put this (what's below here in the if body) in event handler for dialog response

			// if they want to buy it, update the owner of the property, and deduct the cost from the current player
			if (input.toUpperCase().equals(new String("YES"))) {
				parent.players[currPlayer].deductFromBank(prop.getPrice());
				prop.setOwner(currPlayer);
				parent.players[currPlayer].addProperty(prop);;
			}		
			nextTurn();
		}
		else {
			// notify player that they don't have money
			// TODO -- put this notification somewhere on GUI
			System.out.println("You do not have enough money to buy this property.");
			nextTurn();
		}		
	}
	
	/* Function:	payRent()
	 * Purpose:		helper to takeAction(), used when a property is already owned and the current player has to pay
	 * 				rent to that owner
	 */
	private void payRent(Property prop) {
		if (currPlayer != prop.getOwner()) {		
			int amountPaid = parent.players[currPlayer].deductFromBank(prop.getRent());
			parent.players[prop.getOwner()].addToBank(amountPaid);
			System.out.println(parent.players[currPlayer].getName() + " paid $" + amountPaid + 
				" to " + parent.players[prop.getOwner()].getName() + " for rent on " + prop.getName());
		}
		nextTurn();
	}

	/* Function:	nextTurn()
	 * Purpose:		updates the current player to the next still active player in the game
	 */
	public void nextTurn() {
		if (!this.doubles) {
			this.currPlayer = (this.currPlayer + 1) % parent.players.length;
			int playersOut = 0;
			while (!parent.players[currPlayer].isActive()) {
				this.currPlayer = (this.currPlayer + 1) % parent.players.length;
				playersOut++;	
			}

			//check if game is still going
			if (playersOut > parent.players.length - 2) {
				// gameover!
				CardLayout cl = (CardLayout)(parent.cards.getLayout());
				cl.next(parent.cards);
			}
		}
		this.doubles = false;

		newTurnNotification();

	}
	
	/* Function:	newTurnNotification() 
	 * Purpose:		display something on GUI to indicate that it is player X's turn and the
	 * 				dice should be rolled
	 */
	public void newTurnNotification() {
		// notify player X that it is their turn
		System.out.println("\n" + parent.players[currPlayer].getName() + ", it is your turn!");
		System.out.println("\tBank balance is: $" + parent.players[currPlayer].getBank());
		String sProps = "";
		Vector<Property> props = parent.players[currPlayer].getProperties();
		for (int i = 0; i < props.size(); ++i) {
			if (i != 0) sProps += ", ";
			sProps += props.elementAt(i).getName();
		}
		System.out.println("\tProperties: " + sProps);
		// TODO -- enable dice again
	}
		
	
}
