package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10 -a;
		System.out.println("Some Code1....");
		try {
			System.out.println("Some Code2....");
			System.out.println("Some Code3....");
			int result = (1+2+3)/b;
			System.out.println("Some Code4....");
			System.out.println("Some Code5....");
			return;
		} catch(ArithmeticException ex) {
			System.out.println("error: " + ex);
			
			System.out.println("미안합니다....");
			
			//return;
			//System.exit(0);
			
		} finally {
			//주로 자원정리
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
		}
		System.out.println("Some Code6....");
		System.out.println("Some Code7....");
		return;	
	}
	

}
