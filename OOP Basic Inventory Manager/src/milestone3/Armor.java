package milestone3;

/**
 * Armor class extends the salableProduct superclass as a specific type of armor for sale in the store.
 * There is currently no specialization to these items that differentiate them from a standard salable product (ie. item effect).
 * No default constructor was added as each item should be unique. 
 * @author Tyler Brown
 *
 */

public class Armor extends salableProduct {
	
	/**
	 * 
	 * @param itemID itemID that is unique to that item and its effects
	 * @param name name of the armor item
	 * @param description description of the armor item
	 * @param price price of the armor item
	 * @param quantity quantity of that armor item available 
	 */

	public Armor(String itemID, String name, String description, double price, int quantity) {
		super(itemID, name, description, price, quantity);
	}
}
