package Comparator;

import java.util.Comparator;

public class SortByNameAndTime implements Comparator<Student> {


	@Override
	public int compare(Student Student1, Student student2) {
		// TODO Auto-generated method stub

		if (Student1.getName().compareTo(student2.getName()) == 0) {

		}
		return 0;
	}

}
