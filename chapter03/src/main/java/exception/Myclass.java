package exception;

import java.io.IOException;

public class Myclass {
	public void danger() throws IOException, MyException{
		System.out.println("some code1....");
		System.out.println("some code2....");
		if(3 - 3 ==0) {
			throw new MyException();
		}
		if(5-5==0)
			throw new IOException();
		
		System.out.println("some code3....");
		System.out.println("some code4....");
	}
}