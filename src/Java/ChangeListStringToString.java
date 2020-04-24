package Java;

import java.util.ArrayList;
import java.util.List;

public class ChangeListStringToString {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("lakhvir");
		names.add("bansal");
		
		String wholeStr = names.toString();
		System.out.println(wholeStr);
	}
}
