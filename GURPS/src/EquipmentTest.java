import static org.junit.Assert.*;

import org.junit.Test;

public class EquipmentTest {

	@Test
	public void itemConstructorTest() {
		Equipment.Item ring = new Equipment.Item("Ring", 20, 0.0);
		
		assertEquals("Ring", ring.getDescription());
		assertEquals(20, ring.getValue());
		assertEquals(0.0, ring.getWeight());
	}
	
	@Test
	public void leatherJacketConstructorTest() {
		Equipment.Armor.LeatherJacket leatherJacket = new Equipment.Armor.LeatherJacket(8);
		
		assertEquals("Leather Jacket", leatherJacket.getDescription());
		assertEquals(50, leatherJacket.getValue());
		assertEquals(4.0, leatherJacket.getWeight());
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
		assertEquals(2.0, buckler.getWeight());
		assertEquals(1, buckler.getPassiveDefense());
	}
	
	@Test
	public void daggerConstructorTest() {
		Equipment.Weapon.HandWeapon.Dagger dagger = new Equipment.Weapon.HandWeapon.Dagger();
		
		assertEquals("Dagger", dagger.getDescription());
		assertEquals(20, dagger.getValue());
		assertEquals(0.25, dagger.getWeight());
		assertEquals(0, dagger.getMinimumStrength());
		assertEquals(Equipment.Weapon.DAMAGE_TYPE_IMPALING, dagger.getDamageType());
	}
	
	@Test
	public void smallKnifeConstructorTest() {
		Equipment.Weapon.HandWeapon.SmallKnife smallKnife = new Equipment.Weapon.HandWeapon.SmallKnife();
		assertEquals("Small knife", smallKnife.getDescription());
		assertEquals(30, smallKnife.getValue());
		assertEquals(0.5, smallKnife.getWeight());
		assertEquals(0, smallKnife.getMinimumStrength());
		assertEquals(Equipment.Weapon.DAMAGE_TYPE_CUTTING & Equipment.Weapon.DAMAGE_TYPE_IMPALING, smallKnife.getDamageType());
	}
}