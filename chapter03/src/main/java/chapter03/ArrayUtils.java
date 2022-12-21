package chapter03;

public class ArrayUtils {
	static double [] intToDouble(int[] source) {
		double[] rdouble = new double[source.length];
		for(int i=0; i<source.length;i++) {
			rdouble[i] = (double)source[i];
		}
		return rdouble;
		
	}
	static int[] doubleToInt(double[] source) {
		int[] rint = new int[source.length];
		for(int i=0; i<source.length;i++) {
			rint[i] = (int)source[i];
		}
		return rint;
	}
}
