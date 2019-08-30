package eecs2030.lab1;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpiroUtilTest {
	
	/**
	 * Some pre-computed values to test the methods
	 * hypoX, hypoY, and hypo; these values come from a reference
	 * implementation that is thought to be correct. 
	 */
	private static final double WHEEL_RADIUS = 0.45;
	private static final double PENCIL_RADIUS = 0.33;
	private static final double[] DEGREES = {0.0, 35.0, 218.0, 1500.0};
	private static final double[] X = {0.8800000000000001,
			0.6927514236751531,
			-0.45387130321761343,
			0.5507109777662673};
	private static final double[] Y = {0.0,
			0.09134533712962353,
			-0.009249016917054598,
			0.2949760093180739};
	
	/**
	 * Tests the value of SpiroUtil.BIG_WHEEL_RADIUS
	 */
	@Test
	public void test00_constantField() {
		assertTrue("SpiroUtil.BIG_WHEEL_RADIUS has the wrong value\n",
				SpiroUtil.BIG_WHEEL_RADIUS == 1.0);
	}
	
	
	/**
	 * Tests that hypoX() throws an IllegalArgumentException.
	 * 
	 * <p>
	 * The value of <code>wheelRadius</code> and/or <code>pencilRadius</code>
	 * should cause an exception to be thrown. 
	 * 
	 * @param wheelRadius the small wheel radius
	 * @param pencilRadius the pencil radius
	 */
	private void test_hypoXThrows(double wheelRadius, double pencilRadius) {
		try {
			SpiroUtil.hypoX(wheelRadius, pencilRadius, 0.0);
			String s = String.format("SpiroUtil.hypoX(%s, %s, %s) should have thrown an exception\n", 
					wheelRadius, pencilRadius, 0.0);
			fail(s);
		}
		catch (IllegalArgumentException x) {
			// this is expected
		}
	}
	
	
	/**
	 * Tests that hypoY() throws an IllegalArgumentException.
	 * 
	 * <p>
	 * The value of <code>wheelRadius</code> and/or <code>pencilRadius</code>
	 * should cause an exception to be thrown. 
	 * 
	 * @param wheelRadius the small wheel radius
	 * @param pencilRadius the pencil radius
	 */
	private void test_hypoYThrows(double wheelRadius, double pencilRadius) {
		try {
			SpiroUtil.hypoY(wheelRadius, pencilRadius, 0.0);
			String s = String.format("SpiroUtil.hypoY(%s, %s, %s) should have thrown an exception\n", 
					wheelRadius, pencilRadius, 0.0);
			fail(s);
		}
		catch (IllegalArgumentException x) {
			// this is expected
		}
	}
	
	
	/**
	 * Tests that hypo() throws an IllegalArgumentException.
	 * 
	 * <p>
	 * The value of <code>wheelRadius</code> and/or <code>pencilRadius</code>
	 * should cause an exception to be thrown. 
	 * 
	 * @param wheelRadius the small wheel radius
	 * @param pencilRadius the pencil radius
	 */
	private void test_hypoThrows(double wheelRadius, double pencilRadius) {
		try {
			SpiroUtil.hypo(wheelRadius, pencilRadius, 0.0);
			String s = String.format("SpiroUtil.hypo(%s, %s, %s) should have thrown an exception\n", 
					wheelRadius, pencilRadius, 0.0);
			fail(s);
		}
		catch (IllegalArgumentException x) {
			// this is expected
		}
	}
	
	
	/**
	 * Test that hypoX() throws and exception when using illegal values
	 * for the small wheel radius and/or pencil radius.
	 * 
	 * <p>
	 * Test that hypoX() does not throw an exception when using
	 * legal values for the small wheel radius and/or pencil radius.
	 */
	@Test
	public void test01_hypoXThrows() {
		double wheelRadius =  0.0;
		double pencilRadius = 0.0;
		
		// negative wheel radius
		wheelRadius = -0.0001;
		this.test_hypoXThrows(wheelRadius, pencilRadius);
		
		// wheel radius > SpiroUtil.BIG_WHEEL_RADIUS
		wheelRadius = SpiroUtil.BIG_WHEEL_RADIUS + 0.0001;
		this.test_hypoXThrows(wheelRadius, pencilRadius);
		
		// negative pencil radius
		wheelRadius = 0.5;
		pencilRadius = -0.0001;
		this.test_hypoXThrows(wheelRadius, pencilRadius);
		
		// pencil radius > wheel radius
		pencilRadius = wheelRadius + 0.0001;
		this.test_hypoXThrows(wheelRadius, pencilRadius);
		
		// none of the following should throw
		wheelRadius =  0.0;
		pencilRadius = 0.0;
		SpiroUtil.hypoX(wheelRadius, pencilRadius, 0.0);
		
		wheelRadius = 1.0;
		SpiroUtil.hypoX(wheelRadius, pencilRadius, 0.0);
		
		wheelRadius = 0.5;
		pencilRadius = 0.5;
		SpiroUtil.hypoX(wheelRadius, pencilRadius, 0.0);
	}
	

	/**
	 * Test that hypoY() throws and exception when using illegal values
	 * for the small wheel radius and/or pencil radius.
	 * 
	 * <p>
	 * Test that hypoY() does not throw an exception when using
	 * legal values for the small wheel radius and/or pencil radius.
	 */
	@Test
	public void test02_hypoYThrows() {
		double wheelRadius =  0.0;
		double pencilRadius = 0.0;
		
		// negative wheel radius
		wheelRadius = -0.0001;
		this.test_hypoYThrows(wheelRadius, pencilRadius);
		
		// wheel radius > SpiroUtil.BIG_WHEEL_RADIUS
		wheelRadius = SpiroUtil.BIG_WHEEL_RADIUS + 0.0001;
		this.test_hypoYThrows(wheelRadius, pencilRadius);
		
		// negative pencil radius
		wheelRadius = 0.5;
		pencilRadius = -0.0001;
		this.test_hypoYThrows(wheelRadius, pencilRadius);
		
		// pencil radius > wheel radius
		pencilRadius = wheelRadius + 0.0001;
		this.test_hypoYThrows(wheelRadius, pencilRadius);
		
		// none of the following should throw
		wheelRadius =  0.0;
		pencilRadius = 0.0;
		SpiroUtil.hypoY(wheelRadius, pencilRadius, 0.0);
		
		wheelRadius = 1.0;
		SpiroUtil.hypoY(wheelRadius, pencilRadius, 0.0);
		
		wheelRadius = 0.5;
		pencilRadius = 0.5;
		SpiroUtil.hypoY(wheelRadius, pencilRadius, 0.0);
	}
	
	
	/**
	 * Test that hypo() throws and exception when using illegal values
	 * for the small wheel radius and/or pencil radius.
	 * 
	 * <p>
	 * Test that hypo() does not throw an exception when using
	 * legal values for the small wheel radius and/or pencil radius.
	 */
	@Test
	public void test03_hypoThrows() {
		double wheelRadius =  0.0;
		double pencilRadius = 0.0;
		
		// negative wheel radius
		wheelRadius = -0.0001;
		this.test_hypoThrows(wheelRadius, pencilRadius);
		
		// wheel radius > SpiroUtil.BIG_WHEEL_RADIUS
		wheelRadius = SpiroUtil.BIG_WHEEL_RADIUS + 0.0001;
		this.test_hypoThrows(wheelRadius, pencilRadius);
		
		// negative pencil radius
		wheelRadius = 0.5;
		pencilRadius = -0.0001;
		this.test_hypoThrows(wheelRadius, pencilRadius);
		
		// pencil radius > wheel radius
		pencilRadius = wheelRadius + 0.0001;
		this.test_hypoThrows(wheelRadius, pencilRadius);
		
		// none of the following should throw
		wheelRadius =  0.0;
		pencilRadius = 0.0;
		SpiroUtil.hypo(wheelRadius, pencilRadius, 0.0);
		
		wheelRadius = 1.0;
		SpiroUtil.hypo(wheelRadius, pencilRadius, 0.0);
		
		wheelRadius = 0.5;
		pencilRadius = 0.5;
		SpiroUtil.hypo(wheelRadius, pencilRadius, 0.0);
	}
	
	/**
	 * Test hypoX() using a few pre-computed values.
	 */
	@Test
	public void test04_hypoX() {
		for (int i = 0; i < SpiroUtilTest.DEGREES.length; i++) {
			double deg = SpiroUtilTest.DEGREES[i];
			double expected = SpiroUtilTest.X[i];
			double got = SpiroUtil.hypoX(
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			String error = String.format("hypoX(%s, %s, %s) failed\n",
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			assertEquals(error, expected, got, 1e-8);
		}
	}

	
	/**
	 * Test hypoY() using a few pre-computed values.
	 */
	@Test
	public void test05_hypoY() {
		for (int i = 0; i < SpiroUtilTest.DEGREES.length; i++) {
			double deg = SpiroUtilTest.DEGREES[i];
			double expected = SpiroUtilTest.Y[i];
			double got = SpiroUtil.hypoY(
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			String error = String.format("hypoY(%s, %s, %s) failed\n",
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			assertEquals(error, expected, got, 1e-8);
		}
	}

	
	/**
	 * Test hypo() using a few pre-computed values.
	 */
	@Test
	public void test06_hypo() {
		for (int i = 0; i < SpiroUtilTest.DEGREES.length; i++) {
			double deg = SpiroUtilTest.DEGREES[i];
			double expectedX = SpiroUtilTest.X[i];
			double expectedY = SpiroUtilTest.Y[i];
			Point2 got = SpiroUtil.hypo(
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			
			String error = String.format("hypo(%s, %s, %s) failed\n" +
					"the x-coordinate was wrong\n",
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			assertEquals(error, expectedX, got.getX(), 1e-8);
			
			error = String.format("hypo(%s, %s, %s) failed\n" +
					"the y-coordinate was wrong\n",
					SpiroUtilTest.WHEEL_RADIUS,
					SpiroUtilTest.PENCIL_RADIUS,
					deg);
			assertEquals(error, expectedY, got.getY(), 1e-8);
		}
	}

}