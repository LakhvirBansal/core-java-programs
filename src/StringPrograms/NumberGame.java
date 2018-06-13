package StringPrograms;

import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		for (int i = 0; i < number; i++) {

			Integer stacks = sc.nextInt();
			Integer noOfElementsInStack = sc.nextInt();

			if (stacks <= 2) {
				System.out.println("Mojo");
			} else {
				if (stacks % 2 != 0 || (stacks / 2) % 2 == 0) {
					System.out.println("Jojo");
				} else {
					System.out.println("Mojo");
				}
			}

		}


		
	}

}
