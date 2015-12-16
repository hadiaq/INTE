import static org.junit.Assert.*;

import org.junit.Test;

public class CombatTest {
	Character atk = new Character("Per", 100);
	Character def = new Character("olle", 100);
	Equipment.Weapon.HandWeapon.Shortsword sword = new Equipment.Weapon.HandWeapon.Shortsword();
	Equipment.Shield.SmallShield shield = new Equipment.Shield.SmallShield();
	
	@Test
	public void getStartingCharacterTest () {
		Combat com = new Combat(atk, def);
		atk.setDexterity(15);
		def.setDexterity(5);
		assertEquals(com.getStartingCharacter(3), atk);
		atk.setDexterity(5);
		def.setDexterity(15);
		assertEquals(com.getStartingCharacter(3), def);
		atk.setDexterity(10);
		def.setDexterity(10);
		assertEquals(com.getStartingCharacter(2), atk);
		assertEquals(com.getStartingCharacter(5), def);

	}
	
	@Test
	public void attackSwingTestBlock () {
		atk.equip(sword);
		def.equip(sword);
		def.equip(shield);
		Combat com = new Combat(atk, def);
		
		def.setState(Character.State.Blocking);
		assertTrue(com.attackSwing(atk, def, 12));
		assertFalse(com.attackSwing(atk, def, 1));
	}
	
	@Test
	public void attackSwingTestParry () {
		atk.equip(sword);
		def.equip(sword);
		def.equip(shield);
		Combat com = new Combat(atk, def);
		
		def.setState(Character.State.Parrying);
		assertTrue(com.attackSwing(atk,  def, 12));
		assertFalse(com.attackSwing(atk,  def, 1));
	}
	
	@Test
	public void attackSwingTestDodge () {
		atk.equip(sword);
		def.equip(sword);
		def.equip(shield);
		Combat com = new Combat(atk, def);
		
		def.setState(Character.State.Dodging);
		assertTrue(com.attackSwing(atk,  def, 12));
		assertFalse(com.attackSwing(atk,  def, 1));
	}
	
	@Test
	public void attackThrustTestBlock () {
		atk.equip(sword);
		def.equip(sword);
		def.equip(shield);
		Combat com = new Combat(atk, def);
		
		def.setState(Character.State.Blocking);
		assertTrue(com.attackThrust(atk, def, 12));
		assertFalse(com.attackThrust(atk, def, 1));
	}
	
	@Test
	public void attackThrustTestParry () {
		atk.equip(sword);
		def.equip(sword);
		def.equip(shield);
		Combat com = new Combat(atk, def);
		
		def.setState(Character.State.Parrying);
		assertTrue(com.attackThrust(atk,  def, 12));
		assertFalse(com.attackThrust(atk,  def, 1));
	}
	
	@Test
	public void attackThrustTestDodge () {
		atk.equip(sword);
		def.equip(sword);
		def.equip(shield);
		Combat com = new Combat(atk, def);
		
		def.setState(Character.State.Dodging);
		assertTrue(com.attackThrust(atk,  def, 12));
		assertFalse(com.attackThrust(atk,  def, 1));
	}
	
	@Test
	public void applyDamageTestSwing () {
		atk.equip(sword);
		Combat com = new Combat(atk, def);
		DiceRoll dr = Equipment.Weapon.calculateBasicWeaponDamage(atk.getStrength(), Equipment.Weapon.AttackType.SWINGING);
		int currentHealth = def.getHealth();
		com.applyDamage(atk, def, dr.getValue());
		assertEquals(def.getHealth(), currentHealth-dr.getValue());
	}
	
	@Test
	public void applyDamageTestThrust () {
		atk.equip(sword);
		Combat com = new Combat(atk, def);
		DiceRoll dr = Equipment.Weapon.calculateBasicWeaponDamage(atk.getStrength(), Equipment.Weapon.AttackType.THRUSTING);
		int currentHealth = def.getHealth();
		com.applyDamage(atk, def, dr.getValue());
		assertEquals(def.getHealth(), currentHealth-dr.getValue());
	}
	
//	@Test
//	public void attackTest() {
//		atk.setStrength(10);
//		boolean strike = Combat.attack(atk, def);
//		int roll = Combat.totalRoll;
//		if (roll <= atk.getStrength())
//			assertEquals(strike, true);
//		else
//			assertEquals(strike, false);
//	}
//	
//	@Test
//	public void defendTest() {
//		Character def = new Character("olle", 100);
//		
//		Equipment.Shield.Buckler buck = new Equipment.Shield.Buckler();
//		def.equip(buck);
//		
//		Equipment.Armor.LeatherJacket leather = new Equipment.Armor.LeatherJacket(5);
//		def.equip(leather);
//		
//		def.setStrength(10);
//		boolean defend = Combat.defend(def);
//		int roll = Combat.totalRoll;
//		if (roll <= def.getStrength())
//			assertEquals(defend, true);
//		else{
//			assertEquals(def.getHealth(), 10-Combat.damageRoll + 2);
//			assertEquals(defend, false);
//		}
//	}
	
//	@Test
//	public void combatTurnTest() {
//		
//		Equipment.Item sword = new Equipment.Weapon.HandWeapon.Shortsword();
//		atk.addItem(sword);
//		atk.equip(sword);
//		Combat.CombatTurn ct = new Combat.CombatTurn(atk, def, 1);
//		
//		assertEquals(ct.getAttackerDiceRoll(atk), Equipment.Weapon.calculateBasicWeaponDamage(atk.getStrength(), Equipment.Weapon.AttackType.SWINGING));
//		int damage = ct.calculateDamage(ct.getAttackerDiceRoll(atk));
//		
//		assertTrue(ct.calculateDamage(ct.getAttackerDiceRoll(atk))>=1 && ct.calculateDamage(ct.getAttackerDiceRoll(atk))<=6);
//		ct.dealDamage(def);
//		
//		assertTrue(def.getHealth() >= 4 && def.getHealth() <= 9);
//		
//	}
}