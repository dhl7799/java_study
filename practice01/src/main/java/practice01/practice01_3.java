package practice01;

import java.util.Scanner;

public class practice01_3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("숫자를 입력하세요: ");
			int input = in.nextInt();
			int sum = 0;
			if(input%2 ==0)
			{
				for(int i=0; i<= input; i++)
				{
					if(i%2==0)
						sum += i;
				}
			}
			
			else if(input%2 ==1)
			{
				for(int i=0; i<= input; i++)
				{
					if(i%2==1)
						sum += i;
				}
			}
			
			else
			{
				sum = 0;
			}
			
			System.out.println(sum);
			
		}
		
	}

}
