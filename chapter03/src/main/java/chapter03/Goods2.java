package chapter03;

public class Goods2 {
	public String name;		//모두
	protected int price;	//같은 패키지 + 자식
	int countStock;			//같은 패키지
	private int countSold;	//클래스 내부
	
	public void m() {
		countSold = 50;
	}
}
