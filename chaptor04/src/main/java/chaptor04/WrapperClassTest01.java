package chaptor04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		//직접 생성하면 힙상에 객체가 존재
		//리터럴을 사용하게 되면 JVM안의 constant Pool이 관리
		Integer i = new Integer(10);
		
		//Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;
		
		//Auto Unboxing
		int m1 = j1 + 10;
		int m2 = j1.intValue() + 10;
	}

}
