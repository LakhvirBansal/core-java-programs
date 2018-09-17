package Immutable;

public final class ImmutableExample {

	private int i;

	public ImmutableExample(int i) {
		this.i = i;
	}

	public ImmutableExample modify(int i) {
		if (this.i == i) {
			return this;
		}
		return new ImmutableExample(i);
	}

	public static void main(String[] args) {
		ImmutableExample c1 = new ImmutableExample(10);
		ImmutableExample c2 = c1.modify(100);
		ImmutableExample c3 = c1.modify(10);
		System.out.println(c1 == c2);// false
		System.out.println(c1 == c3);// true
		ImmutableExample c4 = c1.modify(100);
		System.out.println(c2 == c4);// false

	}
}
