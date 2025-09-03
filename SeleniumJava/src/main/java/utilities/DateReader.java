package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateReader {
	private DateReader() {
		super();
	}
	
	public static String getCurrentDate() {
		Date date=new Date();
		return date.toString().replace(":", "_").replace(" ","_");
	}
	
	public static String getCurrentDateTime() {
		Date dateTime=new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		return format.format(dateTime);
	}
	
	public static String getCurrentDateTimeCustom(String dateSeparator,String timeSeparator) {
		Date dateTime=new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String dateTimeModified=format.format(dateTime).replace("/", dateSeparator).replace(" ", "_").replace(":", timeSeparator);
		return dateTimeModified;
	}
}
