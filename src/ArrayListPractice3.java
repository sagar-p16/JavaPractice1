/*
 Write a program to merge two ArrayLists into a single list, ensuring there are no duplicate elements. Print the merged list.
 */
import java.util.*;
public class ArrayListPractice3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try
		{
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			System.out.print("Enter size 1: ");
			int n1 = in.nextInt();
			if(n1==0)
			{
				throw new ZeroSizeException();
			}
			System.out.println("Enter list1 elements: ");
			for(int i=0; i<n1; i++)
			{
				list1.add(in.nextInt());
			}
			System.out.print("Enter size 2: ");
			int n2 = in.nextInt();
			if(n2==0)
			{
				throw new ZeroSizeException();
			}
			System.out.println("Enter list2 elements: ");
			for(int i=0; i<n2; i++)
			{
				list2.add(in.nextInt());
			}
			System.out.println("List 1: "+list1);
			System.out.println("List 2: "+list2);
			list1.addAll(list2);
			System.out.println("Merged List: "+list1);
			list1 = removeDuplicates(list1);
			System.out.println("Duplicates removed: "+list1);
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter integers only");
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
	public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list)
	{
		if(list.isEmpty() || list==null)
		{
			return null;
		}
		ArrayList<Integer> unique = new ArrayList<>();
		for(Integer num : list)
		{
			if(!unique.contains(num))
			{
				unique.add(num);
			}
		}
		return unique;
	}

}
