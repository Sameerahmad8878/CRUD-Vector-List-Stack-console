package pack2;

import java.util.*;

class Student{
	private int studentid;
	private String fname;
	private String lname;
	private String mobileno;
	
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Student() {}
		public Student(int studentid, String fname, String lname, String mobileno) {
			this.studentid=studentid;
			this.fname=fname;
			this.lname=lname;
			this.mobileno=mobileno;
			
		}
		public String toString() {
			String str=studentid+"\t "+fname+"\t "+lname+"\t "+mobileno;
			return str;
		}
	}
class myStudent{
	private Stack<Student>students=new Stack<>();
	public void push(Student newelement) {
		students.push(newelement);
		System.out.println(newelement+ "pushe to stack element");
	}
	public void pop() {
		if(students.empty()==true) {
			System.out.println("stack is empty");
			return;
			
		}
		Student removedelement=students.pop();
		System.out.println(removedelement+ "removed to stack collection");
		
	}
	public void show() {
		if(students.empty()==true) {
			System.out.println("stack is empty");
			return;
	}
		for(Iterator<Student> itr=students.iterator();
				itr.hasNext()==true;) {
			Student element=itr.next();
			System.out.println(element);
		}		
		}
}

public class StudentStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myStudent mystudent=new myStudent();
		while(true) {
			System.out.println("1. register new student in stack");
			System.out.println("2. remove last student record in stack");
			System.out.println("3. display student stack");
			System.out.println("4. exit programme");
			
			Scanner sc=new Scanner(System.in);
			System.out.print("enter your choice? 1/2/3/4: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:Student student=new Student();
			Scanner sc1=new Scanner(System.in);
			System.out.print("enter student fname: ");
			student.setFname(sc1.nextLine());
			System.out.print("enter student lname: ");
			student.setLname(sc1.nextLine());
			System.out.print("enter student mobileno: ");
			student.setMobileno(sc1.nextLine());
			System.out.print("enter studentid: ");
			student.setStudentid(sc1.nextInt());
			mystudent.push(student);
			break;
			
			case 2:
			mystudent.pop();
			break;
			case 3:
				mystudent.show();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("invalid option given!!!");
				break;
	}
		}
}
}