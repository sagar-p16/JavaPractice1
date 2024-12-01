/*
 Create a Product Inventory System where each Product object stores the following details:

int productId: Unique ID of the product.
String productName: Name of the product.
double price: Price of the product.
int quantity: Number of units available in stock.
Implement the Comparable interface in the Product class to sort products as follows:

Primarily by total value in stock (price × quantity) in descending order.
If two products have the same total value, sort them by productName in lexicographical order.
Write a program that:

Adds products to an ArrayList and sorts them using Collections.sort().
Displays the sorted product list.
Finds the product with the highest total value in stock and displays its details.
 */
import java.util.*;
class Product1 implements Comparable<Product1>
{
	private int productID;
	private String productName;
	private double price;
	private int quantity;
	
	public Product1(int productID, String productName, double price, int quantity)
	{
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || this.getClass() != obj.getClass()) return false;
		Product1 prod = (Product1) obj;
		return this.getProductID()==prod.getProductID();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getProductID());
	}
	
	@Override
	public int compareTo(Product1 o) {
		if(this.getQuantity()*this.getPrice()==o.getQuantity()*o.getPrice())
		{
			return this.getProductName().compareToIgnoreCase(o.getProductName());
		}
		return Double.compare(o.getQuantity()*o.getPrice(), this.getQuantity()*this.getPrice());
	}
	
	@Override
	public String toString() {
		return "Product {ID: "+this.getProductID()+" Name: "+this.getProductName()+" Price: "+this.getPrice()+" Quantity: "+this.getQuantity()+"}";
	}
	
}
public class ComparablePractice1 {
	
	public static ArrayList<Product1> addProducts(int n, ArrayList<Product1> products, Scanner in)
	{
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter Product "+(i+1)+" Name: ");
			String productName = in.nextLine();
			System.out.print("Enter Product "+(i+1)+" Price Per Unit: ");
			double price = in.nextDouble();
			System.out.print("Enter Product "+(i+1)+" Quantity: ");
			int quantity = in.nextInt(); in.nextLine();
			System.out.println();
			products.add(new Product1(products.size()+1, productName, price, quantity));
		}
		return products;
	}
	
	public static void displayProducts(ArrayList<Product1> products)
	{
		if(products.isEmpty())
		{
			System.out.println("\nNo products available.\n");
			return;
		}
		Collections.sort(products);
		System.out.println();
		for(Product1 prod: products)
		{
			System.out.println(prod);
		}
		System.out.println();
	}
	
	public static void highestProduct(ArrayList<Product1> products)
	{
		if(products.isEmpty())
		{
			System.out.println("\nNo products available.\n");
			return;
		}
		double hvalue = Double.MIN_VALUE;
		for(Product1 prod : products)
		{
			if(prod.getPrice()*prod.getQuantity() > hvalue)
			{
				hvalue = prod.getPrice()*prod.getQuantity();
			}
		}
		HashSet<Product1> highest = new HashSet<>();
		for(Product1 prod : products)
		{
			if(prod.getPrice()*prod.getQuantity() == hvalue)
			{
				highest.add(prod);
			}
		}
		System.out.println("\nProducts with Highest Value: ");
		for(Product1 prod: highest)
		{
			System.out.println(prod);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Product1> products = new ArrayList<>();
		try
		{
			while(true)
			{
				System.out.println("\n------Menu------\n");
				System.out.println("1. Add Products");
				System.out.println("2. Display Sorted List");
				System.out.println("3. Products with highest price");
				System.out.println("4. Exit\n");
				
				System.out.print("Enter your choice: ");
				int choice = in.nextInt(); in.nextLine();
				
				switch(choice)
				{
				case 1: System.out.print("Enter no. of products: ");
						int n = in.nextInt(); in.nextLine();
						if(n<=0) throw new ZeroSizeException();
						products = addProducts(n,products,in);
						System.out.println("\nProducts Added Successfully.\n");
						break;
						
				case 2: displayProducts(products);
						break;
						
				case 3: highestProduct(products);
						break;
						
				case 4: System.out.println("\nExited Successfully.");
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
