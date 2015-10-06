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
import javax.swing.SwingConstants;

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
		gridBagLayout.columnWidths = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton freeParking = new JButton("");
		GridBagConstraints gbc_freeParking = new GridBagConstraints();
		gbc_freeParking.fill = GridBagConstraints.BOTH;
		gbc_freeParking.gridwidth = 3;
		gbc_freeParking.gridheight = 3;
		gbc_freeParking.insets = new Insets(0, 0, 5, 5);
		gbc_freeParking.gridx = 5;
		gbc_freeParking.gridy = 2;
		add(freeParking, gbc_freeParking);
		
		JButton kentuckyAvenue = new JButton("");
		GridBagConstraints gbc_kentuckyAvenue = new GridBagConstraints();
		gbc_kentuckyAvenue.fill = GridBagConstraints.BOTH;
		gbc_kentuckyAvenue.gridheight = 3;
		gbc_kentuckyAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_kentuckyAvenue.gridx = 8;
		gbc_kentuckyAvenue.gridy = 2;
		Image red = new ImageIcon(this.getClass().getResource("/redspace.jpg")).getImage();
 		kentuckyAvenue.setIcon(new ImageIcon(red));
		add(kentuckyAvenue, gbc_kentuckyAvenue);
		
		JButton chanceNorth = new JButton("");
		GridBagConstraints gbc_chanceNorth = new GridBagConstraints();
		gbc_chanceNorth.fill = GridBagConstraints.BOTH;
		gbc_chanceNorth.gridheight = 3;
		gbc_chanceNorth.insets = new Insets(0, 0, 5, 5);
		gbc_chanceNorth.gridx = 9;
		gbc_chanceNorth.gridy = 2;
		add(chanceNorth, gbc_chanceNorth);
		
		JButton indianaAvenue = new JButton("");
		GridBagConstraints gbc_indianaAvenue = new GridBagConstraints();
		gbc_indianaAvenue.fill = GridBagConstraints.BOTH;
		gbc_indianaAvenue.gridheight = 3;
		gbc_indianaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_indianaAvenue.gridx = 10;
		gbc_indianaAvenue.gridy = 2;
		indianaAvenue.setIcon(new ImageIcon(red));
		add(indianaAvenue, gbc_indianaAvenue);
		
		JButton illinoisAvenue = new JButton("");
		GridBagConstraints gbc_illinoisAvenue = new GridBagConstraints();
		gbc_illinoisAvenue.fill = GridBagConstraints.BOTH;
		gbc_illinoisAvenue.gridheight = 3;
		gbc_illinoisAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_illinoisAvenue.gridx = 11;
		gbc_illinoisAvenue.gridy = 2;
		illinoisAvenue.setIcon(new ImageIcon(red));
		add(illinoisAvenue, gbc_illinoisAvenue);
		
		JButton bORailroad = new JButton("");
		GridBagConstraints gbc_bORailroad = new GridBagConstraints();
		gbc_bORailroad.fill = GridBagConstraints.BOTH;
		gbc_bORailroad.gridheight = 3;
		gbc_bORailroad.insets = new Insets(0, 0, 5, 5);
		gbc_bORailroad.gridx = 12;
		gbc_bORailroad.gridy = 2;
		add(bORailroad, gbc_bORailroad);
		
		JButton atlanticAvenue = new JButton("");
		GridBagConstraints gbc_atlanticAvenue = new GridBagConstraints();
		gbc_atlanticAvenue.fill = GridBagConstraints.BOTH;
		gbc_atlanticAvenue.gridheight = 3;
		gbc_atlanticAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_atlanticAvenue.gridx = 13;
		gbc_atlanticAvenue.gridy = 2;
		Image yellow = new ImageIcon(this.getClass().getResource("/yellowspace.jpg")).getImage();
 		atlanticAvenue.setIcon(new ImageIcon(yellow));
		add(atlanticAvenue, gbc_atlanticAvenue);
		
		JButton ventnorAvenue = new JButton("");
		GridBagConstraints gbc_ventnorAvenue = new GridBagConstraints();
		gbc_ventnorAvenue.fill = GridBagConstraints.BOTH;
		gbc_ventnorAvenue.gridheight = 3;
		gbc_ventnorAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_ventnorAvenue.gridx = 14;
		gbc_ventnorAvenue.gridy = 2;
		ventnorAvenue.setIcon(new ImageIcon(yellow));
		add(ventnorAvenue, gbc_ventnorAvenue);
		
		JButton waterWorks = new JButton("");
		GridBagConstraints gbc_waterWorks = new GridBagConstraints();
		gbc_waterWorks.fill = GridBagConstraints.BOTH;
		gbc_waterWorks.gridheight = 3;
		gbc_waterWorks.insets = new Insets(0, 0, 5, 5);
		gbc_waterWorks.gridx = 15;
		gbc_waterWorks.gridy = 2;
		add(waterWorks, gbc_waterWorks);
		
		JButton marvinGardens = new JButton("");
		GridBagConstraints gbc_marvinGardens = new GridBagConstraints();
		gbc_marvinGardens.fill = GridBagConstraints.BOTH;
		gbc_marvinGardens.gridheight = 3;
		gbc_marvinGardens.insets = new Insets(0, 0, 5, 5);
		gbc_marvinGardens.gridx = 16;
		gbc_marvinGardens.gridy = 2;
		marvinGardens.setIcon(new ImageIcon(yellow));
		add(marvinGardens, gbc_marvinGardens);
		
		JButton goToJail = new JButton("");
		GridBagConstraints gbc_goToJail = new GridBagConstraints();
		gbc_goToJail.fill = GridBagConstraints.BOTH;
		gbc_goToJail.gridheight = 3;
		gbc_goToJail.gridwidth = 3;
		gbc_goToJail.insets = new Insets(0, 0, 5, 5);
		gbc_goToJail.gridx = 17;
		gbc_goToJail.gridy = 2;
		add(goToJail, gbc_goToJail);
		
		JButton newYorkAvenue = new JButton("");
		GridBagConstraints gbc_newYorkAvenue = new GridBagConstraints();
		gbc_newYorkAvenue.fill = GridBagConstraints.BOTH;
		gbc_newYorkAvenue.gridwidth = 3;
		gbc_newYorkAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_newYorkAvenue.gridx = 5;
		gbc_newYorkAvenue.gridy = 5;Image orange = new ImageIcon(this.getClass().getResource("/orangespace.jpg")).getImage();
 		newYorkAvenue.setIcon(new ImageIcon(orange));
		add(newYorkAvenue, gbc_newYorkAvenue);
		
		JButton pacificAvenue = new JButton("");
		GridBagConstraints gbc_pacificAvenue = new GridBagConstraints();
		gbc_pacificAvenue.fill = GridBagConstraints.BOTH;
		gbc_pacificAvenue.gridwidth = 3;
		gbc_pacificAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_pacificAvenue.gridx = 17;
		gbc_pacificAvenue.gridy = 5;
		Image green = new ImageIcon(this.getClass().getResource("/greenspace.jpg")).getImage();
 		pacificAvenue.setIcon(new ImageIcon(green));
		add(pacificAvenue, gbc_pacificAvenue);
		
		JButton tennesseeAvenue = new JButton("");
		GridBagConstraints gbc_tennesseeAvenue = new GridBagConstraints();
		gbc_tennesseeAvenue.fill = GridBagConstraints.BOTH;
		gbc_tennesseeAvenue.gridwidth = 3;
		gbc_tennesseeAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_tennesseeAvenue.gridx = 5;
		gbc_tennesseeAvenue.gridy = 6;
		tennesseeAvenue.setIcon(new ImageIcon(orange));
		add(tennesseeAvenue, gbc_tennesseeAvenue);
		
		JButton northCarolinaAvenue = new JButton("");
		GridBagConstraints gbc_northCarolinaAvenue = new GridBagConstraints();
		gbc_northCarolinaAvenue.fill = GridBagConstraints.BOTH;
		gbc_northCarolinaAvenue.gridwidth = 3;
		gbc_northCarolinaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_northCarolinaAvenue.gridx = 17;
		gbc_northCarolinaAvenue.gridy = 6;
		northCarolinaAvenue.setIcon(new ImageIcon(green));
		add(northCarolinaAvenue, gbc_northCarolinaAvenue);
		
		JButton communityChestWest = new JButton("");
		GridBagConstraints gbc_communityChestWest = new GridBagConstraints();
		gbc_communityChestWest.fill = GridBagConstraints.BOTH;
		gbc_communityChestWest.gridwidth = 3;
		gbc_communityChestWest.insets = new Insets(0, 0, 5, 5);
		gbc_communityChestWest.gridx = 5;
		gbc_communityChestWest.gridy = 7;
		add(communityChestWest, gbc_communityChestWest);
		
		JButton communityChestEast = new JButton("");
		GridBagConstraints gbc_communityChestEast = new GridBagConstraints();
		gbc_communityChestEast.fill = GridBagConstraints.BOTH;
		gbc_communityChestEast.gridwidth = 3;
		gbc_communityChestEast.insets = new Insets(0, 0, 5, 5);
		gbc_communityChestEast.gridx = 17;
		gbc_communityChestEast.gridy = 7;
		add(communityChestEast, gbc_communityChestEast);
		
		JButton stJamesPlace = new JButton("");
		GridBagConstraints gbc_stJamesPlace = new GridBagConstraints();
		gbc_stJamesPlace.fill = GridBagConstraints.BOTH;
		gbc_stJamesPlace.gridwidth = 3;
		gbc_stJamesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_stJamesPlace.gridx = 5;
		gbc_stJamesPlace.gridy = 8;
		stJamesPlace.setIcon(new ImageIcon(orange));
		add(stJamesPlace, gbc_stJamesPlace);
		
		JButton diceButton = new JButton("");
		GridBagConstraints gbc_diceButton = new GridBagConstraints();
		gbc_diceButton.fill = GridBagConstraints.BOTH;
		gbc_diceButton.gridwidth = 3;
		gbc_diceButton.gridheight = 3;
		gbc_diceButton.insets = new Insets(0, 0, 5, 5);
		gbc_diceButton.gridx = 11;
		gbc_diceButton.gridy = 8;
		Image img = new ImageIcon(this.getClass().getResource("/dice.png")).getImage();
 		diceButton.setIcon(new ImageIcon(img));
 		diceButton.addActionListener(diceClicked);
		add(diceButton, gbc_diceButton);
		
		JButton pennsylvaniaAvenue = new JButton("");
		GridBagConstraints gbc_pennsylvaniaAvenue = new GridBagConstraints();
		gbc_pennsylvaniaAvenue.fill = GridBagConstraints.BOTH;
		gbc_pennsylvaniaAvenue.gridwidth = 3;
		gbc_pennsylvaniaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_pennsylvaniaAvenue.gridx = 17;
		gbc_pennsylvaniaAvenue.gridy = 8;
		pennsylvaniaAvenue.setIcon(new ImageIcon(green));
		add(pennsylvaniaAvenue, gbc_pennsylvaniaAvenue);
		
		JButton pennsylvaniaRailroad = new JButton("");
		GridBagConstraints gbc_pennsylvaniaRailroad = new GridBagConstraints();
		gbc_pennsylvaniaRailroad.fill = GridBagConstraints.BOTH;
		gbc_pennsylvaniaRailroad.gridwidth = 3;
		gbc_pennsylvaniaRailroad.insets = new Insets(0, 0, 5, 5);
		gbc_pennsylvaniaRailroad.gridx = 5;
		gbc_pennsylvaniaRailroad.gridy = 9;
		add(pennsylvaniaRailroad, gbc_pennsylvaniaRailroad);
		
		JButton shortLine = new JButton("");
		GridBagConstraints gbc_shortLine = new GridBagConstraints();
		gbc_shortLine.fill = GridBagConstraints.BOTH;
		gbc_shortLine.gridwidth = 3;
		gbc_shortLine.insets = new Insets(0, 0, 5, 5);
		gbc_shortLine.gridx = 17;
		gbc_shortLine.gridy = 9;
		add(shortLine, gbc_shortLine);
		
		JButton virginiaAvenue = new JButton("");
		GridBagConstraints gbc_virginiaAvenue = new GridBagConstraints();
		gbc_virginiaAvenue.fill = GridBagConstraints.BOTH;
		gbc_virginiaAvenue.gridwidth = 3;
		gbc_virginiaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_virginiaAvenue.gridx = 5;
		gbc_virginiaAvenue.gridy = 10;
		add(virginiaAvenue, gbc_virginiaAvenue);
		
		JButton chanceEast = new JButton("");
		GridBagConstraints gbc_chanceEast = new GridBagConstraints();
		gbc_chanceEast.fill = GridBagConstraints.BOTH;
		gbc_chanceEast.gridwidth = 3;
		gbc_chanceEast.insets = new Insets(0, 0, 5, 5);
		gbc_chanceEast.gridx = 17;
		gbc_chanceEast.gridy = 10;
		add(chanceEast, gbc_chanceEast);
		
		JButton statesAvenue = new JButton("");
		GridBagConstraints gbc_statesAvenue = new GridBagConstraints();
		gbc_statesAvenue.fill = GridBagConstraints.BOTH;
		gbc_statesAvenue.gridwidth = 3;
		gbc_statesAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_statesAvenue.gridx = 5;
		gbc_statesAvenue.gridy = 11;
		add(statesAvenue, gbc_statesAvenue);
		
		JButton parkPlace = new JButton("");
		GridBagConstraints gbc_parkPlace = new GridBagConstraints();
		gbc_parkPlace.fill = GridBagConstraints.BOTH;
		gbc_parkPlace.gridwidth = 3;
		gbc_parkPlace.insets = new Insets(0, 0, 5, 5);
		gbc_parkPlace.gridx = 17;
		gbc_parkPlace.gridy = 11;
		add(parkPlace, gbc_parkPlace);
		
		JButton electicCompany = new JButton("");
		GridBagConstraints gbc_electricCompany = new GridBagConstraints();
		gbc_electricCompany.fill = GridBagConstraints.BOTH;
		gbc_electricCompany.gridwidth = 3;
		gbc_electricCompany.insets = new Insets(0, 0, 5, 5);
		gbc_electricCompany.gridx = 5;
		gbc_electricCompany.gridy = 12;
		add(electicCompany, gbc_electricCompany);
		
		JButton luxuryTax = new JButton("");
		GridBagConstraints gbc_luxuryTax = new GridBagConstraints();
		gbc_luxuryTax.fill = GridBagConstraints.BOTH;
		gbc_luxuryTax.gridwidth = 3;
		gbc_luxuryTax.insets = new Insets(0, 0, 5, 5);
		gbc_luxuryTax.gridx = 17;
		gbc_luxuryTax.gridy = 12;
		add(luxuryTax, gbc_luxuryTax);
		
		JButton stCharlesPlace = new JButton("");
		GridBagConstraints gbc_stCharlesPlace = new GridBagConstraints();
		gbc_stCharlesPlace.fill = GridBagConstraints.BOTH;
		gbc_stCharlesPlace.gridwidth = 3;
		gbc_stCharlesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_stCharlesPlace.gridx = 5;
		gbc_stCharlesPlace.gridy = 13;
		add(stCharlesPlace, gbc_stCharlesPlace);
		
		JButton boardwalk = new JButton("");
		GridBagConstraints gbc_boardwalk = new GridBagConstraints();
		gbc_boardwalk.fill = GridBagConstraints.BOTH;
		gbc_boardwalk.gridwidth = 3;
		gbc_boardwalk.insets = new Insets(0, 0, 5, 5);
		gbc_boardwalk.gridx = 17;
		gbc_boardwalk.gridy = 13;
		add(boardwalk, gbc_boardwalk);
		
		JButton jail = new JButton("");
		GridBagConstraints gbc_jail = new GridBagConstraints();
		gbc_jail.fill = GridBagConstraints.BOTH;
		gbc_jail.gridheight = 3;
		gbc_jail.gridwidth = 3;
		gbc_jail.insets = new Insets(0, 0, 5, 5);
		gbc_jail.gridx = 5;
		gbc_jail.gridy = 14;
		add(jail, gbc_jail);
		
		JButton connecticutAvenue = new JButton("");
		GridBagConstraints gbc_connecticutAvenue = new GridBagConstraints();
		gbc_connecticutAvenue.fill = GridBagConstraints.BOTH;
		gbc_connecticutAvenue.gridheight = 3;
		gbc_connecticutAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_connecticutAvenue.gridx = 8;
		gbc_connecticutAvenue.gridy = 14;
		add(connecticutAvenue, gbc_connecticutAvenue);
		
		JButton vermontAvenue = new JButton("");
		GridBagConstraints gbc_vermontAvenue = new GridBagConstraints();
		gbc_vermontAvenue.fill = GridBagConstraints.BOTH;
		gbc_vermontAvenue.gridheight = 3;
		gbc_vermontAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_vermontAvenue.gridx = 9;
		gbc_vermontAvenue.gridy = 14;
		add(vermontAvenue, gbc_vermontAvenue);
		
		JButton chanceSouth = new JButton("");
		GridBagConstraints gbc_chanceSouth = new GridBagConstraints();
		gbc_chanceSouth.fill = GridBagConstraints.BOTH;
		gbc_chanceSouth.gridheight = 3;
		gbc_chanceSouth.insets = new Insets(0, 0, 5, 5);
		gbc_chanceSouth.gridx = 10;
		gbc_chanceSouth.gridy = 14;
		add(chanceSouth, gbc_chanceSouth);
		
		JButton orientalAvenue = new JButton("");
		GridBagConstraints gbc_orientalAvenue = new GridBagConstraints();
		gbc_orientalAvenue.fill = GridBagConstraints.BOTH;
		gbc_orientalAvenue.gridheight = 3;
		gbc_orientalAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_orientalAvenue.gridx = 11;
		gbc_orientalAvenue.gridy = 14;
		add(orientalAvenue, gbc_orientalAvenue);
		
		JButton readingRailroad = new JButton("");
		GridBagConstraints gbc_readingRailroad = new GridBagConstraints();
		gbc_readingRailroad.fill = GridBagConstraints.BOTH;
		gbc_readingRailroad.gridheight = 3;
		gbc_readingRailroad.insets = new Insets(0, 0, 5, 5);
		gbc_readingRailroad.gridx = 12;
		gbc_readingRailroad.gridy = 14;
		add(readingRailroad, gbc_readingRailroad);
		
		JButton incomeTax = new JButton("");
		GridBagConstraints gbc_incomeTax = new GridBagConstraints();
		gbc_incomeTax.fill = GridBagConstraints.BOTH;
		gbc_incomeTax.gridheight = 3;
		gbc_incomeTax.insets = new Insets(0, 0, 5, 5);
		gbc_incomeTax.gridx = 13;
		gbc_incomeTax.gridy = 14;
		add(incomeTax, gbc_incomeTax);
		
		JButton balticAvenue = new JButton("");
		GridBagConstraints gbc_balticAvenue = new GridBagConstraints();
		gbc_balticAvenue.fill = GridBagConstraints.BOTH;
		gbc_balticAvenue.gridheight = 3;
		gbc_balticAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_balticAvenue.gridx = 14;
		gbc_balticAvenue.gridy = 14;
		add(balticAvenue, gbc_balticAvenue);
		
		JButton communityChestSouth = new JButton("");
		GridBagConstraints gbc_communityChestSouth = new GridBagConstraints();
		gbc_communityChestSouth.fill = GridBagConstraints.BOTH;
		gbc_communityChestSouth.gridheight = 3;
		gbc_communityChestSouth.insets = new Insets(0, 0, 5, 5);
		gbc_communityChestSouth.gridx = 15;
		gbc_communityChestSouth.gridy = 14;
		add(communityChestSouth, gbc_communityChestSouth);
		
		JButton medditerraneanAvenue = new JButton("");
		GridBagConstraints gbc_medditerraneanAvenue = new GridBagConstraints();
		gbc_medditerraneanAvenue.fill = GridBagConstraints.BOTH;
		gbc_medditerraneanAvenue.gridheight = 3;
		gbc_medditerraneanAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_medditerraneanAvenue.gridx = 16;
		gbc_medditerraneanAvenue.gridy = 14;
		add(medditerraneanAvenue, gbc_medditerraneanAvenue);
		
		JButton go = new JButton("");
		GridBagConstraints gbc_go = new GridBagConstraints();
		gbc_go.fill = GridBagConstraints.BOTH;
		gbc_go.gridwidth = 3;
		gbc_go.gridheight = 3;
		gbc_go.insets = new Insets(0, 0, 5, 5);
		gbc_go.gridx = 17;
		gbc_go.gridy = 14;
		add(go, gbc_go);

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
