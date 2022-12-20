package practice01;

import java.util.Scanner;

public class practice01_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("수를 입력 하세요 : ");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		if(input%3 == 0)
			System.out.println("3의 배수입니다");
		else
			System.out.println("3의 배수가 아닙니다");
		in.close();

	}
}


