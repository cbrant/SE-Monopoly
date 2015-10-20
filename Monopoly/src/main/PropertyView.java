package main;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class PropertyView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PropertyView() {
		setBackground(new Color(255, 250, 205));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblBrown = new JLabel("Brown");
		GridBagConstraints gbc_lblBrown = new GridBagConstraints();
		gbc_lblBrown.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrown.gridx = 1;
		gbc_lblBrown.gridy = 1;
		add(lblBrown, gbc_lblBrown);
		
		JLabel lblLightBlue = new JLabel("Light Blue");
		GridBagConstraints gbc_lblLightBlue = new GridBagConstraints();
		gbc_lblLightBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblLightBlue.gridx = 5;
		gbc_lblLightBlue.gridy = 1;
		add(lblLightBlue, gbc_lblLightBlue);
		
		JLabel lblPink = new JLabel("Pink");
		GridBagConstraints gbc_lblPink = new GridBagConstraints();
		gbc_lblPink.insets = new Insets(0, 0, 5, 5);
		gbc_lblPink.gridx = 9;
		gbc_lblPink.gridy = 1;
		add(lblPink, gbc_lblPink);
		
		JLabel lblOrange = new JLabel("Orange");
		GridBagConstraints gbc_lblOrange = new GridBagConstraints();
		gbc_lblOrange.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrange.gridx = 13;
		gbc_lblOrange.gridy = 1;
		add(lblOrange, gbc_lblOrange);
		
		JLabel lblRed = new JLabel("Red");
		GridBagConstraints gbc_lblRed = new GridBagConstraints();
		gbc_lblRed.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed.gridx = 17;
		gbc_lblRed.gridy = 1;
		add(lblRed, gbc_lblRed);
		
		JLabel lblYellow = new JLabel("Yellow");
		GridBagConstraints gbc_lblYellow = new GridBagConstraints();
		gbc_lblYellow.insets = new Insets(0, 0, 5, 5);
		gbc_lblYellow.gridx = 1;
		gbc_lblYellow.gridy = 6;
		add(lblYellow, gbc_lblYellow);
		
		JLabel lblGreen = new JLabel("Green");
		GridBagConstraints gbc_lblGreen = new GridBagConstraints();
		gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
		gbc_lblGreen.gridx = 5;
		gbc_lblGreen.gridy = 6;
		add(lblGreen, gbc_lblGreen);
		
		JLabel lblDarkBlue = new JLabel("Dark Blue");
		GridBagConstraints gbc_lblDarkBlue = new GridBagConstraints();
		gbc_lblDarkBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDarkBlue.gridx = 9;
		gbc_lblDarkBlue.gridy = 6;
		add(lblDarkBlue, gbc_lblDarkBlue);
		
		JLabel lblRailroads = new JLabel("RailRoads");
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

	}

}
