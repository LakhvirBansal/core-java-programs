package Java8;

interface interf1 {
	static void m1() {
		System.out.println("interface static method");// to define general utility methods
		// any body calls this method by using interface name only
	}
}

public class InterfaceStaticMethod implements interf1 {

	public static void main(String[] args) {
		// InterfaceStaticMethod.m1(); // not possible because interface static
		// method not available to implemented
		// class

		InterfaceStaticMethod ism = new InterfaceStaticMethod();
		// ism.m1(); not allowed because inyterface static method method not
		// available to implemented class

		interf1.m1();
	}
}
