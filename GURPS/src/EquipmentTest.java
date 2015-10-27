import static org.junit.Assert.*;

import org.junit.Test;

public class EquipmentTest {

	@Test
	public void itemConstructorTest() {
		Equipment.Item ring = new Equipment.Item("Ring", 20, 0.01);
		
		assertEquals("Ring", ring.getDescription());
		assertEquals(20, ring.getValue());
		assertEquals(0.01, ring.getWeight());
	}
	
	@Test
	public void armorConstructorTest() {
		Equipment.Armor leatherJacket = new Equipment.Armor("Leather Jacket", 50, 4.0, 1, 1);
		
		assertEquals("Leather Jacket", leatherJacket.getDescription());
		assertEquals(50, leatherJacket.getValue());
		assertEquals(4.0, leatherJacket.getWeight());
		assertEquals(1, leatherJacket.getPassiveDefense());
		assertEquals(1, leatherJacket.getDamageResistance());
	}
	
	@Test
	public void shieldConstructorTest() {
		Equipment.Shield buckler = new Equipment.Shield("Buckler", 25, 2.0, 2);
		
		assertEquals("Buckler", buckler.getDescription());
		assertEquals(25, buckler.getValue());
		assertEquals(2.0, buckler.getWeight());
		assertEquals(2, buckler.getPassiveDefense());
	}
}