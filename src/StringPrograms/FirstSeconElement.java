package StringPrograms;

public class FirstSeconElement {
	public static void main(String[] args) {
		int firstElement=0;
		int secondElement=0;
		
		int[] arr ={9,8,7,6,5,4,3,2,1};
		
		for (int i = 0; i < arr.length; i++) {
			if(i==0){
				firstElement = arr[i];
			}
			if(firstElement > arr[i]){
				int temp = firstElement;
				secondElement = temp;
				firstElement = arr[i];
			}
		}
		
		System.out.println("firstElement :"+firstElement+" secondElement :"+secondElement);
	}
}
