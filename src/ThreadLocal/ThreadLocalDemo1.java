package ThreadLocal;

public class ThreadLocalDemo1 {

	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<String>() {
			public String initialValue() {
				return "abc";
			}
		};

		System.out.println(tl.get());
		tl.set("main");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());
	}
}
