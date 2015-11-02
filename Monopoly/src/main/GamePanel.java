package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Player.PlayerType;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private MainWindow parent;
	private GamePanel thisGamePanel;

	public JButton btnEndGame;

	// index of player who is currently taking a turn
	public int currPlayer;

	/// DICE DATA MEMBERS ///
	private JButton diceButton;
	boolean diceActive = true;
	// random number generator used for dice rolling
	private Random ranGen;
	//variables that represent dice roll on board
	private JLabel dice1;
	private JLabel dice2;

	// flag set when a player rolls doubles -- will roll again
	private boolean doubles;	
	// reset to 0 each time it is a new player's turn, if reaches 3 for the same player, they
	//	go to jail
	private int numDoubles;
	
	// flag set when the dice roll is for attempting to get out of jail
	private boolean jailRoll;


	//variables for the player panels
	private JPanel panel, panel_1, panel_2, panel_3;

	// Array of piece images
	private HashMap<Player.GamePiece, Image> playerPieces = new HashMap<Player.GamePiece, Image>(6);

	//variables for the player pieces
	private JLabel player1, player2, player3, player4;
	private GridBagConstraints gbc_player1, gbc_player2, gbc_player3, gbc_player4;

	private final static String CARD = "card";
	private final static String PLAYER = "player";
	// array to track players
	private GridBagConstraints[] gridLocations = new GridBagConstraints[40];
	
	//current indexes of each deck
	int indexChance = 0;
	int indexChest = 0;
	
	//current decks of community chest and chance cards
	ArrayList<SpecialCard> chanceDeck = new ArrayList<SpecialCard>();
	ArrayList<SpecialCard> communityChestDeck = new ArrayList<SpecialCard>();
	

	/**
	 * Create the panel.
	 */
	public GamePanel(MainWindow par) {
		setBackground(new Color(255, 250, 205));
		this.parent = par;
		thisGamePanel = this;

		this.currPlayer = 0;
		this.jailRoll = false;
		this.diceActive = true;
		this.numDoubles = 0;
		this.ranGen = new Random(System.currentTimeMillis());

		this.playerPieces.put(Player.GamePiece.RACECAR ,new ImageIcon(this.getClass().getResource("/car.png")).getImage());
		this.playerPieces.put(Player.GamePiece.DOG, new ImageIcon(this.getClass().getResource("/dog.png")).getImage());
		this.playerPieces.put(Player.GamePiece.SHOE, new ImageIcon(this.getClass().getResource("/shoe.png")).getImage());
		this.playerPieces.put(Player.GamePiece.HAT, new ImageIcon(this.getClass().getResource("/hat.png")).getImage());
		this.playerPieces.put(Player.GamePiece.THIMBLE, new ImageIcon(this.getClass().getResource("/thimble.png")).getImage());
		this.playerPieces.put(Player.GamePiece.SHIP, new ImageIcon(this.getClass().getResource("/ship.png")).getImage());

		setBackground(new Color(255, 250, 205));

		setBounds(100, 100, 900, 725);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50};
		gridBagLayout.rowHeights = new int[]{50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		
		JButton btnTrade = new JButton("Trade");
		GridBagConstraints gbc_btnTrade = new GridBagConstraints();
		gbc_btnTrade.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrade.gridx = 9;
		gbc_btnTrade.gridy = 6;
		add(btnTrade, gbc_btnTrade);
		btnTrade.addActionListener(tradeClicked);
		
		
		/////////////////////////
		//TODO: Pieces are created on game start, need to be created when the setup screen is left! 
		/////////////////////////
		// Create labels for pieces, need them to dynamically move
		player1 = new JLabel("");
		gbc_player1 = new GridBagConstraints();
		gbc_player1.fill = GridBagConstraints.NONE;
		gbc_player1.anchor = GridBagConstraints.NORTHWEST;
		gbc_player1.insets = new Insets(0, 0, 5, 5);
		gbc_player1.gridx = 14;
		gbc_player1.gridy = 14;
		Image player1Icon = playerPieces.get(parent.players[0].getPiece());
		player1.setIcon(new ImageIcon(player1Icon));
		add(player1, gbc_player1);
		setComponentZOrder(player1, 0);

		player2 = new JLabel("");
		gbc_player2 = new GridBagConstraints();
		gbc_player2.fill = GridBagConstraints.NONE;
		gbc_player2.anchor = GridBagConstraints.NORTHEAST;
		gbc_player2.insets = new Insets(0, 0, 5, 5);
		gbc_player2.gridx = 14;
		gbc_player2.gridy = 14;
		Image player2Icon = playerPieces.get(parent.players[1].getPiece());
		player2.setIcon(new ImageIcon(player2Icon));
		add(player2, gbc_player2);
		setComponentZOrder(player2, 0);

		player3 = new JLabel("");
		gbc_player3 = new GridBagConstraints();
		gbc_player3.fill = GridBagConstraints.NONE;
		gbc_player3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_player3.insets = new Insets(0, 0, 5, 5);
		gbc_player3.gridx = 14;
		gbc_player3.gridy = 14;
		Image player3Icon = playerPieces.get(parent.players[2].getPiece());
		player3.setIcon(new ImageIcon(player3Icon));
		add(player3, gbc_player3);
		setComponentZOrder(player3, 0);

		player4 = new JLabel("");
		gbc_player4 = new GridBagConstraints();
		gbc_player4.fill = GridBagConstraints.NONE;
		gbc_player4.anchor = GridBagConstraints.SOUTHEAST;
		gbc_player4.insets = new Insets(0, 0, 5, 5);
		gbc_player4.gridx = 14;
		gbc_player4.gridy = 14;
		Image player4Icon = playerPieces.get(parent.players[3].getPiece());
		player4.setIcon(new ImageIcon(player4Icon));
		add(player4, gbc_player4);
		setComponentZOrder(player4, 0);


		// Add listener to each space, pop a JOptionPane.showMessageDialog() with card image

		JButton freeParking = new JButton("");
		GridBagConstraints gbc_freeParking = new GridBagConstraints();
		gbc_freeParking.fill = GridBagConstraints.BOTH;
		gbc_freeParking.gridwidth = 3;
		gbc_freeParking.gridheight = 3;
		gbc_freeParking.insets = new Insets(0, 0, 5, 5);
		gbc_freeParking.gridx = 2;
		gbc_freeParking.gridy = 2;
		gridLocations[20] = gbc_freeParking;
		Image freeParkingIcon = new ImageIcon(this.getClass().getResource("/freeparking.jpg")).getImage();
		freeParking.setIcon(new ImageIcon(freeParkingIcon));
		setComponentZOrder(freeParking, 1);
		add(freeParking, gbc_freeParking);


		JButton kentuckyAvenue = new JButton("");
		GridBagConstraints gbc_kentuckyAvenue = new GridBagConstraints();
		gbc_kentuckyAvenue.fill = GridBagConstraints.BOTH;
		gbc_kentuckyAvenue.gridheight = 3;
		gbc_kentuckyAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_kentuckyAvenue.gridx = 5;
		gbc_kentuckyAvenue.gridy = 2;
		gridLocations[21] = gbc_kentuckyAvenue;
		Image red = new ImageIcon(this.getClass().getResource("/redspace.jpg")).getImage();
		kentuckyAvenue.setIcon(new ImageIcon(red));
		kentuckyAvenue.putClientProperty(GamePanel.CARD , 21);
		kentuckyAvenue.addActionListener(spaceClicked);
		setComponentZOrder(kentuckyAvenue, 1);
		add(kentuckyAvenue, gbc_kentuckyAvenue);

		JButton chanceNorth = new JButton("");
		GridBagConstraints gbc_chanceNorth = new GridBagConstraints();
		gbc_chanceNorth.fill = GridBagConstraints.BOTH;
		gbc_chanceNorth.gridheight = 3;
		gbc_chanceNorth.insets = new Insets(0, 0, 5, 5);
		gbc_chanceNorth.gridx = 6;
		gbc_chanceNorth.gridy = 2;
		gridLocations[22] = gbc_chanceNorth;
		Image chanceNorthIcon = new ImageIcon(this.getClass().getResource("/chancenorth.jpg")).getImage();
		chanceNorth.setIcon(new ImageIcon(chanceNorthIcon));
		setComponentZOrder(chanceNorth, 1);
		add(chanceNorth, gbc_chanceNorth);


		JButton indianaAvenue = new JButton("");
		GridBagConstraints gbc_indianaAvenue = new GridBagConstraints();
		gbc_indianaAvenue.fill = GridBagConstraints.BOTH;
		gbc_indianaAvenue.gridheight = 3;
		gbc_indianaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_indianaAvenue.gridx = 7;
		gbc_indianaAvenue.gridy = 2;
		gridLocations[23] = gbc_indianaAvenue;
		indianaAvenue.setIcon(new ImageIcon(red));
		indianaAvenue.putClientProperty(GamePanel.CARD , 23);
		indianaAvenue.addActionListener(spaceClicked);
		setComponentZOrder(indianaAvenue, 1);
		add(indianaAvenue, gbc_indianaAvenue);


		JButton illinoisAvenue = new JButton("");
		GridBagConstraints gbc_illinoisAvenue = new GridBagConstraints();
		gbc_illinoisAvenue.fill = GridBagConstraints.BOTH;
		gbc_illinoisAvenue.gridheight = 3;
		gbc_illinoisAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_illinoisAvenue.gridx = 8;
		gbc_illinoisAvenue.gridy = 2;
		gridLocations[24] = gbc_illinoisAvenue;
		illinoisAvenue.setIcon(new ImageIcon(red));
		illinoisAvenue.putClientProperty(GamePanel.CARD , 24);
		illinoisAvenue.addActionListener(spaceClicked);
		setComponentZOrder(illinoisAvenue, 1);
		add(illinoisAvenue, gbc_illinoisAvenue);


		JButton bORailroad = new JButton("");
		GridBagConstraints gbc_bORailroad = new GridBagConstraints();
		gbc_bORailroad.fill = GridBagConstraints.BOTH;
		gbc_bORailroad.gridheight = 3;
		gbc_bORailroad.insets = new Insets(0, 0, 5, 5);
		gbc_bORailroad.gridx = 9;
		gbc_bORailroad.gridy = 2;
		gridLocations[25] = gbc_bORailroad;
		Image rrNorth = new ImageIcon(this.getClass().getResource("/rrsouth.jpg")).getImage();
		bORailroad.setIcon(new ImageIcon(rrNorth));
		bORailroad.putClientProperty(GamePanel.CARD , 25);
		bORailroad.addActionListener(spaceClicked);
		setComponentZOrder(bORailroad, 1);
		add(bORailroad, gbc_bORailroad);


		JButton atlanticAvenue = new JButton("");
		GridBagConstraints gbc_atlanticAvenue = new GridBagConstraints();
		gbc_atlanticAvenue.fill = GridBagConstraints.BOTH;
		gbc_atlanticAvenue.gridheight = 3;
		gbc_atlanticAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_atlanticAvenue.gridx = 10;
		gbc_atlanticAvenue.gridy = 2;
		gridLocations[26] = gbc_atlanticAvenue;
		Image yellow = new ImageIcon(this.getClass().getResource("/yellowspace.jpg")).getImage();
		atlanticAvenue.setIcon(new ImageIcon(yellow));
		atlanticAvenue.putClientProperty(GamePanel.CARD , 26);
		atlanticAvenue.addActionListener(spaceClicked);
		setComponentZOrder(atlanticAvenue, 1);
		add(atlanticAvenue, gbc_atlanticAvenue);


		JButton ventnorAvenue = new JButton("");
		GridBagConstraints gbc_ventnorAvenue = new GridBagConstraints();
		gbc_ventnorAvenue.fill = GridBagConstraints.BOTH;
		gbc_ventnorAvenue.gridheight = 3;
		gbc_ventnorAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_ventnorAvenue.gridx = 11;
		gbc_ventnorAvenue.gridy = 2;
		gridLocations[27] = gbc_ventnorAvenue;
		ventnorAvenue.setIcon(new ImageIcon(yellow));
		ventnorAvenue.putClientProperty(GamePanel.CARD , 27);
		ventnorAvenue.addActionListener(spaceClicked);
		setComponentZOrder(ventnorAvenue, 1);
		add(ventnorAvenue, gbc_ventnorAvenue);

		JButton waterWorks = new JButton("");
		GridBagConstraints gbc_waterWorks = new GridBagConstraints();
		gbc_waterWorks.fill = GridBagConstraints.BOTH;
		gbc_waterWorks.gridheight = 3;
		gbc_waterWorks.insets = new Insets(0, 0, 5, 5);
		gbc_waterWorks.gridx = 12;
		gbc_waterWorks.gridy = 2;
		gridLocations[28] = gbc_waterWorks;
		Image waterWorksIcon = new ImageIcon(this.getClass().getResource("/waterworkks.jpg")).getImage();
		waterWorks.setIcon(new ImageIcon(waterWorksIcon));
		waterWorks.putClientProperty(GamePanel.CARD , 28);
		waterWorks.addActionListener(spaceClicked);
		setComponentZOrder(waterWorks, 1);
		add(waterWorks, gbc_waterWorks);

		JButton marvinGardens = new JButton("");
		GridBagConstraints gbc_marvinGardens = new GridBagConstraints();
		gbc_marvinGardens.fill = GridBagConstraints.BOTH;
		gbc_marvinGardens.gridheight = 3;
		gbc_marvinGardens.insets = new Insets(0, 0, 5, 5);
		gbc_marvinGardens.gridx = 13;
		gbc_marvinGardens.gridy = 2;
		gridLocations[29] = gbc_marvinGardens;
		marvinGardens.setIcon(new ImageIcon(yellow));
		marvinGardens.putClientProperty(GamePanel.CARD , 29);
		marvinGardens.addActionListener(spaceClicked);
		setComponentZOrder(marvinGardens, 1);
		add(marvinGardens, gbc_marvinGardens);

		JButton goToJail = new JButton("");
		GridBagConstraints gbc_goToJail = new GridBagConstraints();
		gbc_goToJail.fill = GridBagConstraints.BOTH;
		gbc_goToJail.gridheight = 3;
		gbc_goToJail.gridwidth = 3;
		gbc_goToJail.insets = new Insets(0, 0, 5, 5);
		gbc_goToJail.gridx = 14;
		gbc_goToJail.gridy = 2;
		gridLocations[30] = gbc_goToJail;
		Image goToJailIcon = new ImageIcon(this.getClass().getResource("/gotojail.jpg")).getImage();
		goToJail.setIcon(new ImageIcon(goToJailIcon));
		setComponentZOrder(goToJail, 1);
		add(goToJail, gbc_goToJail);

		JButton newYorkAvenue = new JButton("");
		GridBagConstraints gbc_newYorkAvenue = new GridBagConstraints();
		gbc_newYorkAvenue.fill = GridBagConstraints.BOTH;
		gbc_newYorkAvenue.gridwidth = 3;
		gbc_newYorkAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_newYorkAvenue.gridx = 2;
		gbc_newYorkAvenue.gridy = 5;
		gridLocations[19] = gbc_newYorkAvenue;
		Image orange = new ImageIcon(this.getClass().getResource("/orangespace.jpg")).getImage();
		newYorkAvenue.setIcon(new ImageIcon(orange));
		newYorkAvenue.putClientProperty(GamePanel.CARD , 19);
		newYorkAvenue.addActionListener(spaceClicked);
		setComponentZOrder(newYorkAvenue, 1);
		add(newYorkAvenue, gbc_newYorkAvenue);

		JButton pacificAvenue = new JButton("");
		GridBagConstraints gbc_pacificAvenue = new GridBagConstraints();
		gbc_pacificAvenue.fill = GridBagConstraints.BOTH;
		gbc_pacificAvenue.gridwidth = 3;
		gbc_pacificAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_pacificAvenue.gridx = 14;
		gbc_pacificAvenue.gridy = 5;
		gridLocations[31] = gbc_pacificAvenue;
		Image green = new ImageIcon(this.getClass().getResource("/greenspace.jpg")).getImage();
		pacificAvenue.setIcon(new ImageIcon(green));
		pacificAvenue.putClientProperty(GamePanel.CARD , 31);
		pacificAvenue.addActionListener(spaceClicked);
		setComponentZOrder(pacificAvenue, 1);
		add(pacificAvenue, gbc_pacificAvenue);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 5;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		panel.setLayout(gbl_panel);

		GridBagConstraints gbc_player1Name = new GridBagConstraints();
		gbc_player1Name.fill = GridBagConstraints.BOTH;
		gbc_player1Name.insets = new Insets(0, 0, 5, 5);
		gbc_player1Name.gridx = 0;
		gbc_player1Name.gridy = 1;
		panel.add(parent.players[0].nameL, gbc_player1Name);

		JLabel player1CashLabel = new JLabel("Cash: ");
		GridBagConstraints gbc_player1CashLabel = new GridBagConstraints();
		gbc_player1CashLabel.fill = GridBagConstraints.BOTH;
		gbc_player1CashLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player1CashLabel.gridx = 0;
		gbc_player1CashLabel.gridy = 2;
		panel.add(player1CashLabel, gbc_player1CashLabel);

		GridBagConstraints gbc_player1Cash = new GridBagConstraints();
		gbc_player1Cash.fill = GridBagConstraints.VERTICAL;
		gbc_player1Cash.insets = new Insets(0, 0, 5, 0);
		gbc_player1Cash.gridx = 1;
		gbc_player1Cash.gridy = 2;
		panel.add(parent.players[0].bankL, gbc_player1Cash);

//		GridBagConstraints gbc_player1Properties = new GridBagConstraints();
//		gbc_player1Properties.insets = new Insets(0, 0, 5, 0);
//		gbc_player1Properties.gridx = 1;
//		gbc_player1Properties.gridy = 3;
//		panel.add(parent.players[0].propertiesL, gbc_player1Properties);

		JLabel player1PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player1PropertiesLabel = new GridBagConstraints();
		gbc_player1PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player1PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player1PropertiesLabel.gridx = 0;
		gbc_player1PropertiesLabel.gridy = 3;
		panel.add(player1PropertiesLabel, gbc_player1PropertiesLabel);
		
		JButton btnProperties = new JButton("Properties");
		GridBagConstraints gbc_btnProperties = new GridBagConstraints();
		gbc_btnProperties.insets = new Insets(0, 0, 5, 0);
		gbc_btnProperties.gridx = 1;
		gbc_btnProperties.gridy = 3;
		btnProperties.putClientProperty(PLAYER, 0);
		btnProperties.addActionListener(propertiesClicked);
		panel.add(btnProperties, gbc_btnProperties);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 10;
		gbc_panel_1.gridy = 5;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0 ,0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		panel_1.setLayout(gbl_panel_1);

		GridBagConstraints gbc_player2Name = new GridBagConstraints();
		gbc_player2Name.fill = GridBagConstraints.BOTH;
		gbc_player2Name.insets = new Insets(0, 0, 5, 5);
		gbc_player2Name.gridx = 0;
		gbc_player2Name.gridy = 1;
		panel_1.add(parent.players[1].nameL, gbc_player2Name);

		JLabel player2CashLabel = new JLabel("Cash: ");
		GridBagConstraints gbc_player2CashLabel = new GridBagConstraints();
		gbc_player2CashLabel.fill = GridBagConstraints.BOTH;
		gbc_player2CashLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player2CashLabel.gridx = 0;
		gbc_player2CashLabel.gridy = 2;
		panel_1.add(player2CashLabel, gbc_player2CashLabel);

		GridBagConstraints gbc_player2Cash = new GridBagConstraints();
		gbc_player2Cash.fill = GridBagConstraints.VERTICAL;
		gbc_player2Cash.insets = new Insets(0, 0, 5, 0);
		gbc_player2Cash.gridx = 1;
		gbc_player2Cash.gridy = 2;
		panel_1.add(parent.players[1].bankL, gbc_player2Cash);

//		GridBagConstraints gbc_player2Properties = new GridBagConstraints();
//		gbc_player2Properties.insets = new Insets(0, 0, 5, 0);
//		gbc_player2Properties.gridx = 1;
//		gbc_player2Properties.gridy = 3;
//		panel_1.add(parent.players[1].propertiesL, gbc_player2Properties);

		JLabel player2PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player2PropertiesLabel = new GridBagConstraints();
		gbc_player2PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player2PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player2PropertiesLabel.gridx = 0;
		gbc_player2PropertiesLabel.gridy = 3;
		panel_1.add(player2PropertiesLabel, gbc_player2PropertiesLabel);
		
		JButton button = new JButton("Properties");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		button.putClientProperty(PLAYER, 1);
		button.addActionListener(propertiesClicked);
		panel_1.add(button, gbc_button);

		JButton tennesseeAvenue = new JButton("");
		GridBagConstraints gbc_tennesseeAvenue = new GridBagConstraints();
		gbc_tennesseeAvenue.fill = GridBagConstraints.BOTH;
		gbc_tennesseeAvenue.gridwidth = 3;
		gbc_tennesseeAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_tennesseeAvenue.gridx = 2;
		gbc_tennesseeAvenue.gridy = 6;
		gridLocations[18] = gbc_tennesseeAvenue;
		tennesseeAvenue.setIcon(new ImageIcon(orange));
		tennesseeAvenue.putClientProperty(GamePanel.CARD , 18);
		tennesseeAvenue.addActionListener(spaceClicked);
		setComponentZOrder(tennesseeAvenue, 1);
		add(tennesseeAvenue, gbc_tennesseeAvenue);

		JButton northCarolinaAvenue = new JButton("");
		GridBagConstraints gbc_northCarolinaAvenue = new GridBagConstraints();
		gbc_northCarolinaAvenue.fill = GridBagConstraints.BOTH;
		gbc_northCarolinaAvenue.gridwidth = 3;
		gbc_northCarolinaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_northCarolinaAvenue.gridx = 14;
		gbc_northCarolinaAvenue.gridy = 6;
		gridLocations[32] = gbc_northCarolinaAvenue;
		northCarolinaAvenue.setIcon(new ImageIcon(green));
		northCarolinaAvenue.putClientProperty(GamePanel.CARD , 32);
		northCarolinaAvenue.addActionListener(spaceClicked);
		setComponentZOrder(northCarolinaAvenue, 1);
		add(northCarolinaAvenue, gbc_northCarolinaAvenue);

		JButton communityChestWest = new JButton("");
		GridBagConstraints gbc_communityChestWest = new GridBagConstraints();
		gbc_communityChestWest.fill = GridBagConstraints.BOTH;
		gbc_communityChestWest.gridwidth = 3;
		gbc_communityChestWest.insets = new Insets(0, 0, 5, 5);
		gbc_communityChestWest.gridx = 2;
		gbc_communityChestWest.gridy = 7;
		gridLocations[17] = gbc_communityChestWest;
		Image communityChestWestIcon = new ImageIcon(this.getClass().getResource("/commchestwest.jpg")).getImage();
		communityChestWest.setIcon(new ImageIcon(communityChestWestIcon));
		setComponentZOrder(communityChestWest, 1);
		add(communityChestWest, gbc_communityChestWest);

		JButton communityChestEast = new JButton("");
		GridBagConstraints gbc_communityChestEast = new GridBagConstraints();
		gbc_communityChestEast.fill = GridBagConstraints.BOTH;
		gbc_communityChestEast.gridwidth = 3;
		gbc_communityChestEast.insets = new Insets(0, 0, 5, 5);
		gbc_communityChestEast.gridx = 14;
		gbc_communityChestEast.gridy = 7;
		gridLocations[33] = gbc_communityChestEast;
		Image communityChestEastIcon = new ImageIcon(this.getClass().getResource("/commchesteast.jpg")).getImage();
		communityChestEast.setIcon(new ImageIcon(communityChestEastIcon));
		setComponentZOrder(communityChestEast, 1);
		add(communityChestEast, gbc_communityChestEast);

		JButton stJamesPlace = new JButton("");
		GridBagConstraints gbc_stJamesPlace = new GridBagConstraints();
		gbc_stJamesPlace.fill = GridBagConstraints.BOTH;
		gbc_stJamesPlace.gridwidth = 3;
		gbc_stJamesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_stJamesPlace.gridx = 2;
		gbc_stJamesPlace.gridy = 8;
		gridLocations[16] = gbc_stJamesPlace;
		stJamesPlace.setIcon(new ImageIcon(orange));
		stJamesPlace.putClientProperty(GamePanel.CARD , 16);
		stJamesPlace.addActionListener(spaceClicked);
		setComponentZOrder(stJamesPlace, 1);
		add(stJamesPlace, gbc_stJamesPlace);

		this.diceButton = new JButton("");
		GridBagConstraints gbc_diceButton = new GridBagConstraints();
		gbc_diceButton.fill = GridBagConstraints.BOTH;
		gbc_diceButton.gridwidth = 1;
		gbc_diceButton.gridheight = 1;
		gbc_diceButton.insets = new Insets(0, 0, 5, 5);
		gbc_diceButton.gridx = 9;
		gbc_diceButton.gridy = 9;
		Image img = new ImageIcon(this.getClass().getResource("/dice.jpg")).getImage();
		this.diceButton.setIcon(new ImageIcon(img));
		this.diceButton.addActionListener(diceClicked);
		add(this.diceButton, gbc_diceButton);

		dice1 = new JLabel("");
		dice1.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_dice1 = new GridBagConstraints();
		gbc_dice1.insets = new Insets(0, 0, 5, 5);
		gbc_dice1.gridx = 8;
		gbc_dice1.gridy = 9;
		add(dice1, gbc_dice1);


		JButton pennsylvaniaAvenue = new JButton("");
		GridBagConstraints gbc_pennsylvaniaAvenue = new GridBagConstraints();
		gbc_pennsylvaniaAvenue.fill = GridBagConstraints.BOTH;
		gbc_pennsylvaniaAvenue.gridwidth = 3;
		gbc_pennsylvaniaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_pennsylvaniaAvenue.gridx = 14;
		gbc_pennsylvaniaAvenue.gridy = 8;
		gridLocations[34] = gbc_pennsylvaniaAvenue;
		pennsylvaniaAvenue.setIcon(new ImageIcon(green));
		pennsylvaniaAvenue.putClientProperty(GamePanel.CARD , 34);
		pennsylvaniaAvenue.addActionListener(spaceClicked);
		setComponentZOrder(pennsylvaniaAvenue, 1);
		add(pennsylvaniaAvenue, gbc_pennsylvaniaAvenue);

		JButton pennsylvaniaRailroad = new JButton("");
		GridBagConstraints gbc_pennsylvaniaRailroad = new GridBagConstraints();
		gbc_pennsylvaniaRailroad.fill = GridBagConstraints.BOTH;
		gbc_pennsylvaniaRailroad.gridwidth = 3;
		gbc_pennsylvaniaRailroad.insets = new Insets(0, 0, 5, 5);
		gbc_pennsylvaniaRailroad.gridx = 2;
		gbc_pennsylvaniaRailroad.gridy = 9;
		gridLocations[15] = gbc_pennsylvaniaRailroad;
		Image rrWest = new ImageIcon(this.getClass().getResource("/rrwest.jpg")).getImage();
		pennsylvaniaRailroad.setIcon(new ImageIcon(rrWest));
		pennsylvaniaRailroad.putClientProperty(GamePanel.CARD , 15);
		pennsylvaniaRailroad.addActionListener(spaceClicked);
		setComponentZOrder(pennsylvaniaRailroad, 1);
		add(pennsylvaniaRailroad, gbc_pennsylvaniaRailroad);

		JButton shortLine = new JButton("");
		GridBagConstraints gbc_shortLine = new GridBagConstraints();
		gbc_shortLine.fill = GridBagConstraints.BOTH;
		gbc_shortLine.gridwidth = 3;
		gbc_shortLine.insets = new Insets(0, 0, 5, 5);
		gbc_shortLine.gridx = 14;
		gbc_shortLine.gridy = 9;
		gridLocations[35] = gbc_shortLine;
		Image rrEast = new ImageIcon(this.getClass().getResource("/rreast.jpg")).getImage();
		shortLine.setIcon(new ImageIcon(rrEast));
		shortLine.putClientProperty(GamePanel.CARD , 35);
		shortLine.addActionListener(spaceClicked);
		setComponentZOrder(shortLine, 1);
		add(shortLine, gbc_shortLine);

		dice2 = new JLabel("");
		dice2.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_dice2 = new GridBagConstraints();
		gbc_dice2.insets = new Insets(0, 0, 5, 5);
		gbc_dice2.gridx = 10;
		gbc_dice2.gridy = 9;
		add(dice2, gbc_dice2);

		JButton virginiaAvenue = new JButton("");
		GridBagConstraints gbc_virginiaAvenue = new GridBagConstraints();
		gbc_virginiaAvenue.fill = GridBagConstraints.BOTH;
		gbc_virginiaAvenue.gridwidth = 3;
		gbc_virginiaAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_virginiaAvenue.gridx = 2;
		gbc_virginiaAvenue.gridy = 10;
		gridLocations[14] = gbc_virginiaAvenue;
		Image purple = new ImageIcon(this.getClass().getResource("/purplespace.jpg")).getImage();
		virginiaAvenue.setIcon(new ImageIcon(purple));
		virginiaAvenue.putClientProperty(GamePanel.CARD , 14);
		virginiaAvenue.addActionListener(spaceClicked);
		setComponentZOrder(virginiaAvenue, 1);
		add(virginiaAvenue, gbc_virginiaAvenue);

		JButton chanceEast = new JButton("");
		GridBagConstraints gbc_chanceEast = new GridBagConstraints();
		gbc_chanceEast.fill = GridBagConstraints.BOTH;
		gbc_chanceEast.gridwidth = 3;
		gbc_chanceEast.insets = new Insets(0, 0, 5, 5);
		gbc_chanceEast.gridx = 14;
		gbc_chanceEast.gridy = 10;
		gridLocations[36] = gbc_chanceEast;
		Image chanceEastIcon = new ImageIcon(this.getClass().getResource("/chanceeast.jpg")).getImage();
		chanceEast.setIcon(new ImageIcon(chanceEastIcon));
		setComponentZOrder(chanceEast, 1);
		add(chanceEast, gbc_chanceEast);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.gridheight = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 5;
		gbc_panel_2.gridy = 10;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0 ,0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		panel_2.setLayout(gbl_panel_2);

		GridBagConstraints gbc_player3Name = new GridBagConstraints();
		gbc_player3Name.fill = GridBagConstraints.BOTH;
		gbc_player3Name.insets = new Insets(0, 0, 5, 5);
		gbc_player3Name.gridx = 0;
		gbc_player3Name.gridy = 1;
		panel_2.add(parent.players[2].nameL, gbc_player3Name);

		JLabel player3CashLabel = new JLabel("Cash: ");
		GridBagConstraints gbc_player3CashLabel = new GridBagConstraints();
		gbc_player3CashLabel.fill = GridBagConstraints.BOTH;
		gbc_player3CashLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player3CashLabel.gridx = 0;
		gbc_player3CashLabel.gridy = 2;
		panel_2.add(player3CashLabel, gbc_player3CashLabel);

		GridBagConstraints gbc_player3Cash = new GridBagConstraints();
		gbc_player3Cash.fill = GridBagConstraints.VERTICAL;
		gbc_player3Cash.insets = new Insets(0, 0, 5, 0);
		gbc_player3Cash.gridx = 1;
		gbc_player3Cash.gridy = 2;
		panel_2.add(parent.players[2].bankL, gbc_player3Cash);

//		GridBagConstraints gbc_player3Properties = new GridBagConstraints();
//		gbc_player3Properties.insets = new Insets(0, 0, 5, 0);
//		gbc_player3Properties.gridx = 1;
//		gbc_player3Properties.gridy = 3;
//		panel_2.add(parent.players[2].propertiesL, gbc_player3Properties);

		JLabel player3PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player3PropertiesLabel = new GridBagConstraints();
		gbc_player3PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player3PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player3PropertiesLabel.gridx = 0;
		gbc_player3PropertiesLabel.gridy = 3;
		panel_2.add(player3PropertiesLabel, gbc_player3PropertiesLabel);
		
		JButton button_1 = new JButton("Properties");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 3;
		button_1.putClientProperty(PLAYER, 2);
		button_1.addActionListener(propertiesClicked);
		panel_2.add(button_1, gbc_button_1);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 4;
		gbc_panel_3.gridheight = 4;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 10;
		gbc_panel_3.gridy = 10;
		add(panel_3, gbc_panel_3);


		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0 ,0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		panel_3.setLayout(gbl_panel_3);

		GridBagConstraints gbc_player4Name = new GridBagConstraints();
		gbc_player4Name.fill = GridBagConstraints.BOTH;
		gbc_player4Name.insets = new Insets(0, 0, 5, 5);
		gbc_player4Name.gridx = 0;
		gbc_player4Name.gridy = 1;
		panel_3.add(parent.players[3].nameL, gbc_player4Name);

		JLabel player4CashLabel = new JLabel("Cash: ");
		GridBagConstraints gbc_player4CashLabel = new GridBagConstraints();
		gbc_player4CashLabel.fill = GridBagConstraints.BOTH;
		gbc_player4CashLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player4CashLabel.gridx = 0;
		gbc_player4CashLabel.gridy = 2;
		panel_3.add(player4CashLabel, gbc_player4CashLabel);

		GridBagConstraints gbc_player4Cash = new GridBagConstraints();
		gbc_player4Cash.fill = GridBagConstraints.VERTICAL;
		gbc_player4Cash.insets = new Insets(0, 0, 5, 0);
		gbc_player4Cash.gridx = 1;
		gbc_player4Cash.gridy = 2;
		panel_3.add(parent.players[3].bankL, gbc_player4Cash);

//		GridBagConstraints gbc_player4Properties = new GridBagConstraints();
//		gbc_player4Properties.insets = new Insets(0, 0, 5, 0);
//		gbc_player4Properties.gridx = 1;
//		gbc_player4Properties.gridy = 3;
//		panel_3.add(parent.players[3].propertiesL, gbc_player4Properties);

		JLabel player4PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player4PropertiesLabel = new GridBagConstraints();
		gbc_player4PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player4PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player4PropertiesLabel.gridx = 0;
		gbc_player4PropertiesLabel.gridy = 3;
		panel_3.add(player4PropertiesLabel, gbc_player4PropertiesLabel);
		
		JButton button_2 = new JButton("Properties");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 3;
		button_2.putClientProperty(PLAYER, 3);
		button_2.addActionListener(propertiesClicked);
		panel_3.add(button_2, gbc_button_2);

		JButton statesAvenue = new JButton("");
		GridBagConstraints gbc_statesAvenue = new GridBagConstraints();
		gbc_statesAvenue.fill = GridBagConstraints.BOTH;
		gbc_statesAvenue.gridwidth = 3;
		gbc_statesAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_statesAvenue.gridx = 2;
		gbc_statesAvenue.gridy = 11;
		gridLocations[13]= gbc_statesAvenue;
		statesAvenue.setIcon(new ImageIcon(purple));
		statesAvenue.putClientProperty(GamePanel.CARD , 13);
		statesAvenue.addActionListener(spaceClicked);
		setComponentZOrder(statesAvenue, 1);
		add(statesAvenue, gbc_statesAvenue);

		JButton parkPlace = new JButton("");
		GridBagConstraints gbc_parkPlace = new GridBagConstraints();
		gbc_parkPlace.fill = GridBagConstraints.BOTH;
		gbc_parkPlace.gridwidth = 3;
		gbc_parkPlace.insets = new Insets(0, 0, 5, 5);
		gbc_parkPlace.gridx = 14;
		gbc_parkPlace.gridy = 11;
		gridLocations[37]= gbc_parkPlace;
		Image darkBlue = new ImageIcon(this.getClass().getResource("/darkbluespace.jpg")).getImage();
		parkPlace.setIcon(new ImageIcon(darkBlue));
		parkPlace.putClientProperty(GamePanel.CARD , 37);
		parkPlace.addActionListener(spaceClicked);
		setComponentZOrder(parkPlace, 1);
		add(parkPlace, gbc_parkPlace);

		JButton electricCompany = new JButton("");
		GridBagConstraints gbc_electricCompany = new GridBagConstraints();
		gbc_electricCompany.fill = GridBagConstraints.BOTH;
		gbc_electricCompany.gridwidth = 3;
		gbc_electricCompany.insets = new Insets(0, 0, 5, 5);
		gbc_electricCompany.gridx = 2;
		gbc_electricCompany.gridy = 12;
		gridLocations[12] = gbc_electricCompany;
		Image eCIcon = new ImageIcon(this.getClass().getResource("/electriccompany.jpg")).getImage();
		electricCompany.setIcon(new ImageIcon(eCIcon));
		electricCompany.putClientProperty(GamePanel.CARD , 12);
		electricCompany.addActionListener(spaceClicked);
		setComponentZOrder(electricCompany, 1);
		add(electricCompany, gbc_electricCompany);

		JButton luxuryTax = new JButton("");
		GridBagConstraints gbc_luxuryTax = new GridBagConstraints();
		gbc_luxuryTax.fill = GridBagConstraints.BOTH;
		gbc_luxuryTax.gridwidth = 3;
		gbc_luxuryTax.insets = new Insets(0, 0, 5, 5);
		gbc_luxuryTax.gridx = 14;
		gbc_luxuryTax.gridy = 12;
		gridLocations[38] = gbc_luxuryTax;
		Image luxuryTaxIcon = new ImageIcon(this.getClass().getResource("/luxtax.jpg")).getImage();
		luxuryTax.putClientProperty(GamePanel.CARD , 38);
		luxuryTax.addActionListener(spaceClicked);
		luxuryTax.setIcon(new ImageIcon(luxuryTaxIcon));
		setComponentZOrder(luxuryTax, 1);
		add(luxuryTax, gbc_luxuryTax);

		JButton stCharlesPlace = new JButton("");
		GridBagConstraints gbc_stCharlesPlace = new GridBagConstraints();
		gbc_stCharlesPlace.fill = GridBagConstraints.BOTH;
		gbc_stCharlesPlace.gridwidth = 3;
		gbc_stCharlesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_stCharlesPlace.gridx = 2;
		gbc_stCharlesPlace.gridy = 13;
		gridLocations[11] = gbc_stCharlesPlace;
		stCharlesPlace.setIcon(new ImageIcon(purple));
		stCharlesPlace.putClientProperty(GamePanel.CARD , 11);
		stCharlesPlace.addActionListener(spaceClicked);
		setComponentZOrder(stCharlesPlace, 1);
		add(stCharlesPlace, gbc_stCharlesPlace);

		JButton boardwalk = new JButton("");
		GridBagConstraints gbc_boardwalk = new GridBagConstraints();
		gbc_boardwalk.fill = GridBagConstraints.BOTH;
		gbc_boardwalk.gridwidth = 3;
		gbc_boardwalk.insets = new Insets(0, 0, 5, 5);
		gbc_boardwalk.gridx = 14;
		gbc_boardwalk.gridy = 13;
		gridLocations[39] = gbc_boardwalk;
		boardwalk.setIcon(new ImageIcon(darkBlue));
		boardwalk.putClientProperty(GamePanel.CARD , 39);
		boardwalk.addActionListener(spaceClicked);
		add(boardwalk, gbc_boardwalk);

		JButton jail = new JButton("");
		GridBagConstraints gbc_jail = new GridBagConstraints();
		gbc_jail.fill = GridBagConstraints.BOTH;
		gbc_jail.gridheight = 3;
		gbc_jail.gridwidth = 3;
		gbc_jail.insets = new Insets(0, 0, 5, 5);
		gbc_jail.gridx = 2;
		gbc_jail.gridy = 14;
		gridLocations[10] = gbc_jail;
		Image jailIcon = new ImageIcon(this.getClass().getResource("/injail.jpg")).getImage();
		jail.setIcon(new ImageIcon(jailIcon));
		setComponentZOrder(jail, 1);
		add(jail, gbc_jail);

		JButton connecticutAvenue = new JButton("");
		GridBagConstraints gbc_connecticutAvenue = new GridBagConstraints();
		gbc_connecticutAvenue.fill = GridBagConstraints.BOTH;
		gbc_connecticutAvenue.gridheight = 3;
		gbc_connecticutAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_connecticutAvenue.gridx = 5;
		gbc_connecticutAvenue.gridy = 14;
		gridLocations[9] = gbc_connecticutAvenue;
		Image lightBlue = new ImageIcon(this.getClass().getResource("/lightbluespace.jpg")).getImage();
		connecticutAvenue.setIcon(new ImageIcon(lightBlue));
		connecticutAvenue.putClientProperty(GamePanel.CARD , 9);
		connecticutAvenue.addActionListener(spaceClicked);
		setComponentZOrder(connecticutAvenue, 1);
		add(connecticutAvenue, gbc_connecticutAvenue);

		JButton vermontAvenue = new JButton("");
		GridBagConstraints gbc_vermontAvenue = new GridBagConstraints();
		gbc_vermontAvenue.fill = GridBagConstraints.BOTH;
		gbc_vermontAvenue.gridheight = 3;
		gbc_vermontAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_vermontAvenue.gridx = 6;
		gbc_vermontAvenue.gridy = 14;
		gridLocations[8] = gbc_vermontAvenue;
		vermontAvenue.setIcon(new ImageIcon(lightBlue));
		vermontAvenue.putClientProperty(GamePanel.CARD , 8);
		vermontAvenue.addActionListener(spaceClicked);
		setComponentZOrder(vermontAvenue, 1);
		add(vermontAvenue, gbc_vermontAvenue);

		JButton chanceSouth = new JButton("");
		GridBagConstraints gbc_chanceSouth = new GridBagConstraints();
		gbc_chanceSouth.fill = GridBagConstraints.BOTH;
		gbc_chanceSouth.gridheight = 3;
		gbc_chanceSouth.insets = new Insets(0, 0, 5, 5);
		gbc_chanceSouth.gridx = 7;
		gbc_chanceSouth.gridy = 14;
		gridLocations[7] = gbc_chanceSouth;
		Image chanceSouthIcon = new ImageIcon(this.getClass().getResource("/chancesouth.jpg")).getImage();
		chanceSouth.setIcon(new ImageIcon(chanceSouthIcon));
		setComponentZOrder(chanceSouth, 1);
		add(chanceSouth, gbc_chanceSouth);

		JButton orientalAvenue = new JButton("");
		GridBagConstraints gbc_orientalAvenue = new GridBagConstraints();
		gbc_orientalAvenue.fill = GridBagConstraints.BOTH;
		gbc_orientalAvenue.gridheight = 3;
		gbc_orientalAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_orientalAvenue.gridx = 8;
		gbc_orientalAvenue.gridy = 14;
		gridLocations[6] = gbc_orientalAvenue;
		orientalAvenue.setIcon(new ImageIcon(lightBlue));
		orientalAvenue.putClientProperty(GamePanel.CARD , 6);
		orientalAvenue.addActionListener(spaceClicked);
		setComponentZOrder(orientalAvenue, 1);
		add(orientalAvenue, gbc_orientalAvenue);

		JButton readingRailroad = new JButton("");
		GridBagConstraints gbc_readingRailroad = new GridBagConstraints();
		gbc_readingRailroad.fill = GridBagConstraints.BOTH;
		gbc_readingRailroad.gridheight = 3;
		gbc_readingRailroad.insets = new Insets(0, 0, 5, 5);
		gbc_readingRailroad.gridx = 9;
		gbc_readingRailroad.gridy = 14;
		gridLocations[5] = gbc_readingRailroad;
		Image rrSouth = new ImageIcon(this.getClass().getResource("/rrnorth.jpg")).getImage();
		readingRailroad.setIcon(new ImageIcon(rrSouth));
		readingRailroad.putClientProperty(GamePanel.CARD , 5);
		readingRailroad.addActionListener(spaceClicked);
		setComponentZOrder(readingRailroad, 1);
		add(readingRailroad, gbc_readingRailroad);

		JButton incomeTax = new JButton("");
		GridBagConstraints gbc_incomeTax = new GridBagConstraints();
		gbc_incomeTax.fill = GridBagConstraints.BOTH;
		gbc_incomeTax.gridheight = 3;
		gbc_incomeTax.insets = new Insets(0, 0, 5, 5);
		gbc_incomeTax.gridx = 10;
		gbc_incomeTax.gridy = 14;
		gridLocations[4] = gbc_incomeTax;
		Image incomeTaxIcon = new ImageIcon(this.getClass().getResource("/incometax.jpg")).getImage();
		incomeTax.setIcon(new ImageIcon(incomeTaxIcon));
		incomeTax.putClientProperty(GamePanel.CARD , 4);
		incomeTax.addActionListener(spaceClicked);
		setComponentZOrder(incomeTax, 1);
		add(incomeTax, gbc_incomeTax);

		JButton balticAvenue = new JButton("");
		GridBagConstraints gbc_balticAvenue = new GridBagConstraints();
		gbc_balticAvenue.fill = GridBagConstraints.BOTH;
		gbc_balticAvenue.gridheight = 3;
		gbc_balticAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_balticAvenue.gridx = 11;
		gbc_balticAvenue.gridy = 14;
		gridLocations[3] = gbc_balticAvenue;
		Image brown = new ImageIcon(this.getClass().getResource("/brownspace.jpg")).getImage();
		balticAvenue.setIcon(new ImageIcon(brown));
		balticAvenue.putClientProperty(GamePanel.CARD , 3);
		balticAvenue.addActionListener(spaceClicked);
		setComponentZOrder(balticAvenue, 1);
		add(balticAvenue, gbc_balticAvenue);

		JButton communityChestSouth = new JButton("");
		GridBagConstraints gbc_communityChestSouth = new GridBagConstraints();
		gbc_communityChestSouth.fill = GridBagConstraints.BOTH;
		gbc_communityChestSouth.gridheight = 3;
		gbc_communityChestSouth.insets = new Insets(0, 0, 5, 5);
		gbc_communityChestSouth.gridx = 12;
		gbc_communityChestSouth.gridy = 14;
		gridLocations[2] = gbc_communityChestSouth;
		Image communityChestSouthIcon = new ImageIcon(this.getClass().getResource("/commchestsouth.jpg")).getImage();
		communityChestSouth.setIcon(new ImageIcon(communityChestSouthIcon));
		setComponentZOrder(communityChestSouth, 1);
		add(communityChestSouth, gbc_communityChestSouth);

		JButton mediterraneanAvenue = new JButton("");
		GridBagConstraints gbc_medditerraneanAvenue = new GridBagConstraints();
		gbc_medditerraneanAvenue.fill = GridBagConstraints.BOTH;
		gbc_medditerraneanAvenue.gridheight = 3;
		gbc_medditerraneanAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_medditerraneanAvenue.gridx = 13;
		gbc_medditerraneanAvenue.gridy = 14;
		gridLocations[1] = gbc_medditerraneanAvenue;
		mediterraneanAvenue.setIcon(new ImageIcon(brown));
		mediterraneanAvenue.putClientProperty(GamePanel.CARD , 1);
		mediterraneanAvenue.addActionListener(spaceClicked);
		setComponentZOrder(mediterraneanAvenue, 1);
		add(mediterraneanAvenue, gbc_medditerraneanAvenue);

		JButton go = new JButton("");
		GridBagConstraints gbc_go = new GridBagConstraints();
		gbc_go.fill = GridBagConstraints.BOTH;
		gbc_go.gridwidth = 3;
		gbc_go.gridheight = 3;
		gbc_go.insets = new Insets(0, 0, 5, 5);
		gbc_go.gridx = 14;
		gbc_go.gridy = 14;
		gridLocations[0] = gbc_go;
		Image goIcon = new ImageIcon(this.getClass().getResource("/go.jpg")).getImage();
		go.setIcon(new ImageIcon(goIcon));
		setComponentZOrder(go, 1);
		add(go, gbc_go);

		btnEndGame = new JButton("End");
		GridBagConstraints gbc_btnEndGame = new GridBagConstraints();
		gbc_btnEndGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnEndGame.gridx = 9;
		gbc_btnEndGame.gridy = 17;
		btnEndGame.setVisible(false);
		add(btnEndGame, gbc_btnEndGame);

		/*for(int i = 0; i < 40; i++){
			System.out.println(gridLocations[i].gridy);
		}*/

		createChanceDeck();
		createCommunityChanceDeck();
		
		updateCurrentPlayer();


	}
	
	/* Function:	createChanceDeck()
	 * Purpose:		creates and shuffles the chance deck
	 * 				
	 */
	private void createChanceDeck()
	{
		//set up chance deck
		chanceDeck.add(new BankSpecialCard("Chance", "Pay poor tax of $15.", -15));
		chanceDeck.add(new BankSpecialCard("Chance", "You're building and loan matures.\nCollect $150.", 150));
		chanceDeck.add(new MoveSpecialCard("Chance", "Advance to Go!", 0));
		chanceDeck.add(new MoveSpecialCard("Chance", "Take a ride on the Reading Railroad!\nAdvance to Reading Railroad", 5));
		chanceDeck.add(new MoveSpecialCard("Chance", "Move back 3 spaces!", -3));
		Collections.shuffle(chanceDeck);
	}
	
	/* Function:	createCommunityChestDeck()
	 * Purpose:		creates and shuffles the community chest deck
	 * 				
	 */
	private void createCommunityChanceDeck()
	{
		//set up community chest deck
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Bank error in your favor\nCollect $200", 200));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Doctor's fee\nPay $50", -50));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "From sale of stock you gain $50", 50));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Holiday fund matures\nReceive $100", 100));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Income tax refund\nCollect $20", 20));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Life insurance matures\nGain $100", 100));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Pay hospital fee of $100", -100));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Pay school tax of $150", -150));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Receive $25 consultancy fee", 25));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "Receive $25 consultancy fee", 25));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "You have won second prize in a beauty contest\nCollect $10", 10));
		communityChestDeck.add(new BankSpecialCard("Community Chest", "You inherit $100", 100));
		Collections.shuffle(communityChestDeck);
	}
	
	public MainWindow getParentFrame(){
		return parent;
	}

	/* Handler:		diceClicked
	 * Purpose:		handles the dice button clicked event, rolls dice, moves the current player forward, and begins
	 * 				any interaction the user will have on the new space he/she has landed on
	 */
	private ActionListener diceClicked = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			// do nothing if dice is currently disabled
			if(diceActive == true && parent.players[currPlayer].isHuman()) {
				//deactivate dice
				diceActive = false;
				// roll the dice for the current player
				int d1 = diceRoll(); int d2 = diceRoll();
				// display the result of the dice on the screen (for now, console only)
				dice1.setText(""+d1); dice2.setText(""+d2);
				
				if(jailRoll) {
					jailRoll = false;
					if (d1 != d2) {
						// decrement player's time in jail and check if they have to pay the fine
						boolean dontHaveToPay = parent.players[currPlayer].stillinJail();
					
						if (dontHaveToPay) {
							JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
								", you did not roll doubles to get out of jail.", "Lost Turn", JOptionPane.INFORMATION_MESSAGE);
							nextTurn();
							return;
						}
						else {
							// ran out of times to attempt to roll doubles -- so deduct the fine
							parent.players[currPlayer].deductFromBank(50, parent.playersOut);
							JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
								", you are out of attempts for rolling doubles! Pay $50.", "Pay Jail Fine", 
								JOptionPane.INFORMATION_MESSAGE);
							
							// check if player exited game
							if (!parent.players[currPlayer].isActive()) {
								JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you are out of money!", 
									"Out of Game!", JOptionPane.INFORMATION_MESSAGE);
								++parent.playersOut;
							}
							// get the player out of jail
							parent.players[currPlayer].outOfJail();	
						}
					}
					else {
						JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
							", you got out of jail!", "Got out of Jail", JOptionPane.INFORMATION_MESSAGE);
						// get the player out of jail
						parent.players[currPlayer].outOfJail();
						numDoubles++;
					}
				}
				// if rolling to get out of jail, then the doubles don't let you roll again
				else if (d1 == d2) {
					doubles = true;	//player will roll again
					numDoubles++;
				}
				
				// check if the player has rolled 3 doubles in a row
				if (numDoubles == 3) {
					// in this case, the player goes directly to jail
					// move player to jail space
					parent.players[currPlayer].setCurrLocation(parent.jailSpace);
					movePlayerIcon();
					// inform the player of what happened
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you rolled"
							+ " doubles 3 times in a row.\nYou're going to jail!", "Go to Jail", 
							JOptionPane.INFORMATION_MESSAGE);
					// set jailed to true for their next turn
					parent.players[currPlayer].putInJail();
					
					nextTurn();
				}
				
				else {
					// advance the current player's position
					movePlayer(d1+d2);		

					// given the state of the current property, notify user or allow user to take action
					takeAction(parent.spaces.get(parent.players[currPlayer].getCurrLocation()), d1+d2);

					// going to next turn will take place in takeAction or in an event handler for an event
					//	that will be created by takeAction						
				}
				

			}
		}
	};

	/* Function: 	compTurnBegin()
	 * Purpose:		analogous to the diceClicked handler, but for a computer player's turn
	 */
	public void compTurnBegin() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// roll the dice for the computer player
		int d1 = diceRoll(); int d2 = diceRoll();
		// display the result of the dice on the screen 
		dice1.setText(""+d1); dice2.setText(""+d2);
		
		if(jailRoll) {
			jailRoll = false;
			if (d1 != d2) {
				// decrement player's time in jail and check if they have to pay the fine
				boolean dontHaveToPay = parent.players[currPlayer].stillinJail();
			
				if (dontHaveToPay) {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
						" (computer) did not roll doubles to get out of jail.", "Lost Turn", 
						JOptionPane.INFORMATION_MESSAGE);
					nextTurn();
					return;
				}
				else {
					// ran out of times to attempt to roll doubles -- so deduct the fine
					parent.players[currPlayer].deductFromBank(50, parent.playersOut);
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
						" (computer) is out of attempts for rolling doubles! Pay $50.", "Pay Jail Fine", 
						JOptionPane.INFORMATION_MESSAGE);
					
					// check if player exited game
					if (!parent.players[currPlayer].isActive()) {
						JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
								" (computer) is are out of money!", "Out of Game!", 
								JOptionPane.INFORMATION_MESSAGE);
						++parent.playersOut;
						nextTurn();
						return;
					}
					// get the player out of jail
					parent.players[currPlayer].outOfJail();	
				}
			}
			else {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
					" (computer) got out of jail!", "Got out of Jail", JOptionPane.INFORMATION_MESSAGE);
				// get the player out of jail
				parent.players[currPlayer].outOfJail();
				numDoubles++;
			}
		}
		// if rolling to get out of jail, then the doubles don't let you roll again
		else if (d1 == d2) {
			doubles = true;	//player will roll again
			numDoubles++;
		}
		
		// check if the player has rolled 3 doubles in a row
		if (numDoubles == 3) {
			// in this case, the player goes directly to jail
			// move player to jail space
			parent.players[currPlayer].setCurrLocation(parent.jailSpace);
			movePlayerIcon();
			// inform the player of what happened
			JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
					" (computer) rolled doubles 3 times in a row and is going to jail!", "Go to Jail", 
					JOptionPane.INFORMATION_MESSAGE);
			// set jailed to true for their next turn
			parent.players[currPlayer].putInJail();
			
			nextTurn();
		}
		
		else {
			// advance the current player's position
			movePlayer(d1+d2);		

			// given the state of the current property, notify user or allow user to take action
			takeAction(parent.spaces.get(parent.players[currPlayer].getCurrLocation()), d1+d2);

			// going to next turn will take place in takeAction or in an event handler for an event
			//	that will be created by takeAction						
		}

	}
	
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
	public void movePlayer(int roll) {
		int newLoc = parent.players[currPlayer].getCurrLocation() + roll;
		// check if the player passed go
		if (newLoc >= parent.spaces.size()) {
			parent.players[currPlayer].passedGo();
		}
		// set user's location to correct index into properties array
		parent.players[currPlayer].setCurrLocation(newLoc % parent.spaces.size());

		movePlayerIcon();

	}	

	/* Function:	takeAction()
	 * Purpose:		given the property <prop> that the current player has landed on, give user notification or
	 * 				require response from the current player based on the property type, the owner of it, etc
	 * 				NOTE: nextTurn() is called from here for some scenarios (or called from event handlers
	 * 				built in helper functions for other scenarios) to follow event based paradigm
	 */
	private void takeAction(Space s, int dice) {
		// space is a special space -- GO, draw card, taxes, etc; not a buyable property
		if (s.getType() == Space.SpaceType.ACTION) {
			switch(((ActionSpace)s).getAType()) {
			case NOTHING:
				break;
			case CARD:
				// check which card it is and draw from the pile
				if(s.getName().equals("Chance")) {
					SpecialCard temp = getTopChance();
					temp.act(parent.players[currPlayer], parent.playersOut, this);
					JOptionPane.showMessageDialog(null, temp.getText(), "Chance", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(s.getName().equals("Community Chest")) {
					SpecialCard temp = getTopCommunityChest();
					temp.act(parent.players[currPlayer], parent.playersOut, this);
					JOptionPane.showMessageDialog(null, temp.getText(), "Community Chest", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case JAIL:
				// move player to jail space
				parent.players[currPlayer].setCurrLocation(parent.jailSpace);
				movePlayerIcon();
				// inform the player of what happened
				if (parent.players[currPlayer].isHuman()) {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you're going to jail!", 
							"Go to Jail", JOptionPane.INFORMATION_MESSAGE);	
				} else {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
							" (computer) is going to jail!", "Go to Jail", JOptionPane.INFORMATION_MESSAGE);
				}
				// set jailed to true for their next turn
				parent.players[currPlayer].putInJail();
				break;
			case TAX:
				// check which tax it is and charge player
				payTax((ActionSpace)s);
				break;			
			}
			
		}
		// space is a buyable property
		else {
			Property prop = (Property) s;
			// it has not been bought yet
			if (prop.getOwner() == -1) {
				optionToBuy(prop);
				//**for testing rents:
				//		COMMENT 'optionToBuy(prop);' AND
				//		UNCOMMENT BELOW TO TEST BUYING HOUSES, DOUBLING RENT, ETC
				/*for(int i = 0; i< parent.spaces.size(); i++)
		        {
		            Space sp = parent.spaces.get(i);
		            if(sp.getType() == Space.SpaceType.NORM || sp.getType() == Space.SpaceType.UTIL)
		            {
		                Property p = (Property) sp;
		                p.setOwner(0);
		                //spaces.get(i).setForsale(false);
		                parent.players[0].addProperty(p);
		            }
		        }*/
			}
			// it has been bought by a different player -- current player pays rent
			else if (prop.getOwner() != currPlayer) {
				payRent(prop, dice);
			}
			// it has been bought and the owner is the current player
			else {
				// DO NOTHING
			}

		}
		nextTurn();	//moved to allow takeChanceAction() to 
	}

	
	/*	Function:	takeChanceAction()
	 * 	Purpose:	Acts on the space which a chance card causes the user to land on.
	 * 				Works similarly to takeAction, but ignores the nextTurn() calls so it works within the normal takeAction()
	 * 				Public to allow execution in the specialCard classes
	 */
	
	public void takeChanceAction(Space s) {
		// space is a special space -- GO, draw card, taxes, etc; not a buyable property
				if (s.getType() == Space.SpaceType.ACTION) {
					switch(((ActionSpace)s).getAType()) {
					case NOTHING:
						break;
					case CARD:
						// check which card it is and draw from the pile
						if(s.getName().equals("Chance")) {
							SpecialCard temp = getTopChance();
							temp.act(parent.players[currPlayer], parent.playersOut, this);
							JOptionPane.showMessageDialog(null, temp.getText(), "Chance", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(s.getName().equals("Community Chest")) {
							SpecialCard temp = getTopCommunityChest();
							temp.act(parent.players[currPlayer], parent.playersOut, this);
							JOptionPane.showMessageDialog(null, temp.getText(), "Community Chest", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case TAX:
						// check which tax it is and charge player
						payTax((ActionSpace)s);
						break;
					case JAIL:
						break;
					default:
						break;			
					}
					
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
						payChanceRent(prop);
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
			int buyProp;
			if (parent.players[currPlayer].isHuman()) {
				buyProp = JOptionPane.showConfirmDialog(null, parent.players[currPlayer].getName() + 
						", do you want to buy \n" + prop.getName() + " for $" + prop.getPrice() + "?", 
						"Buy "+prop.getName(), JOptionPane.YES_NO_OPTION);	
			}
			// AI will always buy the property if it has enough money for it
			else {
				buyProp = 0;
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
						" (computer) bought " + prop.getName() + " for $" + prop.getPrice() + ".",
						"Buy " + prop.getName(), JOptionPane.INFORMATION_MESSAGE);
			}
			
			// if they want to buy it, update the owner of the property, and deduct the cost from the current player
			if (buyProp == 0) {
				parent.players[currPlayer].deductFromBank(prop.getPrice(), parent.playersOut);
				prop.setOwner(currPlayer);
				parent.players[currPlayer].addProperty(prop);;
			} else {
				// **TODO -- put in an auction function if they decide not to buy
			}
		}
		else {
			// notify player that they don't have money via popup window
			JOptionPane.showMessageDialog(null, "Insufficient funds in bank account!\nProperty cost: $" +
					prop.getPrice()+"\nAccount Balance: $"+parent.players[currPlayer].getBank(), 
					"Bank error", JOptionPane.ERROR_MESSAGE);
			// action function would go here as well.
		}		
	}

	/* Function:	payRent()
	 * Purpose:		helper to takeAction(), used when a property is already owned and the current player has to pay
	 * 				rent to that owner
	 */
	private void payRent(Property prop, int dice) {
		if (currPlayer != prop.getOwner() && parent.players[prop.getOwner()].isActive() && !prop.isMortgaged()) {	
			int amountPaid = 0;
			if (prop.getCategory() == Property.PropertyCategory.UTILITIES) {
				amountPaid = parent.players[currPlayer].deductFromBank(((Utility)prop).getRent(dice), parent.playersOut);
			}
			else if (prop.getCategory() == Property.PropertyCategory.RAILROAD) {
				int numRailroads = 0;
				for (int i = 0; i < parent.players[prop.getOwner()].getProperties().size(); ++i) {
					if (parent.players[prop.getOwner()].getProperties().get(i).get(0).getCategory() == Property.PropertyCategory.RAILROAD) {
						numRailroads = parent.players[prop.getOwner()].getProperties().get(i).size(); 
					}
				}
				amountPaid = parent.players[currPlayer].deductFromBank(((Railroad)prop).getRent(numRailroads), parent.playersOut);
			}
			else {
				amountPaid = parent.players[currPlayer].deductFromBank(prop.getRent(), parent.playersOut);
			}
			parent.players[prop.getOwner()].addToBank(amountPaid);

			// inform users of rent payment
			if (parent.players[currPlayer].isHuman()) {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + " paid $" + amountPaid + 
						" to " + parent.players[prop.getOwner()].getName() + " for rent on " + prop.getName(), "Rent Paid", 
						JOptionPane.INFORMATION_MESSAGE);				
			}
			else {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + " (computer) paid $" 
						+ amountPaid + " to " + parent.players[prop.getOwner()].getName() + " for rent on " + 
						prop.getName(), "Rent Paid", JOptionPane.INFORMATION_MESSAGE);
			}


			// check if player exited game
			if (!parent.players[currPlayer].isActive()) {
				if (parent.players[currPlayer].isHuman()) {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
							", you are out of money!", "Out of Game!", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
							" (computer) is out of money!", "Out of Game!", JOptionPane.INFORMATION_MESSAGE);
				}

				++parent.playersOut;
			}
		}
	}
	
	
	/* Function:	payChanceRent()
	 * Purpose:		helper to takeChanceAction(), used when a property is already owned and the current player has to pay
	 * 				rent to that owner
	 * 				similar to payRent() but does not inculde a utilities option to remove dice parameter
	 */
	private void payChanceRent(Property prop) {
		if (currPlayer != prop.getOwner() && parent.players[prop.getOwner()].isActive() && !prop.isMortgaged()) {	
			int amountPaid = 0;
			if (prop.getCategory() == Property.PropertyCategory.RAILROAD) {
				int numRailroads = 0;
				for (int i = 0; i < parent.players[prop.getOwner()].getProperties().size(); ++i) {
					if (parent.players[prop.getOwner()].getProperties().get(i).get(0).getCategory() == Property.PropertyCategory.RAILROAD) {
						numRailroads = parent.players[prop.getOwner()].getProperties().get(i).size(); 
					}
				}
				amountPaid = parent.players[currPlayer].deductFromBank(((Railroad)prop).getRent(numRailroads), parent.playersOut);
			}
			else {
				amountPaid = parent.players[currPlayer].deductFromBank(prop.getRent(), parent.playersOut);
			}
			parent.players[prop.getOwner()].addToBank(amountPaid);

			// inform users of rent payment
			if (parent.players[currPlayer].isHuman()) {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + " paid $" + amountPaid + 
						" to " + parent.players[prop.getOwner()].getName() + " for rent on " + prop.getName(), "Rent Paid", 
						JOptionPane.INFORMATION_MESSAGE);				
			}
			else {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + " (computer) paid $" 
						+ amountPaid + " to " + parent.players[prop.getOwner()].getName() + " for rent on " + 
						prop.getName(), "Rent Paid", JOptionPane.INFORMATION_MESSAGE);
			}


			// check if player exited game
			if (!parent.players[currPlayer].isActive()) {
				if (parent.players[currPlayer].isHuman()) {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
							", you are out of money!", "Out of Game!", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
							" (computer) is out of money!", "Out of Game!", JOptionPane.INFORMATION_MESSAGE);
				}

				++parent.playersOut;
			}
		}
	}
	/* Function:	payTax()
	 * Purpose:		helper to takeAction(), used when the space landed on is a tax space
	 */
	private void payTax(ActionSpace taxS) {
		int deduction = 0;
		
		// luxury tax -- player must pay $100 (no option with this tax)
		if (taxS.getName().equals("Luxury Tax")) {
			int flatRate = 100;
			// inform user that they are paying the tax
			if (parent.players[currPlayer].isHuman()) {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you have to pay a $100 luxury tax!", 
						"Luxury Tax", JOptionPane.INFORMATION_MESSAGE);	
			}
			else {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
						" (computer) has to pay a $100 luxury tax!", "Luxury Tax", 
						JOptionPane.INFORMATION_MESSAGE);				
			}
			deduction = flatRate;
		}
		// income tax -- player gets option to pay 10% of net worth or flat rate of $200
		else {
			int tenPerc = parent.players[currPlayer].getNetWorth() / 10;
			int flatRate = 200;
			
			if (parent.players[currPlayer].isHuman()) {
				Object [] options = (Object[])(new String[] {"Pay $" + flatRate, "Pay 10% ($" + tenPerc + ")"});
				int percOrFlatRate = JOptionPane.showOptionDialog(null, parent.players[currPlayer].getName() + 
						", you have to pay taxes!\n", "Income Tax", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, 
						null, options, options[(flatRate > tenPerc ? 1 : 0)]);
				deduction = (percOrFlatRate == 0 ? flatRate : tenPerc);
			}
			else {
				// AI selects the smaller of the two tax options
				deduction = (flatRate < tenPerc ? flatRate: tenPerc);
			}
		}
		
		// deduct the tax from the bank
		parent.players[currPlayer].deductFromBank(deduction, parent.playersOut);
		// check if player exited game
		if (!parent.players[currPlayer].isActive()) {
			if (parent.players[currPlayer].isHuman()) {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you are out of money!", 
					"Out of Game!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
						" (computer) is out of money!", "Out of Game!", JOptionPane.INFORMATION_MESSAGE);
			}
			++parent.playersOut;
		}
	}

	/* Function:	nextTurn()
	 * Purpose:		updates the current player to the next still active player in the game
	 */
	public void nextTurn() {
		// figure out how many players are out of the game and update that in MainWindow
		int playersOut = 0;
		for (int i = 0; i < parent.players.length; ++i) {
			if (!parent.players[i].isActive()) ++playersOut;
		}
		parent.playersOut = playersOut;
		
		//check if game is still going
		if (parent.playersOut > parent.players.length - 2) {
			// gameover!
			for (int i = 0; i < parent.players.length; ++i) {
				if (parent.players[i].isActive()) {
					// last player left gets 1st
					parent.players[i].setPlace(1);
					break;
				}
			}
			// go to endpanel -- display results to all players
			parent.flipCards();
			return;
		}
		
		if (!this.doubles || this.parent.players[currPlayer].inJail()) {
			// update to next player
			this.numDoubles = 0;	// reset doubles counter
			this.currPlayer = (this.currPlayer + 1) % parent.players.length;
			while (!parent.players[currPlayer].isActive()) {
				this.currPlayer = (this.currPlayer + 1) % parent.players.length;
			}			
		}
		this.doubles = false;
		diceActive = true;
		updateCurrentPlayer();
				
		// finally, check if this next player is in jail
		if (parent.players[currPlayer].inJail()) {
			// show dialog asking player if they want to pay the fine or try 
			//	to roll doubles to get out
			if (parent.players[currPlayer].isHuman()) {
				Object [] options = (Object[])(new String[] {"Roll", "Pay $50"});
				int rollOrPay = JOptionPane.showOptionDialog(null, parent.players[currPlayer].getName() + 
						", do you want to attempt to roll doubles, or pay the $50 fine?\n" + 
						"Turns left in Jail: " + parent.players[currPlayer].turnsLeftInJail(), "In Jail",
						JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,	null, options, options[0]);
				// if player wants to roll the dice, set jailRoll flag
				if (rollOrPay == 0) this.jailRoll = true;
				// otherwise, deduct $50 from player's bank and let them continue with their turn as normal
				else  {
					// deduct the fine
					parent.players[currPlayer].deductFromBank(50, parent.playersOut);
					// check if player exited game
					if (!parent.players[currPlayer].isActive()) {
						JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you are out of money!", 
								"Out of Game!", JOptionPane.INFORMATION_MESSAGE);
						++parent.playersOut;
						nextTurn();
					}
					else {
						// get the player out of jail
						parent.players[currPlayer].outOfJail();	
					}
				}
			}
			// otherwise, it is a computer player
			// AI decision -- if I have > $100, pay to get out of jail
			//				  else, roll to get out of jail
			else {
				if (parent.players[currPlayer].getBank() > 100) {
					parent.players[currPlayer].deductFromBank(50, parent.playersOut);
					// check if player exited game
					if (!parent.players[currPlayer].isActive()) {
						JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
								" (computer) is out of money!", "Out of Game!", JOptionPane.INFORMATION_MESSAGE);
						++parent.playersOut;
						nextTurn();
					}
					else {
						// get the player out of jail
						JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + 
								" (computer) paid $50 to get out of jail.", "Pay Jail Fine", 
								JOptionPane.INFORMATION_MESSAGE);
						parent.players[currPlayer].outOfJail();	
					}
				}
				else {
					this.jailRoll = true;
					compTurnBegin();
				}
			}
		}
		// if the player is not in jail and the player is a computer player, then call compDiceClicked
		else if (!parent.players[currPlayer].isHuman()) {
			compTurnBegin();
		}
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
		@SuppressWarnings("unused")
		ArrayList<ArrayList<Property>> props = parent.players[currPlayer].getProperties();
		/*for (int i = 0; i < props.size(); ++i) {
			if (i != 0) sProps += ", ";
			sProps += props.elementAt(i).getName();
		}*/
		System.out.println("\tProperties: " + sProps);
		// enable dice again
		diceActive = true;
	}

	/*
	 * Handler: spaceClicked()
	 * Purpose: Displays property card for given space
	 */
	
	private ActionListener spaceClicked = new ActionListener() {  

		@Override
		public void actionPerformed(ActionEvent e) {  

			if( ((JButton)e.getSource()).getClientProperty(GamePanel.CARD).equals(null) )
			{
				//there is not a pop up for this space
			}
			else
			{
				//show custom card for space clicked
				int index = (int)(((JButton)e.getSource()).getClientProperty(GamePanel.CARD));
				Space clicked = parent.spaces.get(index);
				
				CardView currentCard = new CardView(clicked);
				currentCard.setVisible(true);
			}
		}
	};
	
	/*
	 * Function: updateCurrentPlayer()
	 * Purpose: Graphically update the player panels to designate current turn
	 */

	private void updateCurrentPlayer(){

		Color n = new Color(238, 238, 238);
		Color y = new Color(153, 255, 153);
		Color out = new Color(200, 200, 200);

		switch (this.currPlayer){

		case 0:
			panel.setBackground(y);
			panel_1.setBackground((parent.players[1].isActive()? n : out));
			panel_2.setBackground((parent.players[2].isActive()? n : out));
			panel_3.setBackground((parent.players[3].isActive()? n : out));
			break;

		case 1:
			panel.setBackground((parent.players[0].isActive()? n : out));
			panel_1.setBackground(y);
			panel_2.setBackground((parent.players[2].isActive()? n : out));
			panel_3.setBackground((parent.players[3].isActive()? n : out));
			break;

		case 2:
			panel.setBackground((parent.players[0].isActive()? n : out));
			panel_1.setBackground((parent.players[1].isActive()? n : out));
			panel_2.setBackground(y);
			panel_3.setBackground((parent.players[3].isActive()? n : out));
			break;

		case 3:
			panel.setBackground((parent.players[0].isActive()? n : out));
			panel_1.setBackground((parent.players[1].isActive()? n : out));
			panel_2.setBackground((parent.players[2].isActive()? n : out));
			panel_3.setBackground(y);
			break;

		}	

	}
	
	/*
	 * Function: movePlayer()
	 * Purpose: Graphically move player to new space
	 */

	private void movePlayerIcon(){

		switch (this.currPlayer){

		case 0:
			this.gbc_player1.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player1.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			this.remove(player1);
			this.add(player1, gbc_player1);
			setComponentZOrder(player1, 0);
			break;

		case 1:
			this.gbc_player2.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player2.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			this.remove(player2);
			this.add(player2, gbc_player2);
			setComponentZOrder(player2, 0);
			break;

		case 2:
			this.gbc_player3.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player3.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			this.remove(player3);
			this.add(player3, gbc_player3);
			setComponentZOrder(player3, 0);
			break;

		case 3:
			this.gbc_player4.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player4.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			this.remove(player4);
			this.add(player4, gbc_player4);
			setComponentZOrder(player4, 0);
			break;

		}	
	}
	
	/*
	 * Function: getTopChance()
	 * Purpose: returns the current top card of the chance deck and resets/shuffles when necessary
	 */
	public SpecialCard getTopChance() {
		
		SpecialCard top = chanceDeck.get(indexChance);
		indexChance++;
		if(indexChance == chanceDeck.size()) {
			indexChance = 0;
			Collections.shuffle(chanceDeck);
		}
		return top;
	}
	
	/*
	 * Function: getTopCommunityChest()
	 * Purpose: returns the current top card of the community chest deck and resets/shuffles when necessary
	 */
	public SpecialCard getTopCommunityChest() {
		
		SpecialCard top = communityChestDeck.get(indexChest);
		indexChest++;
		if(indexChest == communityChestDeck.size()) {
			indexChest = 0;
			Collections.shuffle(communityChestDeck);
		}
		return top;
	}
	
	public MainWindow getMyParent()
	{
		return parent;
	}
	
	private ActionListener propertiesClicked = new ActionListener() { 

		@Override
		public void actionPerformed(ActionEvent e) { 
			// TODO Auto-generated method stub
			
			int index = (int)(((JButton)e.getSource()).getClientProperty(GamePanel.PLAYER));
			Player clicked = parent.players[index];
			
			PropertyView playerSelected = new PropertyView(clicked, thisGamePanel);
			playerSelected.setVisible(true);
			
		}
		
	};

	private ActionListener tradeClicked = new ActionListener() {   

		@Override
		public void actionPerformed(ActionEvent e) {   

			TradeView tradeOpened = new TradeView(thisGamePanel);
			tradeOpened.setVisible(true);
		
		}
	};
}

