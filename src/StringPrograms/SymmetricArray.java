package StringPrograms;

public class CherckArr {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,5,4,3,7,1};
		
		int arrayHalfLength = a.length/2;
		int arrayLength = a.length;
		boolean isSymmetric = true;
		for (int i = 0; i < arrayHalfLength; i++) {
			if(a[i] != a[arrayLength-(i+1)]){
				isSymmetric = false;
				break;
			}
		}
		if(isSymmetric){
			System.out.println("true");
		} else{
			System.out.println("false");
		}
	}
}
