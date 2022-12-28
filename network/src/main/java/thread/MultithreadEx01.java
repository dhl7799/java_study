package thread;

public class MultithreadEx01 {

	public static void main(String[] args) {
		try {
		Thread thread = new DigitalThread();     // 스레드를 생성   
        thread.start();                        // 스레드를 시작
        for (char ch = 'A'; ch <= 'Z'; ch++) { 
            System.out.print(ch);
            thread.sleep(1000);
        }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}

}
