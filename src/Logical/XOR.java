package Logical;

public class XOR {

	// Returns XOR of x and y
	static int myXOR(int x, int y) {
		return (x | y) & (~x | ~y);
	}

	// Driver Code
	public static void main(String[] args) {
		int x = 64, y = 128, z = 256;
		System.out.println("XOR is " + (myXOR(x, y)));
	}
}
