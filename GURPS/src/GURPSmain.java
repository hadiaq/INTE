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
		System.out.println("GURPS lite");
	}

}
