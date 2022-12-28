package thread;

public class DigitRunnableImpl implements Runnable {

	@Override
	public void run() {
		for( int i = 0; i < 9; i++ ) {
            System.out.print( i );
        }
	}

}
