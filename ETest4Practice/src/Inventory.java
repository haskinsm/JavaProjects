
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 *  Given Item.java and Order.java, develop a program that allows a user to create a collection of items
	for an inventory and uses items to create a collection of orders. To develop this program, you are
	required to:
	Create a Java file called Inventory.java with two instance variables and three methods.
	1. Instance variables:
	The first instance variable represents an items collection (this can be an Array or an
	ArrayList that stores objects of type Item). The second instance variable represents an
	orders collection with objects of type Order.
	2. public void addItem(String itemName, double itemPrice,
	int itemQuantity)
	This method is required create an item (using the provided parameters) and add it to the
	next available position in the items collection. Each item requires a unique ID. What
	happens if there is an item in the item inventory with the same name and price as the item
	to be added?
	3. public void createOrder(Item item)
	This method is required to create an order and add it to the first available position in the
	orders collection. Each order requires a unique ID.
	4. public static void main(String[] args)
	The mainline is required to:
	a. Create an instance of class Inventory
	b. Ask the user how many items he/she would like to create and ask the user for the item
	name, price and quantity for each.
	c. Initialise the items collection and add each item to it by calling the addItem method.
	d. Create an order for each item by calling the createOrder method.
 */
public class Inventory {
	private ArrayList<Item> items;
	private ArrayList<Order> orders;
	
	public Inventory()
	{
		items = new ArrayList<Item>();
		orders = new ArrayList<Order>();
	}
	public void addItem(String itemName, double itemPrice, int itemQuantity)
	{
		boolean uniqueNumber = true;
		long uniqueId;
		do{
			Random generator = new Random();
			uniqueId = generator.nextLong();
			for(int i = 0; i < items.size(); i++)
			{
				if(items.get(i).getId() == uniqueId)
				{
					uniqueNumber = false;
				}
			}
		}while(!uniqueNumber);
		boolean uniqueItem = true;
		for(int i = 0; i < items.size() && uniqueItem; i++)
		{
			if(items.get(i).getName().equals(itemName) && items.get(i).getPrice() == itemPrice)
			{
				uniqueItem = false;
				itemQuantity += items.get(i).getQuantity();
				uniqueId = items.get(i).getId();
				itemName = items.get(i).getName();
				itemPrice = items.get(i).getPrice();
			}
		}
		Item item = new Item(uniqueId, itemName, itemPrice, itemQuantity);
		items.add(item);
	}
	
	public void createOrder(Item item)
	{
		boolean uniqueNumber = true;
		int uniqueId;
		do{
			Random generator = new Random();
			uniqueId = generator.nextInt();
			for(int i = 0; i < items.size(); i++)
			{
				if(items.get(i).getId() == uniqueId)
				{
					uniqueNumber = false;
				}
			}
		}while(!uniqueNumber);
		Order order = new Order(item);
		order.setOrderID(uniqueId);
		orders.add(order);
	}
	
	public static void main(String[] args)
	{
		Inventory inventory = new Inventory();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter how many items you want to add: ");
		int noItems = scanner.nextInt();
		for(int i = 0; i <= noItems; i++)
		{
			System.out.println("Enter the name, price and quantity of the item seperated by a space." );
			scanner.useDelimiter(" ");
			scanner = new Scanner(System.in);
			String name = scanner.next();
			double itemPrice = scanner.nextDouble();
			int quantity = scanner.nextInt();
			inventory.addItem(name, itemPrice, quantity);
		}
		for(int i = 0; i< inventory.items.size(); i++)
		{
			Item item = inventory.items.get(i);
			inventory.createOrder(item);
		}
		String list = "";
		for(int i = 0; i< inventory.items.size(); i++)
		{
			Item item = inventory.items.get(i);
			list += "\n" + item.toString() + "\n";
		}
		System.out.println(list);
		scanner.close();
	}
}
