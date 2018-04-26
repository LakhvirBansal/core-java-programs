package StringPrograms;

import java.util.Date;

public class ChangeLongToDate {

	public static void main(String a[]) {

		long tmp = 1470357329000l;

		long mp = 1460357329000l;

		Date d = new Date(tmp);
		System.out.println(d);
		Date d1 = new Date(mp);
		System.out.println(d1);

		Date currentDate = new Date();

		System.out.println(currentDate.compareTo(d));
	}
}
