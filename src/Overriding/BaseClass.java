package Overriding;

public class BaseClass {

	int x = 100;
	public void m1(int... a) {
		System.out.println("base class var arg method :" + a[0]);
	}
}
