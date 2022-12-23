package chaptor04;

public class ObejctTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(10,20);

		Point p2 = new Point(10,20);
		

		Point p3 = p2;
		
		//두 객체의 동일성 비교
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);
		
		System.out.println(p2.equals(p3));
	}

}
