package chapter03;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SwapTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Value a = new Value(10);
		Value b = new Value(20);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		System.out.println("a:" +a.val + ", b:" +b.val);
		swap(a,b);
		System.out.println("a:" +a.val + ", b:" +b.val);
		
	}
	
	public static void swap(Value m, Value n) {
		int tem = m.val;
		m.val = n.val;
		n.val = tem;
	}

}
