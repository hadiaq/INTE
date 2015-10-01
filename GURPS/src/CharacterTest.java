import static org.junit.Assert.*;

import org.junit.Test;


public class CharacterTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Character newChar = new Character(100);
		assertEquals(10, newChar.getStrength());
		assertEquals(10, newChar.getDexterity());
		assertEquals(10, newChar.getIntelligence());
		assertEquals(10, newChar.getHealth());
		assertEquals(100, newChar.getPoints());
	}

}
