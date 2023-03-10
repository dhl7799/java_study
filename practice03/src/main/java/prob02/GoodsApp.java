package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		for(int i=0; i<COUNT_GOODS;i++) {
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			goods[i] = new Goods(infos[0],Integer.parseInt(infos[1]),Integer.parseInt(infos[2]));
		}
		for(int i=0; i<COUNT_GOODS;i++) {
			goods[i].printGoods();
		}
		// 자원정리
		scanner.close();
	}
}
