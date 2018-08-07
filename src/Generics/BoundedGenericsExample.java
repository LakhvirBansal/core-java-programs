package Generics;

/**
 * class Test<T extends X> {} 
 * 
 * If x is a class then as the type parameter we can pass either x or its child classes. 
 * If x is an interface then as the type parameter we can pass either x or its implementation classes.
 */

/**
 * • We can’t define bounded types by using implements and super keyword.
 */

/**
 * • As the type parameter we can use any valid java identifier but it convention to use T always.
 */

/**
 * We can pass any no of type parameters need not be one. HashMap<Integer,String> h=new HashMap<Integer,String>();
 */

/**
 * • We can’t extend more than one class at a time 
 * class Test<T extends Number&String>
 */

class generics<T extends Number> {

}
public class BoundedGenericsExample {

	public static void main(String[] args) {
		generics<Integer> g1 = new generics<Integer>();
		// generics<String> g2 = new generics<String>();
	}
}
