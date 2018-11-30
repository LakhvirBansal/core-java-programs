package Java;

public class TestEquals {

	public static void main(String[] args) {
		String a = "aasas";
		String b = "aasas";
		String c = "sd";

		System.out.println(a.equals(b));
		System.out.println(a.hashCode() == b.hashCode());

		System.out.println(c.hashCode() == b.hashCode());
		System.out.println(c.equals(b));

		int[] arr = new int[10];
		arr[0] = 1;
		System.out.println(arr.length);
	}

}
