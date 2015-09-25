package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import main.StartPanel;
import main.SetupPanel;
import main.GamePanel;
import main.EndPanel;

public class MainWindow{

	static JFrame frame;
	static JPanel cards;
	final static String STARTPANEL = "Start Screen";
	final static String SETUPPANEL = "Setup Screen";
	final static String GAMEPANEL = "Game Screen";
	final static String ENDPANEL = "End Screen";
	// every game will have 4 players
	final static int NUMPLAYERS = 4;
	
	public Player[] players;
	
	public MainWindow() {
		this.players = new Player[NUMPLAYERS];
		for (int i = 0; i < NUMPLAYERS; ++i) {
			this.players[i] = new Player(i+1);
		}
	}
	
	public void addComponentToPane(Container pane) {

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.next(cards);

			}
		};

		//Create the "cards".
		StartPanel card1 = new StartPanel(this);
		card1.goButton.addActionListener(l);

		SetupPanel card2 = new SetupPanel(this);
		card2.startButton.addActionListener(l);

		GamePanel card3 = new GamePanel(this);
		card3.rollButton.addActionListener(l);

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

	private static void createAndShowGUI() {
		//Create and set up the window.
		frame = new JFrame("MainWindow");
		frame.setBounds(100, 100, 650, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		MainWindow window = new MainWindow();
		window.addComponentToPane(frame.getContentPane());

		//Display the window.
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

