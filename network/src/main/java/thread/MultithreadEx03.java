package thread;

public class MultithreadEx03 {

	public static void main(String[] args) {
		Thread thread = new Thread( new DigitRunnableImpl() ); // 스레드를 생성   
        thread.start();                                             // 스레드를 시작
        for (char ch = 'A'; ch <= 'Z'; ch++) 
            System.out.print(ch);
    }


}

