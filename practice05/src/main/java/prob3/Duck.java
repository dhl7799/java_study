package prob3;

public class Duck extends Bird {

	public Duck() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void fly() {
		System.out.println("오리("+getName()+")는 날지 않습니다.");
	}
	@Override
	public void sing() {
		System.out.println("참새("+getName()+")가 소리내어 웁니다.");
	}

}
