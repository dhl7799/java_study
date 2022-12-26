package chaptor04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);

	}
	
	public static void printDate01(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(d);
		
		System.out.println(date);
	}
	
	public static void printDate02(Date d) {
		//년도
		int year = d.getYear();
		int month = d.getMonth();
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();
		System.out.println(
				(year+1900) + "-" +
				(month+1) + "-" +
				date + " " +
				hours + ":" +
				minutes + ":" +
				seconds
				
		);
		
		//월
		//일
		//시
		//분
		//초
		
	}
}
