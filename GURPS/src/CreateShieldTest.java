import static org.junit.Assert.*;

import org.junit.Test;


public class CreateShieldTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void test() {
		Equipment.Shield sh1 = GURPSmain.createShield("The Shield", 10, 5.0, 2);
		assertEquals(sh1.getDescription(), "The Shield");
		assertEquals(sh1.getValue(), 10);
		assertEquals(sh1.getWeight(), 5.0, DELTA);
		assertEquals(sh1.getPassiveDefense(), 2);
		
		Equipment.Shield sh2 = GURPSmain.createShield("1234567", 0, 5.0, 0);
		assertEquals(sh2.getDescription(), "1234567");
		assertEquals(sh2.getValue(), 0);
		assertEquals(sh2.getWeight(), 5.0, DELTA);
		assertEquals(sh2.getPassiveDefense(), 0);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentTest1(){
		Equipment.Shield sh = GURPSmain.createShield(null , 0, 4.0, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentTest2(){
		Equipment.Shield sh = GURPSmain.createShield("The Shield", -2, 5.0, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentTest3(){
		Equipment.Shield sh = GURPSmain.createShield("The Shield", 3, 0, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentTest4(){
		Equipment.Shield sh = GURPSmain.createShield("The Shield", 3, -2.0, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentTest5(){
		Equipment.Shield sh = GURPSmain.createShield("The Shield", 4, 5.0, -3);
	}
	
	
	

}
