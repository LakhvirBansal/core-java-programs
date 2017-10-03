package Generics;

public class GenericsTest1<T extends Number> {

	public static void main(String[] args) {
		GenericsTest1<Integer> a = new GenericsTest1<Integer>();
		GenericsTest1<Double> a1 = new GenericsTest1<Double>();
	}
}
