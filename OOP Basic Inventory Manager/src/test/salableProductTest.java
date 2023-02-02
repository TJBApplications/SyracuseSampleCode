package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.sym.Name;

import milestone3.salableProduct;

public class salableProductTest {

	@Test
	public void testSalableProductStringStringStringDoubleInt() {
		salableProduct testproduct = new salableProduct("1", "item1", "item1 des", 100, 5);
		Assert.assertSame(testproduct, testproduct);
	}

	@Test
	public void testSalableProduct() {
		salableProduct testproduct = new salableProduct();
		Assert.assertSame(testproduct, testproduct);
	}

	@Test
	public void testSalableProductSalableProduct() {
		salableProduct testproduct = new salableProduct();
		salableProduct testproduct1 = new salableProduct(testproduct);
		Assert.assertSame(testproduct1, testproduct1);
	}

	@Test
	public void testToString() {
		String itemID = "item";
		String name = "";
		String description = "";
		double price = 0;
		int quantity = 0;
		
		salableProduct testproduct = new salableProduct(); 
		
		Assert.assertEquals(testproduct.toString(), (itemID + ": " + name + "\n Description: " + description + "\n Price: " + price + "\n Quantity: " + quantity + "\n"));
	}
}
