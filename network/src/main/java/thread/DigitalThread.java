package thread;

public class DigitalThread extends Thread {
	public void run() {
        for (int cnt = 0; cnt < 10; cnt++) { 
            System.out.print(cnt);
        
        }
        
    }

}
