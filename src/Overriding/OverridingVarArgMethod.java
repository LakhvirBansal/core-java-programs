package Overriding;

public class OverridingVarArgMethod {

	public static void main(String[] args) {

		/**
		 * var-arg method is override only with var-arg method, If we are trying to override with normal method then it
		 * will become overloading but not overriding.
		 */
		BaseClass b = new BaseClass();
		b.m1(10);

		OverrideClass oc = new OverrideClass();
		oc.m1(20);

		BaseClass c = new OverrideClass();
		c.m1(30);
		c.m1(30);
	}

}
