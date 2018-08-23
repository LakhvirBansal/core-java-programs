package ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int total = 0;
		for (int i = 0; i < 10; i++) {
			total = total + i;
		}

		return total;
	}

}
public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(1);
		MyCallable m = new MyCallable();
		
		Future<Integer> val = service.submit(m);
		System.out.println(val.get());
	}
}
