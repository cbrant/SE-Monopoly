package main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Player.PlayerType;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class SetupPanel extends JPanel {

	public JButton startButton;

	public JTextField[] playerNames;
	public ArrayList<JComboBox<PlayerType> > playerTypes;
	public ArrayList<JComboBox<Player.GamePiece>> playerPieces;

	private Random ranGen;

	/**
	 * Create the panel.
	 */
	public SetupPanel(MainWindow par) {
		this.ranGen = new Random(System.currentTimeMillis());

		this.setBackground(new Color(255, 250, 205));

		playerNames = new JTextField[MainWindow.NUMPLAYERS];
		playerTypes = new ArrayList<JComboBox<Player.PlayerType>>(MainWindow.NUMPLAYERS);
		playerPieces = new ArrayList<JComboBox<Player.GamePiece>>(MainWindow.NUMPLAYERS);

		//Contents for Combo boxes
		Player.PlayerType[] pTypes = Player.PlayerType.values();	//use later when want computer players
		//Player.PlayerType[] pTypes = new Player.PlayerType[1];
		//pTypes[0] = Player.PlayerType.HUMAN;
		Player.GamePiece[] pieces = Player.GamePiece.values();

		//Setup gridbag layout
		setBounds(100, 100, 900, 725);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 75, 50, 50, 50, 75, 75, 0};
		gridBagLayout.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		//Setup all components on page

		JLabel setupLabel = new JLabel("Game Setup");
		setupLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		GridBagConstraints gbc_setupLabel = new GridBagConstraints();
		gbc_setupLabel.insets = new Insets(0, 0, 5, 5);
		gbc_setupLabel.gridx = 2;
		gbc_setupLabel.gridy = 1;
		gbc_setupLabel.gridwidth = 3;
		add(setupLabel, gbc_setupLabel);

		playerNames[0] = new JTextField("Player 1");
		GridBagConstraints gbc_Player1NameText = new GridBagConstraints();
		gbc_Player1NameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_Player1NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player1NameText.gridx = 1;
		gbc_Player1NameText.gridy = 3;
		add(playerNames[0], gbc_Player1NameText);
		playerNames[0].setColumns(10);

		playerTypes.add(new JComboBox<Player.PlayerType>(pTypes));
		GridBagConstraints gbc_Player1TypeComboBox = new GridBagConstraints();
		gbc_Player1TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player1TypeComboBox.gridx = 3;
		gbc_Player1TypeComboBox.gridy = 3;
		add(playerTypes.get(0), gbc_Player1TypeComboBox);

		playerPieces.add(new JComboBox<Player.GamePiece>(pieces));
		playerPieces.get(0).setSelectedIndex(0);
		playerPieces.get(0).addActionListener(pieceChanged);
		GridBagConstraints gbc_Player1PieceComboBox = new GridBagConstraints();
		gbc_Player1PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player1PieceComboBox.gridx = 5;
		gbc_Player1PieceComboBox.gridy = 3;
		add(playerPieces.get(0), gbc_Player1PieceComboBox);

		playerNames[1] = new JTextField("Player 2");
		playerNames[1].setColumns(10);
		GridBagConstraints gbc_Player2NameText = new GridBagConstraints();
		gbc_Player2NameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_Player2NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player2NameText.gridx = 1;
		gbc_Player2NameText.gridy = 5;
		add(playerNames[1], gbc_Player2NameText);

		playerTypes.add(new JComboBox<Player.PlayerType>(pTypes));
		GridBagConstraints gbc_Player2TypeComboBox = new GridBagConstraints();
		gbc_Player2TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player2TypeComboBox.gridx = 3;
		gbc_Player2TypeComboBox.gridy = 5;
		add(playerTypes.get(1), gbc_Player2TypeComboBox);

		playerPieces.add(new JComboBox<Player.GamePiece>(pieces));
		playerPieces.get(1).setSelectedIndex(1);
		playerPieces.get(1).addActionListener(pieceChanged);
		GridBagConstraints gbc_Player2PieceComboBox = new GridBagConstraints();
		gbc_Player2PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player2PieceComboBox.gridx = 5;
		gbc_Player2PieceComboBox.gridy = 5;
		add(playerPieces.get(1), gbc_Player2PieceComboBox);

		playerNames[2] = new JTextField("Player 3");
		playerNames[2].setColumns(10);
		GridBagConstraints gbc_Player3NameText = new GridBagConstraints();
		gbc_Player3NameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_Player3NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player3NameText.gridx = 1;
		gbc_Player3NameText.gridy = 7;
		add(playerNames[2], gbc_Player3NameText);

		playerTypes.add(new JComboBox<Player.PlayerType>(pTypes));
		GridBagConstraints gbc_Player3TypeComboBox = new GridBagConstraints();
		gbc_Player3TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player3TypeComboBox.gridx = 3;
		gbc_Player3TypeComboBox.gridy = 7;
		add(playerTypes.get(2), gbc_Player3TypeComboBox);

		playerPieces.add(new JComboBox<Player.GamePiece>(pieces));
		playerPieces.get(2).setSelectedIndex(2);
		playerPieces.get(2).addActionListener(pieceChanged);
		GridBagConstraints gbc_Player3PieceComboBox = new GridBagConstraints();
		gbc_Player3PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player3PieceComboBox.gridx = 5;
		gbc_Player3PieceComboBox.gridy = 7;
		add(playerPieces.get(2), gbc_Player3PieceComboBox);

		playerNames[3] = new JTextField("Player 4");
		playerNames[3].setColumns(10);
		GridBagConstraints gbc_Player4NameText = new GridBagConstraints();
		gbc_Player4NameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_Player4NameText.insets = new Insets(0, 0, 5, 5);
		gbc_Player4NameText.gridx = 1;
		gbc_Player4NameText.gridy = 9;
		add(playerNames[3], gbc_Player4NameText);

		playerTypes.add(new JComboBox<Player.PlayerType>(pTypes));
		GridBagConstraints gbc_Player4TypeComboBox = new GridBagConstraints();
		gbc_Player4TypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player4TypeComboBox.gridx = 3;
		gbc_Player4TypeComboBox.gridy = 9;
		add(playerTypes.get(3), gbc_Player4TypeComboBox);

		playerPieces.add(new JComboBox<Player.GamePiece>(pieces));
		playerPieces.get(3).setSelectedIndex(3);
		playerPieces.get(3).addActionListener(pieceChanged);
		GridBagConstraints gbc_Player4PieceComboBox = new GridBagConstraints();
		gbc_Player4PieceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_Player4PieceComboBox.gridx = 5;
		gbc_Player4PieceComboBox.gridy = 9;
		add(playerPieces.get(3), gbc_Player4PieceComboBox);

		startButton = new JButton("Start!");
		startButton.setFont(new Font("Dialog", Font.BOLD, 24));
		startButton.setBackground(new Color(30, 144, 255));

		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 3;
		gbc_btnStart.gridy = 11;
		add(startButton, gbc_btnStart);

	}

	private ActionListener pieceChanged = new ActionListener() {
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e){
			// set up arrays for keeping track of what pieces are being used
			Player.GamePiece[] pieces = Player.GamePiece.values(); 
			boolean[] avail = new boolean[pieces.length];
			for (int i = 0; i < avail.length; ++i) avail[i] = true;

			JComboBox<Player.GamePiece> changedBox = (JComboBox<Player.GamePiece>)e.getSource();
			avail[getEnumIndex(pieces, (Player.GamePiece)changedBox.getSelectedItem())] = false;
			for (int i = 0; i < playerPieces.size(); ++i) {
				// if it is the same element, then skip it
				if (changedBox != playerPieces.get(i)) {
					avail[getEnumIndex(pieces, (Player.GamePiece)playerPieces.get(i).getSelectedItem())] = false;
					// find a match for new selection? change original to available random piece
					if (changedBox.getSelectedItem() == playerPieces.get(i).getSelectedItem()) {
						// check for any other already selected pieces
						for (int j = i + 1; j < playerPieces.size(); ++j) {
							avail[getEnumIndex(pieces, (Player.GamePiece)playerPieces.get(j).getSelectedItem())] = false;			
						}
						ArrayList<Player.GamePiece> availOptions = new ArrayList<Player.GamePiece>();
						for (int j = 0; j < pieces.length; ++j) {
							if (avail[j]) availOptions.add(pieces[j]);
						}

						playerPieces.get(i).setSelectedItem(availOptions.get(ranGen.nextInt(availOptions.size())));
					}
				}
			}
		}

		private int getEnumIndex(Player.GamePiece[] valArray, Player.GamePiece val) {
			for (int i = 0; i < valArray.length; ++i) {
				if (valArray[i] == val) return i;
			}
			return -1;
		}
	};

	
}

