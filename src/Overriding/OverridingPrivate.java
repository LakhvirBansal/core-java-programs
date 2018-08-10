package Overriding;

class parent {
	private void m1() {

	};

}

class child extends parent {
	private void m1() {
		System.out.println("child class m1 method");
	}

	public static void main(String[] args) {
		child c = new child();
		c.m1();
	}
}

public class OverridingPrivate {

	public static void main(String[] args) {

	}
}
