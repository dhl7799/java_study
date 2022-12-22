package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {
		String rstr = "";
		for(int i=0; i<str.length;i++) {
			rstr += str[i];
			if(i!=str.length-1)
				rstr += " ";
		}
		return rstr;
	}
}
