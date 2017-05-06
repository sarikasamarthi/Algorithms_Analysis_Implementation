import java.util.*;
public class StudentInfo
{
   public static class Student 
	{
		StudentNode(int Val, Student nextNode) 
		{
			studentID  = Val;
			next = nextNode;
		}

		int studentID;
		Student next;
	}
	protected Student nodes = null;
	protected int studentID;
    public StudentInfo(){}
	public void hashStudent(int id)
	{
		nodes = new Student(id, this.nodes);
	}
	public int quadraticHash(int id) 
	{
		if(this.nodes == null) 
		{
			nodes = new Student(id, this.nodes);
			return 1;
		}

		return 0;
	}

	public final void printStudent()
	{
		for (Student current = this.nodes; current != null; current = current.next)
			if(current.next != null)
				System.out.print(current.studentID + " --> ");
			else
				System.out.print(current.studentID);
	}

	public final int searchStudent(int findMatchingID) 
	{
		for (Student current = this.nodes; current != null; current = current.next)
			if(current.studentID == findMatchingID)
				return 1;

		return 0;
	}

}