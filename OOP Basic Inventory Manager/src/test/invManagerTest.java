package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import milestone3.invManager;
import milestone3.salableProduct;

public class invManagerTest {

	@Test
	public void testSortArrayChoice() {
		invManager invManager1 = new invManager();
		ArrayList<salableProduct> productInv = new ArrayList<salableProduct>();
		ArrayList<salableProduct> productInv1 = new ArrayList<salableProduct>();
		productInv = invManager1.makeInventory("productInventory.json");
		productInv1 = invManager1.makeInventory("productInventory.json");
		
		{
			Collections.sort(productInv, new Comparator<salableProduct>()	{
		
			public int compare(salableProduct sp1, salableProduct sp2)	{
				return sp1.getName().compareTo(sp2.getName());
			}
		});
	}
	{
			Collections.sort(productInv1, new Comparator<salableProduct>()	{
		
			public int compare(salableProduct sp1, salableProduct sp2)	{
				return sp1.getName().compareTo(sp2.getName());
			}
		});
	}
	
	Assert.assertEquals(productInv1, productInv);
	}

	@Test
	public void testMakeInventory() {
		invManager invManager1 = new invManager();
		
		ArrayList<salableProduct> productInv = new ArrayList<salableProduct>();
		ArrayList<salableProduct> productInv1 = new ArrayList<salableProduct>();
		
		productInv = invManager1.makeInventory("productInventory.json");
		productInv1 = invManager1.makeInventory("productInventory.json");
		
		Assert.assertArrayEquals(productInv.toArray(), productInv1.toArray());
	}

	@Test
	public void testGetQuantityShop() {
		invManager invManager1 = new invManager();
		ArrayList<salableProduct> productInv = new ArrayList<salableProduct>();
		productInv = invManager1.makeInventory("productInventory.json");
		
		int testQuantity = productInv.get(0).getQuantity();
		
		Assert.assertEquals(testQuantity, invManager1.getQuantityShop(0));
	}

	@Test
	public void testMakeShoppingCart() {
		invManager invManager1 = new invManager();
		
		ArrayList<salableProduct> cartInv = new ArrayList<salableProduct>();
		ArrayList<salableProduct> cartInv1 = new ArrayList<salableProduct>();
		
		cartInv = invManager1.makeInventory("productInventory.json");
		cartInv1 = invManager1.makeInventory("productInventory.json");
		
		Assert.assertArrayEquals(cartInv.toArray(), cartInv1.toArray());
	}

	@Test
	public void testRemoveFromCart() {
		invManager invManager1 = new invManager();
		int input = 0;
		
		ArrayList<salableProduct> cartInv = new ArrayList<salableProduct>();
		ArrayList<salableProduct> cartInv1 = new ArrayList<salableProduct>();
		
		cartInv = invManager1.makeShoppingCart("productInventory.json");
		cartInv1 = invManager1.makeShoppingCart("productInventory.json");
		
		cartInv.get(input).setQuantity(invManager1.getQuantityCart(input) - 1);
		cartInv1.get(input).setQuantity(invManager1.getQuantityCart(input) - 1);
		
		int inv = cartInv.get(input).getQuantity();
		int inv1 = cartInv1.get(input).getQuantity();
		
		Assert.assertEquals(inv, inv1);
	}

	@Test
	public void testAddToCart() {
		invManager invManager1 = new invManager();
		int input = 0;
		
		ArrayList<salableProduct> cartInv = new ArrayList<salableProduct>();
		ArrayList<salableProduct> cartInv1 = new ArrayList<salableProduct>();
		
		cartInv = invManager1.makeShoppingCart("productInventory.json");
		cartInv1 = invManager1.makeShoppingCart("productInventory.json");
		
		cartInv.get(input).setQuantity(invManager1.getQuantityCart(input) + 1);
		cartInv1.get(input).setQuantity(invManager1.getQuantityCart(input) + 1);
		
		int inv = cartInv.get(input).getQuantity();
		int inv1 = cartInv1.get(input).getQuantity();
		
		Assert.assertEquals(inv, inv1);
	}

	@Test
	public void testGetQuantityCart() {
		invManager invManager1 = new invManager();
		int input = 0;
		
		ArrayList<salableProduct> cartInv = new ArrayList<salableProduct>();
		
		cartInv = invManager1.makeShoppingCart("productInventory.json");
		
		int inv = cartInv.get(input).getQuantity();
		
		Assert.assertEquals(inv, cartInv.get(input).getQuantity());
	}

	@Test
	public void testEmptyCart() {
		
		invManager invManager1 = new invManager();
		int input = 0;
		
		ArrayList<salableProduct> cartInv = new ArrayList<salableProduct>();

		
		cartInv = invManager1.makeShoppingCart("productInventory.json");

		
		cartInv.get(input).setQuantity(0);

		Assert.assertEquals(0, cartInv.get(0).getQuantity());
	}

}
