/*
 Warehouse Inventory System Using HashMap
Problem Statement:
Create a Warehouse Inventory Management System using a HashMap where:

The keys are product IDs (unique integers).
The values are Product objects that contain:
String productName - Name of the product.
int quantity - Quantity of the product in stock.
double price - Price per unit.
Requirements:

Write a program to:
Add products to the inventory.
Update the quantity of a product when a new shipment arrives or when products are sold.
Delete a product from the inventory when it is discontinued.
Calculate the total value of all products in the inventory (quantity × price for all products).
Find the product with the highest total value in stock (quantity × price for a single product).
Ensure all operations are efficient, leveraging HashMap methods.
 */
import java.util.*;

class Product
{
	private int id, quantity;
	private double price;
	
	public Product(int id, int quantity, double price)
	{
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || this.getClass() != obj.getClass()) return false;
		Product prod = (Product) obj;
		return this.getId()==prod.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
	
	@Override
	public String toString() {
		return "Product {ID: "+this.getId()+" Quantity: "+this.getQuantity()+" Price: "+this.getPrice()+"}";
	}
}
public class HashMapPractice2 {

	public static HashMap<Integer, Product> addProducts(int n, HashMap<Integer, Product> inventory, int addID, Scanner in)
	{
		for(int i=0; i<n; i++) 
		{
			System.out.print("Enter Product "+(i+1)+" Quantity: ");
			int quantity = in.nextInt();
			System.out.print("Enter Product "+(i+1)+" Price Per Unit: ");
			double price = in.nextDouble();
			System.out.println();
			inventory.put(addID+i+1, new Product(addID+i+1, quantity, price));
		}
		return inventory;
	}
	
	public static void totalValue(HashMap<Integer, Product> inventory)
	{
		if(inventory.isEmpty())
		{
			System.out.println("\nInventory is empty.\n");
		}
		else
		{
			double tvalue = 0;
			for(Map.Entry<Integer, Product> entry : inventory.entrySet())
			{
				tvalue += entry.getValue().getPrice()*entry.getValue().getQuantity();
			}
			System.out.println("\nTotal value of the inventory: "+tvalue+"\n");
		}
	}
	
	public static void highestValue(HashMap<Integer, Product> inventory)
	{
		if(inventory.isEmpty())
		{
			System.out.println("\nInventory is empty.\n");
		}
		else
		{
			double hvalue = Double.MIN_VALUE;
			for(Map.Entry<Integer, Product> entry : inventory.entrySet())
			{
				if(entry.getValue().getPrice()*entry.getValue().getQuantity() > hvalue)
				{
					hvalue = entry.getValue().getPrice()*entry.getValue().getQuantity();
				}
			}
			HashSet<Product> highest = new HashSet<>();
			for(Map.Entry<Integer, Product> entry : inventory.entrySet())
			{
				if(entry.getValue().getPrice()*entry.getValue().getQuantity() == hvalue)
				{
					highest.add(entry.getValue());
				}
			}
			System.out.println("\nProducts with Highest Value are: \n");
			for(Product prod : highest)
			{
				System.out.println(prod);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Product> inventory = new HashMap<>();
		int addID =0;	
		try
		{
			while(true)
			{
				System.out.println("\n------Inventory Management------\n");
				System.out.println("1. Add Product");
				System.out.println("2. Update Quantity of Product");
				System.out.println("3. Delete Discontinued Product");
				System.out.println("4. Inventory Total Value");
				System.out.println("5. Product with highest total value");
				System.out.println("6. Exit\n");
				
				System.out.print("\nEnter your choice: ");
				int choice = in.nextInt(); in.nextLine();
				switch(choice)
				{
				case 1: System.out.print("Enter the no. of products to add: ");
						int n = in.nextInt(); in.nextLine();
						if(n==0) throw new ZeroSizeException();
						inventory = addProducts(n,inventory,addID,in);
						addID += n;
						System.out.println("\nProducts Added Successfully.\n");
						break;
						
				case 2: if(inventory.isEmpty())
						{
							System.out.println("\nInventory is empty.\n");
						}
						else
						{
							System.out.print("Enter Product ID: ");
							int id = in.nextInt(); in.nextLine();
							if(inventory.containsKey(id))
							{
								System.out.print("Enter new quantity: ");
								int quantity = in.nextInt(); in.nextLine();
								inventory.get(id).setQuantity(quantity);
								System.out.println("\nQuantity Updated Successfully.\n");
							}
							else
							{
								System.out.println("\nProduct not found.\n");
							}
						}
						break;
				case 3: if(inventory.isEmpty())
						{
							System.out.println("\nInventory is empty.\n");
						}
						else
						{
							System.out.print("Enter Product ID: ");
							int id = in.nextInt(); in.nextLine();
							if(inventory.containsKey(id))
							{
								inventory.remove(id);
								System.out.println("\nProduct Removed Successfully.\n");
							}
							else
							{
								System.out.println("\nProduct not found.\n");
							}
							
						}
						break;
				case 4: totalValue(inventory);
						break;
						
				case 5: highestValue(inventory);
						break;
						
				case 6: System.out.println("\nExited Successfully.");
				  		in.close();
				  		System.exit(0);
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nProvide proper input to data types.");
		}
		catch(ZeroSizeException e) {
			System.out.println("\nThe no. of products should be greater than zero.");
		}
		finally
		{
			in.close();
		}

	}

}
