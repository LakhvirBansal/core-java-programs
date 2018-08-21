package ThreadGroup;

public class ThreadGroupPriorty {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("parent");
		MyThread t1 = new MyThread(tg, "thread1");
		MyThread t2 = new MyThread(tg, "thread2");
		t1.start();
		t2.start();
		tg.setMaxPriority(3);
		MyThread t3 = new MyThread(tg, "thread3");
		t3.start();
		tg.list();
	}
}
