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
		setBounds(100, 100, 900, 725);
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
				
				JLabel lbl1Place = new JLabel("Dummy");
				lbl1Place.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lbl1Place = new GridBagConstraints();
				gbc_lbl1Place.insets = new Insets(0, 0, 5, 5);
				gbc_lbl1Place.gridx = 1;
				gbc_lbl1Place.gridy = 1;
				add(lbl1Place, gbc_lbl1Place);
				
				JLabel lblnd = new JLabel("2nd");
				lblnd.setFont(new Font("Dialog", Font.BOLD, 20));
				GridBagConstraints gbc_lblnd = new GridBagConstraints();
				gbc_lblnd.anchor = GridBagConstraints.EAST;
				gbc_lblnd.insets = new Insets(0, 0, 5, 5);
				gbc_lblnd.gridx = 0;
				gbc_lblnd.gridy = 2;
				add(lblnd, gbc_lblnd);
				
				JLabel lbl2Place = new JLabel("Dummy");
				lbl2Place.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lbl2Place = new GridBagConstraints();
				gbc_lbl2Place.insets = new Insets(0, 0, 5, 5);
				gbc_lbl2Place.gridx = 1;
				gbc_lbl2Place.gridy = 2;
				add(lbl2Place, gbc_lbl2Place);
				
				JLabel lblrd = new JLabel("3rd");
				lblrd.setFont(new Font("Dialog", Font.BOLD, 16));
				GridBagConstraints gbc_lblrd = new GridBagConstraints();
				gbc_lblrd.anchor = GridBagConstraints.EAST;
				gbc_lblrd.insets = new Insets(0, 0, 5, 5);
				gbc_lblrd.gridx = 0;
				gbc_lblrd.gridy = 3;
				add(lblrd, gbc_lblrd);
				
				JLabel lbl3Place = new JLabel("Dummy");
				lbl3Place.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lbl3Place = new GridBagConstraints();
				gbc_lbl3Place.insets = new Insets(0, 0, 5, 5);
				gbc_lbl3Place.gridx = 1;
				gbc_lbl3Place.gridy = 3;
				add(lbl3Place, gbc_lbl3Place);
				
				JLabel lblth = new JLabel("4th");
				GridBagConstraints gbc_lblth = new GridBagConstraints();
				gbc_lblth.anchor = GridBagConstraints.EAST;
				gbc_lblth.insets = new Insets(0, 0, 5, 5);
				gbc_lblth.gridx = 0;
				gbc_lblth.gridy = 4;
				add(lblth, gbc_lblth);
				
				JLabel lbl4Place = new JLabel("Dummy");
				lbl4Place.setFont(new Font("Dialog", Font.BOLD, 24));
				GridBagConstraints gbc_lbl4Place = new GridBagConstraints();
				gbc_lbl4Place.insets = new Insets(0, 0, 5, 5);
				gbc_lbl4Place.gridx = 1;
				gbc_lbl4Place.gridy = 4;
				add(lbl4Place, gbc_lbl4Place);
		
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
