package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods camera = new Goods();
		camera.setName("nikon");
		camera.setPrice(400000);
		System.out.println(camera.calcDiscountPrice(0.5f));
		camera.setCountStock(30);
		camera.setCountSold(50);
		
		camera.printInfo();
		
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods);
		
		Goods tv = new Goods("TV", 400000, 10, 20);
		tv.printInfo();
		
	}

}
