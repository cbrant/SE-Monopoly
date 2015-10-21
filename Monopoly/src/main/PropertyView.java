package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PropertyView extends JFrame {

	
	private JLabel lblMediterraneanAve, lblBalticAve, lblOrientalAve, lblVermontAve, lblConnecticutAve, lblStCharlesPlace, lblStatesAve, lblVirginiaAve, lblStJamesPlace, lblTennesseeAve, lblNewYorkAve;
	private JLabel lblKentuckyAve, lblIndianaAve, lblIllinoisAve, lblAtlanticAve, lblVentnorAve, lblMarvinGardens, lblPacificAve, lblNorthCarolinaAve, lblPennsylvaniaAve, lblParkPlace, lblBoardwalk;
	private JLabel lblReadingRr, lblPennsylvaniaRr, lblBO, lblShortLine, lblElectricCompany, lblWaterWorks;
	
	private ArrayList<JLabel> propLabels = new ArrayList<JLabel>();
	
	private Player currentPlayer;
	
	/**
	 * Create the panel.
	 */
	public PropertyView(Player playerIn) {

		getContentPane().setBackground(new Color(255, 250, 205));

		this.setBackground(new Color(255, 250, 205));

		setBounds(100, 100, 1100, 500);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		currentPlayer = playerIn;
		
		setBackground(new Color(255, 250, 205));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblBrown = new JLabel("");
		GridBagConstraints gbc_lblBrown = new GridBagConstraints();
		gbc_lblBrown.fill = GridBagConstraints.BOTH;
		gbc_lblBrown.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrown.gridx = 1;
		gbc_lblBrown.gridy = 1;
		lblBrown.setBackground(new Color(153,76,0));
		lblBrown.setOpaque(true);
		getContentPane().add(lblBrown, gbc_lblBrown);
		
		JLabel lblLightBlue = new JLabel("");
		GridBagConstraints gbc_lblLightBlue = new GridBagConstraints();
		gbc_lblLightBlue.fill = GridBagConstraints.BOTH;
		gbc_lblLightBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblLightBlue.gridx = 5;
		gbc_lblLightBlue.gridy = 1;
		lblLightBlue.setBackground(new Color(153,255,255));
		lblLightBlue.setOpaque(true);
		getContentPane().add(lblLightBlue, gbc_lblLightBlue);
		
		JLabel lblPink = new JLabel("");
		GridBagConstraints gbc_lblPink = new GridBagConstraints();
		gbc_lblPink.fill = GridBagConstraints.BOTH;
		gbc_lblPink.insets = new Insets(0, 0, 5, 5);
		gbc_lblPink.gridx = 9;
		gbc_lblPink.gridy = 1;
		lblPink.setBackground(new Color(255,0,255));
		lblPink.setOpaque(true);
		getContentPane().add(lblPink, gbc_lblPink);
		
		JLabel lblOrange = new JLabel("");
		GridBagConstraints gbc_lblOrange = new GridBagConstraints();
		gbc_lblOrange.fill = GridBagConstraints.BOTH;
		gbc_lblOrange.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrange.gridx = 13;
		gbc_lblOrange.gridy = 1;
		lblOrange.setBackground(new Color(255,128,0));
		lblOrange.setOpaque(true);
		getContentPane().add(lblOrange, gbc_lblOrange);
		
		JLabel lblRed = new JLabel("");
		GridBagConstraints gbc_lblRed = new GridBagConstraints();
		gbc_lblRed.fill = GridBagConstraints.BOTH;
		gbc_lblRed.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed.gridx = 17;
		gbc_lblRed.gridy = 1;
		lblRed.setBackground(new Color(255,0,0));
		lblRed.setOpaque(true);
		getContentPane().add(lblRed, gbc_lblRed);
		
		lblMediterraneanAve = new JLabel("Mediterranean Ave");
		lblMediterraneanAve.setBackground(new Color(255, 250, 205));
		lblMediterraneanAve.setOpaque(true);
		GridBagConstraints gbc_lblMediterranean = new GridBagConstraints();
		gbc_lblMediterranean.fill = GridBagConstraints.BOTH;
		gbc_lblMediterranean.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediterranean.gridx = 1;
		gbc_lblMediterranean.gridy = 2;
		getContentPane().add(lblMediterraneanAve, gbc_lblMediterranean);
		propLabels.add(lblMediterraneanAve);
		
		lblOrientalAve = new JLabel("Oriental Ave");
		lblOrientalAve.setBackground(new Color(255, 250, 205));
		lblOrientalAve.setOpaque(true);
		GridBagConstraints gbc_lblOrientalAve = new GridBagConstraints();
		gbc_lblOrientalAve.fill = GridBagConstraints.BOTH;
		gbc_lblOrientalAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrientalAve.gridx = 5;
		gbc_lblOrientalAve.gridy = 2;
		getContentPane().add(lblOrientalAve, gbc_lblOrientalAve);
		propLabels.add(lblOrientalAve);
		
		lblStCharlesPlace = new JLabel("St. Charles Place");
		lblStCharlesPlace.setBackground(new Color(255, 250, 205));
		lblStCharlesPlace.setOpaque(true);
		GridBagConstraints gbc_lblStCharlesPlace = new GridBagConstraints();
		gbc_lblStCharlesPlace.fill = GridBagConstraints.BOTH;
		gbc_lblStCharlesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblStCharlesPlace.gridx = 9;
		gbc_lblStCharlesPlace.gridy = 2;
		getContentPane().add(lblStCharlesPlace, gbc_lblStCharlesPlace);
		propLabels.add(lblStCharlesPlace);
		
		lblStJamesPlace = new JLabel("St. James Place");
		lblStJamesPlace.setBackground(new Color(255, 250, 205));
		lblStJamesPlace.setOpaque(true);
		GridBagConstraints gbc_lblStJamesPlace = new GridBagConstraints();
		gbc_lblStJamesPlace.fill = GridBagConstraints.BOTH;
		gbc_lblStJamesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblStJamesPlace.gridx = 13;
		gbc_lblStJamesPlace.gridy = 2;
		getContentPane().add(lblStJamesPlace, gbc_lblStJamesPlace);
		propLabels.add(lblStJamesPlace);
		
		lblKentuckyAve = new JLabel("Kentucky Ave");
		lblKentuckyAve.setBackground(new Color(255, 250, 205));
		lblKentuckyAve.setOpaque(true);
		GridBagConstraints gbc_lblKentuckyAve = new GridBagConstraints();
		gbc_lblKentuckyAve.fill = GridBagConstraints.BOTH;
		gbc_lblKentuckyAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblKentuckyAve.gridx = 17;
		gbc_lblKentuckyAve.gridy = 2;
		getContentPane().add(lblKentuckyAve, gbc_lblKentuckyAve);
		propLabels.add(lblKentuckyAve);
		
		lblBalticAve = new JLabel ("Baltic Ave");
		lblBalticAve.setBackground(new Color(255, 250, 205));
		lblBalticAve.setOpaque(true);
		GridBagConstraints gbc_lblBalticAve = new GridBagConstraints();
		gbc_lblBalticAve.fill = GridBagConstraints.BOTH;
		gbc_lblBalticAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalticAve.gridx = 1;
		gbc_lblBalticAve.gridy = 3;
		getContentPane().add(lblBalticAve, gbc_lblBalticAve);
		propLabels.add(lblBalticAve);
		
		lblVermontAve = new JLabel("Vermont Ave");
		lblVermontAve.setBackground(new Color(255, 250, 205));
		lblVermontAve.setOpaque(true);
		GridBagConstraints gbc_lblVermontAve = new GridBagConstraints();
		gbc_lblVermontAve.fill = GridBagConstraints.BOTH;
		gbc_lblVermontAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblVermontAve.gridx = 5;
		gbc_lblVermontAve.gridy = 3;
		getContentPane().add(lblVermontAve, gbc_lblVermontAve);
		propLabels.add(lblVermontAve);
		
		lblStatesAve = new JLabel("States Ave");
		lblStatesAve.setBackground(new Color(255, 250, 205));
		lblStatesAve.setOpaque(true);
		GridBagConstraints gbc_lblStatesAve = new GridBagConstraints();
		gbc_lblStatesAve.fill = GridBagConstraints.BOTH;
		gbc_lblStatesAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatesAve.gridx = 9;
		gbc_lblStatesAve.gridy = 3;
		getContentPane().add(lblStatesAve, gbc_lblStatesAve);
		propLabels.add(lblStatesAve);
		
		lblTennesseeAve = new JLabel("Tennessee Ave");
		lblTennesseeAve.setBackground(new Color(255, 250, 205));
		lblTennesseeAve.setOpaque(true);
		GridBagConstraints gbc_lblTennesseeAve = new GridBagConstraints();
		gbc_lblTennesseeAve.fill = GridBagConstraints.BOTH;
		gbc_lblTennesseeAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblTennesseeAve.gridx = 13;
		gbc_lblTennesseeAve.gridy = 3;
		getContentPane().add(lblTennesseeAve, gbc_lblTennesseeAve);
		propLabels.add(lblTennesseeAve);
		
		lblIndianaAve = new JLabel("Indiana Ave");
		lblIndianaAve.setBackground(new Color(255, 250, 205));
		lblIndianaAve.setOpaque(true);
		GridBagConstraints gbc_lblIndianaAve = new GridBagConstraints();
		gbc_lblIndianaAve.fill = GridBagConstraints.BOTH;
		gbc_lblIndianaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndianaAve.gridx = 17;
		gbc_lblIndianaAve.gridy = 3;
		getContentPane().add(lblIndianaAve, gbc_lblIndianaAve);
		propLabels.add(lblIndianaAve);
		
		lblConnecticutAve = new JLabel("Connecticut Ave");
		lblConnecticutAve.setBackground(new Color(255, 250, 205));
		lblConnecticutAve.setOpaque(true);
		GridBagConstraints gbc_lblConnecticutAve = new GridBagConstraints();
		gbc_lblConnecticutAve.fill = GridBagConstraints.BOTH;
		gbc_lblConnecticutAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblConnecticutAve.gridx = 5;
		gbc_lblConnecticutAve.gridy = 4;
		getContentPane().add(lblConnecticutAve, gbc_lblConnecticutAve);
		propLabels.add(lblConnecticutAve);
		
		lblVirginiaAve = new JLabel("Virginia Ave");
		lblVirginiaAve.setBackground(new Color(255, 250, 205));
		lblVirginiaAve.setOpaque(true);
		GridBagConstraints gbc_lblVirginiaAve = new GridBagConstraints();
		gbc_lblVirginiaAve.fill = GridBagConstraints.BOTH;
		gbc_lblVirginiaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblVirginiaAve.gridx = 9;
		gbc_lblVirginiaAve.gridy = 4;
		getContentPane().add(lblVirginiaAve, gbc_lblVirginiaAve);
		propLabels.add(lblVirginiaAve);
		
		lblNewYorkAve = new JLabel("New York Ave");
		lblNewYorkAve.setBackground(new Color(255, 250, 205));
		lblNewYorkAve.setOpaque(true);
		GridBagConstraints gbc_lblNewYorkAve = new GridBagConstraints();
		gbc_lblNewYorkAve.fill = GridBagConstraints.BOTH;
		gbc_lblNewYorkAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYorkAve.gridx = 13;
		gbc_lblNewYorkAve.gridy = 4;
		getContentPane().add(lblNewYorkAve, gbc_lblNewYorkAve);
		propLabels.add(lblNewYorkAve);
		
		lblIllinoisAve = new JLabel("Illinois Ave");
		lblIllinoisAve.setBackground(new Color(255, 250, 205));
		lblIllinoisAve.setOpaque(true);
		GridBagConstraints gbc_lblIllinoisAve = new GridBagConstraints();
		gbc_lblIllinoisAve.fill = GridBagConstraints.BOTH;
		gbc_lblIllinoisAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblIllinoisAve.gridx = 17;
		gbc_lblIllinoisAve.gridy = 4;
		getContentPane().add(lblIllinoisAve, gbc_lblIllinoisAve);
		propLabels.add(lblIllinoisAve);
		
		JLabel lblYellow = new JLabel("");
		GridBagConstraints gbc_lblYellow = new GridBagConstraints();
		gbc_lblYellow.fill = GridBagConstraints.BOTH;
		gbc_lblYellow.insets = new Insets(0, 0, 5, 5);
		gbc_lblYellow.gridx = 1;
		gbc_lblYellow.gridy = 6;
		lblYellow.setBackground(new Color(255,255,0));
		lblYellow.setOpaque(true);
		getContentPane().add(lblYellow, gbc_lblYellow);
		
		JLabel lblGreen = new JLabel("");
		GridBagConstraints gbc_lblGreen = new GridBagConstraints();
		gbc_lblGreen.fill = GridBagConstraints.BOTH;
		gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
		gbc_lblGreen.gridx = 5;
		gbc_lblGreen.gridy = 6;
		lblGreen.setBackground(new Color(0,204,102));
		lblGreen.setOpaque(true);
		getContentPane().add(lblGreen, gbc_lblGreen);
		
		JLabel lblDarkBlue = new JLabel("");
		GridBagConstraints gbc_lblDarkBlue = new GridBagConstraints();
		gbc_lblDarkBlue.fill = GridBagConstraints.BOTH;
		gbc_lblDarkBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDarkBlue.gridx = 9;
		gbc_lblDarkBlue.gridy = 6;
		lblDarkBlue.setBackground(new Color(0,128,255));
		lblDarkBlue.setOpaque(true);
		getContentPane().add(lblDarkBlue, gbc_lblDarkBlue);
		
		JLabel lblRailroads = new JLabel("Railroads");
		GridBagConstraints gbc_lblRailroads = new GridBagConstraints();
		gbc_lblRailroads.insets = new Insets(0, 0, 5, 5);
		gbc_lblRailroads.gridx = 13;
		gbc_lblRailroads.gridy = 6;
		getContentPane().add(lblRailroads, gbc_lblRailroads);
		
		JLabel lblUtilities = new JLabel("Utilities");
		GridBagConstraints gbc_lblUtilities = new GridBagConstraints();
		gbc_lblUtilities.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilities.gridx = 17;
		gbc_lblUtilities.gridy = 6;
		getContentPane().add(lblUtilities, gbc_lblUtilities);
		
		lblAtlanticAve = new JLabel("Atlantic Ave");
		lblAtlanticAve.setBackground(new Color(255, 250, 205));
		lblAtlanticAve.setOpaque(true);
		GridBagConstraints gbc_lblAtlanticAve = new GridBagConstraints();
		gbc_lblAtlanticAve.fill = GridBagConstraints.BOTH;
		gbc_lblAtlanticAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtlanticAve.gridx = 1;
		gbc_lblAtlanticAve.gridy = 7;
		getContentPane().add(lblAtlanticAve, gbc_lblAtlanticAve);
		propLabels.add(lblAtlanticAve);
		
		lblPacificAve = new JLabel("Pacific Ave");
		lblPacificAve.setBackground(new Color(255, 250, 205));
		lblPacificAve.setOpaque(true);
		GridBagConstraints gbc_lblPacificAve = new GridBagConstraints();
		gbc_lblPacificAve.fill = GridBagConstraints.BOTH;
		gbc_lblPacificAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblPacificAve.gridx = 5;
		gbc_lblPacificAve.gridy = 7;
		getContentPane().add(lblPacificAve, gbc_lblPacificAve);
		propLabels.add(lblPacificAve);
		
		lblParkPlace = new JLabel("Park Place");
		lblParkPlace.setBackground(new Color(255, 250, 205));
		lblParkPlace.setOpaque(true);
		GridBagConstraints gbc_lblParkPlace = new GridBagConstraints();
		gbc_lblParkPlace.fill = GridBagConstraints.BOTH;
		gbc_lblParkPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblParkPlace.gridx = 9;
		gbc_lblParkPlace.gridy = 7;
		getContentPane().add(lblParkPlace, gbc_lblParkPlace);
		propLabels.add(lblParkPlace);
		
		lblReadingRr = new JLabel("Reading RR");
		lblReadingRr.setBackground(new Color(255, 250, 205));
		lblReadingRr.setOpaque(true);
		GridBagConstraints gbc_lblReadingRr = new GridBagConstraints();
		gbc_lblReadingRr.fill = GridBagConstraints.BOTH;
		gbc_lblReadingRr.insets = new Insets(0, 0, 5, 5);
		gbc_lblReadingRr.gridx = 13;
		gbc_lblReadingRr.gridy = 7;
		getContentPane().add(lblReadingRr, gbc_lblReadingRr);
		propLabels.add(lblReadingRr);
		
		lblElectricCompany = new JLabel("Electric Company");
		lblElectricCompany.setBackground(new Color(255, 250, 205));
		lblElectricCompany.setOpaque(true);
		GridBagConstraints gbc_lblElectricCompany = new GridBagConstraints();
		gbc_lblElectricCompany.fill = GridBagConstraints.BOTH;
		gbc_lblElectricCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricCompany.gridx = 17;
		gbc_lblElectricCompany.gridy = 7;
		getContentPane().add(lblElectricCompany, gbc_lblElectricCompany);
		propLabels.add(lblElectricCompany);
		
		lblVentnorAve = new JLabel("Ventnor Ave");
		lblVentnorAve.setBackground(new Color(255, 250, 205));
		lblVentnorAve.setOpaque(true);
		GridBagConstraints gbc_lblVentnorAve = new GridBagConstraints();
		gbc_lblVentnorAve.fill = GridBagConstraints.BOTH;
		gbc_lblVentnorAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblVentnorAve.gridx = 1;
		gbc_lblVentnorAve.gridy = 8;
		getContentPane().add(lblVentnorAve, gbc_lblVentnorAve);
		propLabels.add(lblVentnorAve);
		
		lblNorthCarolinaAve = new JLabel("North Carolina Ave");
		lblNorthCarolinaAve.setBackground(new Color(255, 250, 205));
		lblNorthCarolinaAve.setOpaque(true);
		GridBagConstraints gbc_lblNorthCarolinaAve = new GridBagConstraints();
		gbc_lblNorthCarolinaAve.fill = GridBagConstraints.BOTH;
		gbc_lblNorthCarolinaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblNorthCarolinaAve.gridx = 5;
		gbc_lblNorthCarolinaAve.gridy = 8;
		getContentPane().add(lblNorthCarolinaAve, gbc_lblNorthCarolinaAve);
		propLabels.add(lblNorthCarolinaAve);
		
		lblBoardwalk = new JLabel("Boardwalk");
		lblBoardwalk.setBackground(new Color(255, 250, 205));
		lblBoardwalk.setOpaque(true);
		GridBagConstraints gbc_lblBoardwalk = new GridBagConstraints();
		gbc_lblBoardwalk.fill = GridBagConstraints.BOTH;
		gbc_lblBoardwalk.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoardwalk.gridx = 9;
		gbc_lblBoardwalk.gridy = 8;
		getContentPane().add(lblBoardwalk, gbc_lblBoardwalk);
		propLabels.add(lblBoardwalk);
		
		lblPennsylvaniaRr = new JLabel("Pennsylvania RR");
		lblPennsylvaniaRr.setBackground(new Color(255, 250, 205));
		lblPennsylvaniaRr.setOpaque(true);
		GridBagConstraints gbc_lblPennsylvaniaRr = new GridBagConstraints();
		gbc_lblPennsylvaniaRr.fill = GridBagConstraints.BOTH;
		gbc_lblPennsylvaniaRr.insets = new Insets(0, 0, 5, 5);
		gbc_lblPennsylvaniaRr.gridx = 13;
		gbc_lblPennsylvaniaRr.gridy = 8;
		getContentPane().add(lblPennsylvaniaRr, gbc_lblPennsylvaniaRr);
		propLabels.add(lblPennsylvaniaRr);
		
		lblWaterWorks = new JLabel("Water Works");
		lblWaterWorks.setBackground(new Color(255, 250, 205));
		lblWaterWorks.setOpaque(true);
		GridBagConstraints gbc_lblWaterWorks = new GridBagConstraints();
		gbc_lblWaterWorks.fill = GridBagConstraints.BOTH;
		gbc_lblWaterWorks.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaterWorks.gridx = 17;
		gbc_lblWaterWorks.gridy = 8;
		getContentPane().add(lblWaterWorks, gbc_lblWaterWorks);
		propLabels.add(lblWaterWorks);
		
		lblMarvinGardens = new JLabel("Marvin Gardens");
		lblMarvinGardens.setBackground(new Color(255, 250, 205));
		lblMarvinGardens.setOpaque(true);
		GridBagConstraints gbc_lblMarvinGardens = new GridBagConstraints();
		gbc_lblMarvinGardens.fill = GridBagConstraints.BOTH;
		gbc_lblMarvinGardens.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarvinGardens.gridx = 1;
		gbc_lblMarvinGardens.gridy = 9;
		getContentPane().add(lblMarvinGardens, gbc_lblMarvinGardens);
		propLabels.add(lblMarvinGardens);
		
		lblPennsylvaniaAve = new JLabel("Pennsylvania Ave");
		lblPennsylvaniaAve.setBackground(new Color(255, 250, 205));
		lblPennsylvaniaAve.setOpaque(true);
		GridBagConstraints gbc_lblPennsylvaniaAve = new GridBagConstraints();
		gbc_lblPennsylvaniaAve.fill = GridBagConstraints.BOTH;
		gbc_lblPennsylvaniaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblPennsylvaniaAve.gridx = 5;
		gbc_lblPennsylvaniaAve.gridy = 9;
		getContentPane().add(lblPennsylvaniaAve, gbc_lblPennsylvaniaAve);
		propLabels.add(lblPennsylvaniaAve);
		
		lblBO = new JLabel("B. & O. RR");
		lblBO.setBackground(new Color(255, 250, 205));
		lblBO.setOpaque(true);
		GridBagConstraints gbc_lblBO = new GridBagConstraints();
		gbc_lblBO.fill = GridBagConstraints.BOTH;
		gbc_lblBO.insets = new Insets(0, 0, 5, 5);
		gbc_lblBO.gridx = 13;
		gbc_lblBO.gridy = 9;
		getContentPane().add(lblBO, gbc_lblBO);
		propLabels.add(lblBO);
		
		lblShortLine = new JLabel("Short Line");
		lblShortLine.setBackground(new Color(255, 250, 205));
		lblShortLine.setOpaque(true);
		GridBagConstraints gbc_lblShortLine = new GridBagConstraints();
		gbc_lblShortLine.fill = GridBagConstraints.BOTH;
		gbc_lblShortLine.insets = new Insets(0, 0, 0, 5);
		gbc_lblShortLine.gridx = 13;
		gbc_lblShortLine.gridy = 10;
		getContentPane().add(lblShortLine, gbc_lblShortLine);
		propLabels.add(lblShortLine);
		
		highlightOwned();
		
	}
	
	void highlightOwned()
	{
		
		for(ArrayList<Property> x : currentPlayer.getProperties())
		{
			for(Property y : x)
			{
				String prop = y.getName();
					for(JLabel z : propLabels)
					{
						if (z.getText().equals(prop))
						{
							z.setBackground(new Color(204, 255, 153) );
						}
					}
			}
		}
		
	}

}
