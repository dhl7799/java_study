package chaptor04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		//Class klass = point.getClass();
		System.out.println(point.getClass());
		//System.out.println(point);
		/*getClass()
		 * toString()
		 * hashCodes()
		 * equals() : 두 객체의 동질성
		 * 부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다.
		 */
		System.out.println(point.hashCode());
		Class klass = point.getClass();
		System.out.println(klass.toString());
		System.out.println(point.toString()); //getClass() + @ + hashcode()
		System.out.println(point);
	}

}
