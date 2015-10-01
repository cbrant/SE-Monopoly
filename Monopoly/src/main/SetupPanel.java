package main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SetupPanel extends JPanel {

	private MainWindow parent;


	private JPanel[] panelHolder;

	private JLabel title; 

	private JPanel[] playerPanels;

	private JTextField[] playerNames;
	private JComboBox<String>[] playerPieces;
	private JComboBox<String>[] playerTypes;

	public JButton startButton;
	private JTextField Player1NameText;
	private JTextField Player2NameText;
	private JTextField Player3NameText;
	private JTextField textField_3;
	private JComboBox Player2TypeComboBox;
	private JComboBox Player3TypeComboBox;
	private JComboBox comboBox_3;
	private JComboBox Player1PieceComboBox;
	private JComboBox Player2PieceComboBox;
	private JComboBox Player3PieceComboBox;
	private JComboBox comboBox_7;
	private JButton btnStart;

	/**
	 * Create the panel.
	 */
	public SetupPanel(MainWindow par) {
		setBackground(new Color(255, 250, 205));
		
		this.parent = par;	//used to access outer window and data members (ie. players, etc)
		
		setBounds(100, 100, 650, 725);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 149, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		Player1NameText = new JTextField();
		GridBagConstraints gbc_Player1NameText = new GridBagConstraints();
		gbc_Player1NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player1NameText.gridx = 1;
		gbc_Player1NameText.gridy = 3;
		add(Player1NameText, gbc_Player1NameText);
		Player1NameText.setColumns(10);
		
		JComboBox Player1TypeComboBox = new JComboBox();
		GridBagConstraints gbc_Player1TypeComboBox = new GridBagConstraints();
		gbc_Player1TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player1TypeComboBox.gridx = 3;
		gbc_Player1TypeComboBox.gridy = 3;
		add(Player1TypeComboBox, gbc_Player1TypeComboBox);
		
		Player1PieceComboBox = new JComboBox();
		GridBagConstraints gbc_Player1PieceComboBox = new GridBagConstraints();
		gbc_Player1PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player1PieceComboBox.gridx = 5;
		gbc_Player1PieceComboBox.gridy = 3;
		add(Player1PieceComboBox, gbc_Player1PieceComboBox);
		
		Player2NameText = new JTextField();
		Player2NameText.setColumns(10);
		GridBagConstraints gbc_Player2NameText = new GridBagConstraints();
		gbc_Player2NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player2NameText.gridx = 1;
		gbc_Player2NameText.gridy = 5;
		add(Player2NameText, gbc_Player2NameText);
		
		Player2TypeComboBox = new JComboBox();
		GridBagConstraints gbc_Player2TypeComboBox = new GridBagConstraints();
		gbc_Player2TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player2TypeComboBox.gridx = 3;
		gbc_Player2TypeComboBox.gridy = 5;
		add(Player2TypeComboBox, gbc_Player2TypeComboBox);
		
		Player2PieceComboBox = new JComboBox();
		GridBagConstraints gbc_Player2PieceComboBox = new GridBagConstraints();
		gbc_Player2PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player2PieceComboBox.gridx = 5;
		gbc_Player2PieceComboBox.gridy = 5;
		add(Player2PieceComboBox, gbc_Player2PieceComboBox);
		
		Player3NameText = new JTextField();
		Player3NameText.setColumns(10);
		GridBagConstraints gbc_Player3NameText = new GridBagConstraints();
		gbc_Player3NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player3NameText.gridx = 1;
		gbc_Player3NameText.gridy = 7;
		add(Player3NameText, gbc_Player3NameText);
		
		Player3TypeComboBox = new JComboBox();
		GridBagConstraints gbc_Player3TypeComboBox = new GridBagConstraints();
		gbc_Player3TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player3TypeComboBox.gridx = 3;
		gbc_Player3TypeComboBox.gridy = 7;
		add(Player3TypeComboBox, gbc_Player3TypeComboBox);
		
		Player3PieceComboBox = new JComboBox();
		GridBagConstraints gbc_Player3PieceComboBox = new GridBagConstraints();
		gbc_Player3PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player3PieceComboBox.gridx = 5;
		gbc_Player3PieceComboBox.gridy = 7;
		add(Player3PieceComboBox, gbc_Player3PieceComboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 9;
		add(textField_3, gbc_textField_3);
		
		comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 3;
		gbc_comboBox_3.gridy = 9;
		add(comboBox_3, gbc_comboBox_3);
		
		comboBox_7 = new JComboBox();
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_7.gridx = 5;
		gbc_comboBox_7.gridy = 9;
		add(comboBox_7, gbc_comboBox_7);
		
		startButton = new JButton("Start!");
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.gridx = 3;
		gbc_btnStart.gridy = 13;
		add(startButton, gbc_btnStart);
		
		
//		setBackground(new Color(255, 250, 205));

//
//		// set up the panel with an outer grid layout with 6 rows
//		setLayout(new GridLayout(6, 1));
//		panelHolder = new JPanel[6];
//		for (int i = 0; i < 6; ++i) {
//			panelHolder[i] = new JPanel();
//			add(panelHolder[i]);
//		}
//
//		// title goes on the top grid space
//		title = new JLabel("Game Setup");
//		title.setFont(title.getFont().deriveFont(50.0f));
//		panelHolder[0].add(title);
//
//		playerNames = new JTextField[MainWindow.NUMPLAYERS];
//		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
//			playerNames[i] = new JTextField(this.parent.players[i].getpName());
//		}
//
//		String[] pTypes = {"Human", "Computer"};
//		playerTypes = new JComboBox[MainWindow.NUMPLAYERS];
//		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
//			playerTypes[i] = new JComboBox<String>(pTypes);
//		}
//
//		String[] pieces = { "Car", "Dog", "Shoe", "Hat" };
//		playerPieces = new JComboBox[MainWindow.NUMPLAYERS];
//		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
//			playerPieces[i] = new JComboBox<String>(pieces);
//			playerPieces[i].setSelectedItem(pieces[i]);
//		}
//
//		// each of the middle rows is split into three columns for player information gathering
//		playerPanels = new JPanel[MainWindow.NUMPLAYERS];
//		for (int i = 0; i < MainWindow.NUMPLAYERS; ++i) {
//			panelHolder[i+1].setLayout(new GridLayout(1, 3));
//			playerPanels[i] = new JPanel();
//			panelHolder[i+1].add(playerPanels[i]);
//			playerPanels[i].add(playerNames[i]);
//			playerPanels[i].add(playerTypes[i]);
//			playerPanels[i].add(playerPieces[i]);
//		}
//
//		// start game button goes at the bottom of the setup screen
//		startButton = new JButton("Start Game!");
//		panelHolder[5].add(startButton);

	}

}
