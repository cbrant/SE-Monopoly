package main;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import main.StartPanel;
import main.SetupPanel;
import main.GamePanel;
import main.EndPanel;


public class MainWindow{

	public JFrame frame;
	public JPanel cards;
	final static String STARTPANEL = "Start Screen";
	final static String SETUPPANEL = "Setup Screen";
	final static String GAMEPANEL = "Game Screen";
	final static String ENDPANEL = "End Screen";
	// every game will have 4 players
	final static int NUMPLAYERS = 4;
	public Player[] players;
	public int playersOut;
	public ArrayList<Space> spaces;	
	public int jailSpace;	// index of where jail is
	public static String[] arg;
	
	public MainWindow() {
		spaces = loadSpaces();
		this.players = new Player[NUMPLAYERS];
		for (int i = 0; i < NUMPLAYERS; ++i) {
			this.players[i] = new Player(i+1);
		}
		this.playersOut = 0;
	}

	public void flipCards() {
		CardLayout cl = (CardLayout)(cards.getLayout());

		// if leaving the set up screen, extract player names and pieces selected
		if (cards.getComponents().length > 1) {
			if (cards.getComponents()[1].isVisible()) {
				SetupPanel setupP = ((SetupPanel)(cards.getComponents()[1]));
				for (int i = 0; i < players.length; ++i) {
					players[i].setName(setupP.playerNames[i].getText());
					//players[i].setpType(PlayerType.HUMAN); 
					players[i].setpType((Player.PlayerType)setupP.playerTypes.get(i).getSelectedItem());
					players[i].setPiece((Player.GamePiece)setupP.playerPieces.get(i).getSelectedItem());
				}	
			}

		}

		cl.next(cards);
		if (cards.getComponents().length > 2) {
			if (cards.getComponents()[2].isVisible()) {
				// if the first player is a computer player, then start that player's turn
				if (!players[0].isHuman()) {
					((GamePanel)(cards.getComponents()[2])).compTurnBegin();
				}
			}
		}

		if (cards.getComponents()[3].isVisible()) {
			((EndPanel)cards.getComponents()[3]).setPlacesLabels();
		}
	}
	
	public void restart()
	{
		for(int i = 0; i < 4; i++)
		{
			players[i].setBank(1500);
		}
	}

	public void addComponentToPane(Container pane) {

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flipCards();
			}
		};
		
		ActionListener reset = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				main(arg);

			}
		};

		//Create the "cards".
		StartPanel card1 = new StartPanel(this);
		card1.goButton.addActionListener(l);

		SetupPanel card2 = new SetupPanel(this);
		card2.startButton.addActionListener(l);

		GamePanel card3 = new GamePanel(this);
		card3.btnEndGame.addActionListener(l);

		EndPanel card4 = new EndPanel(this);
		card4.restartButton.addActionListener(reset);

		//Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(card1, STARTPANEL);
		cards.add(card2, SETUPPANEL);
		cards.add(card3, GAMEPANEL);
		cards.add(card4, ENDPANEL);

		pane.add(cards, BorderLayout.CENTER);
	}

	public void createAndShowGUI() {
		//Create and set up the window.
		frame = new JFrame("Monopoly");
		frame.setBounds(100, 100, 900, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addComponentToPane(frame.getContentPane());

		//Display the window.
		frame.setVisible(true);
	}

	/////	users can be on (see GamePanel method movePlayer() for how the properties array is currently being used)
	private ArrayList<Space> loadSpaces()
	{
		ArrayList<Space> spaces = new ArrayList<Space>();
		// use relative path so don't have to update it
		String file = "properties.csv";
		try
		{
			BufferedReader buffer = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(file)));
			String line = buffer.readLine();
			String[] values = null;
			Space s = null;
			while((line = buffer.readLine())  != null)
			{
				values = line.split(",");
				switch(values[1])
				{
				case("NORM"):
				{
					int[] rent = {Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8])};
					s = new Property(values[0], Space.SpaceType.valueOf(values[1]), Integer.parseInt(values[2]), rent, Integer.parseInt(values[9]), Integer.parseInt(values[10]), Property.PropertyCategory.valueOf(values[11]));
					spaces.add(s);
					break;
				}
				case("RR"):
				{
					int[] rent = {Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6])};
					s = new Railroad(values[0], Space.SpaceType.valueOf(values[1]), Integer.parseInt(values[2]), rent,  Integer.parseInt(values[9]), 0, Property.PropertyCategory.valueOf(values[11]));
					spaces.add(s);
					break;
				}
				case("UTIL"):
				{
					int[] rent = {Integer.parseInt(values[3]), Integer.parseInt(values[4])};
					s = new Utility(values[0], Space.SpaceType.valueOf(values[1]), Integer.parseInt(values[2]), rent,  Integer.parseInt(values[9]), 0, Property.PropertyCategory.valueOf(values[11]));
					spaces.add(s);
					break;
				}
				case("ACTION"):
				{
					s = new ActionSpace(values[0], Space.SpaceType.valueOf(values[1]), ActionSpace.ActionType.valueOf(values[11]));
					spaces.add(s);
					if (s.getName().equals("Jail")) {
						jailSpace = spaces.size()-1;
					}
					break;
				}
				default:
				{
					System.out.println("Invalid entry type");
					break;
				}

				}

			}
			buffer.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(spaces.size() != 40)
			System.out.println("Incorrect number of properties in list, there are " + spaces.size());
		return spaces;
	}

	public static void main(String[] args) {
		arg = args;
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Create and set up the content pane.
				MainWindow window = new MainWindow();
				window.createAndShowGUI();
			}
		});
	}
}

