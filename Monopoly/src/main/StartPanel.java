package main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class StartPanel extends JPanel {

	public JButton goButton;
	
	/**
	 * Create the panel.
	 */
	public StartPanel() {
		 setLayout(null);
		 setBounds(100, 100, 650, 725);

		 goButton = new JButton("Go!");
		 goButton.setBounds(266, 587, 110, 59);
	     add(goButton);
	        		
	}

}
