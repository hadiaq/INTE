
public final class Equipment {
	
	public static class Item {
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
	
	public abstract static class Armor extends Item {
		private int passiveDefense;
		private int damageResistance;
		private int techLevel;
		
		public Armor(String description, int value, double weight, int passiveDefense, int damageResistance, int techLevel) {
			super(description, value, weight);
			
			this.passiveDefense = passiveDefense;
			this.damageResistance = damageResistance;
			this.techLevel = techLevel;
		}
		
		public int getPassiveDefense() {
			return passiveDefense;
		}
		
		public int getDamageResistance() {
			return damageResistance;
		}
		
		public int getTechLevel() {
			return techLevel;
		}
		
		public static class LeatherJacket extends Armor {
			public LeatherJacket(int techLevel) {
				super("Leather Jacket", 50, 4.0, 1, 1, techLevel);
				
				if (techLevel < 1 || techLevel > 8) {
					throw new IllegalArgumentException();
				}
			}
		}
	}
	
	public abstract static class Shield extends Item {
		private int passiveDefense;
		
		public Shield(String description, int value, double weight, int passiveDefense) {
			super(description, value, weight);
			
			this.passiveDefense = passiveDefense;
		}
		
		public int getPassiveDefense() {
			return passiveDefense;
		}
		
		public static class Buckler extends Shield {
			public Buckler() {
				super("Buckler", 25, 2.0, 1);
			}
		}
	}
	
	public abstract static class Weapon extends Item {
		private int minimumStrength; // Minimum strength to wield the weapon
		private int damageType; // Any combination of impaling, cutting and crushing
		
		// damageType flags
		public static final int DAMAGE_TYPE_IMPALING = 1; // 001
		public static final int DAMAGE_TYPE_CUTTING  = 2; // 010
		public static final int DAMAGE_TYPE_CRUSHING = 4; // 100
	
		public Weapon(String description, int value, double weight, int minimumStrength, int damageType) {
			super(description, value, weight);
			
			this.minimumStrength = minimumStrength;
			this.damageType = damageType;
		}
		
		public int getMinimumStrength() {
			return minimumStrength;
		}
		
		public int getDamageType() {
			return damageType;
		}
		
		public abstract static class HandWeapon extends Weapon {
			public HandWeapon(String description, int value, double weight, int minimumStrength, int damageType) {
				super(description, value, weight, minimumStrength, damageType);
			}
			
			public static class Dagger extends HandWeapon {
				public Dagger() {
					super("Dagger", 20, 0.25, 0, DAMAGE_TYPE_IMPALING);
				}
			}
			
			public static class SmallKnife extends HandWeapon {
				public SmallKnife() {
					super("Small knife", 30, 0.5, 0, DAMAGE_TYPE_CUTTING & DAMAGE_TYPE_IMPALING);
				}
			}
		}
	}
}