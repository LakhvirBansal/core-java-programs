package Overriding;

public class OverrideVariables {

	/**
	 * overriding concept is not applicable for variables.
	 * Variable resolution is always takes care by compiler based on reference type.
	 */
	public static void main(String[] args) {
		BaseClass b = new BaseClass();
		System.out.println(b.x);

		OverrideClass oc = new OverrideClass();
		System.out.println(oc.x);

		BaseClass oc1 = new OverrideClass();
		System.out.println(oc1.x);
	}
}
