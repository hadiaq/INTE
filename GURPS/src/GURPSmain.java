import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GURPSmain {
	
	private static final Map<String, Character> charMap = new HashMap<String, Character>();

	public static Equipment.Shield createShield(String description, int value, double weight, int passiveDefence){
		if(description == null)
			throw new IllegalArgumentException();
		if(value <0)
			throw new IllegalArgumentException();
		if(weight <=0)
			throw new IllegalArgumentException();
		if(passiveDefence <0)
			throw new IllegalArgumentException();
		
		Equipment.Shield sh = new Equipment.Shield(description, value, weight, passiveDefence);
		return sh;
	}

	public static void main(String[] args) {
		for (int i=0; i<15000000; i++) {
			Character ch = new Character("asdf", 100);
			Equipment.Shield sh = createShield("shield", 5, 10, 15);
			ch.equip(sh);
		}
		System.out.println("GURPS lite");
	}

}
