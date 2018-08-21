package Java8;

public class MethodReference {

	public static void m1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread");
		}
	}

	public static void main(String[] args) {
		Runnable r = MethodReference::m1;
	}
}
