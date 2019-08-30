package eecs2030.lab1;

public class SpiroUtil {
	private SpiroUtil() {

	}

	public static final double BIG_WHEEL_RADIUS = 1;

	public static double hypoX(double wheelRadius, double pencilRadius, double degrees) {

		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}
		double partCalc = ((BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius) * Math.toRadians(degrees);

		return (BIG_WHEEL_RADIUS - wheelRadius) * Math.cos(Math.toRadians(degrees)) + pencilRadius * Math.cos(partCalc);
	}

	public static double hypoY(double wheelRadius, double pencilRadius, double degrees) {

		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}
		double partCalc = ((BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius) * Math.toRadians(degrees);

		return (BIG_WHEEL_RADIUS - wheelRadius) * Math.sin(Math.toRadians(degrees)) - pencilRadius * Math.sin(partCalc);
	}

	public static Point2 hypo(double wheelRadius, double pencilRadius, double degrees) {

		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}
		double partCalc = ((BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius) * Math.toRadians(degrees);
		double xValue = (BIG_WHEEL_RADIUS - wheelRadius) * Math.cos(Math.toRadians(degrees))
				+ pencilRadius * Math.cos(partCalc);
		double yValue = (BIG_WHEEL_RADIUS - wheelRadius) * Math.sin(Math.toRadians(degrees))
				- pencilRadius * Math.sin(partCalc);

		return new Point2(xValue, yValue);
	}

}
