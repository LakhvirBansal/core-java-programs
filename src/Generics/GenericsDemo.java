package Generics;

class UDGenerics<T> {
	T obj;

	UDGenerics(T t) {
		this.obj = t;
	}

	public void show() {
		System.out.println("The type of object is :" + obj.getClass().getName());
	}

	public T getObject() {
		return obj;
	}

}
public class GenericsDemo {

	public static void main(String[] args) {
		UDGenerics<Integer> obj1 = new UDGenerics<Integer>(10);
		obj1.show();
		System.out.println(obj1.getObject());

		UDGenerics<String> obj2 = new UDGenerics<String>("lucky");
		obj2.show();
		System.out.println(obj2.getObject());

		UDGenerics<Double> obj3 = new UDGenerics<Double>(10.5);
		obj3.show();
		System.out.println(obj3.getObject());

	}
}
