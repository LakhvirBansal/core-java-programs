package Generics;

public final class ImmuatbleDemo {

	private int i;

	ImmuatbleDemo(int i) {
		this.i = i;
	}

	public ImmuatbleDemo modify(int val) {
		if (this.i == val) {
			return this;
		} else {
			return new ImmuatbleDemo(val);
		}
	}

	public static void main(String[] args) {
		ImmuatbleDemo i = new ImmuatbleDemo(10);
		ImmuatbleDemo i1 = i.modify(20);
		ImmuatbleDemo i2 = i.modify(10);

		System.out.println(i.equals(i1));
		System.out.println(i.equals(i2));
	}
}
