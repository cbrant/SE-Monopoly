package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class CardView extends JFrame {
	
	private JLabel title, rentVal, house1Val, house2Val, house3Val, house4Val, hotelVal, houseCostVal, hotelCostVal, railRoad2Val, railRoad3Val, railRoad4Val, cardDescription, mortgageVal;
	
	private ArrayList<JLabel> normalLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> railRoadLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> utilityLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> specialLabels = new ArrayList<JLabel>();
	

	/**
	 * Create the panel.
	 */
	public CardView( Space currentSpace ) {
		getContentPane().setBackground(new Color(255, 250, 205));

		this.setBackground(new Color(255, 250, 205));

		setBounds(100, 100, 450, 600);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0, 20};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		title = new JLabel("New label");
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.fill = GridBagConstraints.VERTICAL;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		gbc_title.gridwidth = 4;
		gbc_title.gridheight = 2;
		getContentPane().add(title, gbc_title);

		JLabel lblRent = new JLabel("Rent:");
		GridBagConstraints gbc_lblRent = new GridBagConstraints();
		gbc_lblRent.fill = GridBagConstraints.VERTICAL;
		gbc_lblRent.insets = new Insets(0, 0, 5, 5);
		gbc_lblRent.gridx = 1;
		gbc_lblRent.gridy = 3;
		getContentPane().add(lblRent, gbc_lblRent);
		this.normalLabels.add(lblRent);
		this.railRoadLabels.add(lblRent);
		
		rentVal = new JLabel("0");
		GridBagConstraints gbc_rentVal = new GridBagConstraints();
		gbc_rentVal.fill = GridBagConstraints.VERTICAL;
		gbc_rentVal.insets = new Insets(0, 0, 5, 5);
		gbc_rentVal.gridx = 2;
		gbc_rentVal.gridy = 3;
		getContentPane().add(rentVal, gbc_rentVal);
		this.normalLabels.add(rentVal);
		this.railRoadLabels.add(rentVal);
		
		JLabel lblWithHouse = new JLabel("With 1 House:");
		GridBagConstraints gbc_lblWithHouse = new GridBagConstraints();
		gbc_lblWithHouse.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithHouse.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithHouse.gridx = 1;
		gbc_lblWithHouse.gridy = 4;
		getContentPane().add(lblWithHouse, gbc_lblWithHouse);
		this.normalLabels.add(lblWithHouse);
		
		house1Val = new JLabel("0");
		GridBagConstraints gbc_house1Val = new GridBagConstraints();
		gbc_house1Val.fill = GridBagConstraints.VERTICAL;
		gbc_house1Val.insets = new Insets(0, 0, 5, 5);
		gbc_house1Val.gridx = 2;
		gbc_house1Val.gridy = 4;
		getContentPane().add(house1Val, gbc_house1Val);
		this.normalLabels.add(house1Val);
		
		JLabel lblWith2Houses = new JLabel("With 2 Houses:");
		GridBagConstraints gbc_lblWithHouses = new GridBagConstraints();
		gbc_lblWithHouses.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithHouses.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithHouses.gridx = 1;
		gbc_lblWithHouses.gridy = 5;
		getContentPane().add(lblWith2Houses, gbc_lblWithHouses);
		this.normalLabels.add(lblWith2Houses);
		
		house2Val = new JLabel("0");
		GridBagConstraints gbc_house2Val = new GridBagConstraints();
		gbc_house2Val.fill = GridBagConstraints.VERTICAL;
		gbc_house2Val.insets = new Insets(0, 0, 5, 5);
		gbc_house2Val.gridx = 2;
		gbc_house2Val.gridy = 5;
		getContentPane().add(house2Val, gbc_house2Val);
		this.normalLabels.add(house2Val);
		
		JLabel lblWith3Houses = new JLabel("WIth 3 Houses:");
		GridBagConstraints gbc_lblWithHouses_1 = new GridBagConstraints();
		gbc_lblWithHouses_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithHouses_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithHouses_1.gridx = 1;
		gbc_lblWithHouses_1.gridy = 6;
		getContentPane().add(lblWith3Houses, gbc_lblWithHouses_1);
		this.normalLabels.add(lblWith3Houses);
		
		house3Val = new JLabel("0");
		GridBagConstraints gbc_house3Val = new GridBagConstraints();
		gbc_house3Val.fill = GridBagConstraints.VERTICAL;
		gbc_house3Val.insets = new Insets(0, 0, 5, 5);
		gbc_house3Val.gridx = 2;
		gbc_house3Val.gridy = 6;
		getContentPane().add(house3Val, gbc_house3Val);
		this.normalLabels.add(house3Val);
		
		JLabel lblWith4Houses = new JLabel("With 4 Houses:");
		GridBagConstraints gbc_lblWithHouses_2 = new GridBagConstraints();
		gbc_lblWithHouses_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithHouses_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithHouses_2.gridx = 1;
		gbc_lblWithHouses_2.gridy = 7;
		getContentPane().add(lblWith4Houses, gbc_lblWithHouses_2);
		this.normalLabels.add(lblWith4Houses);
		
		house4Val = new JLabel("0");
		GridBagConstraints gbc_house4Val = new GridBagConstraints();
		gbc_house4Val.fill = GridBagConstraints.VERTICAL;
		gbc_house4Val.insets = new Insets(0, 0, 5, 5);
		gbc_house4Val.gridx = 2;
		gbc_house4Val.gridy = 7;
		getContentPane().add(house4Val, gbc_house4Val);
		this.normalLabels.add(house4Val);
		
		JLabel lblWithHotel = new JLabel("With HOTEL:");
		GridBagConstraints gbc_lblWithHotel = new GridBagConstraints();
		gbc_lblWithHotel.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithHotel.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithHotel.gridx = 1;
		gbc_lblWithHotel.gridy = 8;
		getContentPane().add(lblWithHotel, gbc_lblWithHotel);
		this.normalLabels.add(lblWithHotel);
		
		hotelVal = new JLabel("0");
		GridBagConstraints gbc_hotelVal = new GridBagConstraints();
		gbc_hotelVal.fill = GridBagConstraints.VERTICAL;
		gbc_hotelVal.insets = new Insets(0, 0, 5, 5);
		gbc_hotelVal.gridx = 2;
		gbc_hotelVal.gridy = 8;
		getContentPane().add(hotelVal, gbc_hotelVal);
		this.normalLabels.add(hotelVal);
		
		JLabel lblHousesCost = new JLabel("Houses Cost:");
		GridBagConstraints gbc_lblHousesCost = new GridBagConstraints();
		gbc_lblHousesCost.fill = GridBagConstraints.VERTICAL;
		gbc_lblHousesCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblHousesCost.gridx = 1;
		gbc_lblHousesCost.gridy = 9;
		getContentPane().add(lblHousesCost, gbc_lblHousesCost);
		this.normalLabels.add(lblHousesCost);
		
		houseCostVal = new JLabel("0");
		GridBagConstraints gbc_houseCostVal = new GridBagConstraints();
		gbc_houseCostVal.fill = GridBagConstraints.VERTICAL;
		gbc_houseCostVal.insets = new Insets(0, 0, 5, 5);
		gbc_houseCostVal.gridx = 2;
		gbc_houseCostVal.gridy = 9;
		getContentPane().add(houseCostVal, gbc_houseCostVal);
		this.normalLabels.add(houseCostVal);
		
		JLabel lblHotelCost = new JLabel("Hotel Costs (Plus 4 Houses): ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 10;
		getContentPane().add(lblHotelCost, gbc_lblNewLabel_1);
		this.normalLabels.add(lblHotelCost);
		
		hotelCostVal = new JLabel("0");
		GridBagConstraints gbc_hotelCostVal = new GridBagConstraints();
		gbc_hotelCostVal.fill = GridBagConstraints.VERTICAL;
		gbc_hotelCostVal.insets = new Insets(0, 0, 5, 5);
		gbc_hotelCostVal.gridx = 2;
		gbc_hotelCostVal.gridy = 10;
		getContentPane().add(hotelCostVal, gbc_hotelCostVal);
		this.normalLabels.add(hotelCostVal);
		
		JLabel lblWithRailroads = new JLabel("With 2 Railroads:");
		GridBagConstraints gbc_lblWithRailroads = new GridBagConstraints();
		gbc_lblWithRailroads.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithRailroads.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithRailroads.gridx = 1;
		gbc_lblWithRailroads.gridy = 11;
		getContentPane().add(lblWithRailroads, gbc_lblWithRailroads);
		this.railRoadLabels.add(lblWithRailroads);
		
		railRoad2Val = new JLabel("0");
		GridBagConstraints gbc_railRoad2Val = new GridBagConstraints();
		gbc_railRoad2Val.fill = GridBagConstraints.VERTICAL;
		gbc_railRoad2Val.insets = new Insets(0, 0, 5, 5);
		gbc_railRoad2Val.gridx = 2;
		gbc_railRoad2Val.gridy = 11;
		getContentPane().add(railRoad2Val, gbc_railRoad2Val);
		this.railRoadLabels.add(railRoad2Val);

		
		JLabel lblWithRailroads_1 = new JLabel("With 3 RailRoads:");
		GridBagConstraints gbc_lblWithRailroads_1 = new GridBagConstraints();
		gbc_lblWithRailroads_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithRailroads_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithRailroads_1.gridx = 1;
		gbc_lblWithRailroads_1.gridy = 12;
		getContentPane().add(lblWithRailroads_1, gbc_lblWithRailroads_1);
		this.railRoadLabels.add(lblWithRailroads_1);

		
		railRoad3Val = new JLabel("0");
		GridBagConstraints gbc_railRoad3Val = new GridBagConstraints();
		gbc_railRoad3Val.fill = GridBagConstraints.VERTICAL;
		gbc_railRoad3Val.insets = new Insets(0, 0, 5, 5);
		gbc_railRoad3Val.gridx = 2;
		gbc_railRoad3Val.gridy = 12;
		getContentPane().add(railRoad3Val, gbc_railRoad3Val);
		this.railRoadLabels.add(railRoad3Val);

		
		JLabel lblWithRailroads_2 = new JLabel("With 4 RailRoads");
		GridBagConstraints gbc_lblWithRailroads_2 = new GridBagConstraints();
		gbc_lblWithRailroads_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblWithRailroads_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithRailroads_2.gridx = 1;
		gbc_lblWithRailroads_2.gridy = 13;
		getContentPane().add(lblWithRailroads_2, gbc_lblWithRailroads_2);
		this.railRoadLabels.add(lblWithRailroads_2);

		
		railRoad4Val = new JLabel("0");
		GridBagConstraints gbc_railRoad4Val = new GridBagConstraints();
		gbc_railRoad4Val.fill = GridBagConstraints.VERTICAL;
		gbc_railRoad4Val.insets = new Insets(0, 0, 5, 5);
		gbc_railRoad4Val.gridx = 2;
		gbc_railRoad4Val.gridy = 13;
		getContentPane().add(railRoad4Val, gbc_railRoad4Val);
		this.railRoadLabels.add(railRoad4Val);
		
		cardDescription = new JLabel("CardDescription");
		GridBagConstraints gbc_cardDescription = new GridBagConstraints();
		gbc_cardDescription.fill = GridBagConstraints.VERTICAL;
		gbc_cardDescription.insets = new Insets(0, 0, 5, 0);
		gbc_cardDescription.gridx = 1;
		gbc_cardDescription.gridy = 14;
		gbc_cardDescription.gridwidth = 2;
		getContentPane().add(cardDescription, gbc_cardDescription);
		this.utilityLabels.add(cardDescription);
		this.specialLabels.add(cardDescription);

		
		JLabel lblMortgageValue = new JLabel("Mortgage Value:");
		GridBagConstraints gbc_lblMortgageValue = new GridBagConstraints();
		gbc_lblMortgageValue.fill = GridBagConstraints.VERTICAL;
		gbc_lblMortgageValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblMortgageValue.gridx = 1;
		gbc_lblMortgageValue.gridy = 15;
		getContentPane().add(lblMortgageValue, gbc_lblMortgageValue);
		this.normalLabels.add(lblMortgageValue);
		this.railRoadLabels.add(lblMortgageValue);
		this.utilityLabels.add(lblMortgageValue);
		
		mortgageVal = new JLabel("0");
		GridBagConstraints gbc_mortgageVal = new GridBagConstraints();
		gbc_mortgageVal.fill = GridBagConstraints.VERTICAL;
		gbc_mortgageVal.insets = new Insets(0, 0, 5, 5);
		gbc_mortgageVal.gridx = 2;
		gbc_mortgageVal.gridy = 15;
		getContentPane().add(mortgageVal, gbc_mortgageVal);
		this.normalLabels.add(mortgageVal);
		this.railRoadLabels.add(mortgageVal);
		this.utilityLabels.add(mortgageVal);
		
		JButton okayButton = new JButton("Okay");
		GridBagConstraints gbc_okayButton = new GridBagConstraints();
		gbc_okayButton.insets = new Insets(0, 0, 5, 0);
		gbc_okayButton.gridx = 1;
		gbc_okayButton.gridy = 17;
		gbc_okayButton.gridwidth = 2;
		okayButton.addActionListener(okayClicked);
		getContentPane().add(okayButton, gbc_okayButton);
		
		switch (currentSpace.type)
		{
		case NORM:
			
			hideLabels(railRoadLabels);
			hideLabels(utilityLabels);
			hideLabels(specialLabels);
			showLabels(normalLabels);
			populateNormal(currentSpace);
			
			break;
		
		case RR:
			
			hideLabels(normalLabels);
			hideLabels(utilityLabels);
			hideLabels(specialLabels);
			showLabels(railRoadLabels);
			populateRailRoad(currentSpace);
			
			break;
			
		case UTIL:
			
			hideLabels(railRoadLabels);
			hideLabels(normalLabels);
			hideLabels(specialLabels);
			showLabels(utilityLabels);
			populateUtility(currentSpace);
			
			break;
			
		case ACTION:
			
			hideLabels(railRoadLabels);
			hideLabels(utilityLabels);
			hideLabels(normalLabels);
			showLabels(specialLabels);
			populateSpecial(currentSpace);
			
			break;
		
		}
		
		
	}
	
	void hideLabels (ArrayList<JLabel> in)
	{
		
		for( JLabel i : in)
		{
			i.setVisible(false);
		}
		
	}
	
	void showLabels (ArrayList<JLabel> in)
	{
		
		for( JLabel i : in)
		{
			i.setVisible(true);
		}
		
	}
	
	void populateNormal(Space input)
	{
		this.title.setText(((Property)input).getName());
		//need a getRentArrayFunction
//		this.rentVal.setText(""+((Property)input).getRent());
//		this.house1Val.setText(""+((Property)input).getRent());
//		this.house2Val.setText(""+((Property)input).getRent());
//		this.house3Val.setText(""+((Property)input).getRent());
//		this.house4Val.setText(""+((Property)input).getRent());
//	NEED MORE GET FUNCTIONS FOR PROPERTY CLASS
//		this.hotelVal.setText(""+((Property)input).get());
//		this.houseCostVal.setText(""+((Property)input).get());
//		this.hotelCostVal.setText(""+((Property)input).get());
//		this.mortgageVal.setText(((Property)input).get);
		
		//set bar color too
		
	}
	
	void populateRailRoad(Space input)
	{
		this.title.setText(((Property)input).getName());
		//need a getRentArrayFunction
//		this.rentVal.setText(""+((Property)input).getRent());
//		this.railRoad2Val.setText(""+((Property)input).getRent());
//		this.railRoad3Val.setText(""+((Property)input).getRent());
//		this.railRoad4Val.setText(""+((Property)input).getRent());
//		this.mortgageVal.setText(((Property)input).get);
		
		//set bar color too
		
	}
	;
	void populateUtility(Space input)
	{
		this.title.setText(((Property)input).getName());
//		this.cardDescription.setText(((Property)input).get);
//		this.mortgageVal.setText(((Property)input).get);
		
	}
	
	void populateSpecial(Space input)
	{
		this.title.setText((input).getName());
//		this.cardDescription.setText((input).get);
		
	}
	
	private ActionListener okayClicked = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			dispose();
			
		}
			
	};

}
