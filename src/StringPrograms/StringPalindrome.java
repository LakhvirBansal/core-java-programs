package StringPrograms;

public class StringPalindrome {

	public static void main(String[] args) {
		String s = "ssasasass";
		int stringLength = s.length();
		boolean palin = true;
		for (int i = 0,j = stringLength-1; i < stringLength-1; i++,j--) {
				if(i > j){
					break;
				}
				if(s.charAt(i) != s.charAt(j)){
					palin = false;
					break;
				}
			
		}
		
		if(palin == false){
			System.out.println("String is not palindrome");
		} else{
			System.out.println("String is palindrome");
		}
	}
}
