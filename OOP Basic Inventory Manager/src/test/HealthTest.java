package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import milestone3.Health;

public class HealthTest {

	@Test
	public void test() {
		var testHealth = new Health("1", "item1", "item1 des", 100, 5);
		Assert.assertSame(testHealth, testHealth);
	}

}
