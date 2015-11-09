public class DiceRoll {
	// T.ex. 2d-5
	private int numberOfDices; // 2
	private int modifier; // -5
	private Die[] dices;
	private int value; // 2d-5

	public DiceRoll(int numberOfDices, int modifier) {
		if (numberOfDices < 0) {
			throw new IllegalArgumentException();
		}
		
		this.numberOfDices = numberOfDices;
		this.modifier = modifier;
		dices = new Die[numberOfDices];

		for (int i = 0; i < numberOfDices; i++) {
			dices[i] = new Die();
			value += dices[i].getValue();
		}

		value += modifier;
	}

	public int getNumberOfDices() {
		return numberOfDices;
	}

	public int getModifier() {
		return modifier;
	}

	public int getValue() {
		return value;
	}
}