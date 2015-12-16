import static org.junit.Assert.*;

import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void constructorTest() {
		Character newChar = new Character("Test", 100);
		assertEquals(Character.State.Passive, newChar.getState());
		assertEquals(10, newChar.getStrength());
		assertEquals(10, newChar.getDexterity());
		assertEquals(10, newChar.getIntelligence());
		assertEquals(10, newChar.getHealth());
		assertEquals(100, newChar.getPointsTotal());
	}
	
	@Test
	public void setStrengthTest() {
		Character newChar = new Character("Test", 100);
		newChar.setStrength(12);
		assertEquals(12, newChar.getStrength());
	}
	
	@Test
	public void setDexterityTest() {
		Character newChar = new Character("Test", 100);
		newChar.setDexterity(17);
		assertEquals(17, newChar.getDexterity());
	}
	
	@Test
	public void setIntelligenceTest() {
		Character newChar = new Character("Test", 100);
		newChar.setIntelligence(9);
		assertEquals(9, newChar.getIntelligence());
	}

	@Test
	public void setHealthTest() {
		Character newChar = new Character("Test", 100);
		newChar.setHealth(13);
		assertEquals(13, newChar.getHealth());
	}

	@Test
	public void equipItemTest() {
		Character newChar = new Character("Test", 100);
		Equipment.Item item = new Equipment.Item("Ring", 20, 0.0);
		newChar.equip(item);
		ArrayList<Equipment.Item> compare = new ArrayList<Equipment.Item>();
		compare.add(item);
		assertEquals(newChar.getEquippedItemsList(), compare);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equipAlreadyEquippedItemTest() {
		// Equippa ett item när det redan är equippat hos en character => fel
		Character newChar = new Character("Test", 100);
		Equipment.Item item = new Equipment.Item("Ring", 20, 0.0);
		newChar.equip(item);
		newChar.equip(item);
	}

	@Test
	public void attackStateTest() {
		Character attacker = new Character("Attacker", 100);
		Character victim = new Character("Victim", 100);
		attacker.attack(victim);
		assertEquals(Character.State.Attacking, attacker.getState());
	}

	@Test
	public void parryStateTest() {
		Character attacker = new Character("Attacker", 100);
		Character victim = new Character("Victim", 100);
		victim.parry(attacker);
		assertEquals(Character.State.Parrying, victim.getState());
	}

	@Test
	public void dodgeStateTest() {
		Character attacker = new Character("Attacker", 100);
		Character victim = new Character("Victim", 100);
		victim.dodge(attacker);
		assertEquals(Character.State.Dodging, victim.getState());
	}

	@Test
	public void blockStateTest() {
		Character attacker = new Character("Attacker", 100);
		Character victim = new Character("Victim", 100);
		victim.block(attacker);
		assertEquals(Character.State.Blocking, victim.getState());
	}
	
	@Test
	public void unEquipTest() {
		Character ch = new Character("Attacker", 100);
		Equipment.Item item = new Equipment.Item("Ring", 20, 0.0);
		ArrayList<Equipment.Item> compare = new ArrayList<Equipment.Item>();
		ch.equip(item);
		ch.unequip(item);
		
		assertEquals(ch.getEquippedItemsList(), compare);
	}
	
	@Test
	public void getItemTest() {
		Character ch = new Character("Attacker", 100);
		Equipment.Item item = new Equipment.Item("Ring", 20, 0.0);
		ArrayList<Equipment.Item> compare = new ArrayList<Equipment.Item>();
		compare.add(item);
		ch.addItem(item);
		
		assertEquals(ch.getItems(), compare);
	}
	
	@Test
	public void addItemTest() {
		Character ch = new Character("Attacker", 100);
		Equipment.Item item = new Equipment.Item("Ring", 20, 0.0);
		ch.addItem(item);
		ArrayList<Equipment.Item> list = ch.getItems();
		Equipment.Item compare = list.get(0); 
		
		assertEquals(item, compare);
	}
	
	@Test
	public void addAdvantageTest() {
		Character ch = new Character("Attacker", 100);
		Advantage adv = new Advantage("Hej", "Hej", 2);
		ch.addAdvantage("Hej");
		Map<String, Advantage> advMap = ch.getAdvantages();
		
		assertEquals(advMap.containsKey("Hej"), true);
	}
	
	@Test
	public void removeAdvantageTest() {
		Character ch = new Character("Attacker", 100);
		Advantage adv = new Advantage("Hej", "Hej", 2);
		ch.addAdvantage("Hej");
		ch.removeAdvantage("Hej");
		Map<String, Advantage> advMap = ch.getAdvantages();
		
		assertEquals(advMap.containsKey("Hej"), false);
	}
	
	@Test
	public void getNameTest() {
		Character ch = new Character("Attacker", 100);
		ch.setName("Axel");
		
		assertEquals("Axel", ch.getName());
		
	}
	
	@Test
	public void stateTest() {
		Character ch = new Character("Attacker", 100);
		assertEquals(ch.isPassive(), true);
		assertEquals(ch.isAttacking(), false);
		assertEquals(ch.isParrying(), false);
		assertEquals(ch.isBlocking(), false);
		assertEquals(ch.isDodging(), false);
		ch.setState(Character.State.Attacking);
		assertEquals(ch.isPassive(), false);
		assertEquals(ch.isAttacking(), true);
		ch.setState(Character.State.Parrying);
		assertEquals(ch.isParrying(), true);
		ch.setState(Character.State.Blocking);
		assertEquals(ch.isBlocking(), true);
		ch.setState(Character.State.Dodging);
		assertEquals(ch.isDodging(), true);
	}
	
	@Test 
	public void setPointsTest() {
		Character ch = new Character("Attacker", 100);
		ch.setPointsTotal(150);
		assertEquals(ch.getPointsTotal(), 150);
		ch.setPointsUnspent(95);
		assertEquals(ch.getPointsUnspent(),95);
	}
	
	@Test
	public void toStringTest() {
		Character ch1 = new Character("Attacker", 100);
		Character ch2 = new Character("Attacker", 100);
		assertEquals(ch1.toString().equals(ch2.toString()), true);
	}
	
	@Test
	public void getWeaponTest() {
		Character newChar = new Character("Test", 100);
		Equipment.Weapon.HandWeapon.Shortsword ss = new Equipment.Weapon.HandWeapon.Shortsword();
		newChar.equip(ss);
		Equipment.Item compare = newChar.getWeapon();
		
		assertEquals(compare, ss);
	}
	
	@Test
	public void getWeaponSkillTest() {
		Character newChar = new Character("Test", 100);
		newChar.setDexterity(15);
		int expected = newChar.getDexterity()-4;
		assertEquals(newChar.getWeaponSkill(), expected);
	}
	
	@Test
	public void getMovementSpeedTest() {
		Character newChar = new Character("Test", 100);
		newChar.setDexterity(12);
		newChar.setHealth(9);
		double expected = ((newChar.getDexterity()+newChar.getHealth())/4);
		assertEquals(newChar.getMovementSpeed(), expected, DELTA);

	}
	
}