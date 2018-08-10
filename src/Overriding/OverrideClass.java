package Overriding;

public class OverrideClass extends BaseClass {

	int x = 200;
	public void m1(int... a) {
		System.out.println("overrideclass var-arg method :" + a[0]);
	}

	public void m1(int a) {
		System.out.println("overrideclass ");
	}
}
