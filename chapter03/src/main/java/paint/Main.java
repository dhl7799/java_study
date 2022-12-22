package paint;

public class Main {

	public static void main(String[] args) {
		Point point = new Point();
		point.setX(10);
		point.setY(10);
		point.show();
		
		drawPoint(point);
		point.show(false);
		Point point2 = new ColorPoint();
		point2.setX(20);
		point2.setY(10);
		((ColorPoint)point2).setColor("red");
		rect rect = new rect();
		Triangle tr = new Triangle();
		Circle c = new Circle();
		drawPoint(point2);
		drawShape(rect);
		drawShape(tr);
		drawShape(c);
		draw(c);
		draw(point2);
	}
	
	public static void drawPoint(Point point) {
		point.show();
	}
	
	public static void drawColorPoint(ColorPoint cp) {
		cp.show();
	}
	/*
	public static void drawRect(rect rect) {
		rect.draw();
	}
	
	public static void drawTriangle(Triangle t) {
		t.draw();
	}
	
	public static void drawCircle(Circle c) {
		c.draw();
	}
	*/
	public static void drawShape(Shape sh) {
		sh.draw();
	}
	
	public static void draw(Drawable d) {
		d.draw();
	}
	
	
}
