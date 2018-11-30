package Logical;

public class MethodNullReference {

	public static void m1() {
		System.out.println("m1 method");
	}

	public void m2() {
		MethodNullReference methodNullReference = null;
		methodNullReference.m1();
	}
	public static void main(String[] args) {
		MethodNullReference methodNullReference = new MethodNullReference();
		methodNullReference.m2();
	}
}
