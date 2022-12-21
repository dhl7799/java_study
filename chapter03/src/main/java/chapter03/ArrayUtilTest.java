package chapter03;

public class ArrayUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {10, 20, 30, 40};
		//ArrayUtils.intToDouble(a);
		double[] darray = ArrayUtils.intToDouble(new int[]{10,20,30,40});
		for(double d: darray)
			System.out.println(d);
			
			

	}

}
