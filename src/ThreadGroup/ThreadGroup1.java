package ThreadGroup;

public class ThreadGroup1 {

	public static void main(String[] args) {

		// every thread belongs to some threadgroup
		// main thread belongs to main thread group
		System.out.println(Thread.currentThread().getThreadGroup().getName());

		// for every thread system threadgroup is a parent thread group either directly or indirectly.
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());

		// constructor to create a threadgroup.
		ThreadGroup g1 = new ThreadGroup("first threadgroup ");

		// by default the parent threadgroup is the executing thread threadgroup.
		System.out.println(g1.getParent().getName());

		// we can explicitly define the parentThreadGroup of creating threadgroup.
		ThreadGroup g2 = new ThreadGroup(g1, "first threadgroup ");
		System.out.println(g2.getParent().getName());
	}
}
