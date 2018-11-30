package Java;

import java.util.HashMap;
import java.util.Map;

class Employee {

	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	/*
	 * @Override public boolean equals(Object obj) { return true; }
	 */

	
}
public class TestMap {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "gagan");
		Employee e2 = new Employee(1, "gagan");
		Employee e3 = new Employee(1, "lakhvir");
		Employee e4 = new Employee(1, "dvhdsf");
		Employee e5 = e1;

		Map<Employee, Integer> map = new HashMap<Employee, Integer>();
		map.put(e1, 1);
		map.put(e2, 2);
		map.put(e3, 3);
		map.put(e5, 5);


		System.out.println(map.size());
		System.out.println(map.get(e4));
	}
}
