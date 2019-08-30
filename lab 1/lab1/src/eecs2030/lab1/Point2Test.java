package eecs2030.lab1;


import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Point2Test {

	@Test
	public void test01_getX() {
		Point2 p = new Point2();
		assertTrue(p.getX() == 0.0);
		
		double x = 1.0;
		double y = -1.0;
		p = new Point2(x, y);
		assertTrue(p.getX() == x);
	}

	@Test
	public void test02_getY() {
		Point2 p = new Point2();
		assertTrue(p.getY() == 0.0);
		
		double x = 1.0;
		double y = -1.0;
		p = new Point2(x, y);
		assertTrue(p.getY() == y);
	}

	@Test
	public void test03_setX() {
		Point2 p = new Point2();
		
		double x = 1.0;
		p.setX(x);
		assertTrue(p.getX() == x);
	}

	@Test
	public void test04_setY() {
		Point2 p = new Point2();
		
		double y = -1.0;
		p.setY(y);
		assertTrue(p.getY() == y);
	}

	@Test
	public void test05_set() {
		Point2 p = new Point2();
		
		double x = 1.0;
		double y = -1.0;
		p.set(x, y);
		assertTrue(p.getX() == x && p.getY() == y);
	}

	@Test
	public void test06_toString() {
		double x = -1.0 / 3.0;
		double y = 1.0000000001;
		Point2 p = new Point2(x, y);
		
		String expected = "(" + x + ", " + y + ")";
		assertEquals(expected, p.toString());
	}

}