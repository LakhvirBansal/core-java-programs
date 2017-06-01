package StringPrograms;

public class CharCount {
	public static void main(String[] args) {
		String str ="bbfbfgbdb sddf sdsdc sdsd";
		char ch= 'b';
		int initialLength = str.length();
		
		str = str.replaceAll(String.valueOf(ch),"");
		int latestLength = str.length();
		
		System.out.println("the count is :"+(initialLength - latestLength));
	}
}
