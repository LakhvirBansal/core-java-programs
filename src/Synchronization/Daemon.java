package Synchronization;

class DaemonThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("lazy thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}

}

public class Daemon {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isDaemon());
		// Thread.currentThread().setDaemon(true);

		DaemonThread d = new DaemonThread();
		System.out.println(d.isDaemon());
		d.setDaemon(true); // if one thread is daemon thread and another one is non-daemon then daemon thread
		d.start();
	}
}
