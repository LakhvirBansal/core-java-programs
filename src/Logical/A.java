package Logical;

public class A extends Thread {

	int count = 0;

	public void run() {
		System.out.println("run");
		synchronized (this) {
			for (int i = 0; i < 50; i++) {
				count = count + i;
			}
			notify();
		}
	}
}
