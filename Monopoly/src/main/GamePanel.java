package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GamePanel extends JPanel {

	public JButton rollButton;
	
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		setLayout(null);
		setBounds(100, 100, 650, 725);
		
		JLabel background = new JLabel("");
	     Image img = new ImageIcon(this.getClass().getResource("/GameScreenBackground.png")).getImage();
	     background.setIcon(new ImageIcon(img));
	     background.setBounds(12, 12, 626, 701);
	     add(background);
	     
	     rollButton = new JButton("Roll");
	     rollButton.setBounds(254, 221, 158, 108);
	     add(rollButton);
	}
}
