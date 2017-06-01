package StringPrograms;

public class AndOp {
	public static void main(String[] args) {
		
		int i = (int) Math.random();
		System.out.println(i);
		int a = 10;
		int b = 10;
		if(a == b || b/0 == 0){
			System.out.println("false");
		}
		
		System.out.println("true");
	}
}
