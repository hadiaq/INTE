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
		
		assertEquals("Leather Jacket", armor.getDescription());
		assertEquals(50, leatherJacket.getValue());
		assertEquals(4.0, leatherJacket.getWeight());
		assertEquals(1, leatherJacket.getPassiveDefense());
		assertEquals(1, leatherJacket.getDamageResistance());
	}
}