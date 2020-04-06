package Java;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<String>();
		q.add("a");
		q.add("b");
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.remove());
		
	}
}
