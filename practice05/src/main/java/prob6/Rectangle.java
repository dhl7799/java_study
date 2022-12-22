package prob6;

public class Rectangle extends Shape implements Resizable{

	public Rectangle(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getWidth()*getHeight();
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*getWidth()+2*getHeight();
	}
	@Override
	public void resize(double s) {
		setWidth(s*getWidth());
		setHeight(s*getHeight());
	}
	
	

}
