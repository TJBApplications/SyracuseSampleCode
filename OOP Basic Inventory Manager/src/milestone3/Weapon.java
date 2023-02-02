package milestone3;

/**
 * Weapon class extends the salableProduct superclass as a specific type of weapon for sale in the store.
 * There is currently no specialization to these items that differentiate them from a standard salable product (ie. item effect).
 * No default constructor was added as each item should be unique. 
 * @author Tyler Brown
 *
 */

public class Weapon extends salableProduct implements salableProductInterface, Comparable<Weapon> {
	
	/**
	 * 
	 * @param itemID itemID that is unique to that item and its effects
	 * @param name name of the weapon item
	 * @param description description of the weapon item
	 * @param price price of the weapon item
	 * @param quantity quantity of that weapon item available 
	 */

	public Weapon(String itemID, String name, String description, double price, int quantity) {
		super(itemID, name, description, price, quantity);
	}

	@Override
	public int compareTo(Weapon o) {
		int value = this.getName().compareTo(o.getName());
		if (value == 0)	{
		return this.getName().compareTo(o.getName());
		}
		else
			return value;
	}

}
