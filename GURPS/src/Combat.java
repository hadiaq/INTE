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
	
	public Character getStartingCharacter (int dieRoll) {
		Character startingChar = null;
		Double d1 = new Double(char1.getMovementSpeed());
		Double d2 = new Double(char2.getMovementSpeed());
		
		if (d1.compareTo(d2) > 0 ) {
			startingChar = char1;
			
		} else if (d1.compareTo(d2)<0) {
			startingChar = char2;
			
		} else if (d1.compareTo(d2)==0 && dieRoll <= 3) {
			startingChar = char1;
			
		} else {
			startingChar = char2;
			
		}
		
		return startingChar;
	}
	
	public boolean attackSwing(Character attacker, Character defender, int die) {
		boolean hit = false;
		
		if (defender.getState() == Character.State.Blocking) {
			int chanceToBlock = 0;
			for (Equipment.Item shield : defender.getEquippedItemsList()) {
				if (shield instanceof Equipment.Shield) {
					chanceToBlock = ((Equipment.Shield) shield).getPassiveDefense();
				}
			}
			if (chanceToBlock > die) {
				hit = false;
			} else {
				hit = true;
			}
			
		} else if (defender.getState() == Character.State.Parrying) {
			int chanceToParry = 0;
			
			for (Equipment.Item weapon : defender.getEquippedItemsList()) {
				if (weapon instanceof Equipment.Weapon) {
					chanceToParry = defender.getWeaponSkill();
				}
			}
			if (chanceToParry > die) {
				hit = false;
			} else {
				hit = true;
			}
			
		} else if (defender.getState() == Character.State.Dodging) {
			int chanceToDodge = (int)defender.getMovementSpeed();
			
			if (chanceToDodge > die) {
				hit = false;
			} else {
				hit = true;
			}
		}
		
		return hit;
		
	}
	
	public boolean attackThrust(Character attacker, Character defender, int die) {
		boolean hit = false;
		
		if (defender.getState() == Character.State.Blocking) {
			int chanceToBlock = 0;
			for (Equipment.Item shield : defender.getEquippedItemsList()) {
				if (shield instanceof Equipment.Shield) {
					chanceToBlock = ((Equipment.Shield) shield).getPassiveDefense();
				}
			}
			if (chanceToBlock > die) {
				hit = false;
			} else {
				hit = true;
			}
			
		} else if (defender.getState() == Character.State.Parrying) {
			int chanceToParry = 0;
			
			for (Equipment.Item weapon : defender.getEquippedItemsList()) {
				if (weapon instanceof Equipment.Weapon) {
					chanceToParry = defender.getWeaponSkill();
				}
			}
			if (chanceToParry > die) {
				hit = false;
			} else {
				hit = true;
			}
			
		} else if (defender.getState() == Character.State.Dodging) {
			int chanceToDodge = (int)defender.getMovementSpeed();
			
			if (chanceToDodge > die) {
				hit = false;
			} else {
				hit = true;
			}
		}
		
		return hit;
		
	}
	
	public void applyDamage (Character attacker, Character defender, int die) {
		defender.setHealth(defender.getHealth()-die);
	}

//	
//	
//	//�r medveten om att dessa �r identiska men d� dessa atkskill samt defendskill beh�vs
//	public static boolean defend(Character def){
//		
//		totalRoll = 0;
//		int totalPassiveDefence = 0;
//		
//		for(int i=0; i<3 ; i++){
//			totalRoll = totalRoll + Die.roll();
//		}
//		
//		if(totalRoll <= def.getStrength())
//			return true;
//		else {
//			damageRoll=Die.roll();
//		
//			for(Equipment.Item item : def.getEquippedItemsList()){
//				if(item instanceof Equipment.Shield.Buckler)
//					totalPassiveDefence ++;
//				else if(item instanceof Equipment.Armor.LeatherJacket)
//					totalPassiveDefence ++;
//			}
//			
//			def.setHealth(def.getHealth() - damageRoll + totalPassiveDefence);
//			return false;
//		}
//	}
}
