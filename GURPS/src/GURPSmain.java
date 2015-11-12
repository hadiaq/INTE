import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class GURPSmain extends JFrame {
	
	public static Map<String, Character> charMap = new HashMap<String, Character>();
	public static Map<String, Advantage> advMap = new HashMap<String, Advantage>();
	public static ArrayList<Equipment.Item> items = new ArrayList<Equipment.Item>();
	
//	public static ArrayList<Advantage> advantages = new ArrayList<Advantage>();
//	public static ArrayList<Character> characters = new ArrayList<Character>();
	
	ListModel advantagesDataModel = new ListModel();
	ListModel itemsDataModel = new ListModel();
	ListModel equipmentDataModel = new ListModel();
	JList<String> advantageList = new JList<String>(advantagesDataModel);
	JList<String> itemList = new JList<String>(itemsDataModel);
	JList<String> equipmentList = new JList<String>(equipmentDataModel);
	static JLabel charName = new JLabel("[enter name]");
	static JLabel charPoints = new JLabel("[total points]");
	static JLabel charUpoints = new JLabel("[unspent points]");
	static JLabel ST = new JLabel("[st value]");
	static JLabel DX = new JLabel("[dx value]");
	static JLabel IQ = new JLabel("[iq value]");
	static JLabel HT = new JLabel("[ht value]");
	static JButton redST = new JButton("-");
	static JButton addST = new JButton("+");
	static JButton redDX = new JButton("-");
	static JButton addDX = new JButton("+");
	static JButton redIQ = new JButton("-");
	static JButton addIQ = new JButton("+");
	static JButton redHT = new JButton("-");
	static JButton addHT = new JButton("+");
	static JButton addADV = new JButton("Add Advantage");
	static JButton remADV = new JButton("Remove Advantage");
	static JButton addItem = new JButton("Add Item");
	static JButton equipItem = new JButton("Equip");
	static JButton unequipItem = new JButton("Unequip");

	GURPSmain() {
		
		//GUI
		super("GURPS Lite");
		
	    JMenuBar fileMenu = new JMenuBar();
	    JMenu file = new JMenu("File");
	    JMenuItem newChar = new JMenuItem("New Character");
	    JMenuItem print = new JMenuItem("Print");
	    JMenuItem quit = new JMenuItem("Quit");
	    
	    file.add(newChar);
	    newChar.addActionListener(new ListenerNewChar());
	    file.add(print);
	    print.addActionListener(new ListenerPrint());
	    file.add(quit);
	    fileMenu.add(file);
	    setJMenuBar(fileMenu);
	    
		JPanel north = new JPanel();
		JPanel east = new JPanel();
		JPanel center = new JPanel();
		JPanel west = new JPanel();
		
		JPanel basicInfo = new JPanel();
		
		JPanel namePanel = new JPanel();
		JLabel charNameL = new JLabel("Name : ");
		namePanel.add(charNameL);
		namePanel.add(charName);
		
		JPanel appearancePanel = new JPanel();
		JLabel charAppearanceL = new JLabel("Appearance : ");
		JLabel charAppearance = new JLabel("[enter appearance]");
		appearancePanel.add(charAppearanceL);
		appearancePanel.add(charAppearance);
		
		basicInfo.add(namePanel);
		basicInfo.add(appearancePanel);
		basicInfo.setLayout(new BoxLayout(basicInfo, BoxLayout.Y_AXIS));
		
		JPanel pointInfo = new JPanel();
		
		JPanel pointPanel = new JPanel();
		JLabel charPointsL = new JLabel("Points : ");
		pointPanel.add(charPointsL);
		pointPanel.add(charPoints);
		
		JPanel uPointPanel = new JPanel();
		JLabel charUpointsL = new JLabel("Unspent : ");
		uPointPanel.add(charUpointsL);
		uPointPanel.add(charUpoints);
		
		pointInfo.add(pointPanel);
		pointInfo.add(uPointPanel);
		pointInfo.setLayout(new BoxLayout(pointInfo, BoxLayout.Y_AXIS));
		
		north.add(basicInfo);
		north.add(pointInfo);
		
		JPanel attributeInfo = new JPanel();
		
		JPanel strengthPanel = new JPanel();
		JLabel STL = new JLabel("ST : ");
		strengthPanel.add(redST);
		redST.setEnabled(false);
		redST.addActionListener(new decreaseST());
		strengthPanel.add(addST);
		addST.setEnabled(false);
		addST.addActionListener(new increaseST());
		strengthPanel.add(STL);
		strengthPanel.add(ST);
		
		JPanel dexPanel = new JPanel();
		JLabel DXL = new JLabel("DX : ");
		dexPanel.add(redDX);
		redDX.setEnabled(false);
		redDX.addActionListener(new decreaseDX());
		dexPanel.add(addDX);
		addDX.setEnabled(false);
		addDX.addActionListener(new increaseDX());
		dexPanel.add(DXL);
		dexPanel.add(DX);
		
		JPanel intPanel = new JPanel();
		JLabel IQL = new JLabel("IQ : ");
		intPanel.add(redIQ);
		redIQ.setEnabled(false);
		redIQ.addActionListener(new decreaseIQ());
		intPanel.add(addIQ);
		addIQ.setEnabled(false);
		addIQ.addActionListener(new increaseIQ());
		intPanel.add(IQL);
		intPanel.add(IQ);
		
		JPanel htPanel = new JPanel();
		JLabel HTL = new JLabel("HT : ");
		htPanel.add(redHT);
		redHT.setEnabled(false);
		redHT.addActionListener(new decreaseHT());
		htPanel.add(addHT);
		addHT.setEnabled(false);
		addHT.addActionListener(new increaseHT());
		htPanel.add(HTL);
		htPanel.add(HT);
		
		JPanel armorPanel = new JPanel();
		JLabel armorL = new JLabel("Armor : ");
		JLabel armor = new JLabel("[armor value]");
		armorPanel.add(armorL);
		armorPanel.add(armor);
		
		JPanel shieldPanel = new JPanel();
		JLabel shieldL = new JLabel("Shield : ");
		JLabel shield = new JLabel("[shield value]");
		shieldPanel.add(shieldL);
		shieldPanel.add(shield);
		
		JPanel dodgePanel = new JPanel();
		JLabel dodgeL = new JLabel("Dodge : ");
		JLabel dodge = new JLabel("[dodge value]");
		dodgePanel.add(dodgeL);
		dodgePanel.add(dodge);
		
		JPanel parryPanel = new JPanel();
		JLabel parryL = new JLabel("Parry : ");
		JLabel parry = new JLabel("[parry value]");
		parryPanel.add(parryL);
		parryPanel.add(parry);
		
		JPanel blockPanel = new JPanel();
		JLabel blockL = new JLabel("Block : ");
		JLabel block = new JLabel("[block value]");
		blockPanel.add(blockL);
		blockPanel.add(block);
		
		JPanel damageresistancePanel = new JPanel();
		JLabel damageresistanceL = new JLabel("Damage Resistance : ");
		JLabel damageresistance = new JLabel("[DR value]");
		damageresistancePanel.add(damageresistanceL);
		damageresistancePanel.add(damageresistance);
		
		attributeInfo.add(strengthPanel);
		attributeInfo.add(dexPanel);
		attributeInfo.add(intPanel);
		attributeInfo.add(htPanel);
		attributeInfo.add(armorPanel);
		attributeInfo.add(shieldPanel);
		attributeInfo.add(dodgePanel);
		attributeInfo.add(parryPanel);
		attributeInfo.add(blockPanel);
		attributeInfo.add(damageresistancePanel);
		attributeInfo.setLayout(new BoxLayout(attributeInfo, BoxLayout.Y_AXIS));
		
		advantageList.setFixedCellWidth(100);
		advantageList.setVisibleRowCount(10);
		advantageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setFixedCellWidth(100);
		itemList.setVisibleRowCount(10);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		equipmentList.setFixedCellWidth(100);
		equipmentList.setVisibleRowCount(10);
		equipmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		west.add(attributeInfo);
		west.add(new JLabel("Advantages:"));
		west.add(new JScrollPane(advantageList));
		west.add(addADV);
		addADV.setEnabled(false);
		addADV.addActionListener(new addAdvantage());
		west.add(remADV);
		remADV.setEnabled(false);
		remADV.addActionListener(new removeAdvantage());
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		
		center.add(new JLabel("Items"));
		center.add(new JScrollPane(itemList));
		center.add(equipItem);
		equipItem.addActionListener(new equipItem());
		equipItem.setEnabled(false);
		center.add(unequipItem);
		unequipItem.addActionListener(new unequipItem());
		unequipItem.setEnabled(false);
		center.add(new JLabel("Equipped Items"));
		center.add(new JScrollPane(equipmentList));
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		east.add(addItem);
		addItem.addActionListener(new addItem());
		addItem.setEnabled(false);
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		
		add(north, BorderLayout.PAGE_START);
		add(east, BorderLayout.LINE_END);
		add(center, BorderLayout.CENTER);
		add(west, BorderLayout.LINE_START);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(0, 0);
		pack();
		setResizable(true);
		setVisible(true); //GUI
		
		// Skapar advantages och lägger till dem i den gemensamma listan.
		createAdvantage("Absolute Direction" , 
				"You always know which way is north, and you can always "
				+ "re-trace a path you have followed within the past month, "
				+ "no matter how faint it may be. This ability does not "
				+ "work in environments such as interstellar space or the "
				+ "limbo of the astral plane, but it does work underground, "
				+ "underwater, and on other planets. Also gives a +3 bonus "
				+ "on your Navigation skill.", 5);
		createAdvantage("Resistant to Poison", "Poison affects you less; +3 "
				+ "to HT to resist its effects.", 5);
		createAdvantage("Double-Jointed", "Your body is unusually flexible. "
				+ "You get a +3 on any Climbing roll, on any roll to escape from "
				+ "ropes, handcuffs or other restraints, or on any Mechanic roll "
				+ "(to reach into an engine, of course)", 10);
		
		createShortsword();
		createDagger();
		createBuckler();
		createSmallShield();
		createScaleArmor();
		
	}
	
	//Knapp för att skapa ny karaktär
    class ListenerNewChar implements ActionListener {
		public void actionPerformed (ActionEvent ave) {
			CharacterForm charForm = new CharacterForm();
			
			int ans = JOptionPane.showConfirmDialog(GURPSmain.this, charForm);
			if (ans != JOptionPane.OK_OPTION) {
				return;
			}
			
			String charName = charForm.getName();
			String charPoints = charForm.getPoints();
			try {
				Integer.parseInt(charPoints);
				GURPSmain.charName.setText(charName);
				GURPSmain.charPoints.setText(charPoints);
				GURPSmain.charUpoints.setText(charPoints);
				GURPSmain.ST.setText("10");
				redST.setEnabled(true);
				addST.setEnabled(true);
				GURPSmain.DX.setText("10");
				redDX.setEnabled(true);
				addDX.setEnabled(true);
				GURPSmain.IQ.setText("10");
				redIQ.setEnabled(true);
				addIQ.setEnabled(true);
				GURPSmain.HT.setText("10");
				redHT.setEnabled(true);
				addHT.setEnabled(true);
				addADV.setEnabled(true);
				remADV.setEnabled(true);
				addItem.setEnabled(true);
				equipItem.setEnabled(true);
				unequipItem.setEnabled(true);
				int parsedPts = Integer.parseInt(charPoints);
				createCharacter(charName, parsedPts);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(GURPSmain.this,  "Invalid point entry.");
			}
		}
    }
    
    class ListenerPrint implements ActionListener {
    	public void actionPerformed (ActionEvent ae) {
    		System.out.println(charMap.get(charName.getText()));
    	}
    }
	
    //Sorteringsmodell för advantages och items
	class ListModel extends DefaultListModel<String>{
		
		public void addSorted(String addNew){
			int pos = 0;
			while (pos < size() && get(pos).compareTo(addNew) < 0)
			    pos++;
			add(pos, addNew);
	    }

		public void remove(String delete) {
			int pos = 0;
			while (pos < size() && !get(pos).equals(delete))
				pos++;
			remove(pos);
		}
	}
	
	//Alla plus- och minusknappar nedan
	public class decreaseST implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			decreaseAttribute(charName.getText(), "ST");
		}
	}
	
	public class increaseST implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			increaseAttribute(charName.getText(), "ST");
		}
	}
	
	public class decreaseDX implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			decreaseAttribute(charName.getText(), "DX");
		}
	}
	
	public class increaseDX implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			increaseAttribute(charName.getText(), "DX");
		}
	}
	
	public class decreaseIQ implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			decreaseAttribute(charName.getText(), "IQ");
		}
	}
	
	public class increaseIQ implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			increaseAttribute(charName.getText(), "IQ");
		}
	}
	
	public class decreaseHT implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			decreaseAttribute(charName.getText(), "HT");
		}
	}
	
	public class increaseHT implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			increaseAttribute(charName.getText(), "HT");
		}
	} // Plus- och minusknappar
	
	//Lägger till en advantage till karaktären
	public class addAdvantage implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			AdvantagesForm advForm = new AdvantagesForm(advMap);
			
			int ans = JOptionPane.showConfirmDialog(GURPSmain.this, advForm);
			if (ans != JOptionPane.OK_OPTION) {
				return;
			}
			
			String advantageName = advForm.getName();
			int advantageCost = advForm.getCost();
			String recipient = charName.getText();
			
			if (charMap.get(recipient).getAdvantages().containsKey(advantageName)) {
				JOptionPane.showMessageDialog(GURPSmain.this, "You already have that advantage");
			} else {
				if (charMap.get(recipient).getPointsUnspent() >= advantageCost) {
					charMap.get(recipient).setPointsUnspent(charMap.get(recipient).getPointsUnspent()-advantageCost);
					charMap.get(recipient).addAdvantage(advantageName);
//					updateAdvantageList(recipient);
				} else {
					JOptionPane.showMessageDialog(GURPSmain.this, "You don't have enough points");
				}
			}
			refresh();
		}
	}
	
	//Tar bort en advantage från karaktärn
	public class removeAdvantage implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
			if (advantageList.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(GURPSmain.this, "No advantage selected.");
			} else {
				String advName = advantageList.getSelectedValue();
				int advCost = 0;
				String newUP = "0";
				
				advCost = advMap.get(advName).getPointCost();
				
				charMap.get(charName.getText()).removeAdvantage(advName);
				charMap.get(charName.getText()).setPointsUnspent(charMap.get(charName.getText()).getPointsUnspent() + advCost);
				
				newUP = Integer.toString(charMap.get(charName.getText()).getPointsUnspent());
				charUpoints.setText(newUP);
				
				advantagesDataModel.remove(advName);
				
				refresh();
			}
		}
	}
	
	//Lägger till ett item till karaktären
	public class addItem implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			ItemsForm itemForm = new ItemsForm(items);
			
			int ans = JOptionPane.showConfirmDialog(GURPSmain.this, itemForm);
			if (ans != JOptionPane.OK_OPTION) {
				return;
			}
			
			charMap.get(charName.getText()).addItem(itemForm.getItem());
			refresh();
		}
	}
	
	public class equipItem implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Equipment.Item eqItem = null;
			for (Equipment.Item it : items) {
				if (it.getDescription().equals(itemList.getSelectedValue())) {
					eqItem = it;
				}
			}
			try {
				charMap.get(charName.getText()).equip(eqItem);
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(GURPSmain.this, "Item already Equipped");
			}
			refresh();
		}
	}
	
	public class unequipItem implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Equipment.Item eqItem = null;
			for (Equipment.Item it : items) {
				if (it.getDescription().equals(equipmentList.getSelectedValue())) {
					eqItem = it;
				}
			}
			charMap.get(charName.getText()).unequip(eqItem);
			refresh();
		}
	}
	
	//Skapar ny karaktär
	public void createCharacter(String name, int points) {
		Character ch = new Character(name, points);
		ch.setStrength(10);
		ch.setDexterity(10);
		ch.setIntelligence(10);
		ch.setHealth(10);
		ch.setPointsTotal(points);
		ch.setPointsUnspent(points);
		charMap.put(name, ch);
		refresh();
	}
	
	public void createAdvantage(String name, String description, int pointCost) {
		Advantage adv = new Advantage(name, description, pointCost);
		advMap.put(name, adv);
	}
	
	public void createItem(String description, int value, double weight) {
		Equipment.Item item = new Equipment.Item(description, value, weight);
		items.add(item);
	}
	
	public void createBuckler() {
		Equipment.Shield.Buckler buckler = new Equipment.Shield.Buckler();
		items.add(buckler);
	}
	
	public void createSmallShield() {
		Equipment.Shield.SmallShield smallShield = new Equipment.Shield.SmallShield();
		items.add(smallShield);
	}
	
	public void createScaleArmor() {
		Equipment.Armor.ScaleArmor scaleArmor = new Equipment.Armor.ScaleArmor(3);
		items.add(scaleArmor);
	}
	
	public void createShortsword() {
		Equipment.Weapon.HandWeapon.Shortsword shortsword = new Equipment.Weapon.HandWeapon.Shortsword();
		items.add(shortsword);
	}
	
	public void createDagger() {
		Equipment.Weapon.HandWeapon.Dagger dagger = new Equipment.Weapon.HandWeapon.Dagger();
		items.add(dagger);
	}
	
	//Metod som används för att beräkna kostnad för att öka/minska attribut
	public int attributeCost (int value) {
		int cost = 0;
		switch (value) {
			case 0 : cost = -90; break;
			case 1 : cost = -80; break;
			case 2 : cost = -70; break;
			case 3 : cost = -60; break;
			case 4 : cost = -50; break;
			case 5 : cost = -40; break;
			case 6 : cost = -30; break;
			case 7 : cost = -20; break;
			case 8 : cost = -15; break;
			case 9 : cost = -10; break;
			case 10 : cost = 0;  break;
			case 11 : cost = 10; break;
			case 12 : cost = 20; break;
			case 13 : cost = 30; break;
			case 14 : cost = 45; break;
			case 15 : cost = 60; break;
			case 16 : cost = 80; break;
			case 17 : cost = 100; break;
			case 18 : cost = 125; break;
			case 19 : cost = 150; break;
			case 20 : cost = 175; break;
			case 21 : cost = 200; break;
			default : System.out.println("Attribute value error.");
		}
		return cost;
	}
	
	//Uppdaterar listor och tillgängliga knappar
	public void refresh() {
		
		Character ch = charMap.get(charName.getText());
		
		String newST = Integer.toString(ch.getStrength());
		String newDX = Integer.toString(ch.getDexterity());
		String newIQ = Integer.toString(ch.getIntelligence());
		String newHT = Integer.toString(ch.getHealth());
		String newPts = Integer.toString(ch.getPointsUnspent());
		
		ST.setText(newST);
		DX.setText(newDX);
		IQ.setText(newIQ);
		HT.setText(newHT);
		charUpoints.setText(newPts);
		
		if (ch.getStrength() == 1)
			redST.setEnabled(false);
		else
			redST.setEnabled(true);
		
		if (attributeCost(ch.getStrength()+1) - attributeCost(ch.getStrength()) > ch.getPointsUnspent())
			addST.setEnabled(false);
		else if (ch.getStrength() >= 20)
			addST.setEnabled(false);
		else
			addST.setEnabled(true);
		
		if (ch.getDexterity() == 1)
			redDX.setEnabled(false);
		else
			redDX.setEnabled(true);
		
		if (attributeCost(ch.getDexterity()+1) - attributeCost(ch.getDexterity()) > ch.getPointsUnspent())
			addDX.setEnabled(false);
		else if (ch.getDexterity() >= 20)
			addDX.setEnabled(false);
		else
			addDX.setEnabled(true);
		
		if (ch.getIntelligence() == 1)
			redIQ.setEnabled(false);
		else
			redIQ.setEnabled(true);
		
		if (attributeCost(ch.getIntelligence()+1) - attributeCost(ch.getIntelligence()) > ch.getPointsUnspent())
			addIQ.setEnabled(false);
		else if (ch.getIntelligence() >= 20)
			addIQ.setEnabled(false);
		else
			addIQ.setEnabled(true);
		
		if (ch.getHealth() == 1)
			redHT.setEnabled(false);
		else
			redHT.setEnabled(true);
		
		if (attributeCost(ch.getHealth()+1) - attributeCost(ch.getHealth()) > ch.getPointsUnspent())
			addHT.setEnabled(false);
		else if (ch.getHealth() >= 20)
			addHT.setEnabled(false);
		else
			addHT.setEnabled(true);
		
		advantagesDataModel.removeAllElements();
		
		Map<String, Advantage> charAdvantages = new HashMap<String, Advantage>();
		charAdvantages = ch.getAdvantages();
		
		for (Map.Entry<String, Advantage> entry : charAdvantages.entrySet()) {
			advantagesDataModel.addSorted(entry.getKey());
		}
		
		itemsDataModel.removeAllElements();
		for (Equipment.Item it : ch.getItems()) {
			itemsDataModel.addSorted(it.getDescription());
		}
		
		equipmentDataModel.removeAllElements();
		for (Equipment.Item it : ch.getEquippedItemsList()) {
			equipmentDataModel.addSorted(it.getDescription());
		}
		
	}
	
	//Minskar ett attribut med 1
	public void decreaseAttribute(String recipient, String attribute) {
		Character ch = charMap.get(charName.getText());
		
		switch(attribute) {
			case "ST": ch.setStrength(ch.getStrength()-1);
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getStrength()) - attributeCost(ch.getStrength()+1)));
			break;
			case "DX" : ch.setDexterity(ch.getDexterity()-1); 
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getDexterity()) - attributeCost(ch.getDexterity()+1)));
			break;
			case "IQ" : ch.setIntelligence(ch.getIntelligence()-1); 
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getIntelligence()) - attributeCost(ch.getIntelligence()+1)));
			break;
			case "HT" : ch.setHealth(ch.getHealth()-1); 
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getHealth()) - attributeCost(ch.getHealth()+1)));
			break;
			default : System.out.println("Attribute not found");
		}
		
		refresh();
		
	}
	
	//Ökar ett attribut med 1
	public void increaseAttribute(String recipient, String attribute) {
		Character ch = charMap.get(recipient);
		
		switch(attribute) {
			case "ST": ch.setStrength(ch.getStrength()+1);
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getStrength()) - attributeCost(ch.getStrength()-1)));
			break;
			case "DX" : ch.setDexterity(ch.getDexterity()+1);
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getDexterity()) - attributeCost(ch.getDexterity()-1)));
			break;
			case "IQ" : ch.setIntelligence(ch.getIntelligence()+1); 
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getIntelligence()) - attributeCost(ch.getIntelligence()-1)));
			break;
			case "HT" : ch.setHealth(ch.getHealth()+1); 
			ch.setPointsUnspent(ch.getPointsUnspent() - (attributeCost(ch.getHealth()) - attributeCost(ch.getHealth()-1)));
			break;
			default : System.out.println("Attribute not found");
		}

		refresh();

	}
	
	//Startar en instans av Combat mellan nuvarande karaktär och exempelkaraktären
	public void startCombat(String name1, String name2) {
		Character char1 = charMap.get(charName.getText());
		Character char2 = charMap.get("Dai Blackthorn");

		Combat combat = new Combat(char1, char2);
	}

	public static void main(String[] args) {
		System.out.println("GURPS lite");
		new GURPSmain();
//		System.out.println(characters);
	}

}
