package Generics;

import java.util.ArrayList;

public class Test4 {

	public static void main(String[] args)
	{
		ArrayList<String> l=new ArrayList<String>();
		l.add("A");
		//l.add(10);//C.E:cannot find symbol,method add(int)
		methodOne(l);
		// l.add(10.5);//C.E:cannot find symbol,method add(double)
		System.out.println(l);//[A, 10, 10.5, true]
	}
	public static void methodOne(ArrayList l)
	{
		l.add(10);
		l.add(10.5);
		l.add(true);
	}

}
