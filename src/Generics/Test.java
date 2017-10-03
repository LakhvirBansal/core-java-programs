package Generics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class A {

	int i;

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}

public class Test {

	public static void main(String[] args) {
		Set<A> set = new HashSet<A>();
		Map<A,String> map = new HashMap<A, String>();
		for (int i = 0; i < 10; i++) {
			A a = new A();
			set.add(a);
			map.put(a, "a" + i);
		}

		System.out.println("set contains :" + set.contains(new A()));
		System.out.println("map contains :" + map.containsKey(new A()));
		System.out.println(set.size());
		for (A a : set) {
			System.out.println(a.i);
		}
	}
}
