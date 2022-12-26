package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		String s1 = new String("도우너");
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add("도우너");
		s.add("도우너");
		s.add(s1);
		System.out.println(s.size());
		System.out.println(s.contains("또치"));
		System.out.println(s.contains(s1));
		//순회1
		for(String str : s)
			System.out.println(str);
	}

}
