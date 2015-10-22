
public class Combat {
	static int totalRoll;
	//Gick på str pga att attackskill ej är implementerat men ville kunna göra koden möjlig ändå
	//Jag har även ignorerat turordning tillsvidare
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
	
	//samma här som på attack. Har även gjort all damage till 1.
	//Är medveten om att dessa är identiska men då dessa atkskill samt defendskill behövs
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
