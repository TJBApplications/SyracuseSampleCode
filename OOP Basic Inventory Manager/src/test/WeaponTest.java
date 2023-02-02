package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import milestone3.Weapon;

public class WeaponTest {

	@Test
	public void test() {
		var testWeapon = new Weapon("1", "item1", "item1 des", 100, 5);
		Assert.assertSame(testWeapon, testWeapon);
	}
}
