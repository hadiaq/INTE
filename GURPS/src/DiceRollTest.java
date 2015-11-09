import static org.junit.Assert.*;

import org.junit.Test;


public class DiceRollTest {

	@Test
	public void constructorTest() {
		int numberOfDices = 3;
		int modifier = -2;
		int minimumPossibleValue = numberOfDices * Die.MIN_VALUE + modifier;
		int maximumPossibleValue = numberOfDices * Die.MAX_VALUE + modifier;

		DiceRoll diceRoll = new DiceRoll(numberOfDices, modifier);

		assertEquals(diceRoll.getNumberOfDices(), numberOfDices);
		assertEquals(diceRoll.getModifier(), modifier);
		assertTrue(diceRoll.getValue() >= minimumPossibleValue && diceRoll.getValue() <= maximumPossibleValue);
	}

	// -2d+2 inte tillåtet!
	@Test(expected=IllegalArgumentException.class)
	public void negativeNumberOfDicesTest() {
		DiceRoll diceRoll = new DiceRoll(-2, 2);
	}
}