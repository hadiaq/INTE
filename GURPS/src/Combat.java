


public class Combat {
	static int totalRoll;
	static int damageRoll;
	private Character char1;
	private Character char2;
	//Gick p� str pga att attackskill ej �r implementerat men ville kunna g�ra koden m�jlig �nd�
	//Jag har �ven ignorerat turordning tillsvidare
	
	public Combat (Character char1, Character char2) {
		this.char1 = char1;
		this.char2 = char2;
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
