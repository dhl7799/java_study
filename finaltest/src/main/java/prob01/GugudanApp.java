package prob01;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GugudanApp {

	static int resultNumber = 0;

	public static void main(String[] args) {
		
		Set<Gugudan> set = new HashSet<>();
		
		for(Gugudan g : set) {
			System.out.println(g.getlValue() +", " + g.getrValue());
		}
		
		int l = randomize(1, 9);
		int r = randomize(1, 9);

		Gugudan resultNumber = new Gugudan(l,r);

		set = randomizeAnswers();
		int loc = randomize(0, 8);
		List<Gugudan> list = new ArrayList<>(set);
		list.set(loc, resultNumber);

		System.out.println(l + " x " + r + " = ?");

		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print((list).get(i).setvalue());
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		System.out.println((answer == resultNumber.setvalue()) ? "정답" : "오답");
	}
	
	private static int randomize(int lNum, int rNum) {
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}

	private static HashSet<Gugudan> randomizeAnswers() {
		HashSet<Gugudan> set = new HashSet<>();
		final int COUNT_ANSWER_NUMBER = 9;
		//int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];
		while(set.size() <COUNT_ANSWER_NUMBER) {
			Gugudan g = new Gugudan((int)((Math.random() * 9) + 1),(int)((Math.random() * 9) + 1));
			set.add(g);
		}
		return set;
	}
}
