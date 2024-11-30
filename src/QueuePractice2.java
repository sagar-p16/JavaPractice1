/*
 Implement a Ticket Booking System using a LinkedList as a queue.

Customers arrive and join the queue to book tickets. Each customer has the following details:

customerId (int)
customerName (String)
Write a program that:

Allows customers to enqueue their details when they arrive.
Dequeues customers to book tickets in the order they arrived.
Prints the details of the customer currently being served.
Provides functionality to check the next customer in line using peek().
Ensures customers who leave the queue without booking are removed using remove().
 */
import java.util.*;
class Customer
{
	private int customerID;
	private String customerName;
	
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || this.getClass() != obj.getClass()) return false;
		Customer cust = (Customer) obj;
		return this.getCustomerID() == cust.getCustomerID();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getCustomerID());
	}
	
	@Override
	public String toString() {
		return "Customer {ID: "+this.getCustomerID()+" Name: "+this.getCustomerName()+"}";
	}	
}
public class QueuePractice2 {
	
	public static LinkedList<Customer> enqueueCustomers(int n, LinkedList<Customer> queue, int addID, Scanner in)
	{
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter Customer "+(i+1)+" Name: ");
			String customerName = in.nextLine();
			queue.offer(new Customer(addID+i+1, customerName));
		}
		return queue;
	}
	
	public static LinkedList<Customer> bookTickets(int n, LinkedList<Customer> queue)
	{
		if(queue.isEmpty())
		{
			System.out.println("\nQueue is empty.\n");
		}
		if(n>queue.size())
		{
			System.out.println("\nThe no. of customers is greater than the queue size.\n");
			return queue;
		}
		System.out.println("\nThe following customers tickets have been booked:");
		for(int i=0; i<n; i++)
		{
			System.out.println(queue.poll());
		}
		System.out.println();
		return queue;
	}
	
	public static void viewQueue(LinkedList<Customer> queue)
	{
		if(queue.isEmpty())
		{
			System.out.println("\nQueue is empty.\n");
		}
		else
		{
			System.out.println("Customer queue: ");
			for(Customer cust : queue)
			{
				System.out.println(cust);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try
		{
			LinkedList<Customer> queue = new LinkedList<>();
			int addID = 0;
			while(true)
			{
				System.out.println("------Menu------\n");
				System.out.println("1. Enqueue Customers");
				System.out.println("2. Book Tickets in Order");
				System.out.println("3. Check Current Customer being served");
				System.out.println("4. Remove Customer that left the queue");
				System.out.println("5. View Queue");
				System.out.println("6. Exit\n");
				
				System.out.print("Enter your choice: ");
				int choice = in.nextInt(); in.nextLine();
				switch(choice)
				{
				case 1: System.out.print("Enter no. of customers to add: ");
						int n = in.nextInt(); in.nextLine();
						if(n==0) throw new ZeroSizeException();
						queue = enqueueCustomers(n, queue, addID, in);
						addID += n;
						System.out.println("\nCustomers added Successfully\n");
						break;
				
				case 2: System.out.print("Enter no. of customers to book tickets: ");
						int n1 = in.nextInt(); in.nextLine();
						if(n1==0) throw new ZeroSizeException();
						queue = bookTickets(n1, queue);
						break;
						
				case 3: Customer current = queue.peek();
						if(current==null)
						{
							System.out.println("\nQueue is empty\n");
						}
						else
						{
							System.out.println("Current Customer being served: "+current);
						}
						break;
						
				case 4: System.out.print("Enter CustomerID of who left the queue: ");
						int custID = in.nextInt(); in.nextLine();
						Customer dummy = new Customer(custID, "");
						boolean res = queue.remove(dummy);
						if(res)
						{
							System.out.println("\nCustomer removed\n");
						}
						else
						{
							System.out.println("\nCustomer not found\n");
						}
						break;
						
				case 5: viewQueue(queue);
						break;
						
				case 6: in.close();
						System.out.println("Exited Successfully");
						System.exit(0);
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Provide provide proper input to data types.");
		}
		catch(ZeroSizeException e)
		{
			System.out.println("The no. of customers to add should be greater than zero.");
		}
		finally
		{
			in.close();
		}

	}

}
