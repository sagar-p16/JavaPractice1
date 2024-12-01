/*
 Advanced Student Management System Using HashMap
Problem Statement:
Design a Student Management System using a HashMap where the keys are student IDs (unique integers) and the values are Student objects. The system should allow for efficient storage, retrieval, and updates of student data.

The Student class contains the following fields:

int id - The student's unique ID.
String name - The student's name.
double grade - The student's average grade.
Requirements:

Write a program to:
Add students to the system.
Update a student's grade given their ID.
Delete a student from the system by their ID.
Retrieve and display the details of the student with the highest grade.
Retrieve all students with a grade greater than a user-specified threshold.
Implement the functionalities efficiently using HashMap methods.
 */
import java.util.*;
class Student
{
	private int id;
	private String name;
	private double grade;
	
	public Student(int id, String name, double grade) {
		this.id  = id;
		this.name = name;
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || this.getClass() != obj.getClass()) return false;
		Student st = (Student) obj;
		return this.getId() == st.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
	
	@Override
	public String toString() {
		return "Student {ID: "+this.getId()+" Name: "+this.getName()+" Grade: "+this.getGrade()+"}";
	}
}
public class HashMapPractice1 {
	
	public static HashMap<Integer, Student> addStudents(int n, HashMap<Integer, Student> students, int addID, Scanner in)
	{
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter Student "+(i+1)+" Name: ");
			String name = in.nextLine();
			System.out.print("Enter Student "+(i+1)+" Grade: ");
			double grade = in.nextDouble(); in.nextLine();
			students.put(addID+i+1, new Student(addID+i+1, name, grade));
			System.out.println();
		}
		System.out.println("\nStudents added successfuklly.\n");
		return students;
	}
	
	public static void highestGrade(HashMap<Integer, Student> students)
	{
		if(students.isEmpty())
		{
			System.out.println("\nNo student records available.\n");
			return;
		}
		Student top = null;
		double maxgrade = Double.MIN_VALUE;
		for(Map.Entry<Integer, Student> entry : students.entrySet())
		{
			if(entry.getValue().getGrade() > maxgrade)
			{
				top = entry.getValue();
				maxgrade = top.getGrade();
			}
		}
		HashSet<Student> highest = new HashSet<>();
		highest.add(top);
		for(Map.Entry<Integer, Student> entry : students.entrySet())
		{
			if(entry.getValue().getGrade() == maxgrade)
			{
				highest.add(entry.getValue());
			}
		}
		System.out.println("Highest Grade Students: ");
		for(Student student : highest)
		{
			System.out.println(student);
		}
	}
	
	public static void gradesThreshold(HashMap<Integer, Student> students, double threshold)
	{
		if(students.isEmpty())
		{
			System.out.println("\nNo student record available.\n");;
			return;
		}
		if(threshold<0 || threshold>100)
		{
			System.out.println("\nThe threshold should be within 0-100 range.\n");
			return;
		}
		List<Student> thresholdStudents = new ArrayList<>();
		for(Map.Entry<Integer, Student> entry : students.entrySet())
		{
			if(entry.getValue().getGrade() >= threshold)
			{
				thresholdStudents.add(entry.getValue());
			}
		}
		if(thresholdStudents.isEmpty())
		{
			System.out.println("\nNo such students found.\n");
		}
		else
		{
			for(Student student : thresholdStudents)
			{
				System.out.println(student);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Student> students = new HashMap<>();
		int addID = 0;
		try
		{
			while(true)
			{
				System.out.println("\n------Menu------\n");
				System.out.println("1. Add Students");
				System.out.println("2. Update Grade");
				System.out.println("3. Delete Student Record");
				System.out.println("4. Student with Highest Grade");
				System.out.println("5. Students with grade greater than threshold");
				System.out.println("6. Exit");
				System.out.print("\nEnter your choice: ");
				int choice = in.nextInt(); in.nextLine();
				switch(choice)
				{
				case 1: System.out.print("Enter no. of students: ");
						int n = in.nextInt(); in.nextLine();
						if(n==0) throw new ZeroSizeException();
						students = addStudents(n, students, addID, in);
						System.out.println("\nStudents added successfully.\n");
						break;
				
				case 2: if(students.isEmpty())
						{
							System.out.println("\nStudent record is empty.\n");
						}
						else
						{
							System.out.print("Enter Student ID: ");
							int id = in.nextInt(); in.nextLine();
							if(students.containsKey(id))
							{
								System.out.print("Enter new grade: ");
								double grade = in.nextDouble(); in.nextLine();
								students.get(id).setGrade(grade);
								System.out.println("\nGrade Updated Successfully.\n");
							}
							else
							{
								System.out.println("\nStudent not found.\n");
							}
						}
						break;
				
				case 3: if(students.isEmpty())
						{
							System.out.println("\nStudent record is empty.\n");
						}
						else
						{
							System.out.print("Enter Student ID: ");
							int id1 = in.nextInt(); in.nextLine();
							if(students.containsKey(id1))
							{
								System.out.println(students.get(id1));
								students.remove(id1);
								System.out.println("\nStudent Removed Successfully.\n");
							}
							else
							{
								System.out.println("\nStudent not found.\n");
							}
						}
						break;
					
				case 4: highestGrade(students);
						break;
						
				case 5: System.out.print("Enter Grade Threshold:  ");
						double threshold = in.nextDouble(); in.nextLine();
						gradesThreshold(students, threshold);
						break;
						
				case 6: System.out.println("\nExited Successfully.");
						in.close();
						System.exit(0);
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nProvidfe inputs to proper data types.");
		}
		catch(ZeroSizeException e)
		{
			System.out.println("\nNo. of students should be greater than zero.");
		}
		finally
		{
			in.close();
		}
	}
}
