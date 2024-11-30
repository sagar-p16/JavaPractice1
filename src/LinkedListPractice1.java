/*
 Write a program to create a LinkedList of cities. Perform the following:

Add cities to the list.
Reverse the order of the list.
Remove the first and last cities, and print the modified list.
 */
import java.util.*;
public class LinkedListPractice1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try
		{
			System.out.print("Enter the size: ");
			int n = in.nextInt(); in.nextLine();
			if(n==0)
			{
				throw new ZeroSizeException();
			}
			LinkedList<String> cities = new LinkedList<>();
			System.out.println("Enter the cities: ");
			for(int i=0; i<n; i++)
			{
				cities.add(in.nextLine());
			}
			System.out.println("Original List: "+cities);
			Collections.reverse(cities);
			System.out.println("Reversed List: "+cities);
			System.out.println("First element removed: "+cities.removeFirst());
			System.out.println("Current List: "+cities);
			System.out.println("Last element removed: "+cities.removeLast());
			System.out.println("Final List: "+cities);
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter integers");
		}
		catch(ZeroSizeException e)
		{
			System.out.println("\nThe input size should be greater than zero.");
		}
		finally
		{
			in.close();
		}
	}
}
