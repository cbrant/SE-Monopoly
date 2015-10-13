package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private MainWindow parent;	

	public JButton btnEndGame;

	// index of player who is currently taking a turn
	public int currPlayer;

	private JButton diceButton;
	boolean diceActive = true;
	// flag set when a player rolls doubles -- will roll again

	//variables that repesent dice roll on board
	private JLabel dice1;
	private JLabel dice2;

	//variables for the player panels
	private JPanel panel, panel_1, panel_2, panel_3;

	// Array of piece images
	private HashMap<Player.GamePiece, Image> playerPieces = new HashMap<Player.GamePiece, Image>(6);

	//variables for the player pieces
	private JLabel player1, player2, player3, player4;
	private GridBagConstraints gbc_player1, gbc_player2, gbc_player3, gbc_player4;

	private boolean doubles;	
	// random number generator used for dice rolling
	private Random ranGen;

	private final static String CARD = "card";

	// array to track players
	private GridBagConstraints[] gridLocations = new GridBagConstraints[40];

	/**
	 * Create the panel.
	 */
	public GamePanel(MainWindow par) {
		setBackground(new Color(255, 250, 205));
		this.parent = par;

		this.currPlayer = 0;
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
		kentuckyAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/kentuckyavenue.jpg")).getImage());
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
		indianaAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/indianaavenue.jpg")).getImage());
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
		illinoisAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/illinoisavenue.jpg")).getImage());
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
		bORailroad.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/borailroad.jpg")).getImage());
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
		atlanticAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/atlanticavenue.jpg")).getImage());
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
		ventnorAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/ventnoravenue.jpg")).getImage());
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
		waterWorks.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/waterworkscard.jpg")).getImage());
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
		marvinGardens.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/marvingardens.jpg")).getImage());
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
		newYorkAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/newyorkavenue.jpg")).getImage());
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
		pacificAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/pacificavenue.jpg")).getImage());
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

		GridBagConstraints gbc_player1Properties = new GridBagConstraints();
		gbc_player1Properties.insets = new Insets(0, 0, 5, 0);
		gbc_player1Properties.gridx = 1;
		gbc_player1Properties.gridy = 3;
		panel.add(parent.players[0].propertiesL, gbc_player1Properties);

		JLabel player1PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player1PropertiesLabel = new GridBagConstraints();
		gbc_player1PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player1PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player1PropertiesLabel.gridx = 0;
		gbc_player1PropertiesLabel.gridy = 3;
		panel.add(player1PropertiesLabel, gbc_player1PropertiesLabel);

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

		GridBagConstraints gbc_player2Properties = new GridBagConstraints();
		gbc_player2Properties.insets = new Insets(0, 0, 5, 0);
		gbc_player2Properties.gridx = 1;
		gbc_player2Properties.gridy = 3;
		panel_1.add(parent.players[1].propertiesL, gbc_player2Properties);

		JLabel player2PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player2PropertiesLabel = new GridBagConstraints();
		gbc_player2PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player2PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player2PropertiesLabel.gridx = 0;
		gbc_player2PropertiesLabel.gridy = 3;
		panel_1.add(player2PropertiesLabel, gbc_player2PropertiesLabel);

		JButton tennesseeAvenue = new JButton("");
		GridBagConstraints gbc_tennesseeAvenue = new GridBagConstraints();
		gbc_tennesseeAvenue.fill = GridBagConstraints.BOTH;
		gbc_tennesseeAvenue.gridwidth = 3;
		gbc_tennesseeAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_tennesseeAvenue.gridx = 2;
		gbc_tennesseeAvenue.gridy = 6;
		gridLocations[18] = gbc_tennesseeAvenue;
		tennesseeAvenue.setIcon(new ImageIcon(orange));
		tennesseeAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/tennesseeavenue.jpg")).getImage());
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
		northCarolinaAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/northcarolinaavenue.jpg")).getImage());
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
		stJamesPlace.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/stjamesplace.jpg")).getImage());
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
		pennsylvaniaAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/pennsylvaniaavenue.jpg")).getImage());
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
		pennsylvaniaRailroad.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/pennsylvaniarailroad.jpg")).getImage());
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
		shortLine.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/shortline.jpg")).getImage());
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
		virginiaAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/virginiaavenue.jpg")).getImage());
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

		GridBagConstraints gbc_player3Properties = new GridBagConstraints();
		gbc_player3Properties.insets = new Insets(0, 0, 5, 0);
		gbc_player3Properties.gridx = 1;
		gbc_player3Properties.gridy = 3;
		panel_2.add(parent.players[2].propertiesL, gbc_player3Properties);

		JLabel player3PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player3PropertiesLabel = new GridBagConstraints();
		gbc_player3PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player3PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player3PropertiesLabel.gridx = 0;
		gbc_player3PropertiesLabel.gridy = 3;
		panel_2.add(player3PropertiesLabel, gbc_player3PropertiesLabel);

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

		GridBagConstraints gbc_player4Properties = new GridBagConstraints();
		gbc_player4Properties.insets = new Insets(0, 0, 5, 0);
		gbc_player4Properties.gridx = 1;
		gbc_player4Properties.gridy = 3;
		panel_3.add(parent.players[3].propertiesL, gbc_player4Properties);

		JLabel player4PropertiesLabel = new JLabel("Properties:");
		GridBagConstraints gbc_player4PropertiesLabel = new GridBagConstraints();
		gbc_player4PropertiesLabel.fill = GridBagConstraints.BOTH;
		gbc_player4PropertiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_player4PropertiesLabel.gridx = 0;
		gbc_player4PropertiesLabel.gridy = 3;
		panel_3.add(player4PropertiesLabel, gbc_player4PropertiesLabel);

		JButton statesAvenue = new JButton("");
		GridBagConstraints gbc_statesAvenue = new GridBagConstraints();
		gbc_statesAvenue.fill = GridBagConstraints.BOTH;
		gbc_statesAvenue.gridwidth = 3;
		gbc_statesAvenue.insets = new Insets(0, 0, 5, 5);
		gbc_statesAvenue.gridx = 2;
		gbc_statesAvenue.gridy = 11;
		gridLocations[13]= gbc_statesAvenue;
		statesAvenue.setIcon(new ImageIcon(purple));
		statesAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/statesavenue.jpg")).getImage());
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
		parkPlace.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/parkplace.jpg")).getImage());
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
		electricCompany.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/electriccompanycard.jpg")).getImage());
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
		luxuryTax.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/luxurytaxcard.jpg")).getImage());
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
		stCharlesPlace.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/stcharlesplace.jpg")).getImage());
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
		boardwalk.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/boardwalk.jpg")).getImage());
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
		connecticutAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/connecticutavenue.jpg")).getImage());
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
		vermontAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/vermontavenue.jpg")).getImage());
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
		orientalAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/orientalavenue.jpg")).getImage());
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
		readingRailroad.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/readingrailroad.jpg")).getImage());
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
		incomeTax.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/incometaxcard.jpg")).getImage());
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
		balticAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/balticavenue.jpg")).getImage());
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
		mediterraneanAvenue.putClientProperty(GamePanel.CARD , new ImageIcon(this.getClass().getResource("/mediterraneanavenue.jpg")).getImage());
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


		updateCurrentPlayer();


	}

	/* Handler:		diceClicked
	 * Purpose:		handles the dice button clicked event, rolls dice, moves the current player forward, and begins
	 * 				any interaction the user will have on the new space he/she has landed on
	 */
	private ActionListener diceClicked = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			/*parent.players[0].deductFromBank(500, 0);
			if (!parent.players[0].isActive()) {
				JOptionPane.showMessageDialog(null, parent.players[0].getName() + ", you are out of money!", 
						"Out of Game!", JOptionPane.INFORMATION_MESSAGE);
			}*/

			// TODO -- disable dice button until enabled for next turn
			if(diceActive == true) {
				//deactivate dice
				diceActive = false;
				// roll the dice for the current player
				int d1 = diceRoll(); int d2 = diceRoll();
				if (d1 == d2) doubles = true;	//player will roll again

				// display the result of the dice on the screen (for now, console only)
				dice1.setText(""+d1); dice2.setText(""+d2);
				//System.out.println("You rolled " + d1 + " and " + d2 + ".");

				// advance the current player's position
				movePlayer(d1+d2);		
				// TODO -- update the GUI

				// given the state of the current property, notify user or allow user to take action
				takeAction(parent.spaces.get(parent.players[currPlayer].getCurrLocation()));

				// going to next turn will take place in takeAction or in an event handler for an event
				//	that will be created by takeAction	
			}
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

		movePlayer();

		// probably don't need to print this info when done on GUI
		//System.out.println("You moved " + roll + " spaces to "+ parent.spaces.get(parent.players[currPlayer].getCurrLocation()).getName());

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

			int buyProp = JOptionPane.showConfirmDialog(null, parent.players[currPlayer].getName() + ", do you want to buy \n" + 
					prop.getName() + " for $" + prop.getPrice() + "?", "Buy "+prop.getName(), JOptionPane.YES_NO_OPTION);

			// if they want to buy it, update the owner of the property, and deduct the cost from the current player
			if (buyProp == 0) {
				int playersOut = 0;
				for (int i = 0; i < parent.players.length; ++i) {
					if (!parent.players[i].isActive()) ++playersOut;
				}
				parent.players[currPlayer].deductFromBank(prop.getPrice(), playersOut);
				prop.setOwner(currPlayer);
				parent.players[currPlayer].addProperty(prop);;
			} else {
				// **TODO -- put in an auction function if they decide not to buy
			}
			nextTurn();
		}
		else {
			// notify player that they don't have money via popup window
			JOptionPane.showMessageDialog(null, "Insufficient funds in bank account!\nProperty cost: $" +
					prop.getPrice()+"\nAccount Balance: $"+parent.players[currPlayer].getBank(), 
					"Bank error", JOptionPane.ERROR_MESSAGE);
			nextTurn();
		}		
	}

	/* Function:	payRent()
	 * Purpose:		helper to takeAction(), used when a property is already owned and the current player has to pay
	 * 				rent to that owner
	 */
	private void payRent(Property prop) {
		if (currPlayer != prop.getOwner() && parent.players[prop.getOwner()].isActive()) {	
			int playersOut = 0;
			for (int i = 0; i < parent.players.length; ++i) {
				if (!parent.players[i].isActive()) ++playersOut;
			}

			int amountPaid = parent.players[currPlayer].deductFromBank(prop.getRent(), playersOut);
			parent.players[prop.getOwner()].addToBank(amountPaid);

			// inform users of rent payment
			JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + " paid $" + amountPaid + 
					" to " + parent.players[prop.getOwner()].getName() + " for rent on " + prop.getName(), "Rent Paid", 
					JOptionPane.INFORMATION_MESSAGE);

			// check if player exited game
			if (!parent.players[currPlayer].isActive()) {
				JOptionPane.showMessageDialog(null, parent.players[currPlayer].getName() + ", you are out of money!", 
						"Out of Game!", JOptionPane.INFORMATION_MESSAGE);
			}

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
				for (int i = 0; i < parent.players.length; ++i) {
					if (parent.players[i].isActive()) {
						// last player left gets 1st
						parent.players[i].setPlace(1);
						break;
					}
				}
				parent.flipCards();
				return;
			}
		}
		this.doubles = false;

		diceActive = true;
		updateCurrentPlayer();
		//newTurnNotification();	
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
		// enable dice again
		diceActive = true;
	}

	/*
	 * Funtion: spaceClicked()
	 * Purpose: Displays property card for given space
	 */
	
	private ActionListener spaceClicked = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//Pop open new CardView with card info, just testing for now
			
			CardView popUp = new CardView(new Property("PropertyTest", Space.SpaceType.NORM, 1, null, 1 ,1, Property.PropertyCategory.GREEN));
			CardView popUp2 = new CardView(new Property("PropertyTest", Space.SpaceType.RR, 1, null, 1 ,1, Property.PropertyCategory.RAILROAD));
			CardView popUp3 = new CardView(new Property("PropertyTest", Space.SpaceType.UTIL, 1, null, 1 ,1, Property.PropertyCategory.RAILROAD));
			CardView popUp4 = new CardView(new Property("PropertyTest", Space.SpaceType.ACTION, 1, null, 1 ,1, Property.PropertyCategory.RAILROAD));
			
			popUp.setVisible(true);
			popUp2.setVisible(true);
			popUp3.setVisible(true);
			popUp4.setVisible(true);

