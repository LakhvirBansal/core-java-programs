package Synchronization;

class Display {

	public static synchronized void wish(String name) {

		for (int i = 0; i < 10; i++) {

			System.out.print("Good morning :");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {

			}
			System.out.println(name);
		}
	}
}

class MyThread extends Thread {

	Display d;
	String name;

	MyThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		d.wish(name);
	}
}
public class SynchronizedDemo {

	public static void main(String[] args) {
		Display d = new Display();
		Display d1 = new Display();
		MyThread myThread = new MyThread(d, "dhoni");
		myThread.start();
		MyThread myThread2 = new MyThread(d1, "yuvraj");
		myThread2.start();
	}
	
}
