package CustomHashSet;

public class HashSetCustomApp {

	public static void main(String[] args) {
		HashSetCustom<Integer> hashSetCustom = new HashSetCustom<Integer>();
		hashSetCustom.add(21);
		hashSetCustom.add(25);
		hashSetCustom.add(30);
		hashSetCustom.add(33);
		hashSetCustom.add(35);

		System.out.println("HashSetCustom contains 21 =" + hashSetCustom.contains(21));
		System.out.println("HashSetCustom contains 51 =" + hashSetCustom.contains(51));

		System.out.print("Displaying HashSetCustom: ");
		hashSetCustom.display();

		System.out.println("\n\n21 removed: " + hashSetCustom.remove(21));
		System.out.println("22 removed: " + hashSetCustom.remove(22));

		System.out.print("Displaying HashSetCustom: ");
		hashSetCustom.display();

	}
}
