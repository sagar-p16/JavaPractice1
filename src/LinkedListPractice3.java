/*
 Use a LinkedList to store a sequence of numbers entered by the user. For each operation:

Add a number at the end of the list.
Insert a number at the beginning of the list.
Find and remove the first occurrence of a specific number.
 */
import java.util.*;
public class LinkedListPractice3 {

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
			LinkedList<Integer> numbers = new LinkedList<>();
			System.out.println("Enter numbers: ");
			for(int i=0; i<n; i++)
			{
				numbers.add(in.nextInt());
			}
			System.out.println("Numbers: "+numbers);
			System.out.print("Enter Number to Add at Last: ");
			numbers.addLast(in.nextInt());
			System.out.println("Numbers: "+numbers);
			System.out.print("Enter Number to Add at First: ");
			numbers.addFirst(in.nextInt());
			System.out.println("Numbers: "+numbers);
			System.out.print("Enter the number to remove its first and last occurence occurence: ");
			int rnum = in.nextInt();
			boolean rf1 = numbers.removeFirstOccurrence(rnum);
			if(rf1)
			{
				System.out.println("Fist occurence of "+rnum+" removed.");
				System.out.println("Numbers: "+numbers);
			}
			else
			{
				System.out.println(rnum+" not found.");
			}
			boolean rf2 = numbers.removeLastOccurrence(rnum);
			if(rf2)
			{
				System.out.println("Last occurence of "+rnum+" removed.");
				System.out.println("Numbers: "+numbers);
			}
			else
			{
				System.out.println(rnum+" not found.");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter Integer only");
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
