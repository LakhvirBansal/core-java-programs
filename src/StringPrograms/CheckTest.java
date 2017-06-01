package StringPrograms;

public class CheckTest {

	public static void main(String[] args) {
		int a[] = {1,2,7,5,7,4,1,1,2,5};
		
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]){
					count = count + 1;
				}
			}
		}
		
		System.out.println(count);
	}
}
