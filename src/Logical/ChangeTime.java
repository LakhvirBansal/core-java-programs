package Logical;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeTime {

	static String str = "2018-10-23T11-08-31 to 2018-10-23T11-38-31";

	// 23Oct,2018 11:08 to 23Oct,2018 11:38
	public static void main(String[] args) {
		// 2018/10/23-11:33:17
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		try {
			Date date = formatter.parse("2018/10/23-11:33:17");
			formatter = new SimpleDateFormat("ddMMM HH:mm");
			String strDate = formatter.format(date);
			System.out.println(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
