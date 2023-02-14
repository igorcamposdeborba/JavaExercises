package basic.challengeData;

public class Data {
	public Data() {}
	
	public static String getData(int day, int month, int year) {
		int dayFormatted = String.valueOf(day).length();
		int monthFormatted = String.valueOf(month).length();
		int yearFormatted = String.valueOf(year).length();
		
		String dayString = null;
		String monthString = null;
		String yearString = null;
		
		if (dayFormatted == 1) {
			dayString = "0" + day;
		} else {
			dayString = Integer.toString(day);
		}
		if (monthFormatted == 1) {
			monthString = "0" + month;
		} else {
			monthString = Integer.toString(month);
		}
		if (yearFormatted == 2) {
			yearString = "19" + year;
		} else {
			yearString = Integer.toString(year);
		}
		
		String calendarFormatted = dayString + "/" + monthString + "/" + yearString;
		return calendarFormatted;
	}
}
