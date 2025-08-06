import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class FineCalculation {
	
	public static int calculate(Date issueDate) {
		int fixdate = 14;
		
		java.util.Date date = new java.util.Date(issueDate.getTime());
		java.util.Date currentDate = new java.util.Date();
		
		long milli = currentDate.getTime();
		long issdt = date.getTime();
		
		long duration = milli - issdt ;
		long diffInDay = TimeUnit.MILLISECONDS.toDays(duration);
		
		int days = (int)diffInDay;
		System.out.println("Total Days: "+days);
		
		if(days > fixdate)
		{
			int fine = (days - fixdate)*2;
			System.out.println("Total Fine: "+fine);
			return fine;
		}
		
		return 0;
	}
}
