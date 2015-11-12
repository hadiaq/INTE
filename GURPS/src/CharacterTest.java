import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class CharacterTest {

	@Test
	public void constructorTest() {
		Character newChar = new Character("Test", 100);
		assertEquals(Character.State.Idle, newChar.getState());
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
	public void isAttackingTest() {
		Character newChar = new Character("Test", 100);
		assertNotEquals(Character.State.Attacking, newChar.getState());
	}

	@Test
	public void isParryingTest() {
		Character newChar = new Character("Test", 100);
		assertNotEquals(Character.State.Parrying, newChar.getState());
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
}
