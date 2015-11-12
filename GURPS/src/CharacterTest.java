import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class CharacterTest {

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
}