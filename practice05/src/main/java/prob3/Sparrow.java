package prob3;

public class Sparrow extends Bird {

	public Sparrow() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void fly() {
		System.out.println("참새("+getName()+")가 날아다닙니다.");
	}
	@Override
	public void sing() {
		System.out.println("참새("+getName()+")가 소리내어 웁니다.");
	}
}
