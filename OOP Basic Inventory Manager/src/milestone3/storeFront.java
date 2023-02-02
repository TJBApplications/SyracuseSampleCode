package milestone3;

import java.util.*;

/**
 * Storefront class that the user of the store will interact with. Creates a shopping cart object and allows the users to move items into and out of the shopping cart.
 * @author Tyler Brown
 *
 */

public class storeFront {
	
	/**
	 * 
	 * @param args Main method for the program.
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		invManager invManager1 = new invManager(); //creates new invManager that is used throughout the storefront. Important to avoid different inventories later on. 
		
		System.out.println("Welcome to the Milestone VII StoreFront! Would you like to see the items we have for sale? (Y/N)"); //Shows the start of the store to the user. 
		
	
		if (sc.next().equals("Y"))	{
			invManager1.makeInventory("productInventory.json");
			invManager1.makeShoppingCart("productInventory.json");
			
			
			System.out.println("The store is open. Available items are below: \n");
			invManager1.printInv(); //Prints out the current inventory of the store
		}
			
		else	{
			System.out.println("Okay, feel free to come back to the store any time. Enjoy your adventure!");
			System.exit(0); //Exits program if the user wants to not see the store. 
		}
	
		for (int i = 0; i < 100; ++i)	{ //For loop to allow the user  to do a variety of options. 
			
			System.out.println("Enter number command for next action: [1] Add item to cart [2] Remove item from cart [3] See all items in cart [4] See all items in store [5] Empty Cart [6] Exit");
			
			int input = sc.nextInt(); //Stores users input
			
			if (input == 1)
				invManager1.addToCart(); //Add to cart method is called
			
			if (input == 2)	{
				invManager1.printCart(); //Prints the items currently in the cart
				invManager1.removeFromCart(); //Remove from cart function is called
			}
			
			if (input == 3) {
				invManager1.printCart(); //Prints the items currently in the cart
			}
			
			if (input == 4)	{
				invManager1.sortArrayChoice();
				invManager1.printInv(); //Prints the items currently available in the inventory manager
			}
			
			if (input == 5)	{
				invManager1.emptyCart();
			}
			
			if (input == 6)	{
				System.exit(0);
			}
			
			if (input > 6 || input < 1)
				System.out.println("That is not a vaild command, please enter the number attached the action you would like to take.");
		}
	}		
}


