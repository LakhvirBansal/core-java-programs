package Java8;

class P {
	private void m1() {
	}
}

class C extends P {
	public void m1() {
	}
}
public interface DefaultInterface {

	default public void m2() {
		System.out.println(" default method");
	}

	public static void main(String[] args) {
		System.out.println("main method ");
	}
}
