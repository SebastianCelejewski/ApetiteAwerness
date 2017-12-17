package pl.sebcel.aa.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String toString(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		StringBuffer result = new StringBuffer();
		result.append(toString(year, 0));
		result.append("-");
		result.append(toString(month, 2));
		result.append("-");
		result.append(toString(day, 2));
		result.append(" ");
		result.append(toString(hour, 0));
		result.append(":");
		result.append(toString(minute, 2));

		return result.toString();
	}

	/**
	 * Converts int to String, optionally adding leading zeroes 
	 * 
	 * @param value value to be converted
	 * @param numberOfDigits total length of output including leading zeroes (0 - no leading zeroes)
	 * 
	 * @return converted number
	 */
	private static String toString(int value, int numberOfDigits) {
		String result = Integer.toString(value);
		if (numberOfDigits > 0) {
			while (result.length() < numberOfDigits) {
				result = "0" + result;
			}
		}
		return result;
	}
}