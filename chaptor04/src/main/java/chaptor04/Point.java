package chaptor04;

import java.util.Objects;

public class Point{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	@Override
	public String toString() {
		return "class chaptor04.Point";
	}
	/*
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != getClass()) {
			return false;
		}
		Point other = (Point)obj;
		return x == other.x && y == other.y;
	}*/
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		System.out.println(x + "," +y + " 에 점을 찍었습니다");
	}
	public void disapear() {
		System.out.println(x + "," +y + " 에 점을 지웠습니다");
	}
	public void show(boolean check) {
		if(check)
			show();
		else
			disapear();
	}
}
