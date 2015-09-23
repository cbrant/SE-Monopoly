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

		 goButton = new JButton("Go!");
		 goButton.setBounds(195, 219, 58, 25);
	     add(goButton);
	        		
	}

}
