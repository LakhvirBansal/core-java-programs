package Patterns;

/*
 * create a pattern for a given number
 * 
 * Exmaple number is 5
 * output :-
 * 5 4 3 2 1
 * 	4 3 2 1
 *   3 2 1
 *    2 1
 *     1
 * 
 */
public class Pyramid {

	public static void main(String[] args) {
	
		int count = 0;
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
