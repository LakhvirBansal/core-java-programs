package CustomLinkedHashMap;

public class LinkedHashMapCustomApp {

	public static void main(String[] args) {
		LinkedHashMapCustom<Integer, Integer> linkedHashMapCustom = new LinkedHashMapCustom<Integer, Integer>();

		linkedHashMapCustom.put(21, 12);
		linkedHashMapCustom.put(25, 121);
		linkedHashMapCustom.put(30, 151);
		linkedHashMapCustom.put(33, 15);
		linkedHashMapCustom.put(35, 89);

		System.out.println("Display values corresponding to keys>");
		System.out.println("value corresponding to key 21=" + linkedHashMapCustom.get(21));
		System.out.println("value corresponding to key 51=" + linkedHashMapCustom.get(51));

		System.out.print("Displaying : ");
		linkedHashMapCustom.display();

		System.out.println("\n\nvalue corresponding to key 21 removed: " + linkedHashMapCustom.remove(21));
		System.out.println("value corresponding to key 22 removed: " + linkedHashMapCustom.remove(22));

		System.out.print("Displaying : ");
		linkedHashMapCustom.display();

	}
}
