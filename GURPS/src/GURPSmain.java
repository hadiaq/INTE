import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class GURPSmain extends JFrame {
	
	public static ArrayList<Advantage> advantages = new ArrayList<Advantage>();
	public static ArrayList<Character> characters = new ArrayList<Character>();
	ListModel advantagesDataModel = new ListModel();
	JList<String> advantageList = new JList<String>(advantagesDataModel);
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

	GURPSmain() {
		
		super("GURPS Lite");
		
	    JMenuBar fileMenu = new JMenuBar();
	    JMenu file = new JMenu("File");
	    JMenuItem newChar= new JMenuItem("New Character");
	    JMenuItem open= new JMenuItem("Open");
	    JMenuItem save= new JMenuItem("Save");
	    JMenuItem quit= new JMenuItem("Quit");
	    
	    file.add(newChar);
	    newChar.addActionListener(new ListenerNewChar());
	    file.add(open);
	    file.add(save);
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
		west.add(attributeInfo);
		west.add(new JLabel("Advantages:"));
		west.add(new JScrollPane(advantageList));
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		
		add(north, BorderLayout.PAGE_START);
		add(east, BorderLayout.LINE_END);
		add(center, BorderLayout.CENTER);
		add(west, BorderLayout.LINE_START);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(0, 0);
		pack();
		setResizable(true);
		setVisible(true);

		// Skapar exempelkarakt�ren fr�n manualen
		createCharacter("Dai Blackthorn", 100);
		
		// Skapar advantages och l�gger till dem i den gemensamma listan.
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
				+ "You get a +3 on any Climbing roll, onany roll to escape from "
				+ "ropes, handcuffs or other restraints, or on any Mechanic roll "
				+ "(to reach into an engine, of course)", 5);
		
		//H�mtar en advantage fr�n den gemensamma listan och ger den till karakt�ren.
		addAdvantageToChar("Dai Blackthorn", "Absolute Direction");
		addAdvantageToChar("Dai Blackthorn", "Double-Jointed");
		
		//Tilldela attribut
//		setCharacterST("Dai Blackthorn", 8);
//		setCharacterDX("Dai Blackthorn", 15);
//		setCharacterIQ("Dai Blackthorn", 12);
//		setCharacterHT("Dai Blackthorn", 12);
		
		advantagesDataModel.addSorted("Absolute Direction");
		advantagesDataModel.addSorted("Double Jointed");
	}
	
    class ListenerNewChar implements ActionListener {
		public void actionPerformed (ActionEvent ave) {
			CharacterForm charForm = new CharacterForm();
			
			int ans = JOptionPane.showConfirmDialog(GURPSmain.this, charForm);
			if (ans != JOptionPane.OK_OPTION) {
				return;
			}
			
			String charName = charForm.getName();
			String charPoints = charForm.getPoints();
			
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
			
			int parsedPts = Integer.parseInt(charPoints);
			createCharacter(charName, parsedPts);
		}
    }
	
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
	}
	
	
	public void createCharacter(String name, int points) {
		Character ch = new Character(name, points);
		characters.add(ch);
	}
	
	public void createAdvantage(String name, String description, int pointCost) {
		Advantage adv = new Advantage(name, description, pointCost);
		advantages.add(adv);
	}
	
	public void addAdvantageToChar(String recipient, String advantage) {
		for (Character ch : characters) {
			if (ch.getName().equals(recipient)) {
				for (Advantage adv : advantages) {
					if (adv.getName().equals(advantage)) {
						ch.addAdvantage(advantage);
					}
				}
			}
		}
	}
	
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
		}
		return cost;
	}
	
	public void disableButtons() {
		
		for (Character ch : characters) {
			
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
			else
				addST.setEnabled(true);
			
			if (ch.getDexterity() == 1)
				redDX.setEnabled(false);
			else
				redDX.setEnabled(true);
			
			if (attributeCost(ch.getDexterity()+1) - attributeCost(ch.getDexterity()) > ch.getPointsUnspent())
				addDX.setEnabled(false);
			else
				addDX.setEnabled(true);
			
			if (ch.getIntelligence() == 1)
				redIQ.setEnabled(false);
			else
				redIQ.setEnabled(true);
			
			if (attributeCost(ch.getIntelligence()+1) - attributeCost(ch.getIntelligence()) > ch.getPointsUnspent())
				addIQ.setEnabled(false);
			else
				addIQ.setEnabled(true);
			
			if (ch.getHealth() == 1)
				redHT.setEnabled(false);
			else
				redHT.setEnabled(true);
			
			if (attributeCost(ch.getHealth()+1) - attributeCost(ch.getHealth()) > ch.getPointsUnspent())
				addHT.setEnabled(false);
			else
				addHT.setEnabled(true);
			
		}
	}
	
	public void decreaseAttribute(String recipient, String attribute) {
		for (Character ch : characters) {
			
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
			
			disableButtons();
		}
	}
	
	public void increaseAttribute(String recipient, String attribute) {
		for (Character ch : characters) {
			
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
		
			disableButtons();
		}
	}
	
	public void startCombat(String name1, String name2) {
		Character char1 = null;
		Character char2 = null;
		for (Character ch : characters) {
			if (ch.getName().equals(name1)) {
				char1 = ch;
			}
		}
		for (Character ch : characters) {
			if (ch.getName().equals(name2)) {
				char2 = ch;
			}
		}
		Combat combat = new Combat(char1, char2);
	}

	public static void main(String[] args) {
		System.out.println("GURPS lite");
		new GURPSmain();
		System.out.println(characters);
	}

}
