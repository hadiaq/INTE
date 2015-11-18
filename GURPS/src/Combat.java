import java.util.ArrayList;

public class Combat {
	static int totalRoll;
	static int damageRoll;
	private Character char1;
	private Character char2;
	
	public Combat (Character char1, Character char2) {
		this.char1 = char1;
		this.char2 = char2;
	}
	
	public Character getStartingCharacter () {
		Character startingChar = null;
		if (char1.getMovementSpeed() > char2.getMovementSpeed()) {
			startingChar = char1;
			
		} else if (char2.getMovementSpeed() > char1.getMovementSpeed()) {
			startingChar = char2;
			
		} else {
			startingChar = randomizeStartingCharacter();
		}
		return startingChar;
	}
	
	public Character randomizeStartingCharacter() {
		Character startingChar = null;
		int die = new Die().getValue();
		if (die <= 3)
			startingChar = char1;
		else
			startingChar = char2;
		
		return startingChar;
	}
	
	public boolean attackSwinging(Character attacker, Character defender) {
		Equipment.Weapon wpn = attacker.getWeapon();
		DiceRoll dr = wpn.calculateBasicWeaponDamage(attacker.getStrength(), Equipment.Weapon.AttackType.SWINGING);
		int damage = dr.getValue();
		boolean hit = false;
		
		if (defender.getState() == Character.State.Blocking) {
			hit = block(attacker, defender);
		} else if (defender.getState() == Character.State.Parrying) {
			hit = parry(attacker, defender);
		} else if (defender.getState() == Character.State.Dodging) {
			hit = dodge(attacker, defender);
		}
		
		if (hit == true) {
			applyDamage(damage, defender);
		}
		
		return hit;
	}
	
	
	
	public boolean block(Character attacker, Character defender) {
		int chanceToBlock = 0;
		boolean blocked = false;
		
		for (Equipment.Item shield : defender.getEquippedItemsList()) {
			if (shield instanceof Equipment.Shield) {
				chanceToBlock = ((Equipment.Shield) shield).getPassiveDefense();
			}
		}
		if (chanceToBlock > new DiceRoll(2,0).getValue()) {
			blocked = true;
		}
		return blocked;
	}

	public boolean parry(Character attacker, Character defender) {
		int chanceToParry = 0;
		boolean parried = false;
		
		for (Equipment.Item weapon : defender.getEquippedItemsList()) {
			if (weapon instanceof Equipment.Weapon) {
				chanceToParry = defender.getWeaponSkill();
			}
		}
		if (chanceToParry > new DiceRoll(2,0).getValue()) {
			parried = true;
		}
		
		return parried;
	}		
	
	public boolean dodge(Character attacker, Character defender) {
		int chanceToDodge = (int)defender.getMovementSpeed();
		boolean dodged = false;
		
		if (chanceToDodge > new DiceRoll(2,0).getValue()) {
			dodged = true;
		}
		
		return dodged;
	}		
	
	public void applyDamage (int damage, Character defender) {
		defender.setHealth(defender.getHealth()-damage);
	}
	
//	public static class CombatTurn {
//		private int turnCount;
//		private static Character attacker;
//		private static Character defender;
//		private boolean avoided;
//		
//		
//		public CombatTurn (Character attacker, Character defender, int turnCount) {
//			this.attacker = attacker;
//			this.defender = defender;
//			this.turnCount = turnCount;
//			
//			if (defender.isBlocking()) {
//				ArrayList<Equipment.Item> equipped = new ArrayList<Equipment.Item>(defender.getEquippedItemsList());
//				for (Equipment.Item eq : equipped) {
//					if (eq instanceof Equipment.Shield) {
//						DiceRoll dr = new DiceRoll(3,0);
//						if (dr.getValue() <= 7) {
//							avoided = true;
//						}
//					}
//				}
//			} else if (defender.isParrying()) {
//				ArrayList<Equipment.Item> equipped = new ArrayList<Equipment.Item>(defender.getEquippedItemsList());
//				for (Equipment.Item eq : equipped) {
//					if (eq instanceof Equipment.Weapon.HandWeapon) {
//						DiceRoll dr = new DiceRoll(2,0);
//						if (dr.getValue() <= 5) {
//							avoided = true;
//						}
//					}
//				}
//			} else if (defender.isDodging()) {
//				DiceRoll dr = new DiceRoll(2,0);
//				if (dr.getValue() <= defender.getDexterity()/2) {
//					avoided = true;
//				}
//			} else {
//				avoided = false;
//			}
//				
//			
//		}
//		
//		public static DiceRoll getAttackerDiceRoll (Character atk) {
//			Equipment.Weapon weapon = attacker.getWeapon();
//			DiceRoll diceRoll = weapon.calculateBasicWeaponDamage(attacker.getStrength(), Equipment.Weapon.AttackType.SWINGING);
//			return diceRoll;
//		}
//		
//		public int calculateDamage(DiceRoll dr) {
//			int damage = getAttackerDiceRoll(attacker).getValue();
//			return damage;
//		}
//		
//		public void dealDamage (Character def) {
//			if(avoided == false) {
//				def.setHealth(def.getHealth()-calculateDamage(getAttackerDiceRoll(attacker)));
//			}
//		}
//		
//		
//		
//	}
	
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
}
