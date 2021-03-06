
import java.util.Random;

public class Die {
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 6;
	
	public int value;

	public Die() {
		Random ran = new Random();
		this.value = ran.nextInt(MAX_VALUE) +1;
	}
	
	public int getValue() {
		return value;
	}
	
	public final int roll() {
		Random ran = new Random();
		return ran.nextInt(MAX_VALUE) +1;
		
	}
	
}
