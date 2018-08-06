package Java8;

public class InterfaceStaticmethodForOverriding implements Interf {

	@Override
	public void m1() {
		// TODO Auto-generated method stub

	}

	/**
	 * same as defined in interface but this is not overriding because interface method are not available to implemented
	 * class then there is not concept of overriding.
	 */
	public static void m3() {
		System.out.println("implemented class static method");
	}

	/**
	 * we can reduce the scope because method overriding is not possible with interfaces static methods.
	 */
	/*
	 * private static void m3() {
	 * System.out.println("implemented class private method that is same as interface public method"); }
	 */

	/*
	 * public void m3() {
	 * System.out.println("Implemented class non-static method declared as same as interface static method"); }
	 */
	public static void main(String[] args) {
		m3(); // implemeted class method
		Interf.m3(); // interface static method
	}
}
