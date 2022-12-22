package prob6;

public abstract class Shape {
	private double width;
	private double height;
	public Shape(int w, int h) {
		this.width = (double)w;
		this.height = (double)h;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	
}