//			Image spaceCard = (Image)((JButton)e.getSource()).getClientProperty(GamePanel.CARD);
//
//			JOptionPane.showMessageDialog(null, "", "", JOptionPane.PLAIN_MESSAGE, new ImageIcon(spaceCard));


		}


	};
	
	/*
	 * Funtion: updateCurrentPlayer()
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

	private void movePlayer(){

		switch (this.currPlayer){

		case 0:
			//System.out.println("Moving player1");
			this.gbc_player1.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player1.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			//System.out.println(this.gbc_player1.gridx);
			//System.out.println(this.gbc_player1.gridy);
			this.remove(player1);
			this.add(player1, gbc_player1);
			setComponentZOrder(player1, 0);
			break;

		case 1:
			this.gbc_player2.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player2.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			//System.out.println(this.gbc_player2.gridx);
			//System.out.println(this.gbc_player2.gridy);
			this.remove(player2);
			this.add(player2, gbc_player2);
			setComponentZOrder(player2, 0);
			break;

		case 2:
			this.gbc_player3.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player3.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			//System.out.println(this.parent.players[this.currPlayer].getCurrLocation());
			//System.out.println(this.gbc_player3.gridy);
			this.remove(player3);
			this.add(player3, gbc_player3);
			setComponentZOrder(player3, 0);
			break;

		case 3:
			this.gbc_player4.gridx = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridx;
			this.gbc_player4.gridy = this.gridLocations[this.parent.players[this.currPlayer].getCurrLocation()].gridy;
			//System.out.println(this.parent.players[this.currPlayer].getCurrLocation());
			//System.out.println(this.gbc_player4.gridy);
			this.remove(player4);
			this.add(player4, gbc_player4);
			setComponentZOrder(player4, 0);
			break;

		}	
	}
	
}
