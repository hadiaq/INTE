import static org.junit.Assert.*;

import org.junit.Test;


public class DieTest {

	@Test
	public void test() {
		
		Die d = new Die();
		assertTrue(d.value>=1 && d.value<=6);
	}
	
	@Test
	public void testRoll() {
		
		Die d = new Die();
		assertTrue(d.roll() >=1 && d.roll() <= 6);	
	}
	
	@Test
	public void testValue() {
		
		Die d = new Die();
		assertTrue(d.getValue() >=1 && d.getValue() <= 6);	
	}

}
