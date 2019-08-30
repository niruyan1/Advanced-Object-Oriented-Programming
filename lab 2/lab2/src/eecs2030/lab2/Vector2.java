package eecs2030.lab2;

/**
 * A class that represents two dimensional spatial vectors (a direction and a
 * magnitude). Every vector has a real-valued x-component and a y-component. The
 * class provides some basic mathematical operations such as vector addition and
 * subtraction, and scalar multiplicaton.
 * 
 * @author EECS2030 Fall 2016
 * 
 */
public final class Vector2 {
	private double x;
	private double y;

	public Vector2() {
		x = 0;
		y = 0;
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2(Vector2 vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}

	public Vector2 add(Vector2 b) {
		x += b.getX();
		y += b.getY();
		return new Vector2(x, y);

	}

	public static Vector2 add(Vector2 a, Vector2 b) {
		return new Vector2(a.getX() + b.getX(), a.getY() + b.getY());
	}

	public static Vector2 dirVector(double theta) {
		return new Vector2(Math.cos(Math.toRadians(theta)), Math.sin(Math.toRadians(theta)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2 other = (Vector2) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public int hashcode() {
		return this.hashCode();
	}

	public double mag() {
		return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
	}

	public Vector2 multiply(double s) {
		x = s * this.getX();
		y = s * this.getY();
		return new Vector2(x, y);

	}

	public static Vector2 multiply(double s, Vector2 a) {
		return new Vector2(s * a.getX(), s * a.getY());
	}

	/**
	 * Returns the x component of the vector.
	 * 
	 * @return the x component of the vector.
	 */

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {

		this.y = y;
	}

	public Vector2 subtract(Vector2 a) {
		x -= a.getX();
		y -= a.getY();
		return new Vector2(x, y);
	}

	public static Vector2 subtract(Vector2 a, Vector2 b) {
		return new Vector2(a.getX() - b.getX(), a.getY() - b.getY());
	}

	public boolean similarTo(Vector2 a, double tol) {
		Vector2 b = Vector2.subtract(this, a);
		double value = b.mag();
		return (value < tol);
	}

	public double getX() {
		return this.x;
	}

	/**
	 * Returns the y component of the vector.
	 * 
	 * @return the y component of the vector.
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Returns a string representation of the vector. The string is the name of
	 * the vector, followed by the comma separated components of the vector
	 * inside parentheses.
	 * 
	 * @return a string representation of the vector
	 */
	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

}
