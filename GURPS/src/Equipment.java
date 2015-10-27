
public final class Equipment {
	
	static class Item {
		private String description; // t.ex. "Chainmail", "Flail"
		private int value;
		private double weight;

		public Item(String description, int value, double weight) {
			this.description = description;
			this.value = value;
			this.weight = weight;
		}
		
		public String getDescription() {
			return description;
		}
		
		public int getValue() {
			return value;
		}
		
		public double getWeight() {
			return weight;
		}
	}
	
	static class Armor extends Item {
		private int passiveDefense;
		private int damageResistance;
		
		public Armor(String description, int value, double weight, int passiveDefense, int damageResistance) {
			super(description, value, weight);
			
			this.passiveDefense = passiveDefense;
			this.damageResistance = damageResistance;
		}
		
		public int getPassiveDefense() {
			return passiveDefense;
		}
		
		public int getDamageResistance() {
			return damageResistance;
		}
	}
}
