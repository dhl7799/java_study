package prob6;
import java.util.*;
public class RectTriangle extends Shape{

	public RectTriangle(int w, int h) {
		// TODO Auto-generated constructor stub
		super(w,h);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getWidth()*getHeight()*0.5;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return getWidth()+getHeight()+Math.sqrt(Math.pow(getWidth(),2)+Math.pow(getHeight(),2));
	}

}
