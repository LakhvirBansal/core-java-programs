package ThreadLocal;

class customerThread extends Thread {
	
	static Integer custId = 0;
	
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return ++custId;
		}
	};
	customerThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ": customerId is :" + tl.get());
	}
}
public class ThreadLocalDemo2 {

	public static void main(String[] args) {
		customerThread c1 = new customerThread("gagan");
		customerThread c2 = new customerThread("sumit");
		customerThread c3 = new customerThread("lucky");
		customerThread c4 = new customerThread("jyoti");

		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}
