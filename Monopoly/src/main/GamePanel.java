package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class GamePanel extends JPanel {

	private MainWindow parent;

	private JButton diceButton;
	
	// flag set when a player rolls doubles -- will roll again
	private boolean doubles;	
	private Random ranGen;
	
	/**
	 * Create the panel.
	 */

	public GamePanel(MainWindow par) {
		setBackground(new Color(255, 250, 205));
		this.parent = par;

		ranGen = new Random(System.currentTimeMillis());
		
		setBounds(100, 100, 650, 725);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
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

	}
	
	private ActionListener diceClicked = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO -- disable dice button until enabled for next turn
			
			// roll the dice for the current player
			doubles = false;
			int d1 = diceRoll(); int d2 = diceRoll();
			if (d1 == d2) doubles = true;
			
			// display the result of the dice on the screen (for now, console only)
			System.out.println("You rolled " + d1 + " and " + d2 + ".");

			// pause for a second
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			// advance the current player's position
			parent.players[parent.currPlayer].movePiece(d1+d2);			
			// move the current player around the board
			System.out.println("You moved " + (d1+d2) + " spaces to "+ parent.properties.get(parent.players[parent.currPlayer].getCurrLocation()).getName());
			// TODO -- update the GUI

			// pause for a second
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			// given the state of the current property, notify user or allow user to take action
			takeAction(parent.properties.get(parent.players[parent.currPlayer].getCurrLocation()));
			
			if (!doubles) parent.nextTurn();

			// notify player X that it is their turn
			System.out.println("\n" + parent.players[parent.currPlayer].getpName() + ", it is your turn!");
			System.out.println("\tYour current bank balance is: $" + parent.players[parent.currPlayer].getBank());

			// TODO -- enable dice again
		}
	};
	
	
	private int diceRoll() {
		return ranGen.nextInt(6) + 1;
	}

	void takeAction(Property prop) {
		prop.landedOn(parent.currPlayer);
	}
}
