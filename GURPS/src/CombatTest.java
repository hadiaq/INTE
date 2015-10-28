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
		
		Equipment.Shield.Buckler buck = new Equipment.Shield.Buckler();
		def.equip(buck);
		
		Equipment.Armor.LeatherJacket leather = new Equipment.Armor.LeatherJacket(5);
		def.equip(leather);
		
		def.setStrength(10);
		boolean defend = Combat.defend(def);
		int roll = Combat.totalRoll;
		if (roll <= def.getStrength())
			assertEquals(defend, true);
		else{
			assertEquals(def.getHealth(), 10-Combat.damageRoll + 2);
			assertEquals(defend, false);
		}
	}
}