import static org.junit.Assert.*;
import org.junit.Test;

public class EquipmentTest {
	private static final double DELTA = 1e-15; // Behövs för assertEquals(double, double, double)

	@Test
	public void calculateBasicThrustingWeaponDamageTest() {
		DiceRoll[] basicThrustingWeaponDamageDiceRolls = {
			new DiceRoll(0, 0),
			new DiceRoll(0, 0),
			new DiceRoll(0, 0),
			new DiceRoll(0, 0),
			new DiceRoll(1, -5),
			new DiceRoll(1, -4),
			new DiceRoll(1, -3),
			new DiceRoll(1, -3),
			new DiceRoll(1, -2),
			new DiceRoll(1, -2),
			new DiceRoll(1, -1),
			new DiceRoll(1, -1),
			new DiceRoll(1, 0),
			new DiceRoll(1, 0),
			new DiceRoll(1, 1),
			new DiceRoll(1, 1),
			new DiceRoll(1, 2),
			new DiceRoll(1, 2),
			new DiceRoll(2, -1),
			new DiceRoll(2, -1)
		};

		for (int strength = 1; strength < 20; strength++) {
			DiceRoll compare = Equipment.Weapon.calculateBasicWeaponDamage(strength, Equipment.Weapon.AttackType.THRUSTING);
		
			assertEquals(basicThrustingWeaponDamageDiceRolls[strength-1].getNumberOfDices(), compare.getNumberOfDices());
			assertEquals(basicThrustingWeaponDamageDiceRolls[strength-1].getModifier(), compare.getModifier());
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void calculateBasicThrustingWeaponDamageZeroOrNegativeStrengthTest() {
		DiceRoll diceRoll = Equipment.Weapon.calculateBasicWeaponDamage(0, Equipment.Weapon.AttackType.THRUSTING);
	}

	@Test(expected=IllegalArgumentException.class)
	public void calculateBasicSwingingWeaponDamageZeroOrNegativeStrengthTest() {
		DiceRoll diceRoll = Equipment.Weapon.calculateBasicWeaponDamage(0, Equipment.Weapon.AttackType.SWINGING);
	}
	
	@Test // Ej definerat när strength > 20 (se tabellen på sidan 18)
	public void calculateBasicThrustingWeaponDamageStrengthOver20Test() {
		assertNull(Equipment.Weapon.calculateBasicWeaponDamage(21, Equipment.Weapon.AttackType.THRUSTING));
	}
	
	@Test // Ej definerat när strength > 20 (se tabellen på sidan 18)
	public void calculateBasicSwingingWeaponDamageStrengthOver20Test() {
		assertNull(Equipment.Weapon.calculateBasicWeaponDamage(21, Equipment.Weapon.AttackType.SWINGING));
	}

	@Test
	public void calculateBasicSwingingWeaponDamageTest() {
		DiceRoll[] basicSwingingWeaponDamageDiceRolls = {
			new DiceRoll(0, 0),
			new DiceRoll(0, 0),
			new DiceRoll(0, 0),
			new DiceRoll(0, 0),
			new DiceRoll(1, -5),
			new DiceRoll(1, -4),
			new DiceRoll(1, -3),
			new DiceRoll(1, -2),
			new DiceRoll(1, -1),
			new DiceRoll(1, 0),
			new DiceRoll(1, 1),
			new DiceRoll(1, 2),
			new DiceRoll(2, -1),
			new DiceRoll(2, 0),
			new DiceRoll(2, 1),
			new DiceRoll(2, 2),
			new DiceRoll(3, -1),
			new DiceRoll(3, 0),
			new DiceRoll(3, 1),
			new DiceRoll(3, 2)
		};

		for (int strength = 1; strength < 20; strength++) {
			DiceRoll compare = Equipment.Weapon.calculateBasicWeaponDamage(strength, Equipment.Weapon.AttackType.SWINGING);
		
			assertEquals(basicSwingingWeaponDamageDiceRolls[strength-1].getNumberOfDices(), compare.getNumberOfDices());
			assertEquals(basicSwingingWeaponDamageDiceRolls[strength-1].getModifier(), compare.getModifier());
		}
	}

	@Test
	public void itemConstructorTest() {
		Equipment.Item ring = new Equipment.Item("Ring", 20, 0.0);
		
		assertEquals("Ring", ring.getDescription());
		assertEquals(20, ring.getValue());
		assertEquals(0.0, ring.getWeight(), DELTA);
	}
	
	@Test
	public void leatherJacketConstructorTest() {
		Equipment.Armor.LeatherJacket leatherJacket = new Equipment.Armor.LeatherJacket(8);
		
		assertEquals("Leather Jacket", leatherJacket.getDescription());
		assertEquals(50, leatherJacket.getValue());
		assertEquals(4.0, leatherJacket.getWeight(), DELTA);
		assertEquals(1, leatherJacket.getPassiveDefense());
		assertEquals(1, leatherJacket.getDamageResistance());
		assertEquals(8, leatherJacket.getTechLevel());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void leatherJacketTooHighTechLevelTest() {
		// TechLevel should be 1-8
		Equipment.Armor.LeatherJacket leatherJacket = new Equipment.Armor.LeatherJacket(9);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void leatherJacketTooLowTechLevelTest() {
		// TechLevel should be 1-8
		Equipment.Armor.LeatherJacket leatherJacket = new Equipment.Armor.LeatherJacket(0);
	}
	
	@Test
	public void bucklerConstructorTest() {
		Equipment.Shield.Buckler buckler = new Equipment.Shield.Buckler();
		
		assertEquals("Buckler", buckler.getDescription());
		assertEquals(25, buckler.getValue());
		assertEquals(2.0, buckler.getWeight(), DELTA);
		assertEquals(1, buckler.getPassiveDefense());
	}
	
	@Test
	public void smallShieldConstructorTest() {
		Equipment.Shield.SmallShield smallShield = new Equipment.Shield.SmallShield();

		assertEquals("Small shield", smallShield.getDescription());
		assertEquals(40, smallShield.getValue());
		assertEquals(8.0, smallShield.getWeight(), DELTA);
		assertEquals(2, smallShield.getPassiveDefense());
	}
	
	@Test
	public void daggerConstructorTest() {
		Equipment.Weapon.HandWeapon.Dagger dagger = new Equipment.Weapon.HandWeapon.Dagger();
		
		assertEquals("Dagger", dagger.getDescription());
		assertEquals(20, dagger.getValue());
		assertEquals(0.25, dagger.getWeight(), DELTA);
		assertEquals(0, dagger.getMinimumStrength());
		assertEquals(Equipment.Weapon.DAMAGE_TYPE_IMPALING, dagger.getDamageType());
	}
	
	@Test
	public void daggerCalculateWeaponDamageTest() {
		Equipment.Weapon.HandWeapon.Dagger dagger = new Equipment.Weapon.HandWeapon.Dagger();

		assertEquals(-1, dagger.calculateWeaponDamage(Equipment.Weapon.DAMAGE_TYPE_IMPALING));
	}

	@Test
	public void smallKnifeConstructorTest() {
		Equipment.Weapon.HandWeapon.SmallKnife smallKnife = new Equipment.Weapon.HandWeapon.SmallKnife();

		assertEquals("Small knife", smallKnife.getDescription());
		assertEquals(30, smallKnife.getValue());
		assertEquals(0.5, smallKnife.getWeight(), DELTA);
		assertEquals(0, smallKnife.getMinimumStrength());
		assertEquals(Equipment.Weapon.DAMAGE_TYPE_CUTTING & Equipment.Weapon.DAMAGE_TYPE_IMPALING, smallKnife.getDamageType());
	}

	@Test
	public void smallKnifeCalculateWeaponDamageTest() {
		Equipment.Weapon.HandWeapon.SmallKnife smallKnife = new Equipment.Weapon.HandWeapon.SmallKnife();

		assertEquals(-3, smallKnife.calculateWeaponDamage(Equipment.Weapon.DAMAGE_TYPE_CUTTING));
		assertEquals(-1, smallKnife.calculateWeaponDamage(Equipment.Weapon.DAMAGE_TYPE_IMPALING));
	}

	@Test
	public void shortswordConstructorTest() {
		Equipment.Weapon.HandWeapon.Shortsword shortsword = new Equipment.Weapon.HandWeapon.Shortsword();

		assertEquals("Shortsword", shortsword.getDescription());
		assertEquals(400, shortsword.getValue());
		assertEquals(2.0, shortsword.getWeight(), DELTA);
		assertEquals(7, shortsword.getMinimumStrength());
		assertEquals(Equipment.Weapon.DAMAGE_TYPE_CUTTING & Equipment.Weapon.DAMAGE_TYPE_IMPALING, shortsword.getDamageType());
	}

	@Test
	public void shortswordCalculateWeaponDamageTest() {
		Equipment.Weapon.HandWeapon.Shortsword shortsword = new Equipment.Weapon.HandWeapon.Shortsword();

		assertEquals(0, shortsword.calculateWeaponDamage(Equipment.Weapon.DAMAGE_TYPE_CUTTING));
		assertEquals(0, shortsword.calculateWeaponDamage(Equipment.Weapon.DAMAGE_TYPE_IMPALING));
	}
}