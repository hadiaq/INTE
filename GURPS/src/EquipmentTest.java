import static org.junit.Assert.*;

import org.junit.Test;

public class EquipmentTest {

	@Test
	public void itemConstructorTest() {
		Equipment.Item item = new Equipment.Item("Ring", 20, 0.01);
		assertEquals("Ring", item.getDescription());
		assertEquals(20, item.getValue());
		assertEquals(0.01, item.getWeight());
	}
}