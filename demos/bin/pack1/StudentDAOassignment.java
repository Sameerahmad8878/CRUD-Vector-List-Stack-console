package pack1;

import java.util.*;


class Student{
	private int studentid;
	private String fname;
	private String lname;
	private String mobileno;
	public Student() {}
	public Student(int studentid, String fname, String lname, String mobileno) {
		this.studentid=studentid;
		this.fname=fname;
		this.lname=lname;
		this.mobileno=mobileno;
		
	}
	public String toString() {
		return studentid+"\t "+fname+"\t "+lname+"\t "+mobileno;
		
	}
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
}
interface StudentDAO{
	void add(Vector<Student>students);
	void show(Vector<Student>students);
	
	void delete(Vector<Student>students);
	void update(Vector<Student>students);
	int[] findStudentid(Vector<Student>students);
}
class StudentDAOImpl implements StudentDAO{

	@Override
	public void add(Vector<Student> students) {
		// TODO Auto-generated method stub
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.print("enter new student fname: ");
		student.setFname(sc.nextLine());
		System.out.print("enter new student lname: ");
		student.setLname(sc.nextLine());
		System.out.print("enter new student mobileno: ");
		student.setMobileno(sc.nextLine());
		System.out.print("enter new studentid: [unique]: ");
		student.setStudentid(sc.nextInt());
		students.addElement(student);
		System.out.println("new student registered successfully in vector collection");
	}

	@Override
	public void show(Vector<Student> students) {
		// TODO Auto-generated method stub
		if (students.isEmpty()==true) {
			System.out.println("vector collection for students is empty");
			return;
	}
		Enumeration<Student>enumeration=students.elements();
		while(enumeration.hasMoreElements()==true) {
			Student element=enumeration.nextElement();
			System.out.println(element);
		}
	}


	@Override
	public void delete(Vector<Student> students) {
		// TODO Auto-generated method stub
		
		if (students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("enter studentid to delete record: ");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0;i<students.size();i++) {
			Student student=students.get(i);
			if(student.getStudentid()==studentid)
				index=i;
		}
		if(index==-1)
			System.out.println("invalid student id given");
		else {
			students.remove(index);
			System.out.println("student removed with id="+studentid);
		}
	}

	@Override
	public void update(Vector<Student> students) {
		// TODO Auto-generated method stub
		if (students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		int[] res=this.findStudentid(students);
		if(res==null) {
			System.out.println("invalid id given");
			return;
		}
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.print("enter modified student fname: ");
		student.setFname(sc.nextLine());
		System.out.print("enter modified student lname: ");
		student.setLname(sc.nextLine());
		System.out.print("enter modified student mobileno: ");
		student.setMobileno(sc.nextLine());
		student.setStudentid(res[1]);
		students.set(res[0], student);
		System.out.println("record modified with studentid="+res[1]);
	}
	

	@Override
	public int[] findStudentid(Vector<Student> students) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("type existing studentid to modify: ");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0;i<students.size();i++) {
			Student student2=students.get(i);
			if(student2.getStudentid()==studentid) {
				index=i;
				break;
		}
	}
	
	if(index==-1) {
		int[] res=null;
		return res;
	}
	int[]res=new int[2];
	res[0]=index;
	res[1]=studentid;
	return res;
}
	
	}

public class StudentDAOassignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector<Student>mycollection;
		mycollection=new Vector<>();
		Scanner sc=new Scanner(System.in);
		StudentDAO dao=new StudentDAOImpl();
		while(true) {
			System.out.println("1. add");
			System.out.println("2. show");
			System.out.println("3. delete by studentid");
			System.out.println("4. modifying existing student record by id");
			System.out.println("5. exit program****");
			
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				dao.add(mycollection);
				break;
			case 2:
				dao.show(mycollection);
				break;
			case 3:
				dao.delete(mycollection);
				break;
			case 4:
				dao.update(mycollection);
				break;
			case 5:
				System.out.println("thanks for using my software**");
				System.exit(0);
				
			default:
				System.out.println("invalid option given!!!");
				break;
			}
		}

	}

}
