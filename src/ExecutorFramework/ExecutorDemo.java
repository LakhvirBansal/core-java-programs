package ExecutorFramework;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable {

	String name;

	public MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println("run method start for :" + name + ": and thread name is :"
				+ Thread.currentThread().getName());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out
				.println("run method ends for :" + name + ": and thread name is :" + Thread.currentThread().getName());

	}

}
public class ExecutorDemo {

	public static void main(String[] args) {

		MyRunnable[] r = { new MyRunnable("lucky"), new MyRunnable("gagan"), new MyRunnable("sumit"),
				new MyRunnable("manoj"), new MyRunnable("kailash"), new MyRunnable("dharm") };
		ExecutorService service = Executors.newFixedThreadPool(3);

		for (MyRunnable myRunnable : r) {
			service.submit(myRunnable);
		}

		service.shutdown();

	}
}
