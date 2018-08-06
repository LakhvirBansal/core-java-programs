package Java8;

@FunctionalInterface
public interface Interf {

	public void m1();

	// public void sum(int a, int b);
	default public void m2() {
		System.out.println(" vdgnmfdsn dsfn cdshjg ");
	}

	static void m3() {
		System.out.println("interface static method");
	}

	public static void main(String[] args) {
		System.out.println("interface main method");
		System.out.println(args.length);
	}
}
