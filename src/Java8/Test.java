package Java8;

public class Test {

	int x = 777;

	public void m2() {
		Interf i = () -> {
			int x = 888;

			System.out.println(x);
			System.out.println(this.x);
		};
		i.m1();
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.m2();
		/*Interf i = () -> System.out.println("lambda expression");
		i.m1();*/

		/*Interf i = (a, b) -> System.out.println(a + b);
		i.sum(10, 20);*/
	}
}
