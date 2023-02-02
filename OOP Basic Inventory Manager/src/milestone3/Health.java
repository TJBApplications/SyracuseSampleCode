package milestone3;

/**
 * Health class extends the salableProduct superclass as a specific type of health item for sale in the store.
 * There is currently no specialization to these items that differentiate them from a standard salable product (ie. item effect).
 * No default constructor was added as each item should be unique. 
 * @author Tyler Brown
 *
 */

public class Health extends salableProduct {
	
	/**
	 * 
	 * @param itemID itemID that is unique to that item and its effects
	 * @param name name of the health item
	 * @param description description of the health item
	 * @param price price of the health item
	 * @param quantity quantity of that health item available 
	 */

	public Health(String itemID, String name, String description, double price, int quantity) {
		super(itemID, name, description, price, quantity);
	}

}
