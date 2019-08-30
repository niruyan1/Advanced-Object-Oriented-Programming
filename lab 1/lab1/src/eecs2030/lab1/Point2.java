package eecs2030.lab1;

/**
 * A simple class for representing points in 2D Cartesian coordinates. Every
 * Point2D instance has an x and y coordinate.
 * 
 * @author EECS2030 Fall 2016
 *
 */
public class Point2 {

	private double x;
	private double y;

	public Point2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point2() {
		x = 0;
		y = 0;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void set(double newX, double newY) {
		x = newX;
		y = newY;

	}

	public void setX(double newX) {
		x = newX;
	}

	public void setY(double newY) {
		y = newY;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}