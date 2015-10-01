package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

public class EndPanel extends JPanel {

	public JButton restartButton;

	private MainWindow parent;

	/**
	 * Create the panel.
	 */
	public EndPanel(MainWindow par) {
		setBackground(new Color(255, 250, 205));
		this.parent = par;
		setBounds(100, 100, 650, 725);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 200, 200, 0};
		gridBagLayout.rowHeights = new int[]{200, 50, 50, 50, 50, 75, 75, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
				
				JLabel lblGameOver = new JLabel("Game Over");
				lblGameOver.setFont(new Font("Dialog", Font.BOLD, 36));
				GridBagConstraints gbc_lblGameOver = new GridBagConstraints();
				gbc_lblGameOver.insets = new Insets(0, 0, 5, 0);
				gbc_lblGameOver.gridx = 0;
				gbc_lblGameOver.gridy = 0;
				gbc_lblGameOver.gridwidth = 3;
				add(lblGameOver, gbc_lblGameOver);
				
				JLabel lblst = new JLabel("1st");
				lblst.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lblst = new GridBagConstraints();
				gbc_lblst.anchor = GridBagConstraints.EAST;
				gbc_lblst.insets = new Insets(0, 0, 5, 5);
				gbc_lblst.gridx = 0;
				gbc_lblst.gridy = 1;
				add(lblst, gbc_lblst);
				
				JLabel lblDummy = new JLabel("Dummy");
				lblDummy.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lblDummy = new GridBagConstraints();
				gbc_lblDummy.insets = new Insets(0, 0, 5, 5);
				gbc_lblDummy.gridx = 1;
				gbc_lblDummy.gridy = 1;
				add(lblDummy, gbc_lblDummy);
				
				JLabel lblnd = new JLabel("2nd");
				lblnd.setFont(new Font("Dialog", Font.BOLD, 20));
				GridBagConstraints gbc_lblnd = new GridBagConstraints();
				gbc_lblnd.anchor = GridBagConstraints.EAST;
				gbc_lblnd.insets = new Insets(0, 0, 5, 5);
				gbc_lblnd.gridx = 0;
				gbc_lblnd.gridy = 2;
				add(lblnd, gbc_lblnd);
				
				JLabel lblDummy_1 = new JLabel("Dummy");
				lblDummy_1.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lblDummy_1 = new GridBagConstraints();
				gbc_lblDummy_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblDummy_1.gridx = 1;
				gbc_lblDummy_1.gridy = 2;
				add(lblDummy_1, gbc_lblDummy_1);
				
				JLabel lblrd = new JLabel("3rd");
				lblrd.setFont(new Font("Dialog", Font.BOLD, 16));
				GridBagConstraints gbc_lblrd = new GridBagConstraints();
				gbc_lblrd.anchor = GridBagConstraints.EAST;
				gbc_lblrd.insets = new Insets(0, 0, 5, 5);
				gbc_lblrd.gridx = 0;
				gbc_lblrd.gridy = 3;
				add(lblrd, gbc_lblrd);
				
				JLabel lblDummy_2 = new JLabel("Dummy");
				lblDummy_2.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lblDummy_2 = new GridBagConstraints();
				gbc_lblDummy_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblDummy_2.gridx = 1;
				gbc_lblDummy_2.gridy = 3;
				add(lblDummy_2, gbc_lblDummy_2);
				
				JLabel lblth = new JLabel("4th");
				GridBagConstraints gbc_lblth = new GridBagConstraints();
				gbc_lblth.anchor = GridBagConstraints.EAST;
				gbc_lblth.insets = new Insets(0, 0, 5, 5);
				gbc_lblth.gridx = 0;
				gbc_lblth.gridy = 4;
				add(lblth, gbc_lblth);
				
				JLabel lblDummy_3 = new JLabel("Dummy");
				lblDummy_3.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lblDummy_3 = new GridBagConstraints();
				gbc_lblDummy_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblDummy_3.gridx = 1;
				gbc_lblDummy_3.gridy = 4;
				add(lblDummy_3, gbc_lblDummy_3);
		
				restartButton = new JButton("Restart");
				restartButton.setBackground(new Color(30, 144, 255));
				restartButton.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_restartButton = new GridBagConstraints();
				gbc_restartButton.insets = new Insets(0, 0, 5, 5);
				gbc_restartButton.fill = GridBagConstraints.BOTH;
				gbc_restartButton.gridx = 1;
				gbc_restartButton.gridy = 6;
				add(restartButton, gbc_restartButton);


	}

}
