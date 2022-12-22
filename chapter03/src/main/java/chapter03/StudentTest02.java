package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		Person p1 = s1; //암시적 upcasting
		Student s2 = (Student)p1; //명시적 downcasting
		
	}

}
