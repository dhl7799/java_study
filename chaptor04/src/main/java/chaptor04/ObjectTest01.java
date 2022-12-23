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
		 * equals()
		 */
		System.out.println(point.hashCode());
		Class klass = point.getClass();
		System.out.println(klass.toString());
		System.out.println(point.toString());
		System.out.println(point);
	}

}
