package Java8;

public class MethodReferenceDemo {

	public static void m2() {
		System.out.println("m2 method");
	}

	public static void main(String[] args) {
		Interf i = MethodReferenceDemo::m2;
		i.m1();
	}
}
