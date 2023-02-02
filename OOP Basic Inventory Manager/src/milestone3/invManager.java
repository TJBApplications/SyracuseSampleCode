package milestone3;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Comparator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Inventory Manager class that is an ArrayList of the available salableProducts. Currently this ArrayList is static and only has the five necessary items in inventory. 
 * @author Tyler Brown
 *
 */

public class invManager {
	
	ArrayList<salableProduct> productInv = new ArrayList<salableProduct>(); //Creates an ArrayList of type salableProduct named productInv
	ArrayList<salableProduct> shoppingcart = new ArrayList<salableProduct>();
	
	/**
	 * Uses the Collection Framework to sort the productInv ArrayList based on the users input.
	 */
	public void sortArrayChoice()	{
		
		System.out.println("Would you like to sort the inventory? [1] alphabetically [2] price [3] itemID (Enter corresponding action number)");
		
		int input = sc.nextInt();
		
		if (input == 3)	{
			{
				
				Collections.sort(productInv, new Comparator<salableProduct>()	{
			
				public int compare(salableProduct sp1, salableProduct sp2)	{
					return sp1.getItemID().compareTo(sp2.getItemID());
				}
			});
		}
		}
					
		if (input == 1)	{
			
			System.out.println("[1] Ascending or [2] descending order?");
			int input1 = sc.nextInt();
			
			if (input1 == 1)	{
			
					Collections.sort(productInv, new Comparator<salableProduct>()	{
				
					public int compare(salableProduct sp1, salableProduct sp2)	{
						return sp1.getName().compareTo(sp2.getName());
					}
				});
			}
			
			if (input1 == 2)	{
				
				Collections.sort(productInv, new Comparator<salableProduct>()	{
			
				public int compare(salableProduct sp1, salableProduct sp2)	{
					return sp2.getName().compareTo(sp1.getName());
				}
			});
			}
		}		
		
		if (input == 2)	{
			
			System.out.println("[1] Ascending or [2] descending order?");
			int input2 = sc.nextInt();
			
			if (input2 == 1)	{
				
				Collections.sort(productInv, new Comparator<salableProduct>()	{
					
					public int compare(salableProduct sp1, salableProduct sp2)	{
					return Double.compare(sp1.getPrice(), sp2.getPrice());				
					}
				});
			}
			
			if (input2 == 2)	{
				
				Collections.sort(productInv, new Comparator<salableProduct>()	{
					
					public int compare(salableProduct sp1, salableProduct sp2)	{
					return Double.compare(sp2.getPrice(), sp1.getPrice());				
					}
				});
			}
		}
	}
	
	/**
	 * 
	 * @param filename name of json file that holds the product inventory
	 * @return returns productInventory array
	 */
	
	public ArrayList<salableProduct> makeInventory(String filename)	{
	
		try	{
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			while(s.hasNext())	{
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				salableProduct productInvItem = objectMapper.readValue(json, salableProduct.class);
				productInv.add(productInvItem);
			}
			s.close();
		}
		
		catch (IOException e)	{
			e.printStackTrace();
		}
		
		return productInv;
	}
	
	/**
	 * 
	 * @param input index of item
	 * @return returns quantity of the item
	 */
	
	public int getQuantityShop(int input)	{
		return productInv.get(input).getQuantity();
	}

	/**
	 * Prints the inventory in the ArrayList and provides identifiers for the user.
	 */
	
	public void printInv()	{
		
		System.out.println("The inventory of items available is below");
		
		for (int i = 0; i < productInv.size(); i++)	{
			System.out.println(productInv.get(i));
		}
	}
	
	//---------------------------- START OF SHOPPINGCART ----------------------------------------//
	

	/**
	 * 
	 * @param filename name of the file used to create product inventory
	 * @return returns the shoppingcart array with item quantity of 0
	 */
	
	public ArrayList<salableProduct> makeShoppingCart(String filename)	{
		
		try	{
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			while(s.hasNext())	{
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				salableProduct productInvItem = objectMapper.readValue(json, salableProduct.class);
				shoppingcart.add(productInvItem);
			}
			s.close();
		}
		
		catch (IOException e)	{
			e.printStackTrace();
		}
		
		for (int i = 0; i < shoppingcart.size(); ++i)	{
			shoppingcart.get(i).setQuantity(0);
		}
		
		return shoppingcart;
	}
		
		Scanner sc = new Scanner(System.in);
		
	/**
	 * removeFromCart method removes items from the cart. Uses shopping cart array. 
	 */
		public void removeFromCart()	{
			
			System.out.println("What item would you like to remove from the cart? (1, 2, 3, 4, 5, etc.)");
			int input = sc.nextInt() - 1;
			
			if (shoppingcart.get(input).getQuantity() < 1)
				System.out.println("That is not a valid shopping cart item");
			
			else	{
				shoppingcart.get(input).setQuantity(getQuantityCart(input) - 1);
				productInv.get(input).setQuantity(getQuantityShop(input) + 1);
			}
		}
		
		/**
		 * addToCart method that allows the user to add specific items to the cart. Additional changes need to be made. 
		 */
		
		public void addToCart()	{ //When the addToCart method is called, the user is prompted to enter an item to add to the cart.
									//Then the add method from shoppingCart is called that adds the items to the shopping cart. 
			
			System.out.println("What item would you like to add to the cart? (1, 2, 3, 4, 5)");
			int input = sc.nextInt() - 1;
					
			shoppingcart.get(input).setQuantity(getQuantityCart(input) + 1);
			productInv.get(input).setQuantity(getQuantityShop(input) - 1);
		}
		
		/**
		 * 
		 * @param input index of item in cart
		 * @return returns quantity in cart
		 */
		
		public int getQuantityCart(int input) {
			return shoppingcart.get(input).getQuantity();
		}

		/**
		 * printCart method that loops through the shopping cart array and prints the items in it to the console.
		 */
		
		public void printCart()	{
			int k = 0;
			
			for (int i = 1; i < shoppingcart.size() + 1; i++)	{
				if (shoppingcart.get(i - 1).getQuantity() > 0)	{
				System.out.println(shoppingcart.get(i - 1).getItemID() + ": " + shoppingcart.get(i - 1).getName() + "\n Description: " + shoppingcart.get(i - 1).getDescription() + "\nPrice: " + shoppingcart.get(i - 1).getPrice() + "\n Quantity: " + shoppingcart.get(i - 1).getQuantity() +"\n");
				++k;
				}
			}
			
			if (k == 0)
				System.out.println("Your shopping cart is empty");
		}
		
		/**
		 * Empties the shopping cart and returns the inventory to the store. 
		 */
		
		public void emptyCart()	{
			for (int i = 0; i < shoppingcart.size(); i++)	{
				shoppingcart.get(i).setQuantity(0);
				productInv.get(i).setQuantity(5);
			}
			System.out.println("Your shopping cart has been emptied and all items are returned to the store");
		}
}

