package StringPrograms;

public class StringTrim {

	public static void main(String[] args) {
		String str = "      i am a software Engineer    ";
		String newStr ="";
		int strLength = str.length();
		for (int i = 0; i < strLength-1; i++) {
			if(str.charAt(i) != ' '){
				newStr = str.substring(i, strLength);
				break;
			}
		}
		
		for (int i = newStr.length()-1; i > 0; i--) {
			if(newStr.charAt(i) != ' '){
				newStr = newStr.substring(0, i+1);
				break;
			}
		}
		
		
		System.out.println("new String using trim :"+newStr);
	}
}
