package practice02;

import java.util.Scanner;

public class practice02_1 {

	public static void main(String[] args) {
		final int[] current = {50000,10000,5000,1000,500,100,50,10,5,1};
		int[] counts = {0,0,0,0,0,0,0,0,0,0};
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int money = in.nextInt();
		
		for(int i=0; i<10;i++)
		{
			int num = money/current[i];
			if(num>0)
				counts[i] = num;
			money = money - current[i]*num;
		}
		
		in.close();
		
		for(int i=0; i<10;i++)
		{
			if(counts[i] != 0)
			{
				System.out.println(current[i] +"원 :" + counts[i] +"개");
			}
		}
	}

}
