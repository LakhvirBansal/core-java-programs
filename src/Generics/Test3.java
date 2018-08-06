package Generics;
public class Test3 {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = new String("hello");
		String s3 = new String("hello");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s2 == s3);
		System.out.println(s2.equals(s3));

		String s4 = s1;
		System.out.println(s1 == s4);
		System.out.println(s1.equals(s4));
		System.out.println(s2.replaceAll("l", "z"));
		System.out.println(s2);

		String s5 = new String();
		s5 = s1 + s2 + s3 + s4;
		System.out.println(s5);

	}
}
