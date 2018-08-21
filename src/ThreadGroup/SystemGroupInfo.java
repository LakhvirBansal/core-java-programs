package ThreadGroup;

public class SystemGroupInfo {

	public static void main(String[] args) {
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();

		Thread[] t = new Thread[system.activeCount()];

		int count = system.enumerate(t);
		System.out.println("the count is :" + count);

		for (Thread thread : t) {
			System.out.println(thread.getName() + ": isDaemon :" + thread.isDaemon());
		}

		ThreadGroup[] tg = new ThreadGroup[system.activeGroupCount()];
		int counttg = system.enumerate(tg);
		System.out.println("the count of subgroups is :" + counttg);

		for (ThreadGroup threadGroup : tg) {
			System.out.println("the threadgroup name is :" + threadGroup.getName());
		}

	}

}
