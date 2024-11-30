/*
 Create an ArrayList of integers. Ask the user to:
Add numbers to the list.
Replace all even numbers with their squares.
Display the updated list.
 */
import java.util.*;

public class ArrayListPractice2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 try
		 {
			 System.out.print("Enter the size: ");
			 int n = in.nextInt();
			 if(n==0)
			 {
				 throw new ZeroSizeException();
			 }
			 ArrayList<Integer> numbers = new ArrayList<>();
			 System.out.println("Enter the numbers: ");
			 for(int i=0; i<n; i++)
			 {
				 numbers.add(in.nextInt());
			 }
			 System.out.println("Original List: "+numbers);
			 for(int i=0; i<n; i++)
			 {
				 if(numbers.get(i)%2==0)
				 {
					 numbers.set(i, (int)Math.pow(numbers.get(i), 2));
				 }
			 }
			 System.out.println("Modified list: "+numbers);
		 }
		 catch(InputMismatchException e)
		 {
			 System.out.println("Enter integer numbers only");
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
