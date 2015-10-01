import static org.junit.Assert.*;

import org.junit.Test;


public class DieTest {

	@Test
	public void test() {
		
		Die d = new Die();
		assertTrue(d.value>=1 && d.value<=6);
	}

}
