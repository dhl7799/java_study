package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		/*
		synchronized(v) {
			v.addElement("둘리");
			v.addElement("마이콜");
			v.addElement("도우너");
		}*/
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		//순회1
		for(int i=0; i<list.size();i++) {
			String s= list.get(i);
			System.out.println(s);
		}
		
		//삭제 - 값으로 비교해서 삭제
		//v.removeElement("둘리");
		list.remove(2);
		
		//순회2
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
			
		}
		
		for(String s : list)
			System.out.println(s);

	}

}
