package thread;

public class MultithreadEx02 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();
		Thread thread2 = new DigitalThread();
		Thread thread3 = new AlphabetThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
