
public class Combat {
	static int totalRoll;
	//Gick p� str pga att attackskill ej �r implementerat men ville kunna g�ra koden m�jlig �nd�
	//Jag har �ven ignorerat turordning tillsvidare
	public static boolean attack(Character atk){
		
		totalRoll = 0;
		for(int i=0; i<3 ; i++){
			totalRoll = totalRoll + Die.roll();
		}
		
		if(totalRoll <= atk.getStrength())
			return true;
		else 
			return false;
	}
	
	//samma h�r som p� attack. Har �ven gjort all damage till 1.
	//�r medveten om att dessa �r identiska men d� dessa atkskill samt defendskill beh�vs
	public static boolean defend(Character def){
		
		totalRoll = 0;
		for(int i=0; i<3 ; i++){
			totalRoll = totalRoll + Die.roll();
		}
		
		if(totalRoll <= def.getStrength())
			return true;
		else {
			def.setHealth(def.getHealth() - 1);
			return false;
		}
	}
}
