package milestone3;

/**
 * salableProduct class that creates the product objects that are for sale in the store. 
 * @author Tyler Brown
 *
 */

public class salableProduct {
	
	private String itemID;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	/**
	 * Constructor for the salableProduct objects that are used through the program. 
	 * @param itemID itemID that is unique to that item and its effects
	 * @param name name of the salableProduct (sP)
	 * @param description short description of the salableProduct (sP)
	 * @param price price of the salableProduct (sP)
	 * @param quantity quantity of the salableProduct (sP) available
	 */
	public salableProduct (String itemID, String name, String description, double price, int quantity)	{
		this.itemID = itemID;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public salableProduct()	{
		itemID = "item";
		name = "";
		description = "";
		price = 0;
		quantity = 0;
	}
	
	public salableProduct(salableProduct salableproduct)	{
		
	}
	
	/**
	 * 
	 * @return returns the items ID
	 */
	
	public String getItemID()	{
		return itemID;
	}
	
	/**
	 * 
	 * @param itemID Sets the items ID
	 */
	
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	/**
	 * 
	 * @return returns the sP name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name sets the sP name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return returns the sP description
	 */

	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @param description gets the sP description
	 */

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return returns the sP price
	 */

	public double getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price sets the sP price
	 */

	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return returns the sP quantity available
	 */

	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * @param quantity sets the sP quantity available
	 */

	public void setQuantity(int quantity) {
	
		this.quantity = quantity;
	}
	
	/**
	 * Overrides toString to print out the salable products correctly
	 */
	
	@Override
	public String toString()	{
		
		return itemID + ": " + name + "\n Description: " + description + "\n Price: " + price + "\n Quantity: " + quantity + "\n"; 

	}	
}
