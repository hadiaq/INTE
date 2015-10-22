import java.util.ArrayList;

public class GURPSmain {
	
	public static ArrayList<Advantage> advantages = new ArrayList<Advantage>();
	public static ArrayList<Character> characters = new ArrayList<Character>();

	GURPSmain() {
		
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
				+ "ropes, handcuffs or other restraints, or on anyMechanic roll "
				+ "(to reach into an engine, of course", 5);
		
		//Hämtar en advantage från den gemensamma listan och ger den till karaktären.
		addAdvantageToChar("Dai Blackthorn", "Absolute Direction");
		addAdvantageToChar("Dai Blackthorn", "Double-Jointed");
		
		//Tilldela attribut
		setCharacterST("Dai Blackthorn", 8);
		setCharacterDX("Dai Blackthorn", 15);
		setCharacterIQ("Dai Blackthorn", 12);
		setCharacterHT("Dai Blackthorn", 12);
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
	
	public static void main(String[] args) {
		System.out.println("GURPS lite");
		new GURPSmain();
		System.out.println(characters);
	}

}
