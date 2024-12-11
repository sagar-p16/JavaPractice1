/*
 Sorting with Method References and Comparator Composition:

Assume you have a Book class with title, author, and price fields. Write a comparator using method references that sorts a list of Book objects by author in ascending order. Then, modify this comparator to sort by author in ascending order and, for books with the same author, by price in ascending order. Finally, reverse the entire sorting order.

Hint: Use Comparator.comparing for the initial sort and Comparator.reversed to invert the order.
 */
import java.util.*;

class Book
{
  private String title, author;
  private double price;

  public Book(String title, String author, double price)
  {
    this.title = title;
    this.author = author;
    this.price = price;
  }
   
  public String getTitle(){
    return this.title;
  }

  public String getAuthor(){
    return this.author;
  }

  public double getPrice(){
    return this.price;
  }


  @Override
  public String toString()
  {
    return this.getTitle()+" by "+this.getAuthor()+" Price: "+this.getPrice();
  }

  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);

    try {
      ArrayList<Book> books = new ArrayList<>();
      System.out.print("Enter no. of books to add: ");
      int n = in.nextInt(); in.nextLine();
      if(n<=0)
      {
        throw new ZeroSizeException();
      }

      for(int i=0; i<n; i++)
      {
        System.out.println("Enter Book "+(i+1)+" Details");
        System.out.print("Title: ");
        String title = in.nextLine();
        System.out.print("Author: ");
        String author = in.nextLine();
        System.out.print("Price: ");
        double price = in.nextDouble(); in.nextLine();     

        books.add(new Book(title, author, price));

        System.out.println();
      }

      Collections.sort(books, Comparator.comparing(Book :: getAuthor).thenComparing(Book :: getPrice));

      System.out.println("Sorted Books: ");

      for(Book b : books)
      {
        System.out.println(b);
      }    

      Collections.reverse(books);      

      System.out.println("\nReverse Sorted Books: ");

      for(Book b : books)
      {
        System.out.println(b);
      }      
    } catch(InputMismatchException e) {
      System.out.println("\nProvide proper inputs to proper data types.\n");     
    } catch(ZeroSizeException e) {
      System.out.println("\nNo. of books should be greater than zero.\n");
    } catch(Exception e) {
      System.out.println("\nOther exception caught.\n");
    } finally {
      in.close();
    }
  }
}