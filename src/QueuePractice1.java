/*
 Task Scheduler with Priority
Design a Task Scheduler system using a PriorityQueue.

Create a Task class with the following fields:

taskId (int)
taskName (String)
priority (int, where lower numbers represent higher priority)
Implement the Comparable interface in the Task class to sort tasks based on their priority.

Write a program that:

Adds tasks to the PriorityQueue.
Simulates a scheduler by polling tasks from the queue one by one and displaying them in order of priority.
If two tasks have the same priority, break ties alphabetically by taskName.
Demonstrate adding and processing tasks and ensure the queue handles priorities correctly.


 */
import java.util.*;
class Task implements Comparable<Task>
{
	private int taskId;
	private String taskName;
	private int priority;
	
	public Task(int taskId, String taskName, int priority)
	{
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
	}
	
	public int getTaskId() {
		return taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Task o) {
		if(this.getPriority()==o.getPriority())
		{
			return this.getTaskName().compareToIgnoreCase(o.getTaskName());
		}
		return Integer.compare(this.getPriority(), o.getPriority());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Task ID: "+this.getTaskId()+" "+this.getTaskName()+" Priority: "+this.getPriority()+"\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) return true;
		if(obj == null || this.getClass() != obj.getClass()) return false;
		Task task = (Task) obj;
		return this.getTaskId() == task.getTaskId();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(this.getTaskId());
	}
	
}
public class QueuePractice1 {
	public static PriorityQueue<Task> addTasks(PriorityQueue<Task> pq, int n, Scanner in, int addID)
	{
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter TaskName "+(i+1)+": ");
			String taskName = in.nextLine();
			System.out.print("Enter Priority "+(i+1)+": ");
			int priority = in.nextInt(); in.nextLine();
			pq.offer(new Task(addID+i+1, taskName, priority));
			System.out.println();
		}
		return pq;
	}
	public static void viewtasks(PriorityQueue<Task> pq)
	{
		if(pq.isEmpty())
		{
			System.out.println("\nQueue is empty\n");;
			return;
		}
		for(Task task : pq)
		{
			System.out.println(task);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try
		{
			int addID = 0;
			PriorityQueue<Task> pq = new PriorityQueue<>();
			while(true)
			{
				System.out.println("------Menu------\n");
				System.out.println("1. Add Task");
				System.out.println("2. Delete Task");
				System.out.println("3. View Queue");
				System.out.println("4. Exit");
				
				System.out.print("\nEnter your choice: ");
				int choice = in.nextInt(); in.nextLine();
				switch(choice)
				{
				case 1: System.out.print("Enter the no. of task to add: ");
						int n = in.nextInt(); in.nextLine();
						if(n==0)
						{
							throw new ZeroSizeException();
						}
						pq = addTasks(pq, n, in, addID);
						addID+=n;
						System.out.println("\nTasks added successfully\n");
						break;
				
				case 2: System.out.println("1. Delete the most priority task");
				        System.out.println("2. Delete task by ID");
				        System.out.print("\nEnter your choice: ");
				        int dchoice = in.nextInt(); in.nextLine();
				        if(dchoice==1)
				        {
				        	Task removed = pq.poll();
				        	if(removed==null)
				        	{
				        		System.out.println("\nQueue is empty\n");
				        	}
				        	else
				        	{
				        		System.out.println(removed);
				        		System.out.println("\nTask removed successfully\n");
				        	}
				        }
				        else if(dchoice==2)
				        {
				        	System.out.print("Enter Task ID: ");
				        	int taskID = in.nextInt(); in.nextLine();
				        	Task dummyTask = new Task(taskID, "", 0);
				        	boolean res = pq.remove(dummyTask);
				        	if(res)
				        	{
				        		System.out.println("\nTask Removed\n");
				        	}
				        	else
				        	{
				        		System.out.println("\nTask not found\n");
				        	}
				        }
				        else
				        {
				        	System.out.println("\nInvalid Input\n");
				        }
				        break;
				case 3: viewtasks(pq);
						break;
				
				case 4: in.close();
						System.out.println("Exited Successfully");
						System.exit(0);
				        
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter proper values to data types.");
		}
		catch(ZeroSizeException e)
		{
			System.out.println("\nThe no. of tasks should be more than zero.");
		}
		finally 
		{
			in.close();
		}

	}

}
