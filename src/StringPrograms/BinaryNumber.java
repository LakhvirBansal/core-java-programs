package StringPrograms;

public class BinaryNumber {

	 public static int ConvertBinaryArrayToInt(int[] val){
		 
		 StringBuilder sb = new StringBuilder();
	  
		  for(int x : val){
			  sb.append(x);
		  }
		  int decimalNum = Integer.parseInt(sb.toString(),2);
	        
	      System.out.println(decimalNum);
	      return decimalNum;
	  }
	 
	 public static void main(String[] args) {
		 
		 int[] arr = {1,0,0,1};   
		 ConvertBinaryArrayToInt(arr);
	 }
}
