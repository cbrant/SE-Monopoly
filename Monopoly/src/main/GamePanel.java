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

	public JButton rollButton;

	private MainWindow parent;

	/**
	 * Create the panel.
	 */

	public GamePanel(MainWindow par) {
		this.parent = par;
		
		setLayout(null);

		setBounds(100, 100, 650, 725);


		rollButton = new JButton("Roll");
		rollButton.setBounds(254, 221, 158, 108);
		add(rollButton);

		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/GameScreenBackground.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 650, 725);
		add(background);

	}
}
