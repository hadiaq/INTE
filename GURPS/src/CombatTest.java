import static org.junit.Assert.*;

import org.junit.Test;

public class CombatTest {

	@Test
	public void attackTest() {
		Character atk = new Character(100);
		atk.setStrength(10);
		boolean strike = Combat.attack(atk);
		int roll = Combat.totalRoll;
		if (roll <= atk.getStrength())
			assertEquals(strike, true);
		else
			assertEquals(strike, false);
	}
	
	@Test
	public void defendTest() {
		Character def = new Character(100);
		def.setStrength(10);
		boolean defend = Combat.defend(def);
		int roll = Combat.totalRoll;
		if (roll <= def.getStrength())
			assertEquals(defend, true);
		else{
			assertEquals(def.getHealth(), 9);
			assertEquals(defend, false);
		}
	}
}