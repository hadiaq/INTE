
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
	
		// Attack types
		public enum AttackType {THRUSTING, SWINGING};

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

		// Hämtat från tabell sida 18
		public static DiceRoll calculateBasicWeaponDamage(int strength, AttackType attackType) {
			if (strength <= 0) {
				throw new IllegalArgumentException();
			} else if (strength > 0 && strength <= 4) {
				return new DiceRoll(0, 0);
			} else {
				if (strength == 5)
					return new DiceRoll(1, -5);
				else if (strength == 6)
					return new DiceRoll(1, -4);
				else if (strength == 7)
					return new DiceRoll(1, -3);
				else if (strength == 8) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, -3);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(1, -2);
					}
				} else if (strength == 9) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, -2);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(1, -1);
					}
				} else if (strength == 10) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, -2);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(1, 0);
					}
				} else if (strength == 11) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, -1);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(1, 1);
					}
				} else if (strength == 12) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, -1);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(1, 2);
					}
				} else if (strength == 13) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, 0);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(2, -1);
					}
				} else if (strength == 14) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, 0);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(2, 0);
					}
				} else if (strength == 15) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, 1);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(2, 1);
					}
				} else if (strength == 16) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, 1);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(2, 2);
					}
				} else if (strength == 17) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, 2);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(3, -1);
					}
				} else if (strength == 18) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(1, 2);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(3, 0);
					}
				} else if (strength == 19) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(2, -1);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(3, 1);
					}
				} else if (strength == 20) {
					if (attackType == AttackType.THRUSTING) {
						return new DiceRoll(2, -1);
					} else if (attackType == AttackType.SWINGING) {
						return new DiceRoll(3, 2);
					}
				}

				return null;
			}
		}	

		public abstract int calculateWeaponDamage(int damageType);

		public abstract static class HandWeapon extends Weapon {
			public HandWeapon(String description, int value, double weight, int minimumStrength, int damageType) {
				super(description, value, weight, minimumStrength, damageType);
			}
			
			public static class Dagger extends HandWeapon {
				public Dagger() {
					super("Dagger", 20, 0.25, 0, DAMAGE_TYPE_IMPALING);
				}

				@Override
				public int calculateWeaponDamage(int damageType) {
					if (damageType == DAMAGE_TYPE_IMPALING) {
						// Cutting attack, thr-1 (from weapon table)
						return -1;
					} else {
						throw new IllegalArgumentException();
					}
				}
			}
			
			public static class SmallKnife extends HandWeapon {
				public SmallKnife() {
					super("Small knife", 30, 0.5, 0, DAMAGE_TYPE_CUTTING & DAMAGE_TYPE_IMPALING);
				}

				@Override
				public int calculateWeaponDamage(int attackType) {
					if (attackType == DAMAGE_TYPE_CUTTING) {
						// Cutting attack, sw-3 (from weapon table)
						return -3;
					} else if (attackType == DAMAGE_TYPE_IMPALING) {
						// Impaling attack, thr-1 (from weapon table)
						return -1;
					} else {
						throw new IllegalArgumentException();
					}
				}
			}

			public static class Shortsword extends HandWeapon {
				public Shortsword() {
					super("Shortsword", 400, 2.0, 7, DAMAGE_TYPE_CUTTING & DAMAGE_TYPE_IMPALING);
				}

				@Override
				public int calculateWeaponDamage(int attackType) {
					if (attackType == DAMAGE_TYPE_CUTTING) {
						// Cutting attack, sw+0 (from weapon table)
						return 0;
					} else if (attackType == DAMAGE_TYPE_IMPALING) {
						// Impaling attack, thr+0 (from weapon table)
						return 0;
					} else {
						throw new IllegalArgumentException();
					}
				}
			}
		}
	}
}