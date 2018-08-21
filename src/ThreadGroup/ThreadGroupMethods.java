package ThreadGroup;

class MyThread extends Thread {

	MyThread(ThreadGroup g, String name) {
		super(g, name);
	}

	public void run() {
		System.out.println("child thread");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {

		}
	}
}
public class ThreadGroupMethods {

	public static void main(String[] args) {
		System.out.println("dskgddsf vnbhjdsbhj ");
		ThreadGroup mg = new ThreadGroup("parent group");
		ThreadGroup cg = new ThreadGroup(mg, "child group");

		MyThread thread1 = new MyThread(mg, "thread1");
		MyThread thread2 = new MyThread(mg, "thread2");
		thread1.start();
		thread2.start();
		System.out.println(mg.activeCount()); // 2
		System.out.println(mg.activeGroupCount());
		mg.list();

		try { // after 10 secs both threads are going into dead state
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(mg.activeCount()); // 0
		System.out.println(mg.activeGroupCount());
		mg.list();

		System.out.println(mg.isDaemon());
	}
}
