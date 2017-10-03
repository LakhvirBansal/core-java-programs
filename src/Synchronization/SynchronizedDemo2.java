package Synchronization;

class DisplayData {

	public static synchronized void displayn() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {

			}
		}
	}

	public static synchronized void displayc() {
		for (int i = 65; i <= 75; i++) {
			System.out.println((char) i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {

			}
		}
	}
}

class DisplayNumber extends Thread {
	DisplayData d;

	public DisplayNumber(DisplayData d) {
		this.d = d;
	}

	@Override
	public void run() {
		d.displayn();
	}
}

class DisplayCharacter extends Thread {
	DisplayData d;

	public DisplayCharacter(DisplayData d) {
		this.d = d;
	}

	@Override
	public void run() {
		d.displayc();
	}
}
public class SynchronizedDemo2 {

	public static void main(String[] args) {
		DisplayData d = new DisplayData();
		
		DisplayNumber num = new DisplayNumber(d);
		num.start();
		
		DisplayCharacter ch = new DisplayCharacter(d);
		ch.start();
	}
}
