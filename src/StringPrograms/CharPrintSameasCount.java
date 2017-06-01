package StringPrograms;

public class CharPrintSameasCount {
	public static void main(String[] args) {
		String str ="abcd";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch =  str.charAt(i);
			char CapsCh = (char) (ch -32);
			sb.append(CapsCh);
			int j = i;
			while(j > 0){
				sb.append(ch);
				j--;
			}
			if(i < (str.length() -1))
			sb.append("-");
		}
		
		System.out.println(sb.toString());
	}
}
