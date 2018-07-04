package StringPrograms;

import java.util.HashMap;
import java.util.Map;

public class TestGenerics<T> {

	void m1(T t) {
		System.out.println(t.getClass());
		if (t instanceof HashMap) {
			System.out.println(t);
		}
	}
	public static void main(String[] args) {
		
		TestGenerics t = new TestGenerics();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		t.m1(map);
	}
}
