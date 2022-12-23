package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		
		try {
			Myclass myclass = new Myclass();
			myclass.danger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error : " +e);
		}
	}

}
