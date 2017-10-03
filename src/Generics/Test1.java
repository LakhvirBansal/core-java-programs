package Generics;

class Overload {

	void m1(String i) {
		System.out.println("String Method");
	}

	void m1(Object i) {
		System.out.println("Object Method");
	}
}
public class Test1 {

	public static void main(String[] args) {

		Overload o = new Overload();
		o.m1(null);
		long time = System.currentTimeMillis();
		Integer[] a = { 4, 1, 3, 2 };

		int diff = 0;
		for (int i = 0; i < a.length; i++) {
			int nextVal = 0;
			if (i < a.length - 1) {
				nextVal = a[i + 1];
			} else {
				nextVal = a[a.length - 1];
			}

			if (nextVal > a[i]) {
				int val = nextVal - a[i];
				if (val > diff) {
					diff = val;
				}
			}
			/*
			 * for (int j = i + 1; j < a.length; j++) { if (a[i] < a[j]) { int val = a[j] - a[i]; if (val > diff) { diff
			 * = val; } } }
			 */
		}

		System.out.println("diff :" + diff);
	}
}
