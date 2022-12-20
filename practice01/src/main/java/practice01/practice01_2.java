package practice01;

public class practice01_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10;i++) {
			for(int j=i;j<i+10;j++)
			{
				System.out.print(j);
				if(j != i+9)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
