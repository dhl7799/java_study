package chaptor04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);
		
		String s1 = String.valueOf(i);
		String s2 = "" + i;
		System.out.println(s1);
		System.out.println(s2);
		
		int i1 = Character.getNumericValue('A');
		int i2 = '9' - '0';
		System.out.println(i1);
		System.out.println(i2);
		
		//2진수
		String ss = Integer.toBinaryString(15);
		System.out.println(ss);
		
		//16진수
		String sss = Integer.toHexString(15);
		System.out.println(sss);
		int[] data = {1,2,3,4,5};
		int[] data2 = {1,1,1,1,1};
		//int[data.length] tdata = data2;
	}

}
