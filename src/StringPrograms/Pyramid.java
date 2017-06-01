package StringPrograms;


public class Pyramid {

	public static void main(String[] args) {
	
		int count = 0;
		Long startTime = System.currentTimeMillis();
		for (int i = 5; i >= 1; i--) {
			while(count > 0){
				System.out.print(" ");
				count--;
			}
			for (int j = i; j >=1; j--) {
				System.out.print(j+" ");
			}
			System.out.println();
			count = count + (5-i)+1;
		}
	}
}
