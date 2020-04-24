package graph;
/*
 * flood fill algorithm is to fill a bounded area with a particular value
 * 
 * Technique = we need to DFS here (recursion is used for DFS)
 * I/p -> 	1111111111 
			1000000001 
			1000000001 
			1000000001 
			1000000001 
			1000000001 
			1000000001 
			1000000001 
			1000000001 
			1111111111 

output :- 
			1111111111 
			1222222221 
			1222222221 
			1222222221 
			1222222221 
			1222222221 
			1222222221 
			1222222221 
			1222222221 
			1111111111 

 */
public class FloodFillAlgorithm {

	static int[][] arr = new int[10][10];
	public static void main(String[] args) {
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i == 0 || i== arr.length -1) {
					arr[i][j] = 1;
				}
				
				 if(j == 0 || j== arr.length -1) { 
					 arr[i][j] = 1;
				}
				 
			}
		}
		
		printArray();
		System.out.println(" ");
		floodFill(arr,8,8,0,2);
		printArray();
	}

	private static void printArray() {
	  for (int i = 0; i < arr.length; i++) { 
		  for (int j = 0; j < arr.length; j++) {
			  System.out.print(arr[i][j]); 
		  } 
		  System.out.println(" "); 
	  }
	}

	private static void floodFill(int[][] arr, int i, int j, int val, int replaceVal) {
		// base case check matrix boundry or element present at current location is different.
		if(i<0||j<0||i>=10||j>=10||arr[i][j]!=val){
			return;
		}

		arr[i][j] = replaceVal;
		/*
		 * printArray(); System.out.println(" ");
		 */

		//Call to fill the color on neighbouring cells (four neighbour of (i,j) -> (i+1,j), (i-1,j), (i,j+1), (i,j-1)
		floodFill(arr,i+1,j,val,replaceVal);
		floodFill(arr,i,j+1,val,replaceVal);
		floodFill(arr,i-1,j,val,replaceVal);
		floodFill(arr,i,j-1,val,replaceVal);
	}
}
