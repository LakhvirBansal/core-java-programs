package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {

	int rollNo;
	String name, address;
	int timeTaken;

	public Student(int rollno, String name, String address) {
		this.rollNo = rollno;
		this.name = name;
		this.address = address;
	}

	public Student(String name, int time) {
		this.name = name;
		this.timeTaken = time;
	}
	// Used to print student details in main()
	public String toString() {
		return this.rollNo + " " + this.name + " " + this.address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

}

class SortByRoll implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		return a.rollNo - b.rollNo;
	}
}

class SortByName implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub

		if (a.name.compareTo(b.name) == 0) {
			return a.address.compareTo(b.address);
		}
		return a.name.compareTo(b.name);
	}

}

public class Main {
	public static void main(String[] args) {
		ArrayList<Student> ar = new ArrayList<Student>();
		ar.add(new Student(111, "bbbb", "london"));
		ar.add(new Student(131, "aaaa", "aaa"));
		ar.add(new Student(121, "aaaa", "bbb"));
		ar.add(new Student(121, "aaaa", "abc"));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));


		Collections.sort(ar, new SortByName());

		System.out.println("\nSorted by name");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}
}