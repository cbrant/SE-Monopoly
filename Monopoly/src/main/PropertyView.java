package main;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

@SuppressWarnings("serial")
public class PropertyView extends JPanel {

	
	private JLabel lblMediterraneanAve, lblBalticAve, lblOrientalAve, lblVermontAve, lblConnecticutAve, lblStCharlesPlace, lblStatesAve, lblVirginiaAve, lblStJamesPlace, lblTennesseeAve, lblNewYorkAve;
	private JLabel lblKentuckyAve, lblIndianaAve, lblIllinoisAve, lblAtlanticAve, lblVentnorAve, lblMarvinGardens, lblPacificAve, lblNorthCarolinaAve, lblPennsylvaniaAve, lblParkPlace, lblBoardwalk;
	private JLabel lblReadingRr, lblPennsylvaniaRr, lblBO, lblShortLine, lblElectricCompany, lblWaterWorks;
	
	/**
	 * Create the panel.
	 */
	public PropertyView() {
		setBackground(new Color(255, 250, 205));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblBrown = new JLabel("");
		GridBagConstraints gbc_lblBrown = new GridBagConstraints();
		gbc_lblBrown.fill = GridBagConstraints.BOTH;
		gbc_lblBrown.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrown.gridx = 1;
		gbc_lblBrown.gridy = 1;
		lblBrown.setBackground(new Color(153,76,0));
		lblBrown.setOpaque(true);
		add(lblBrown, gbc_lblBrown);
		
		JLabel lblLightBlue = new JLabel("");
		GridBagConstraints gbc_lblLightBlue = new GridBagConstraints();
		gbc_lblLightBlue.fill = GridBagConstraints.BOTH;
		gbc_lblLightBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblLightBlue.gridx = 5;
		gbc_lblLightBlue.gridy = 1;
		lblLightBlue.setBackground(new Color(153,255,255));
		lblLightBlue.setOpaque(true);
		add(lblLightBlue, gbc_lblLightBlue);
		
		JLabel lblPink = new JLabel("");
		GridBagConstraints gbc_lblPink = new GridBagConstraints();
		gbc_lblPink.fill = GridBagConstraints.BOTH;
		gbc_lblPink.insets = new Insets(0, 0, 5, 5);
		gbc_lblPink.gridx = 9;
		gbc_lblPink.gridy = 1;
		lblPink.setBackground(new Color(255,0,255));
		lblPink.setOpaque(true);
		add(lblPink, gbc_lblPink);
		
		JLabel lblOrange = new JLabel("");
		GridBagConstraints gbc_lblOrange = new GridBagConstraints();
		gbc_lblOrange.fill = GridBagConstraints.BOTH;
		gbc_lblOrange.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrange.gridx = 13;
		gbc_lblOrange.gridy = 1;
		lblOrange.setBackground(new Color(255,128,0));
		lblOrange.setOpaque(true);
		add(lblOrange, gbc_lblOrange);
		
		JLabel lblRed = new JLabel("");
		GridBagConstraints gbc_lblRed = new GridBagConstraints();
		gbc_lblRed.fill = GridBagConstraints.BOTH;
		gbc_lblRed.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed.gridx = 17;
		gbc_lblRed.gridy = 1;
		lblRed.setBackground(new Color(255,0,0));
		lblRed.setOpaque(true);
		add(lblRed, gbc_lblRed);
		
		lblMediterraneanAve = new JLabel("Mediterranean Ave");
		GridBagConstraints gbc_lblMediterranean = new GridBagConstraints();
		gbc_lblMediterranean.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediterranean.gridx = 1;
		gbc_lblMediterranean.gridy = 2;
		add(lblMediterraneanAve, gbc_lblMediterranean);
		
		lblOrientalAve = new JLabel("Oriental Ave");
		GridBagConstraints gbc_lblOrientalAve = new GridBagConstraints();
		gbc_lblOrientalAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrientalAve.gridx = 5;
		gbc_lblOrientalAve.gridy = 2;
		add(lblOrientalAve, gbc_lblOrientalAve);
		
		lblStCharlesPlace = new JLabel("St. Charles Place");
		GridBagConstraints gbc_lblStCharlesPlace = new GridBagConstraints();
		gbc_lblStCharlesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblStCharlesPlace.gridx = 9;
		gbc_lblStCharlesPlace.gridy = 2;
		add(lblStCharlesPlace, gbc_lblStCharlesPlace);
		
		lblStJamesPlace = new JLabel("St. James Place");
		GridBagConstraints gbc_lblStJamesPlace = new GridBagConstraints();
		gbc_lblStJamesPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblStJamesPlace.gridx = 13;
		gbc_lblStJamesPlace.gridy = 2;
		add(lblStJamesPlace, gbc_lblStJamesPlace);
		
		lblKentuckyAve = new JLabel("Kentucky Ave");
		GridBagConstraints gbc_lblKentuckyAve = new GridBagConstraints();
		gbc_lblKentuckyAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblKentuckyAve.gridx = 17;
		gbc_lblKentuckyAve.gridy = 2;
		add(lblKentuckyAve, gbc_lblKentuckyAve);
		
		lblBalticAve = new JLabel ("Baltic Ave");
		GridBagConstraints gbc_lblBalticAve = new GridBagConstraints();
		gbc_lblBalticAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalticAve.gridx = 1;
		gbc_lblBalticAve.gridy = 3;
		add(lblBalticAve, gbc_lblBalticAve);
		
		lblVermontAve = new JLabel("Vermont Ave");
		GridBagConstraints gbc_lblVermontAve = new GridBagConstraints();
		gbc_lblVermontAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblVermontAve.gridx = 5;
		gbc_lblVermontAve.gridy = 3;
		add(lblVermontAve, gbc_lblVermontAve);
		
		lblStatesAve = new JLabel("States Ave");
		GridBagConstraints gbc_lblStatesAve = new GridBagConstraints();
		gbc_lblStatesAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatesAve.gridx = 9;
		gbc_lblStatesAve.gridy = 3;
		add(lblStatesAve, gbc_lblStatesAve);
		
		lblTennesseeAve = new JLabel("Tennessee Ave");
		GridBagConstraints gbc_lblTennesseeAve = new GridBagConstraints();
		gbc_lblTennesseeAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblTennesseeAve.gridx = 13;
		gbc_lblTennesseeAve.gridy = 3;
		add(lblTennesseeAve, gbc_lblTennesseeAve);
		
		lblIndianaAve = new JLabel("Indiana Ave");
		GridBagConstraints gbc_lblIndianaAve = new GridBagConstraints();
		gbc_lblIndianaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndianaAve.gridx = 17;
		gbc_lblIndianaAve.gridy = 3;
		add(lblIndianaAve, gbc_lblIndianaAve);
		
		lblConnecticutAve = new JLabel("Connecticut Ave");
		GridBagConstraints gbc_lblConnecticutAve = new GridBagConstraints();
		gbc_lblConnecticutAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblConnecticutAve.gridx = 5;
		gbc_lblConnecticutAve.gridy = 4;
		add(lblConnecticutAve, gbc_lblConnecticutAve);
		
		lblVirginiaAve = new JLabel("Virginia Ave");
		GridBagConstraints gbc_lblVirginiaAve = new GridBagConstraints();
		gbc_lblVirginiaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblVirginiaAve.gridx = 9;
		gbc_lblVirginiaAve.gridy = 4;
		add(lblVirginiaAve, gbc_lblVirginiaAve);
		
		lblNewYorkAve = new JLabel("New York Ave");
		GridBagConstraints gbc_lblNewYorkAve = new GridBagConstraints();
		gbc_lblNewYorkAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYorkAve.gridx = 13;
		gbc_lblNewYorkAve.gridy = 4;
		add(lblNewYorkAve, gbc_lblNewYorkAve);
		
		lblIllinoisAve = new JLabel("Illinois Ave");
		GridBagConstraints gbc_lblIllinoisAve = new GridBagConstraints();
		gbc_lblIllinoisAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblIllinoisAve.gridx = 17;
		gbc_lblIllinoisAve.gridy = 4;
		add(lblIllinoisAve, gbc_lblIllinoisAve);
		
		JLabel lblYellow = new JLabel("");
		GridBagConstraints gbc_lblYellow = new GridBagConstraints();
		gbc_lblYellow.fill = GridBagConstraints.BOTH;
		gbc_lblYellow.insets = new Insets(0, 0, 5, 5);
		gbc_lblYellow.gridx = 1;
		gbc_lblYellow.gridy = 6;
		lblYellow.setBackground(new Color(255,255,0));
		lblYellow.setOpaque(true);
		add(lblYellow, gbc_lblYellow);
		
		JLabel lblGreen = new JLabel("");
		GridBagConstraints gbc_lblGreen = new GridBagConstraints();
		gbc_lblGreen.fill = GridBagConstraints.BOTH;
		gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
		gbc_lblGreen.gridx = 5;
		gbc_lblGreen.gridy = 6;
		lblGreen.setBackground(new Color(0,204,102));
		lblGreen.setOpaque(true);
		add(lblGreen, gbc_lblGreen);
		
		JLabel lblDarkBlue = new JLabel("");
		GridBagConstraints gbc_lblDarkBlue = new GridBagConstraints();
		gbc_lblDarkBlue.fill = GridBagConstraints.BOTH;
		gbc_lblDarkBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDarkBlue.gridx = 9;
		gbc_lblDarkBlue.gridy = 6;
		lblDarkBlue.setBackground(new Color(0,128,255));
		lblDarkBlue.setOpaque(true);
		add(lblDarkBlue, gbc_lblDarkBlue);
		
		JLabel lblRailroads = new JLabel("Railroads");
		GridBagConstraints gbc_lblRailroads = new GridBagConstraints();
		gbc_lblRailroads.insets = new Insets(0, 0, 5, 5);
		gbc_lblRailroads.gridx = 13;
		gbc_lblRailroads.gridy = 6;
		add(lblRailroads, gbc_lblRailroads);
		
		JLabel lblUtilities = new JLabel("Utilities");
		GridBagConstraints gbc_lblUtilities = new GridBagConstraints();
		gbc_lblUtilities.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilities.gridx = 17;
		gbc_lblUtilities.gridy = 6;
		add(lblUtilities, gbc_lblUtilities);
		
		lblAtlanticAve = new JLabel("Atlantic Ave");
		GridBagConstraints gbc_lblAtlanticAve = new GridBagConstraints();
		gbc_lblAtlanticAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtlanticAve.gridx = 1;
		gbc_lblAtlanticAve.gridy = 7;
		add(lblAtlanticAve, gbc_lblAtlanticAve);
		
		lblPacificAve = new JLabel("Pacific Ave");
		GridBagConstraints gbc_lblPacificAve = new GridBagConstraints();
		gbc_lblPacificAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblPacificAve.gridx = 5;
		gbc_lblPacificAve.gridy = 7;
		add(lblPacificAve, gbc_lblPacificAve);
		
		lblParkPlace = new JLabel("Park Place");
		GridBagConstraints gbc_lblParkPlace = new GridBagConstraints();
		gbc_lblParkPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblParkPlace.gridx = 9;
		gbc_lblParkPlace.gridy = 7;
		add(lblParkPlace, gbc_lblParkPlace);
		
		lblReadingRr = new JLabel("Reading RR");
		GridBagConstraints gbc_lblReadingRr = new GridBagConstraints();
		gbc_lblReadingRr.insets = new Insets(0, 0, 5, 5);
		gbc_lblReadingRr.gridx = 13;
		gbc_lblReadingRr.gridy = 7;
		add(lblReadingRr, gbc_lblReadingRr);
		
		lblElectricCompany = new JLabel("Electric Company");
		GridBagConstraints gbc_lblElectricCompany = new GridBagConstraints();
		gbc_lblElectricCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricCompany.gridx = 17;
		gbc_lblElectricCompany.gridy = 7;
		add(lblElectricCompany, gbc_lblElectricCompany);
		
		lblVentnorAve = new JLabel("Ventnor Ave");
		GridBagConstraints gbc_lblVentnorAve = new GridBagConstraints();
		gbc_lblVentnorAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblVentnorAve.gridx = 1;
		gbc_lblVentnorAve.gridy = 8;
		add(lblVentnorAve, gbc_lblVentnorAve);
		
		lblNorthCarolinaAve = new JLabel("North Carolina Ave");
		GridBagConstraints gbc_lblNorthCarolinaAve = new GridBagConstraints();
		gbc_lblNorthCarolinaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblNorthCarolinaAve.gridx = 5;
		gbc_lblNorthCarolinaAve.gridy = 8;
		add(lblNorthCarolinaAve, gbc_lblNorthCarolinaAve);
		
		lblBoardwalk = new JLabel("Boardwalk");
		GridBagConstraints gbc_lblBoardwalk = new GridBagConstraints();
		gbc_lblBoardwalk.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoardwalk.gridx = 9;
		gbc_lblBoardwalk.gridy = 8;
		add(lblBoardwalk, gbc_lblBoardwalk);
		
		lblPennsylvaniaRr = new JLabel("Pennsylvania RR");
		GridBagConstraints gbc_lblPennsylvaniaRr = new GridBagConstraints();
		gbc_lblPennsylvaniaRr.insets = new Insets(0, 0, 5, 5);
		gbc_lblPennsylvaniaRr.gridx = 13;
		gbc_lblPennsylvaniaRr.gridy = 8;
		add(lblPennsylvaniaRr, gbc_lblPennsylvaniaRr);
		
		lblWaterWorks = new JLabel("Water Works");
		GridBagConstraints gbc_lblWaterWorks = new GridBagConstraints();
		gbc_lblWaterWorks.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaterWorks.gridx = 17;
		gbc_lblWaterWorks.gridy = 8;
		add(lblWaterWorks, gbc_lblWaterWorks);
		
		lblMarvinGardens = new JLabel("Marvin Gardens");
		GridBagConstraints gbc_lblMarvinGardens = new GridBagConstraints();
		gbc_lblMarvinGardens.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarvinGardens.gridx = 1;
		gbc_lblMarvinGardens.gridy = 9;
		add(lblMarvinGardens, gbc_lblMarvinGardens);
		
		lblPennsylvaniaAve = new JLabel("Pennsylvania Ave");
		GridBagConstraints gbc_lblPennsylvaniaAve = new GridBagConstraints();
		gbc_lblPennsylvaniaAve.insets = new Insets(0, 0, 5, 5);
		gbc_lblPennsylvaniaAve.gridx = 5;
		gbc_lblPennsylvaniaAve.gridy = 9;
		add(lblPennsylvaniaAve, gbc_lblPennsylvaniaAve);
		
		lblBO = new JLabel("B. & O. RR");
		GridBagConstraints gbc_lblBO = new GridBagConstraints();
		gbc_lblBO.insets = new Insets(0, 0, 5, 5);
		gbc_lblBO.gridx = 13;
		gbc_lblBO.gridy = 9;
		add(lblBO, gbc_lblBO);
		
		lblShortLine = new JLabel("Short Line");
		GridBagConstraints gbc_lblShortLine = new GridBagConstraints();
		gbc_lblShortLine.insets = new Insets(0, 0, 0, 5);
		gbc_lblShortLine.gridx = 13;
		gbc_lblShortLine.gridy = 10;
		add(lblShortLine, gbc_lblShortLine);

	}

}
