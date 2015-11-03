package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TradeView extends JFrame {

	private JPanel contentPane;
	private JTextField firstPlayerCash;
	private JTextField secondPlayerCash;
	private JComboBox<Player> firstPlayerBox, secondPlayerBox;
	private JComboBox<Property> firstPlayerProp, secondPlayerProp;
	private GamePanel parent;
	private TradeView myself;
	Player firstSelected;
	Player secondSelected;
	Property None = new Property("NONE");
	/**
	 * Create the frame.
	 */
	public TradeView( GamePanel par ) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.myself = this;
		this.parent = par;
		
		getContentPane().setBackground(new Color(255, 250, 205));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 0, 0, 0, 0, 20};
		gbl_contentPane.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMakeATrade = new JLabel("Make a Trade!");
		GridBagConstraints gbc_lblMakeATrade = new GridBagConstraints();
		gbc_lblMakeATrade.insets = new Insets(0, 0, 5, 5);
		gbc_lblMakeATrade.gridx = 2;
		gbc_lblMakeATrade.gridy = 0;
		contentPane.add(lblMakeATrade, gbc_lblMakeATrade);
		
		firstPlayerBox = new JComboBox<Player>();
		firstPlayerBox.addItem(this.parent.getMyParent().players[this.parent.currPlayer]);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPane.add(firstPlayerBox, gbc_comboBox);
		firstPlayerBox.addActionListener(playerSwitched);
		
		secondPlayerBox = new JComboBox<Player>(this.parent.getMyParent().players);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 1;
		contentPane.add(secondPlayerBox, gbc_comboBox_2);
		secondPlayerBox.addActionListener(playerSwitched);
		
		firstPlayerProp = new JComboBox<Property>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		contentPane.add(firstPlayerProp, gbc_comboBox_1);
		
		secondPlayerProp = new JComboBox<Property>();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 3;
		gbc_comboBox_3.gridy = 3;
		contentPane.add(secondPlayerProp, gbc_comboBox_3);
		
		firstPlayerCash = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		contentPane.add(firstPlayerCash, gbc_textField);
		firstPlayerCash.setColumns(10);
		firstPlayerCash.setText("0");
		firstPlayerCash.setToolTipText("Cash to trade (Optional)");
		
		secondPlayerCash = new JTextField();
		secondPlayerCash.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		contentPane.add(secondPlayerCash, gbc_textField_1);
		secondPlayerCash.setText("0");
		secondPlayerCash.setToolTipText("Cash to trade (Optional)");
		
		JButton confirmButton = new JButton("Confirm");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		contentPane.add(confirmButton, gbc_btnNewButton);
		this.setBackground(new Color(255, 250, 205));
		confirmButton.addActionListener(tradeConfirmed);

		populatePropBox();
		
	}
	
	
	private void populatePropBox()
	{
		
		firstPlayerProp.removeAllItems();
		secondPlayerProp.removeAllItems();
		
		firstSelected = (Player)(this.firstPlayerBox.getSelectedItem());
		secondSelected = (Player)(this.secondPlayerBox.getSelectedItem());
		
		firstPlayerProp.addItem(None);
		secondPlayerProp.addItem(None);
		for( ArrayList<Property> category : firstSelected.getProperties() )
		{
			for( Property x : category)
			{
				this.firstPlayerProp.addItem(x);
				
			}
		}
		for( ArrayList<Property> category : secondSelected.getProperties() )
		{
			for( Property x : category)
			{
				this.secondPlayerProp.addItem(x);
				
			}
		}
	}
	
	private ActionListener playerSwitched = new ActionListener() {   

		@Override
		public void actionPerformed(ActionEvent e) {   

			populatePropBox();
		
		}
	};
	
	private ActionListener tradeConfirmed = new ActionListener() {   
		@Override
		public void actionPerformed(ActionEvent e) {   
			if(!checkPlayers()){
				JOptionPane.showMessageDialog(null, "Error: Trading between same player.", 
						"Trade Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int val1;
			int val2;
			try {
				val1 = Integer.parseInt(firstPlayerCash.getText());
			}
			catch(NumberFormatException nfe) 
			{
				JOptionPane.showMessageDialog(null, "Error: Invalid left cash entry.", 
						"Trade Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				val2 = Integer.parseInt(secondPlayerCash.getText());
			}
			catch(NumberFormatException nfe) 
			{
				JOptionPane.showMessageDialog(null, "Error: Invalid right cash entry.", 
						"Trade Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!firstPlayerProp.getSelectedItem().equals(None)) {
				if(((Property)firstPlayerProp.getSelectedItem()).getNumHouses() != 0)
				{
					JOptionPane.showMessageDialog(null, "Error: Property 1 has houses present.", 
							"Trade Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((Property) firstPlayerProp.getSelectedItem()).setOwner(secondSelected.getId());
				System.out.println("Setting "+((Property) firstPlayerProp.getSelectedItem()).getName()+" owner to player "+secondSelected.getId());
				secondSelected.addProperty((Property) firstPlayerProp.getSelectedItem());
				firstSelected.removeProperty(((Property) firstPlayerProp.getSelectedItem()).getName());
					
				
				
			}
			if(!secondPlayerProp.getSelectedItem().equals(None)) {
				if(((Property)secondPlayerProp.getSelectedItem()).getNumHouses() != 0)
				{
					JOptionPane.showMessageDialog(null, "Error: Property 2 has houses present.", 
							"Trade Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((Property) secondPlayerProp.getSelectedItem()).setOwner(firstSelected.getId());
				System.out.println("Setting "+((Property) secondPlayerProp.getSelectedItem()).getName()+" owner to player "+firstSelected.getId());
				firstSelected.addProperty((Property) secondPlayerProp.getSelectedItem());
				secondSelected.removeProperty(((Property) secondPlayerProp.getSelectedItem()).getName());
			}
			
			
			if(val1 != 0){
				firstSelected.deductFromBank(val1, parent.getParentFrame().playersOut);
				secondSelected.addToBank(val1);
			}
			if(val2 != 0){
				secondSelected.deductFromBank(val2, parent.getParentFrame().playersOut);
				firstSelected.addToBank(val2);
			}
			//Closes the window
			myself.dispose();
		
		}
	};
	
	boolean checkPlayers() {
		firstSelected = (Player)(this.firstPlayerBox.getSelectedItem());
		secondSelected = (Player)(this.secondPlayerBox.getSelectedItem());
		if(firstSelected == secondSelected) { 
			return false;
		}
		return true;
	}

	

}
