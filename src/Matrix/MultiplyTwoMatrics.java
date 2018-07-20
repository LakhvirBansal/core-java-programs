package Matrix;

/*Input : m1[][] = {{1, 2},
						{3, 4}}
 		  m2[][] = {{1, 1}, 
 						{1, 1}}
 			Output : {{3, 3}, 
 					{7, 7}}
 					
 		[	m1[0][0] * m2[0][0] + m1[0][1]* m2[1][0]    m1[0,0]* m2[0,1] + m1[0,1]*m2[1,1]   
 		    m1[1,0] * m2[0,0] + m1[1,1] * m2[1,0]       m1[1,0]*m2[0,1] +  m1[1,1]*m2[1,1]   ]		
*/

public class MultiplyTwoMatrics {

	static int N = 2;

	public static void main(String[] args) {

		int mat1[][] = { { 2, 4 }, { 3, 4 } };

		int mat2[][] = { { 1, 2 }, { 1, 3 } };

		int res[][] = new int[N][N];
		int i, j;
		multiply(mat1, mat2, res);

		System.out.println("Result matrix" + " is ");
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}

	private static void multiply(int[][] mat1, int[][] mat2, int[][] res) {

		int i, j, k;
		
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				res[i][j] = 0;
				for (k = 0; k < N; k++) {
					res[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}

	}
}
