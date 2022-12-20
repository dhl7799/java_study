package practice02;

import java.util.Scanner;

public class practice02_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		String input = in.nextLine();
		char[] rinput = reverse(input);
		printCharArray(rinput);
		in.close();
	}
	public static char[] reverse(String str)
	{
		char[] tochar = str.toCharArray();
		char[] rechar = new char[str.length()];
		for(int i=0;i<tochar.length;i++)
		{
			rechar[i] = tochar[tochar.length-1-i];
		}
		return rechar;
	}
	/*-	문자열의 순서를 뒤집어서 char 배열로 리턴하는 메소드를 구현한다
	-	예를 들어 “Hi!” 라는 문자열을 파라미터로 전달 하면 {‘!’, ‘i’, ‘H’ } 배열을 반환 한다.
	*/
	public static void printCharArray(char[] array)
	{
		for(int i=0; i<array.length;i++)
		{
			System.out.print(array[i]);
		}
		System.out.println();
	}

}
