package eecs2030.lab3;

import princeton.introcs.StdDraw;
import java.awt.Color;

/**
 * A class that supports turtle graphics. A turtle moves between two points in a
 * straight line drawing the line as it moves.
 * 
 * <p>
 * A turtle has-a <code>Point2</code> instance that represents the position of
 * the turtle, and a <code>Color</code> instance that represents the current pen
 * color. The turtle maintains ownership of its position at all times.
 * 
 * 
 * @author EECS2030 Fall 2016-17
 * 
 */
public class Turtle {
	private Point2 position;
	private double angle;
	private Color penColor;
	
	/**
	 * Create a turtle at location (0.5, 0.5) with an angle of 0.0 degrees and a pen color of Color.BLACK.
	 */

	public Turtle() {
		this.position = new Point2(0.5, 0.5);
		this.angle = (0);
		this.penColor = Color.BLACK;
	}
	
	/**
	 *  Create a turtle at location position with an angle of 0.0 degrees and a pen color of 
	 *  Color.BLACK. The turtle is responsible for its own position. 
	 *  <p>
	 *  The starting position must be inside the square with corners (0.0, 0.0) and (1.0, 1.0), 
	 *  otherwise an IllegalArgumentException will be thrown.
	 * 
	 * @param position
	 *            A Point2 to give to turtle.
	 * @throws IllegalArgumentException
	 *            if the starting position is not in the square with corners (0.0, 0.0) and (1.0, 1.0)
	 */

	public Turtle(Point2 position) {
		this.position = new Point2(position);
		this.angle = (0);
		this.penColor = Color.BLACK;
	}
	
	/**
	 *  Create a turtle at location position with an angle of angle degrees and a pen color of 
	 *  Color.BLACK. The starting position must be inside the square with 
	 *  corners (0.0, 0.0) and (1.0, 1.0), otherwise an IllegalArgumentException will be thrown.
	 * 
	 * @param position
	 *            the starting position of the turtle
	 * @param angle
	 *            the angle in degrees from the x axis that the turtle is facing in
	 * @throws IllegalArgumentException
	 *            if the starting position is not in the square with corners (0.0, 0.0) and (1.0, 1.0)
	 */

	public Turtle(Point2 position, double angle) {
		this.position = new Point2(position);
		this.angle = angle;
		this.penColor = Color.BLACK;
	}
	
	/**
	 *  CCreate a turtle with the given starting position, angle, and pen color. 
	 *  The starting position must be inside the square with corners (0.0, 0.0) 
	 *  and (1.0, 1.0), otherwise an IllegalArgumentException will be thrown.
	 * 
	 * @param position
	 *            the starting position of the turtle
	 * @param angle
	 *            the angle in degrees from the x axis that the turtle is facing in
	 * @param c
	 *            the pen color
	 *  @throws IllegalArgumentException
	 *            if the starting position is not in the square with corners (0.0, 0.0) and (1.0, 1.0)
	 *  @throws IllegalArgumentException
	 *            if the pen color c is null
	 */

	public Turtle(Point2 position, double angle, Color c) {
		this.position = new Point2(position);
		this.angle = angle;
		this.penColor = c;
	}
	
	/**
	 *  Create a turtle from another turtle. The created turtle is initialized having the same position, 
	 *  angle, and pen color as the other turtle, but moves independently of the other turtle.
	 * 
	 * @param other
	 *            the turtle to copy
	 */

	public Turtle(Turtle other) {
		this.position = new Point2(other.getPosition());
		this.angle = other.getAngle();
		this.penColor = other.getPenColor();
	}

	public double getAngle() {
		return this.angle;
	}

	public Color getPenColor() {
		return this.penColor;
	}

	public Point2 getPosition() {
		return this.position;
	}

	public void move(double distance) {
		Vector2 vector = Vector2.dirVector(this.getAngle());
		vector.multiply(distance);
		double x = this.getPosition().getX();
		double y = this.getPosition().getY();
		this.position = new Point2(x + vector.getX(), y + vector.getY());
		StdDraw.setPenColor(this.getPenColor());
		StdDraw.line(x, y, this.position.getX(), this.position.getY());
	}

	public void turn(double delta) {
		this.angle = this.getAngle() + delta;
	}

	public void turnLeft() {
		this.angle = this.getAngle() + 90;
	}

	public void turnRight() {
		this.angle = this.getAngle() - 90;
	}

	/**
	 * Sets the pen color.
	 * 
	 * @param c
	 *            the new pen color
	 * @throws IllegalArgumentException
	 *             if the pen color c is null
	 */
	public void setPenColor(Color c) {
		this.penColor = c;

	}

	/**
	 * Compares this turtle with another object for equality. This turtle can be
	 * equal to only other turtles.
	 * 
	 * <p>
	 * Two turtles are equal if their positions, directions, and pen colors are
	 * all equal; otherwise, the turtles are not equal.
	 * 
	 * @param obj
	 *            An object to compare for equality.
	 * @return True if the position, direction, and pen color of this turtle are
	 *         equal to the position, direction, and pen color of the other
	 *         turtle, and false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Turtle other = (Turtle) obj;
		if (Double.doubleToLongBits(angle) != Double.doubleToLongBits(other.angle)) {
			return false;
		} else if (!penColor.equals(other.penColor)) {
			return false;
		} else if (!position.equals(other.position)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns a hash code for this turtle.
	 * 
	 * @return a hash code for this turtle
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((penColor == null) ? 0 : penColor.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this turtle. The string representation
	 * is:
	 * 
	 * <ol>
	 * <li>the position of the turtle (as given by <code>Point2.toString</code>
	 * ), followed by
	 * <li>a comma and a space, followed by
	 * <li>the direction, followed by
	 * <li>a space, the string "degrees", a space, and a comma, followed by
	 * <li>the pen color (as given by <code>Color.toString</code>)
	 * </ol>
	 * 
	 * @return a string representation of this turtle
	 */
	@Override
	public String toString() {
		String s = String.format("%s, %f degrees, %s", this.getPosition(), this.getAngle(), this.getPenColor());
		return s;
	}

}