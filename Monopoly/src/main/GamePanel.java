package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JSeparator;

public class GamePanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		setBounds(100, 100, 650, 725);
		setLayout(new MigLayout("", "[50.00]", "[525.00][]"));
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1");
	     Image img = new ImageIcon(this.getClass().getResource("/GameScreenBackground.png")).getImage();
	     
	     
	}
}
