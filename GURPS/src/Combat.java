import java.util.ArrayList;

import Equipment.Weapon.AttackType;


public class Combat {
	static int totalRoll;
	static int damageRoll;
	private Character char1;
	private Character char2;
	private ArrayList<CombatTurn> turns = new ArrayList<CombatTurn>();
	//Gick p� str pga att attackskill ej �r implementerat men ville kunna g�ra koden m�jlig �nd�
	//Jag har �ven ignorerat turordning tillsvidare
	
	public Combat (Character char1, Character char2) {
		this.char1 = char1;
		this.char2 = char2;
		while (char1.getHealth() > 0 && char2.getHealth() > 0) {
			
			for (int turnCounter = 0; turnCounter<300 ; turnCounter++) {
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
		private Character attacker;
		private Character defender;
		public CombatTurn (Character attacker, Character defender, int turnCount) {
			this.attacker = attacker;
			this.defender = defender;
			this.turnCount = turnCount;
			
			Equipment.Weapon weapon = attacker.getWeapon();
			DiceRoll diceRoll = weapon.calculateBasicWeaponDamage(attacker.getStrength(), Equipment.Weapon.AttackType.SWINGING);
			int damage = diceRoll.getValue();
			
			if (defender.isBlocking()) {
				//block ber�kning
			} else if (defender.isParrying()) {
				//parry ber�kning
			} else if (defender.isDodging()) {
				//dodge ber�kning
			} else {
				//skada
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
	
	
	//�r medveten om att dessa �r identiska men d� dessa atkskill samt defendskill beh�vs
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
