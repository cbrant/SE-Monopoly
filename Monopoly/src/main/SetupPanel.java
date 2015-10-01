package main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class SetupPanel extends JPanel {

	private MainWindow parent;


	private JPanel[] panelHolder;

	private JLabel title; 

	private JPanel[] playerPanels;

	private JTextField[] playerNames;
	private JComboBox<String>[] playerPieces;
	private JComboBox<String>[] playerTypes;

	public JButton startButton;

	/**
	 * Create the panel.
	 */
	public SetupPanel(MainWindow par) {
		
		this.parent = par;	//used to access outer window and data members (ie. players, etc)
		
		setBackground(new Color(255, 250, 205));
		setBounds(100, 100, 650, 725);

		// set up the panel with an outer grid layout with 6 rows
		setLayout(new GridLayout(6, 1));
		panelHolder = new JPanel[6];
		for (int i = 0; i < 6; ++i) {
			panelHolder[i] = new JPanel();
			add(panelHolder[i]);
		}

		// title goes on the top grid space
		title = new JLabel("Game Setup");
		title.setFont(title.getFont().deriveFont(50.0f));
		panelHolder[0].add(title);

		playerNames = new JTextField[MainWindow.NUMPLAYERS];
		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
			playerNames[i] = new JTextField(this.parent.players[i].getpName());
		}

		String[] pTypes = {"Human", "Computer"};
		playerTypes = new JComboBox[MainWindow.NUMPLAYERS];
		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
			playerTypes[i] = new JComboBox<String>(pTypes);
		}

		String[] pieces = { "Car", "Dog", "Shoe", "Hat" };
		playerPieces = new JComboBox[MainWindow.NUMPLAYERS];
		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
			playerPieces[i] = new JComboBox<String>(pieces);
			playerPieces[i].setSelectedItem(pieces[i]);
		}

		// each of the middle rows is split into three columns for player information gathering
		playerPanels = new JPanel[MainWindow.NUMPLAYERS];
		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
			panelHolder[i+1].setLayout(new GridLayout(1, 3));
			playerPanels[i] = new JPanel();
			panelHolder[i+1].add(playerPanels[i]);
			playerPanels[i].add(playerNames[i]);
			playerPanels[i].add(playerTypes[i]);
			playerPanels[i].add(playerPieces[i]);
		}

		// start game button goes at the bottom of the setup screen
		startButton = new JButton("Start Game!");
		panelHolder[5].add(startButton);

	}

}
