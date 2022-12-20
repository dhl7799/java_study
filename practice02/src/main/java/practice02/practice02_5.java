package practice02;

import java.util.Random;
import java.util.Scanner;


public class practice02_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner( System.in );
		
		while(true) {
			Random r = new Random();
			int k = r.nextInt(100) + 1;
			int low = 1;
			int high = 100;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			int count = 1;
			
			System.out.println(low+"-"+high);
			System.out.print(count+">>");
			int check = scanner.nextInt();
			while(check !=k)
			{
				if(check > k)
				{
					System.out.println("더 낮게");
					high = check;
				}
				else if(check < k)
				{
					System.out.println("더 높게");
					low = check;
				}
				System.out.println(low+"-"+high);
				System.out.print(count+">>");
				check = scanner.nextInt();
			}
			System.out.println("맞았습니다.");
			System.out.print("다시하시겠습니까(y/n)>>");
			String answer = scanner.next();
			if( answer.equals("y") ){
			}
			else
				break;
		}
		
		scanner.close();
		return;
	}

}
