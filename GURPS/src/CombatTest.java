import static org.junit.Assert.*;

import org.junit.Test;

public class CombatTest {
	Character atk = new Character("Per", 100);
	Character def = new Character("olle", 100);
	
	@Test
	public void attackTest() {
		atk.setStrength(10);
		boolean strike = Combat.attack(atk, def);
		int roll = Combat.totalRoll;
		if (roll <= atk.getStrength())
			assertEquals(strike, true);
		else
			assertEquals(strike, false);
	}
	
	@Test
	public void defendTest() {
		Character def = new Character("olle", 100);
		def.setStrength(10);
		boolean defend = Combat.defend(def);
		int roll = Combat.totalRoll;
		if (roll <= def.getStrength())
			assertEquals(defend, true);
		else{
			assertEquals(def.getHealth(), 10-Combat.damageRoll);
			assertEquals(defend, false);
		}
	}
}