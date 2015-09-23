package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPanel extends JPanel {

	public JButton restartButton;
	
	/**
	 * Create the panel.
	 */
	public EndPanel() {
		 setLayout(null);
		 setBounds(100, 100, 650, 725);
		 
		 restartButton = new JButton("Restart");
		 restartButton.setBounds(244, 579, 187, 92);
	     add(restartButton);
		 
		 JLabel background = new JLabel("");
	     Image img = new ImageIcon(this.getClass().getResource("/EndScreenBackground.png")).getImage();
	     background.setIcon(new ImageIcon(img));
	     background.setBounds(12, 12, 626, 701);
	     add(background);

	}

}
