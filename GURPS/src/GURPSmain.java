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
		redST.addActionListener(new reduceST());
		strengthPanel.add(addST);
		addST.setEnabled(false);
		addST.addActionListener(new increaseST());
		strengthPanel.add(STL);
		strengthPanel.add(ST);
		
		JPanel dexPanel = new JPanel();
		JLabel DXL = new JLabel("DX : ");
		dexPanel.add(redDX);
		redDX.setEnabled(false);
		dexPanel.add(addDX);
		addDX.setEnabled(false);
		dexPanel.add(DXL);
		dexPanel.add(DX);
		
		JPanel intPanel = new JPanel();
		JLabel IQL = new JLabel("IQ : ");
		intPanel.add(redIQ);
		redIQ.setEnabled(false);
		intPanel.add(addIQ);
		addIQ.setEnabled(false);
		intPanel.add(IQL);
		intPanel.add(IQ);
		
		JPanel htPanel = new JPanel();
		JLabel HTL = new JLabel("HT : ");
		htPanel.add(redHT);
		redHT.setEnabled(false);
		htPanel.add(addHT);
		addHT.setEnabled(false);
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

		// Skapar exempelkaraktären från manualen
		createCharacter("Dai Blackthorn", 100);
		
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
				+ "You get a +3 on any Climbing roll, onany roll to escape from "
				+ "ropes, handcuffs or other restraints, or on any Mechanic roll "
				+ "(to reach into an engine, of course)", 5);
		
		//Hämtar en advantage från den gemensamma listan och ger den till karaktären.
		addAdvantageToChar("Dai Blackthorn", "Absolute Direction");
		addAdvantageToChar("Dai Blackthorn", "Double-Jointed");
		
		//Tilldela attribut
		setCharacterST("Dai Blackthorn", 8);
		setCharacterDX("Dai Blackthorn", 15);
		setCharacterIQ("Dai Blackthorn", 12);
		setCharacterHT("Dai Blackthorn", 12);
		
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
	
	public class reduceST implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			int currentST = Integer.parseInt(ST.getText());
			setCharacterST(charName.getText(), currentST-1);
			int unspentPoints = getCharacterUpoints(charName.getText());
			currentST--;
			String newST = Integer.toString(currentST);
			String newUP = Integer.toString(unspentPoints);
			ST.setText(newST);
			charUpoints.setText(newUP);
		}
	}
	
	public class increaseST implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			int currentST = Integer.parseInt(ST.getText());
			setCharacterST(charName.getText(), currentST+1);
			int unspentPoints = getCharacterUpoints(charName.getText());
			currentST++;
			String newST = Integer.toString(currentST);
			String newUP = Integer.toString(unspentPoints);
			ST.setText(newST);
			charUpoints.setText(newUP);
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
	
	public void setCharacterST(String recipient, int value) {
		for (Character ch : characters) {
			if (ch.getName().equals(recipient)) {
				ch.setStrength(value);
			}
		}
	}
	
	public void setCharacterDX(String recipient, int value) {
		for (Character ch : characters) {
			if (ch.getName().equals(recipient)) {
				ch.setDexterity(value);
			}
		}
	}
	
	public void setCharacterIQ(String recipient, int value) {
		for (Character ch : characters) {
			if (ch.getName().equals(recipient)) {
				ch.setIntelligence(value);
			}
		}
	}
	
	public void setCharacterHT(String recipient, int value) {
		for (Character ch : characters) {
			if (ch.getName().equals(recipient)) {
				ch.setHealth(value);
			}
		}
	}
	
	public int getCharacterUpoints(String recipient) {
		int p = 0;
		for (Character ch : characters) {
			if (ch.getName().equals(recipient)) {
				p = ch.getPointsUnspent();
			}
		}
		return p;
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
