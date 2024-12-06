/*
 Employee Management System with Multiple Inheritance Using Interfaces
Problem Statement:
Create an Employee Management System where:

Abstract Class: Employee

Fields: int employeeId, String employeeName.
Abstract Method: double calculateSalary().
Concrete Method: void displayDetails() to show basic details.
Interface: Department

Methods:
String getDepartmentName().
void setDepartmentName(String name).
Interface: Project

Methods:
String getProjectName().
void setProjectName(String name).
Concrete Class: Manager (Extends Employee and Implements Department and Project)

Additional Fields: double baseSalary, double bonus.
Implements calculateSalary() to return baseSalary + bonus.
Concrete Class: Developer (Extends Employee and Implements Department and Project)

Additional Field: double hourlyRate, int hoursWorked.
Implements calculateSalary() to return hourlyRate * hoursWorked.
Write a program that:

Creates a list of employees (ArrayList<Employee>).
Demonstrates polymorphism by calculating and displaying salaries for all employees.
Allows the user to update department and project details for each employee.
Input Example:

Create employees:

{Manager, "John", 123, 5000, 2000}
{Developer, "Alice", 124, 50, 160}
Actions:

Assign departments: "HR" for Manager, "IT" for Developer.
Assign projects: "System Upgrade" for Manager, "Mobile App Development" for Developer.
Expected Output:

"John (Manager) from HR is working on System Upgrade. Salary: 7000"
"Alice (Developer) from IT is working on Mobile App Development. Salary: 8000"

 */
import java.util.*;

abstract class Employee
{
	private int employeeID;
	private String employeeName;
	
	public Employee(int employeeID, String employeeName)
	{
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	
	abstract double calculateSalary();
	
	void displayDetails()
	{
		System.out.println("Employee{ ID: "+this.getEmployeeID()+" Name: "+this.getEmployeeName()+" }");
	}
}

interface Department
{
	String getDepartmentName();
	
	void setDepartmentName(String name);
}

interface Project
{
	String getProjectName();
	
	void setProjectName(String name);
}

class Manager extends Employee implements Department, Project
{
	private String deptName;
	private String projectName;
	private double baseSalary;
	private double bonus;
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	public double getBonus() {
		return bonus;
	}

	public Manager(int employeeID, String employeeName, String deptName, String projectName, double baseSalary, double bonus) {
		super(employeeID, employeeName);
		this.projectName = projectName;
		this.deptName = deptName;
		this.baseSalary = baseSalary;
		this.bonus = bonus;
	}

	@Override
	public String getProjectName() {
		return this.projectName;
	}

	@Override
	public void setProjectName(String name) {
		this.projectName = name;
		
	}

	@Override
	public String getDepartmentName() {
		return this.deptName;
	}

	@Override
	public void setDepartmentName(String name) {
		this.deptName = name;
		
	}

	@Override
	double calculateSalary() {
		return this.getBaseSalary()+this.getBonus();
	}
	
}

class Developer extends Employee implements Department, Project
{
	private String deptName;
	private String projectName;
	private double hourlyRate;
	private int hoursWorked;
	
	public Developer(int employeeID, String employeeName, String deptName, String projectName, double hourlyRate, int hoursWorked) {
		super(employeeID, employeeName);
		this.projectName = projectName;
		this.deptName = deptName;
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	
	@Override
	public String getProjectName() {
		return this.projectName;
	}

	@Override
	public void setProjectName(String name) {
		this.projectName = name;
		
	}

	@Override
	public String getDepartmentName() {
		return this.deptName;
	}

	@Override
	public void setDepartmentName(String name) {
		this.deptName = name;
		
	}

	@Override
	double calculateSalary() {
		return this.getHourlyRate()*this.getHoursWorked();
	}
	
}
public class InheritanceAbstractionInterface2 {

	public static void main(String[] args) {
		ArrayList<Employee> emps= new ArrayList<>();
		emps.add(new Manager(1, "Alice","NA", "NA", 50, 120));
		emps.add(new Developer(2, "Bob","NA", "NA", 100, 160));
		emps.add(new Manager(3, "Rachel","NA", "NA", 40, 100));
		emps.add(new Developer(2, "Bob","NA", "NA", 100, 160));
		System.out.println("Added Managers and Developers without departments and projects\n");
		
		for(Employee emp : emps)
		{
			if(emp instanceof Manager)
			{
				((Department) emp).setDepartmentName("HR");
				((Project) emp).setProjectName("System Upgrade");
			}
			if(emp instanceof Developer)
			{
				((Department) emp).setDepartmentName("IT");
				((Project) emp).setProjectName("Mobile App Development");
			}
			
			System.out.println(emp.getEmployeeName()+" ("+emp.getClass().getName()+") from "+((Department) emp).getDepartmentName()+" is working on "+((Project) emp).getProjectName()+". Salary: "+emp.calculateSalary()+"\n");
		}

	}

}
