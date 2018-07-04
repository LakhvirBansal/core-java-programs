package CustomHashMap;

public class HashMapCustomDemo {

	public static void main(String[] args) {

		/*HashMapCustom<Employee, Integer> hashMapCustom = new HashMapCustom<Employee, Integer>();
		hashMapCustom.put(new Employee("10", "sam"), 12);
		hashMapCustom.put(new Employee("21", "amy"), 121);
		hashMapCustom.put(new Employee("31", "rob"), 151);
		hashMapCustom.put(new Employee("41", "sam"), 15);
		hashMapCustom.put(new Employee("42", "wil"), 89);
		hashMapCustom.display();*/

		HashMapCustom<Integer, Integer> hashMapCustom1 = new HashMapCustom<Integer, Integer>();
		Integer key1 = 10;
		System.out.println(key1.hashCode());
		Integer key2 = 10;
		System.out.println(key2.hashCode());
		hashMapCustom1.put(key1, 12);
		hashMapCustom1.put(key2, 121);
		hashMapCustom1.put(11, 89);
		hashMapCustom1.display();

		/*System.out.println("Display values corresponding to keys>");
		System.out.println("value corresponding to employee with id=21 & name='amy' : "
				+ hashMapCustom.get(new Employee("21", "amy")));
		System.out.println("value corresponding to employee with id=51 & name='pat' : "
				+ hashMapCustom.get(new Employee("51", "pat")));

		System.out.print("Displaying : ");
		hashMapCustom.display();

		System.out.println("\n\nvalue corresponding to employee with id=21 & name='amy' removed: "
				+ hashMapCustom.remove(new Employee("21", "amy")));
		System.out.println("value corresponding to employee with id=51 & name='pat' removed: "
				+ hashMapCustom.remove(new Employee("51", "pat")));

		System.out.print("Displaying : ");
		hashMapCustom.display();*/

	}
}
