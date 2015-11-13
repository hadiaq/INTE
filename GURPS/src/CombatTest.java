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
	public void CombatTurnTest() {
		
		Equipment.Item sword = new Equipment.Weapon.HandWeapon.Shortsword();
		atk.addItem(sword);
		atk.equip(sword);
		Combat.CombatTurn ct = new Combat.CombatTurn(atk, def, 1);
		
		assertEquals(ct.getAttackerDiceRoll(atk), Equipment.Weapon.calculateBasicWeaponDamage(atk.getStrength(), Equipment.Weapon.AttackType.SWINGING));
		int damage = ct.calculateDamage(ct.getAttackerDiceRoll(atk));
		
		assertTrue(ct.calculateDamage(ct.getAttackerDiceRoll(atk))>=1 && ct.calculateDamage(ct.getAttackerDiceRoll(atk))<=6);
		ct.dealDamage(def);
		
		assertTrue(def.getHealth() >= 4 && def.getHealth() <= 9);
		
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