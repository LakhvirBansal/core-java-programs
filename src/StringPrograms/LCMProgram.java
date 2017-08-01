package StringPrograms;

public class LCMProgram {

	public static void main(String[] args) {
		 int arr[] = {2, 7, 3, 9, 4};
		  
		    System.out.println("the value is :"+findLCM(arr));
	}

	private static int findLCM(int[] arr) {
		int ans = arr[0];
		  for (int i=1; i<arr.length; i++){
			  int firstVal = arr[i]*ans;
			  int gcdVal = gcd(arr[i], ans);
			  ans = firstVal / gcdVal;
		  }
		 
		    return ans;
	}

	private static int gcd(int a, int b) {
		
		if (b==0) {
			return a;
		}
		
	    return gcd(b, a%b);
	}
}
