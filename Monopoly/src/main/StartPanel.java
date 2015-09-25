package main;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StartPanel extends JPanel {

	public JButton goButton;
	
	private MainWindow parent;
	
	/**
	 * Create the panel.
	 */
	public StartPanel(MainWindow par) {
		this.parent = par;	//used to access parent later to advance to the next card
		
		setLayout(null);
		setBounds(100, 100, 650, 725);

		goButton = new JButton("Go!");
		goButton.setBounds(232, 318, 184, 88);
	    add(goButton);
	    
	    JLabel background = new JLabel("");
	    Image img = new ImageIcon(this.getClass().getResource("/StartScreenBackground.png")).getImage();
	    background.setIcon(new ImageIcon(img));
	    background.setBounds(0, 0, 650, 725);
	    add(background);
	        		
	}
}
