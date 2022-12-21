

package chapter03;


public class SwapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 10;
		int b = 20;
		System.out.println("a:" +a + ", b:" +b);
		
		swap(a,b);
		System.out.println("a:" +a + ", b:" +b);
	}
	public static void swap(Integer a, Integer b)
	{
		Integer temp = a;
		a = b;
		b = temp;
	}
}
