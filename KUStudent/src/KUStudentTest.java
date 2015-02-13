import java.util.Scanner;

public class KUStudentTest {

	public static void main(String[] args) {
	KUStudent newStudent = new KUStudent();	//new object
	Scanner input = new Scanner(System.in);//I don't understand the "Resource leak" caution
	//prompt user
	System.out.println("Please input the student's name (firstname lastname):");
	String fname = input.next();
	String lname = input.next();
	newStudent.set_name(fname, lname);
	//"
	System.out.println("Please input the student's KUID and department:");
	String kuid = input.next();
	String dpt = input.next();
	newStudent.set_kuinfo(kuid, dpt);
	//print to user
	System.out.println("Student: "+newStudent.get_fname()+" "+newStudent.get_lname());
	System.out.println("KUID: "+newStudent.get_id());
	System.out.println("Department: "+newStudent.get_dpt());
	}
}
	
