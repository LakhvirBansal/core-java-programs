package Test;

public class Person {

	private String name;

	private Long age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Person(String name, Long age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object arg0) {

		if (this == arg0) {
			return true;
		}
		Person p = (Person) arg0;
		if (age == p.getAge() && name.equals(p.getName())) {
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return this.name + " age : " + this.age;
	}

	@Override
	public int hashCode() {
		return age.intValue();
	}

}
