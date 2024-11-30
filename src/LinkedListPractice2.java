/*
 Create a LinkedList to simulate a playlist of songs. Perform the following:

Add songs to the playlist.
Add a song at the second position.
Remove the current playing song (head of the LinkedList).
Display the remaining songs.
 */
import java.util.*;
public class LinkedListPractice2 {

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
			LinkedList<String> songs = new LinkedList<>();
			System.out.println("Enter song names: ");
			for(int i=0; i<n; i++)
			{
				songs.add(in.nextLine());
			}
			System.out.println("Songs: "+songs);
			System.out.print("Enter song name to insert at 2nd Position: ");
			songs.add(1, in.nextLine());
			System.out.println("Updated Songs: "+songs);
			System.out.println("Current Song Playing Removed: "+songs.removeFirst());
			System.out.println("Final songs list: "+songs);
		}
		catch(ZeroSizeException e)
		{
			System.out.println("\nThe input size should be greater than zero.");
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter integer");
		}
		finally
		{
			in.close();
		}
	}
}
