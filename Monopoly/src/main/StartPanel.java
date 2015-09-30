package main;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPanel extends JPanel {

	public JButton goButton;
	
	/**
	 * Create the panel.
	 */
	public StartPanel() {
		setBackground(new Color(255, 250, 205));
		 setBounds(100, 100, 650, 725);
		 GridBagLayout gridBagLayout = new GridBagLayout();
		 gridBagLayout.columnWidths = new int[]{200, 200, 200, 0};
		 gridBagLayout.rowHeights = new int[]{350, 100, 75, 50, 25, 25, 25, 25, 75, 0};
		 gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		 gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		 setLayout(gridBagLayout);
	     		 		 		 
	     		 		 		 JLabel lblMonopoly = new JLabel("");
	     		 		 		 GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	     		 		 		 gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_lblNewLabel.gridx = 0;
	     		 		 		 gbc_lblNewLabel.gridy = 0;
	     		 		 		 gbc_lblNewLabel.gridwidth = 3;
	     		 		 		 Image img = new ImageIcon(this.getClass().getResource("/monopolyLogo.png")).getImage();
	     		 			     lblMonopoly.setIcon(new ImageIcon(img));
	     		 		 		 add(lblMonopoly, gbc_lblNewLabel);
	     		 		 
	     		 		 		 goButton = new JButton("Go!");
	     		 		 		 goButton.setFont(new Font("Dialog", Font.BOLD, 21));
	     		 		 		 goButton.setBackground(new Color(30, 144, 255));
	     		 		 		 GridBagConstraints gbc_goButton = new GridBagConstraints();
	     		 		 		 gbc_goButton.fill = GridBagConstraints.BOTH;
	     		 		 		 gbc_goButton.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_goButton.gridx = 1;
	     		 		 		 gbc_goButton.gridy = 1;
	     		 		 		 add(goButton, gbc_goButton);
	     		 		 		 
	     		 		 		 JLabel lblCreatedBy = new JLabel("Created by: ");
	     		 		 		 GridBagConstraints gbc_lblCreatedBy = new GridBagConstraints();
	     		 		 		 gbc_lblCreatedBy.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_lblCreatedBy.gridx = 1;
	     		 		 		 gbc_lblCreatedBy.gridy = 3;
	     		 		 		 add(lblCreatedBy, gbc_lblCreatedBy);
	     		 		 		 
	     		 		 		 JLabel lblAlexanderHansen = new JLabel("Alexander Hansen");
	     		 		 		 GridBagConstraints gbc_lblAlexanderHansen = new GridBagConstraints();
	     		 		 		 gbc_lblAlexanderHansen.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_lblAlexanderHansen.gridx = 1;
	     		 		 		 gbc_lblAlexanderHansen.gridy = 4;
	     		 		 		 add(lblAlexanderHansen, gbc_lblAlexanderHansen);
	     		 		 		 
	     		 		 		 JLabel lblConnorBrant = new JLabel("Connor Brant");
	     		 		 		 GridBagConstraints gbc_lblConnorBrant = new GridBagConstraints();
	     		 		 		 gbc_lblConnorBrant.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_lblConnorBrant.gridx = 1;
	     		 		 		 gbc_lblConnorBrant.gridy = 5;
	     		 		 		 add(lblConnorBrant, gbc_lblConnorBrant);
	     		 		 		 
	     		 		 		 JLabel lblMarcellusDiederich = new JLabel("Marcellus Diederich");
	     		 		 		 GridBagConstraints gbc_lblMarcellusDiederich = new GridBagConstraints();
	     		 		 		 gbc_lblMarcellusDiederich.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_lblMarcellusDiederich.gridx = 1;
	     		 		 		 gbc_lblMarcellusDiederich.gridy = 6;
	     		 		 		 add(lblMarcellusDiederich, gbc_lblMarcellusDiederich);
	     		 		 		 
	     		 		 		 JLabel lblSamanthaRack = new JLabel("Samantha Rack");
	     		 		 		 GridBagConstraints gbc_lblSamanthaRack = new GridBagConstraints();
	     		 		 		 gbc_lblSamanthaRack.insets = new Insets(0, 0, 5, 5);
	     		 		 		 gbc_lblSamanthaRack.gridx = 1;
	     		 		 		 gbc_lblSamanthaRack.gridy = 7;
	     		 		 		 add(lblSamanthaRack, gbc_lblSamanthaRack);
	     		 		 		 
	     
	        		
	}
}
