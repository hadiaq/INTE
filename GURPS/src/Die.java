
import java.util.Random;

public class Die {
	
	public int value;
	
	public Die() {
		Random ran = new Random();
		this.value = ran.nextInt(6) +1;
	}
	
	public Die(int seed) {
		Random ran = new Random(seed);
		this.value = ran.nextInt(6) +1;
	}
	
	public int getValue() {
		return value;
	}
	
	public void roll() {
		Random ran = new Random();
		value = ran.nextInt(6) +1;
	}
	
	public void seedRoll(int seed) {
		Random ran = new Random();
		value = ran.nextInt(6) +1;
	}
}
