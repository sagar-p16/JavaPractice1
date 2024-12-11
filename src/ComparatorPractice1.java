/*
	Implementing a Custom Comparator with Multiple Fields:

Given a Person class with firstName, lastName, and age fields, implement a custom comparator that sorts a list of Person objects first by lastName in ascending order, then by firstName in ascending order, and finally by age in descending order. Use both an anonymous inner class and a lambda expression to achieve this.

Hint: Utilize the Comparator interface's thenComparing method for chaining multiple comparisons. 
 */

import java.util.*;

class Person
{
	 private String firstName, lastName;
	 private int age;
 
	 public Person(String firstName, String lastName, int age)
	 {
		 this.age = age;
		 this.firstName = firstName;
		 this.lastName = lastName;
	 }

	 public String getFirstName() {
		 return this.firstName;
	 }

	 public String getLastName() {
		 return this.lastName;
	 }

	 public int getAge() {
		 return this.age;
	 }

	 @Override
	 public String toString()	
	 {
		 return "Name: "+this.getFirstName()+" "+this.getLastName()+" Age: "+this.getAge();
	 }
}

	public class ComparatorPractice1
	{
		 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	
		 try {	
		  System.out.print("Enter no. of Persons to add: ");
		  int n = in.nextInt();
		  in.nextLine();
		  if(n<=0) throw new ZeroSizeException();
		  ArrayList<Person> people = new ArrayList<>();
		  for(int i=0; i<n; i++)
		  {
			  System.out.println("Enter Person "+(i+1)+" Details: ");
			  System.out.print("First Name: ");
			  String firstName = in.nextLine();
			  System.out.print("Last Name: ");
			  String lastName = in.nextLine();
			  System.out.print("Age: ");
			  int age = in.nextInt();
			  in.nextLine();
			  people.add(new Person(firstName, lastName, age));
			  System.out.println();
		  }

		  Collections.sort(people, Comparator.comparing(Person::getLastName)
                  .thenComparing(Comparator.comparing(Person::getFirstName))
                  .thenComparing(Comparator.comparingInt(Person::getAge).reversed()));
		
		  System.out.println("Sorting Using Lambda Expression: ");
		  for(Person p : people)
		  {
			  System.out.println(p);
		  }
		
		  Collections.sort(people, new Comparator<Person> () {
		
		    @Override
		    public int compare(Person p1, Person p2)
		    {
		      if(p1.getLastName().equalsIgnoreCase(p2.getLastName()))
		      {
		        if(p1.getFirstName().equalsIgnoreCase(p2.getFirstName()))
		        {
		          return Double.compare(p2.getAge(), p1.getAge());
		        }
		        return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
		      }
		      return p1.getLastName().compareToIgnoreCase(p2.getLastName());
		    }
		  });
		
		  System.out.println("\nSorting Using Comparator Definition: ");
		
		  for(Person p : people)
		  {
			  System.out.println(p);
		  }
		 } catch(InputMismatchException e) {
		  System.out.println("\nProvide proper inputs to proper data types.\n");
		 } catch(ZeroSizeException e) {
		  System.out.println("\nNo. of people to add should be greater than zero.\n");
		 } catch(Exception e) {
		  System.out.println("\nOther exception caught.\n");
		 }
		 finally
		 {
		  in.close();
		 }
	 }
}

