package Logical;

public class Test1 {

	public static void main(String argv[]) {
		A a = new A();
		a.start();
		synchronized (a) {
			System.out.println("waiting");
			try {
				a.wait();
			} catch (InterruptedException e) {

			}
			System.out.println(a.count);

		}
	}
}
