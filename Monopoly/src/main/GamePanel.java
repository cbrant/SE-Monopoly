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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 18;
		gbc_separator.gridwidth = 21;
		add(separator, gbc_separator);

		diceButton = new JButton("");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 8;
				/////////////////// NOTE IMAGE CHANGED SO I CAN RUN IT /////////////////////
		Image img = new ImageIcon(this.getClass().getResource("/monopolyLogo.png")).getImage();
		diceButton.setIcon(new ImageIcon(img));
		diceButton.addActionListener(diceClicked);

		add(diceButton, gbc_btnNewButton);
		

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

			// pause for a second
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			// given the state of the current property, notify user or allow user to take action
			takeAction(parent.properties.get(parent.players[currPlayer].getCurrLocation()));
			// pause for a second
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			// go to next turn -- also checks for game termination condition
			nextTurn();

			// TODO -- enable dice again
		}
	};
	
	/* Function:	diceRoll()
	 * Purpose:		produce random number in range 1-6, ranGen data member seeded with time at instantiation of 
	 * 				the class
	 */
	private int diceRoll() {
		return ranGen.nextInt(6) + 1;
	}

	/* Function:	takeAction()
	 * Purpose:		given the property <prop> that the current player has landed on, give user notification or
	 * 				require response from the current player based on the property type, the owner of it, etc
	 */
	private void takeAction(Property prop) {
		// space is a special space -- GO, draw card, taxes, etc; not a buyable property
		if (prop.getType() == Property.PropertyType.SPEC) {
			// DO NOTHING for vertical prototype			
		}
		// space is a buyable property
		else {
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
			}
			
		}
	}
	
	/* Function:	movePlayer()
	 * Purpose:		advance the current player around the board to the next space based on the dice roll
	 */
	private void movePlayer(int roll) {
		int newLoc = parent.players[currPlayer].getCurrLocation() + roll;
		// check if the player passed go
		if (newLoc >= parent.properties.size()) {
			parent.players[currPlayer].passedGo();
		}
		// set user's location to correct index into properties array
		parent.players[currPlayer].setCurrLocation(newLoc % parent.properties.size());
		
		// move the current player around the board
		System.out.println("You moved " + roll + " spaces to "+ parent.properties.get(parent.players[currPlayer].getCurrLocation()).getName());
					
	}	

	/* Function:	optionToBuy()
	 * Purpose:		helper to takeAction(), used when a buyable property has not yet been purchased, for vertical
	 * 				prototype just offers current player to buy it or not
	 */
	private void optionToBuy(Property prop) {
		// check if the current player has enough money to buy the property
		if (parent.players[currPlayer].getBank() > prop.getPrice()) {
			System.out.print("Do you want to buy " + prop.getName() + " for $" + prop.getPrice() + "? ");
			
			// TODO -- make this a dialog for user interaction instead of command line
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			String input = "";
			try {
				input = b.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// if they want to buy it, update the owner of the property, and deduct the cost from the current player
			if (input.toUpperCase().equals(new String("YES"))) {
				parent.players[currPlayer].deductFromBank(prop.getPrice());
				prop.setOwner(currPlayer);
				parent.players[currPlayer].addProperty(prop);;
			}
		}
		else {
			// notify player that they don't have money
			System.out.println("You do not have enough money to buy this property.");
		}
		
	}
	
	/* Function:	payRent()
	 * Purpose:		helper to takeAction(), used when a property is already owned and the current player has to pay
	 * 				rent to that owner
	 */
	private void payRent(Property prop) {
		if (currPlayer == prop.getOwner()) return;
		
		int amountPaid = parent.players[currPlayer].deductFromBank(prop.getRent());
		parent.players[prop.getOwner()].addToBank(amountPaid);
		System.out.println(parent.players[currPlayer].getName() + " paid $" + amountPaid + 
				" to " + parent.players[prop.getOwner()].getName() + " for rent on " + prop.getName());
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
	}
		
	
}
