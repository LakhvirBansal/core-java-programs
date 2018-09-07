package Logical;

import java.util.Vector;

public class Output1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Vector obj = new Vector(4, 2);
		obj.addElement(new Integer(3));
		obj.addElement(new Integer(2));
		obj.addElement(new Integer(5));
		System.out.println(obj.elementAt(3));

		Integer i1 = new Integer(2000);
		Integer i2 = new Integer(3000);
		Integer i3 = new Integer(4000);

		Object a = i1;
		i1 = i2;
		i2 = i3;
		i3 = null;// Line 15
	}

}
