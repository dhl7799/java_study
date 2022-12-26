package prob01;

public class Printer {
	/*
	public void println(int i) {
		System.out.println(i);
	}
	public void println(double d) {
		System.out.println(d);
	}
	public void println(String s) {
		System.out.println(s);
	}
	public void println(boolean b) {
		System.out.println(b);
	}
	*/
	//extends랑 super로 제한
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T...ts) {
		System.out.println(ts[0]);
		for(T t : ts)
			System.out.println(t);
	}
	
	//가변 파라미터, 가변인자
	public int sum(Integer...nums) {
		int sum = 0;
		for(Integer i : nums) {
			sum += i;
		}
		return sum;
	}
}
