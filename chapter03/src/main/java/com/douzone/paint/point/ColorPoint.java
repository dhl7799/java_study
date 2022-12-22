package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;
	public ColorPoint() {
		
	}
	public ColorPoint(int x, int y, String color) {
		super(x,y);
		this.color = color;
		
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(getX() + "," +getY() + " 에 " + "color=" +color +"점을 찍었습니다");
	}
	
}
