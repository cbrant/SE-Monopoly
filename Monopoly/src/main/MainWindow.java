package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainWindow {

	static JFrame frame;
	static JPanel cards;
	final static String STARTPANEL = "Start Screen";
	final static String SETUPPANEL = "Setup Screen";
	
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
        JPanel card1 = new JPanel();
        JButton goButton = new JButton("Go!");
        goButton.addActionListener(l);
        card1.add(goButton);
        
        
        JPanel card2 = new JPanel();
        JButton startButton = new JButton("Start!");
        startButton.addActionListener(l);
        card2.add(startButton);
        
        
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, STARTPANEL);
        cards.add(card2, SETUPPANEL);
        
        pane.add(cards, BorderLayout.CENTER);
    }
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("MainWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 251, 257);
        
        //Create and set up the content pane.
        MainWindow window = new MainWindow();
        window.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
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

	