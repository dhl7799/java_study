package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.shape.rect;
import com.douzone.paint.text.GraphicText;

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
		draw(new GraphicText("Hello World"));
		System.out.println(point2 instanceof Drawable);
		//오류: 레퍼런스하고있는 class 타입의 hierachy 상의 하위와 상위만 instanceof 연산자 사용
		//연산자 우측항이 인터페이스인 경우
		System.out.println(c instanceof Runnable);
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
