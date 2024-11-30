/*
Write a program to create an ArrayList of names. Perform the following operations:

Add names to the list.
Remove all names that start with a vowel.
Sort the list alphabetically and print it.
*/

import java.util.*;

public class ArrayListPractice1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size: ");
		try
		{
			int n = in.nextInt(); in.nextLine();
			if(n==0)
			{
				throw new ZeroSizeException();
			}
			ArrayList<String> list = new ArrayList<>();
			ArrayList<String> vowels = new ArrayList<>();
			System.out.println("Enter the names: ");
			for(int i=0; i<n; i++)
			{
				list.add(in.nextLine());
			}
			System.out.println("Original List: "+list);
			for(String name : list)
			{
				char first = Character.toLowerCase(name.charAt(0));
				if(first=='a' || first=='e' || first=='i' || first=='o' || first=='u')
				{
					vowels.add(name);
				}
			}
			list.removeAll(vowels);
			System.out.println("Modified List: "+list);
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter a single integer value.");
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
