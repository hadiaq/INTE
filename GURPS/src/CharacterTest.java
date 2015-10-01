import static org.junit.Assert.*;

import org.junit.Test;


public class CharacterTest {

	@Test
	public void constructorTest() {
		//fail("Not yet implemented");
		Character newChar = new Character(100);
		assertEquals(10, newChar.getStrength());
		assertEquals(10, newChar.getDexterity());
		assertEquals(10, newChar.getIntelligence());
		assertEquals(10, newChar.getHealth());
		assertEquals(100, newChar.getPoints());
	}
	
	@Test
	public void setStrengthTest() {
		Character newChar = new Character(100);
		newChar.setStrength(12);
		assertEquals(12, newChar.getStrength());
	}
	
	@Test
	public void setDexterityTest() {
		Character newChar = new Character(100);
		newChar.setDexterity(17);
		assertEquals(17, newChar.getDexterity());
	}
	
	@Test
	public void setIntelligenceTest() {
		Character newChar = new Character(100);
		newChar.setIntelligence(9);
		assertEquals(9, newChar.getIntelligence());
	}

	@Test
	public void setHealthTest() {
		Character newChar = new Character(100);
		newChar.setHealth(13);
		assertEquals(13, newChar.getHealth());
	}
}
