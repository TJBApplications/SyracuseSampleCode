package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import milestone3.Armor;

public class ArmorTest {

	@Test
	public void testArmor() {
		var testArmor = new Armor("1", "item1", "item1 des", 100, 5);
		Assert.assertSame(testArmor, testArmor);
	}
}
