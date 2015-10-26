package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PropertyView extends JFrame {


	private JLabel lblMediterraneanAve, lblBalticAve, lblOrientalAve, lblVermontAve, lblConnecticutAve, lblStCharlesPlace, lblStatesAve, lblVirginiaAve, lblStJamesPlace, lblTennesseeAve, lblNewYorkAve;
	private JLabel lblKentuckyAve, lblIndianaAve, lblIllinoisAve, lblAtlanticAve, lblVentnorAve, lblMarvinGardens, lblPacificAve, lblNorthCarolinaAve, lblPennsylvaniaAve, lblParkPlace, lblBoardwalk;
	private JLabel lblReadingRr, lblPennsylvaniaRr, lblBO, lblShortLine, lblElectricCompany, lblWaterWorks;

	private final static String BUTTON = "button";
	private final static String HOUSE = "houseProperty";

	private GamePanel parent;

	private ArrayList<JLabel> propLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> houseLabels = new ArrayList<JLabel>();

	private Player currentPlayer;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JButton btnH;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;

	/**
	 * Create the panel.
	 */
	public PropertyView(Player playerIn, GamePanel par) {

		this.parent = par;
		currentPlayer = playerIn;

		getContentPane().setBackground(new Color(255, 250, 205));

		this.setBackground(new Color(255, 250, 205));

		setBounds(100, 100, 1100, 500);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


		setBackground(new Color(255, 250, 205));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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

		label = new JLabel("0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 2;
		getContentPane().add(label, gbc_label);
		houseLabels.add(label);
		label.putClientProperty(HOUSE, "Mediterranean Ave");

		btnH = new JButton("H");
		GridBagConstraints gbc_btnH = new GridBagConstraints();
		gbc_btnH.insets = new Insets(0, 0, 5, 5);
		gbc_btnH.gridx = 3;
		gbc_btnH.gridy = 2;
		getContentPane().add(btnH, gbc_btnH);
		btnH.putClientProperty(BUTTON, 1);
		btnH.addActionListener(houseClicked);

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

		label_2 = new JLabel("0");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 6;
		gbc_label_2.gridy = 2;
		getContentPane().add(label_2, gbc_label_2);
		houseLabels.add(label_2);
		label_2.putClientProperty(HOUSE, "Oriental Ave");

		button_1 = new JButton("H");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 7;
		gbc_button_1.gridy = 2;
		getContentPane().add(button_1, gbc_button_1);
		button_1.putClientProperty(BUTTON, 6);
		button_1.addActionListener(houseClicked);

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

		label_5 = new JLabel("0");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 10;
		gbc_label_5.gridy = 2;
		getContentPane().add(label_5, gbc_label_5);
		houseLabels.add(label_5);
		label_5.putClientProperty(HOUSE, "St. Charles Place");

		button_4 = new JButton("H");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 11;
		gbc_button_4.gridy = 2;
		getContentPane().add(button_4, gbc_button_4);
		button_4.putClientProperty(BUTTON, 11);
		button_4.addActionListener(houseClicked);

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

		label_8 = new JLabel("0");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 14;
		gbc_label_8.gridy = 2;
		getContentPane().add(label_8, gbc_label_8);
		houseLabels.add(label_8);
		label_8.putClientProperty(HOUSE, "St. James Place");

		button_7 = new JButton("H");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 15;
		gbc_button_7.gridy = 2;
		getContentPane().add(button_7, gbc_button_7);
		button_7.putClientProperty(BUTTON, 16);
		button_7.addActionListener(houseClicked);

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

		label_11 = new JLabel("0");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 18;
		gbc_label_11.gridy = 2;
		getContentPane().add(label_11, gbc_label_11);
		houseLabels.add(label_11);
		label_11.putClientProperty(HOUSE, "Kentucky Ave");

		button_10 = new JButton("H");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 19;
		gbc_button_10.gridy = 2;
		getContentPane().add(button_10, gbc_button_10);
		button_10.putClientProperty(BUTTON, 21);
		button_10.addActionListener(houseClicked);

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


		label_1 = new JLabel("0");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 3;
		getContentPane().add(label_1, gbc_label_1);
		houseLabels.add(label_1);
		label_1.putClientProperty(HOUSE, "Baltic Ave");

		button = new JButton("H");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 3;
		getContentPane().add(button, gbc_button);
		button.putClientProperty(BUTTON, 3);
		button.addActionListener(houseClicked);

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

		label_3 = new JLabel("0");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 6;
		gbc_label_3.gridy = 3;
		getContentPane().add(label_3, gbc_label_3);
		houseLabels.add(label_3);
		label_3.putClientProperty(HOUSE, "Vermont Ave");

		button_2 = new JButton("H");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 7;
		gbc_button_2.gridy = 3;
		getContentPane().add(button_2, gbc_button_2);
		button_2.putClientProperty(BUTTON, 8);
		button_2.addActionListener(houseClicked);

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

		label_6 = new JLabel("0");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 10;
		gbc_label_6.gridy = 3;
		getContentPane().add(label_6, gbc_label_6);
		houseLabels.add(label_6);
		label_6.putClientProperty(HOUSE, "States Ave");

		button_5 = new JButton("H");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 11;
		gbc_button_5.gridy = 3;
		getContentPane().add(button_5, gbc_button_5);
		button_5.putClientProperty(BUTTON, 13);
		button_5.addActionListener(houseClicked);

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

		label_9 = new JLabel("0");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 14;
		gbc_label_9.gridy = 3;
		getContentPane().add(label_9, gbc_label_9);
		houseLabels.add(label_9);
		label_9.putClientProperty(HOUSE, "Tennessee Ave");

		button_8 = new JButton("H");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 15;
		gbc_button_8.gridy = 3;
		getContentPane().add(button_8, gbc_button_8);
		button_8.putClientProperty(BUTTON, 18);
		button_8.addActionListener(houseClicked);

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

		label_12 = new JLabel("0");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 18;
		gbc_label_12.gridy = 3;
		getContentPane().add(label_12, gbc_label_12);
		houseLabels.add(label_12);
		label_12.putClientProperty(HOUSE, "Indiana Ave");

		button_11 = new JButton("H");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 19;
		gbc_button_11.gridy = 3;
		getContentPane().add(button_11, gbc_button_11);
		button_11.putClientProperty(BUTTON, 23);
		button_11.addActionListener(houseClicked);

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

		label_4 = new JLabel("0");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 6;
		gbc_label_4.gridy = 4;
		getContentPane().add(label_4, gbc_label_4);
		houseLabels.add(label_4);
		label_4.putClientProperty(HOUSE, "Connecticut Ave");

		button_3 = new JButton("H");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 7;
		gbc_button_3.gridy = 4;
		getContentPane().add(button_3, gbc_button_3);
		button_3.putClientProperty(BUTTON, 9);
		button_3.addActionListener(houseClicked);

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

		label_7 = new JLabel("0");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 10;
		gbc_label_7.gridy = 4;
		getContentPane().add(label_7, gbc_label_7);
		houseLabels.add(label_7);
		label_7.putClientProperty(HOUSE, "Virginia Ave");

		button_6 = new JButton("H");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 11;
		gbc_button_6.gridy = 4;
		getContentPane().add(button_6, gbc_button_6);
		button_6.putClientProperty(BUTTON, 14);
		button_6.addActionListener(houseClicked);

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

		label_10 = new JLabel("0");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 14;
		gbc_label_10.gridy = 4;
		getContentPane().add(label_10, gbc_label_10);
		houseLabels.add(label_10);
		label_10.putClientProperty(HOUSE, "New York Ave");

		button_9 = new JButton("H");
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 15;
		gbc_button_9.gridy = 4;
		getContentPane().add(button_9, gbc_button_9);
		button_9.putClientProperty(BUTTON, 19);
		button_9.addActionListener(houseClicked);

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

		label_13 = new JLabel("0");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 18;
		gbc_label_13.gridy = 4;
		getContentPane().add(label_13, gbc_label_13);
		houseLabels.add(label_13);
		label_13.putClientProperty(HOUSE, "Illinois Ave");

		button_12 = new JButton("H");
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 19;
		gbc_button_12.gridy = 4;
		getContentPane().add(button_12, gbc_button_12);
		button_12.putClientProperty(BUTTON, 24);
		button_12.addActionListener(houseClicked);

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

		label_19 = new JLabel("0");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 2;
		gbc_label_19.gridy = 7;
		getContentPane().add(label_19, gbc_label_19);
		houseLabels.add(label_19);
		label_19.putClientProperty(HOUSE, "Atlantic Ave");

		button_18 = new JButton("H");
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 3;
		gbc_button_18.gridy = 7;
		getContentPane().add(button_18, gbc_button_18);
		button_18.putClientProperty(BUTTON, 26);
		button_18.addActionListener(houseClicked);

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

		label_16 = new JLabel("0");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 6;
		gbc_label_16.gridy = 7;
		getContentPane().add(label_16, gbc_label_16);
		houseLabels.add(label_16);
		label_16.putClientProperty(HOUSE, "Pacific Ave");

		button_15 = new JButton("H");
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 7;
		gbc_button_15.gridy = 7;
		getContentPane().add(button_15, gbc_button_15);
		button_15.putClientProperty(BUTTON, 31);
		button_15.addActionListener(houseClicked);

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

		label_14 = new JLabel("0");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 10;
		gbc_label_14.gridy = 7;
		getContentPane().add(label_14, gbc_label_14);
		houseLabels.add(label_14);
		label_14.putClientProperty(HOUSE, "Park Place");

		button_13 = new JButton("H");
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 11;
		gbc_button_13.gridy = 7;
		getContentPane().add(button_13, gbc_button_13);
		button_13.putClientProperty(BUTTON, 37);
		button_13.addActionListener(houseClicked);

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

		label_20 = new JLabel("0");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 2;
		gbc_label_20.gridy = 8;
		getContentPane().add(label_20, gbc_label_20);
		houseLabels.add(label_20);
		label_20.putClientProperty(HOUSE, "Ventnor Ave");

		button_19 = new JButton("H");
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 3;
		gbc_button_19.gridy = 8;
		getContentPane().add(button_19, gbc_button_19);
		button_19.putClientProperty(BUTTON, 27);
		button_19.addActionListener(houseClicked);

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

		label_17 = new JLabel("0");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 6;
		gbc_label_17.gridy = 8;
		getContentPane().add(label_17, gbc_label_17);
		houseLabels.add(label_17);
		label_17.putClientProperty(HOUSE, "North Carolina Ave");

		button_16 = new JButton("H");
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 7;
		gbc_button_16.gridy = 8;
		getContentPane().add(button_16, gbc_button_16);
		button_16.putClientProperty(BUTTON, 32);
		button_16.addActionListener(houseClicked);

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

		label_15 = new JLabel("0");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 10;
		gbc_label_15.gridy = 8;
		getContentPane().add(label_15, gbc_label_15);
		houseLabels.add(label_15);
		label_15.putClientProperty(HOUSE, "Boardwalk");

		button_14 = new JButton("H");
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 11;
		gbc_button_14.gridy = 8;
		getContentPane().add(button_14, gbc_button_14);
		button_14.putClientProperty(BUTTON, 39);
		button_14.addActionListener(houseClicked);

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

		label_21 = new JLabel("0");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 2;
		gbc_label_21.gridy = 9;
		getContentPane().add(label_21, gbc_label_21);
		houseLabels.add(label_21);
		label_21.putClientProperty(HOUSE, "Marvin Gardens");

		button_20 = new JButton("H");
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 3;
		gbc_button_20.gridy = 9;
		getContentPane().add(button_20, gbc_button_20);
		button_20.putClientProperty(BUTTON, 29);
		button_20.addActionListener(houseClicked);

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

		label_18 = new JLabel("0");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 6;
		gbc_label_18.gridy = 9;
		getContentPane().add(label_18, gbc_label_18);
		houseLabels.add(label_18);
		label_18.putClientProperty(HOUSE, "Pennsylvania Ave");

		button_17 = new JButton("H");
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 5);
		gbc_button_17.gridx = 7;
		gbc_button_17.gridy = 9;
		getContentPane().add(button_17, gbc_button_17);
		button_17.putClientProperty(BUTTON, 34);
		button_17.addActionListener(houseClicked);

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
		updateHouses();

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

	private ActionListener houseClicked = new ActionListener() { 

		@Override
		public void actionPerformed(ActionEvent e) {			 
			int spaceSelected = (int)(((JButton)e.getSource()).getClientProperty(PropertyView.BUTTON));

			MainWindow main = parent.getMyParent();

			//This prints out what property is getting a house
			//Need to write code to actually check if the house can be bought and then buy it
			Property prop = (Property)main.spaces.get(spaceSelected);

			// can only buy a house if all of the following are satisfied: 
			//	(1) the player owns the space
			//	(2) the player owns all of the properties of that space
			//	(3) it is that player's turn
			// 	(4) the player has enough money to buy the house
			//	(5) TODO -- the other properties from that category have the same number of houses
			//		as the selected property (or 1 more)
			//	(6) not all houses are bought for this property (5 can be bought -- means hotel bought)
			if (currentPlayer.ownsProperty(prop) && prop.canBuyHouse() && 
					main.players[parent.currPlayer] == currentPlayer && 
					prop.getNumHouses() < 5) {
				// check if the player is 'stacking' houses (see Player.java housesNotStacked() for 
				//	description of what 'stacking houses' is)
				if (currentPlayer.housesNotStacked(prop)) {
					// check if the player has enough money
					if (currentPlayer.getBank() > prop.getHouseCost()) {
						int buyHouse = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy a house for " 
								+ prop.getName() + " for $" + prop.getHouseCost() + "?", 
								"Buy House for " + prop.getName(), JOptionPane.YES_NO_OPTION);	
						// if player confirms buying it, then add a house to that property 
						if (buyHouse == 0) 	{
							// deduct house cost from bank
							currentPlayer.deductFromBank(prop.getHouseCost(), main.playersOut);
							// add 
							prop.setNumHouses(prop.getNumHouses() + 1);
							updateHouses();
						}

					}
					// if they don't have enough money, give them a warning
					else {
						// notify player that they don't have money via popup window
						JOptionPane.showMessageDialog(null, "Insufficient funds in bank account!\nHouse cost: $" +
								prop.getHouseCost()+"\nAccount Balance: $"+currentPlayer.getBank(), 
								"Bank error", JOptionPane.ERROR_MESSAGE);
					}	
				}
				// if they are stacking, don't let them buy it and give them a warning
				else {
					JOptionPane.showMessageDialog(null, "You need to put houses on the other properties in this" + 
							" category first!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				

			}
			else {
				// one of the above conditions is not met
				JOptionPane.showMessageDialog(null, "You can't buy that right now!", "Error", 
						JOptionPane.ERROR_MESSAGE);
			}

		}

	};

	public void updateHouses()
	{
		for( ArrayList<Property> propCategories : this.currentPlayer.getProperties() )
		{
			for( Property x : propCategories )
			{
				for( JLabel houseLabel : this.houseLabels)
				{
					if( houseLabel.getClientProperty(HOUSE).equals(x.getName()) )
					{
						//if player owns spot, update number of houses shown
						houseLabel.setText(""+x.getNumHouses());
					}
				}
			}
		}
	}

}
