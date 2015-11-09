
import java.util.Random;

public class Die {
	public static int MIN_VALUE = 1;
	public static int MAX_VALUE = 6;
	
	public int value;

	public Die() {
		Random ran = new Random();
		this.value = ran.nextInt(MAX_VALUE) +1;
	}
	
	public Die(int seed) {
		Random ran = new Random(seed);
		this.value = ran.nextInt(MAX_VALUE) +1;
	}
	
	public int getValue() {
		return value;
	}
	
	public static int roll() {
		Random ran = new Random();
		return ran.nextInt(MAX_VALUE) +1;
		
	}
	
	public void seedRoll(int seed) {
		Random ran = new Random();
		value = ran.nextInt(MAX_VALUE) +1;
	}
}
