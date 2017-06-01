package StringPrograms;

import java.util.regex.Pattern;

public class PatternSplit {

	public static void main(String[] args) 
	{
		Pattern p=Pattern.compile("a+");
		String[] s=p.split("bhaaskar software solutions");
		for(String s1:s)
		{
			System.out.println(s1);
		}
		
	}

}
