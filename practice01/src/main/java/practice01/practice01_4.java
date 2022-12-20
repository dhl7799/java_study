package practice01;

import java.util.Scanner;

public class practice01_4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String str = in.nextLine();
		
		char[] charArray = str.toCharArray();
		for(int i=0; i<str.length();i++) {
			for(int j=0; j<i+1;j++) {
				System.out.print(charArray[j]);
			}
			System.out.println();
		}
		in.close();
	}

}
