package Overriding;

/**
 * we can not override static as non-static or vice-versa.
 */
class A {
	public static void a() { // here static a() method is a class level

	}
}

public class OverrideStatic extends A {

	/*
	 * public void a() { here methodOne() method is a object level hence we can’t override methodOne() method gives
	 * error because a() is static in A class }
	 */
}
