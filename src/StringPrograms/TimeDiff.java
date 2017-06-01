package StringPrograms;

import java.util.Calendar;
import java.util.Date;

public class TimeDiff {

	public static void main(String[] args) {
		Date d1 = new Date();
		
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

		Calendar date = Calendar.getInstance();
		long t= date.getTimeInMillis();
		Date afterAddingTenMins=new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
		
		System.out.println(afterAddingTenMins.getTime() - d1.getTime());
 	}
}
