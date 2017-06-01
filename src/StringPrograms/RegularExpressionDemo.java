package StringPrograms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {

	public static void main(String[] args) 
	{
		Pattern p=Pattern.compile("[7-9]{9}[0-9]");
		Matcher m=p.matcher("7777777776");
		
		
		/*while(m.find())
		{
			System.out.println(m.start()+"-------"+m.group());
		}*/
		System.out.println(m.matches());

	}

}
