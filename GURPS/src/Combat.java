import java.util.ArrayList;


public class Combat {
	static int totalRoll;
	static int damageRoll;
	private Character char1;
	private Character char2;
	private ArrayList<CombatTurn> turns = new ArrayList<CombatTurn>();
	
	public Combat (Character char1, Character char2) {
		this.char1 = char1;
		this.char2 = char2;
		while (char1.getHealth() > 0 && char2.getHealth() > 0) {
			
			for (int turnCounter = 0; turnCounter<50 ; turnCounter++) {
				if (turnCounter%2 == 0) {
					CombatTurn even = new CombatTurn(char1, char2, turnCounter);
					turns.add(even);
				} else {
					CombatTurn odd = new CombatTurn(char2, char1, turnCounter);
					turns.add(odd);
				}
			}
		}
	}
	
	public static class CombatTurn {
		private int turnCount;
		private static Character attacker;
		private static Character defender;
		private boolean avoided;
		public CombatTurn (Character attacker, Character defender, int turnCount) {
			this.attacker = attacker;
			this.defender = defender;
			this.turnCount = turnCount;
			
			if (defender.isBlocking()) {
				ArrayList<Equipment.Item> equipped = new ArrayList<Equipment.Item>(defender.getEquippedItemsList());
				for (Equipment.Item eq : equipped) {
					if (eq instanceof Equipment.Shield) {
						DiceRoll dr = new DiceRoll(3,0);
						if (dr.getValue() <= 7) {
							avoided = true;
						}
					}
				}
			} else if (defender.isParrying()) {
				ArrayList<Equipment.Item> equipped = new ArrayList<Equipment.Item>(defender.getEquippedItemsList());
				for (Equipment.Item eq : equipped) {
					if (eq instanceof Equipment.Weapon.HandWeapon) {
						DiceRoll dr = new DiceRoll(2,0);
						if (dr.getValue() <= 5) {
							avoided = true;
						}
					}
				}
			} else if (defender.isDodging()) {
				DiceRoll dr = new DiceRoll(2,0);
				if (dr.getValue() <= defender.getDexterity()/2) {
					avoided = true;
				}
			} else {
				avoided = false;
			}
				
			
		}
		
		public static DiceRoll getAttackerDiceRoll (Character atk) {
			Equipment.Weapon weapon = attacker.getWeapon();
			DiceRoll diceRoll = weapon.calculateBasicWeaponDamage(attacker.getStrength(), Equipment.Weapon.AttackType.SWINGING);
			return diceRoll;
		}
		
		public int calculateDamage(DiceRoll dr) {
			int damage = getAttackerDiceRoll(attacker).getValue();
			return damage;
		}
		
		public void dealDamage (Character def) {
			if(avoided == false) {
				def.setHealth(def.getHealth()-calculateDamage(getAttackerDiceRoll(attacker)));
			}
		}
		
		
		
	}
	
	public static boolean attack(Character atk, Character def){
		
		totalRoll = 0;
		for(int i=0; i<3 ; i++){
			totalRoll = totalRoll + Die.roll();
		}
		
		if(totalRoll <= atk.getStrength()){
			defend(def);
			return true;
		}
		else 
			return false;
	}
	
	
	//Är medveten om att dessa är identiska men då dessa atkskill samt defendskill behövs
	public static boolean defend(Character def){
		
		totalRoll = 0;
		int totalPassiveDefence = 0;
		
		for(int i=0; i<3 ; i++){
			totalRoll = totalRoll + Die.roll();
		}
		
		if(totalRoll <= def.getStrength())
			return true;
		else {
			damageRoll=Die.roll();
		
			for(Equipment.Item item : def.getEquippedItemsList()){
				if(item instanceof Equipment.Shield.Buckler)
					totalPassiveDefence ++;
				else if(item instanceof Equipment.Armor.LeatherJacket)
					totalPassiveDefence ++;
			}
			
			def.setHealth(def.getHealth() - damageRoll + totalPassiveDefence);
			return false;
		}
	}
	
	/*
	 
	public Combat (Character char1, Character char2) {
		this.char1 = char1;
		this.char2 = char2;
		
		public void startCombat() {
			if (char1.getMovementSpeed() > char2.getMovementSpeed()) {
				combatTurn turn = new combatTurn(char1, char2);
				
			} else if (char2.getMovementSpeed() > char1.getMovementSpeed()) {
				combatTurn turn = new combatTurn(char2, char1);
			} else {
				//slå tärning om vem som börjar
			}
		}
		
		private boolean combatTurn(Character c1, Character c2) {
			boolean endTurn = false;
			
			while (endTurn == false) {
				switch (command) {
					case "attack":
					// c1 attackerar c2
					// kontrollera om c2 har valt AOdefense
					// c2 väljer parry/block/dodge
					
					case "escape":
					// end combat
					
					case "AOattack":
					// attackera med +4
					// state = AOattack
					// kontrollera om c2 har valt AOdefense
					// c2 väljer dodge/parry/block
					
					case "AOdefense":
					// state = AOdefense
					
					default:
					System.out.println("Unknown command");
				}
				
				endTurn = true;
			}
			
			if (c1.getHealth > 0 %% c2.getHealth > 0) {
				combatTurn nextTurn = new combatTurn(c1, c2)
			}
		}
	}
	 
	 
	 */
	
}
