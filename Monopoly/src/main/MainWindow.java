package main;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

import javax.swing.*;

import main.Player.PlayerType;
import main.StartPanel;
import main.Property.PropertyCategory;
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
	public ArrayList<Property> properties;
	
	
	public MainWindow() {
		properties = loadProperties();
		this.players = new Player[NUMPLAYERS];
		for (int i = 0; i < NUMPLAYERS; ++i) {
			this.players[i] = new Player(i+1);
		}
	}
	
	public void addComponentToPane(Container pane) {

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				
				// if leaving the set up screen, extract player names and pieces selected
				if (cards.getComponents().length > 1) {
					if (cards.getComponents()[1].isVisible()) {
						SetupPanel setupP = ((SetupPanel)(cards.getComponents()[1]));
						for (int i = 0; i < players.length; ++i) {
							players[i].setName(setupP.playerNames[i].getText());
							// hardcoded for now, but eventually will copy over from setup screen
							players[i].setpType(PlayerType.HUMAN); //players[i].setpType((Player.PlayerType)setupP.playerTypes.get(i).getSelectedItem());
							players[i].setPiece((Player.GamePiece)setupP.playerPieces.get(i).getSelectedItem());
						}
					}
					
				}
				
				cl.next(cards);
				// if moving to the main game screen, execute a turn notification for the first player
				if (cards.getComponents()[2].isVisible()) {
					((GamePanel)(cards.getComponents()[2])).newTurnNotification();
				}
			}
		};
		
        //Create the "cards".
        StartPanel card1 = new StartPanel(this);
        card1.goButton.addActionListener(l);
        
        SetupPanel card2 = new SetupPanel(this);
        card2.startButton.addActionListener(l);
        
        GamePanel card3 = new GamePanel(this);
        //card3.rollButton.addActionListener(l);
        
        EndPanel card4 = new EndPanel(this);
        card4.restartButton.addActionListener(l);
       
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, STARTPANEL);
        cards.add(card2, SETUPPANEL);
        cards.add(card3, GAMEPANEL);
        cards.add(card4, ENDPANEL);
        
        pane.add(cards, BorderLayout.CENTER);
    }
	

	private void createAndShowGUI() {
		//Create and set up the window.
		frame = new JFrame("MainWindow");
		frame.setBounds(100, 100, 650, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addComponentToPane(frame.getContentPane());

		//Display the window.
		frame.setVisible(true);
	}
	
	
	///// TODO: maybe change this to loadSpaces, and the properties array will change to include all spaces 
	/////	users can be on (see GamePanel method movePlayer() for how the properties array is currently being used)
	private static ArrayList<Property> loadProperties()
	{
		ArrayList<Property> properties = new ArrayList<Property>();
		// use relative path so don't have to update it
		String file = "src/main/properties.csv";
		try
		{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = buffer.readLine();
			String[] values = null;
			Property p = null;
			while((line = buffer.readLine())  != null)
			{
				values = line.split(",");
				for(int i = 0; i < 12; i++)
					values[i] = values[i].trim();
				switch(values[1])
				{
					case("NORM"):
					{
						int[] rent = {Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8])};
						p = new Property(values[0], Property.PropertyType.valueOf(values[1]), Integer.parseInt(values[9]),rent, Integer.parseInt(values[10]), Property.PropertyCategory.valueOf(values[11]));
						System.out.println(p);
						if(p.getType() == Property.PropertyType.valueOf("NORM"))
							properties.add(p);
						break;
					}
					case("RR"):
					{
						break;
					}
					case("UTIL"):
					{
						break;
					}
					case("ACTION"):
					{
						break;
					}
					default:
					{
						
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
		if(properties.size() != 10)
			System.out.println("Incorrect number of properties in list, there are " + properties.size());
		return properties;
	}
	

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Create and set up the content pane.
				MainWindow window = new MainWindow();
				window.createAndShowGUI();
			}
		});
	}
}

