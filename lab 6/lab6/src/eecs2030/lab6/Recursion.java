package eecs2030.lab6;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class containing recursive methods.
 * 
 * @author EECS2030 Fall 2016
 *
 */
public class Recursion {

	// DON'T ADD ANY STATIC FIELDS; YOU DON'T STATIC FIELDS AND YOUR METHODS
	// WON'T WORK CORRECTLY IF YOU USE STATIC FIELDS

	private Recursion() {
		// empty by design
	}

	/**
	 * Return the sum of the integers 1 through n where n is a strictly positive
	 * integer. Note that the sum might overflow if n is too large; this method
	 * does not check if the sum overflows (i.e., it's the client's problem).
	 * 
	 * @pre n is greater than 0
	 * 
	 * @param n
	 *            a strictly positive number
	 * @return the sum 1 + 2 + ... + n
	 */
	public static int sum(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + sum(n - 1);

		}

	}

	/**
	 * Returns a new string equal to the reversal of string s. The reversal of
	 * the empty string is equal to the empty string.
	 * 
	 * @pre s is not null
	 * 
	 * @param s
	 *            a string
	 * @return a string equal to the reversal of s
	 */
	public static String reverse(String s) {
		if (s.length() < 1) {
			return s;
		} else {
			return "" + s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
		}

	}

	/**
	 * Returns the minimum element in the list t. This method does not modify
	 * the list <code>t</code>.
	 * 
	 * @pre t.size() is greater than 0
	 * 
	 * @param t
	 *            a non-empty list
	 * @return the minimum element in t
	 */
	public static int min(List<Integer> t) {
		if (t.size() == 1) {
			return t.get(0);
		} else {
			return (t.get(0) < min(t.subList(1, t.size()))) ? t.get(0) : min(t.subList(1, t.size()));
		}

	}

	/**
	 * Downsample a picture <code>n</code> times by a factor of 2 using
	 * recursion. See the lab problem for a description of downsampling.
	 * 
	 * @pre the width and height of the picture are both multiples of 2 to the
	 *      power n
	 * 
	 * @pre1 n is greater than or equal to zero
	 * 
	 * @param p
	 *            the picture to downsample
	 * @param n
	 *            the number of times to downsample the picture by a factor of 2
	 * @return the downsampled picture
	 */
	public static Picture downsample(Picture p, int n) {
		if (n == 0) {
			return p;
		} else {
			List<Color> colorlist = new ArrayList<Color>();
			for (int x = 0; x < p.width(); x = x + 2) {
				for (int y = 0; y < p.height(); y = y + 2) {
					Color c1 = p.get(x, y);
					Color c2 = p.get(x, y + 1);
					Color c3 = p.get(x + 1, y);
					Color c4 = p.get(x + 1, y + 1);
					int r = c1.getRed() + c2.getRed() + c3.getRed() + c4.getRed();
					int g = c1.getGreen() + c2.getGreen() + c3.getGreen() + c4.getGreen();
					int b = c1.getBlue() + c2.getBlue() + c3.getBlue() + c4.getBlue();

					Color avg = new Color(r / 4, g / 4, b / 4);
					colorlist.add(avg);

				}

			}

			Picture z = new Picture(p.width() / 2, p.height() / 2);
			int c = 0;
			for (int x = 0; x < z.width(); x++) {
				for (int y = 0; y < z.height(); y++) {
					z.set(x, y, colorlist.get(c));
					c++;
				}

			}
			return Recursion.downsample(z, n - 1);

		}

	}

	/**
	 * Binary search for the string <code>s</code> in a list <code>t</code>. If
	 * <code>s</code> is in the list, then this method returns the index of the
	 * location of <code>s</code> in <code>t</code>; otherwise, this method
	 * returns the index where <code>s</code> would be located if it were to be
	 * inserted into the list <code>t</code>.
	 * 
	 * <p>
	 * This method does not modify the list <code>t</code>.
	 * 
	 * @pre t.size() is zero or more
	 * @pre1 t is in sorted order
	 * @pre2 t has no duplicate elements
	 * 
	 * @param s
	 *            a string
	 * @param t
	 *            a list
	 * @return the index of s if s is in the list; otherwise, returns the index
	 *         where s would be located if it were to be inserted into the list
	 */
	public static int bsearch(String s, List<String> t) {
		if (t.size() == 0) {
			return 0;

		} else {
			String compare = t.get(t.size() / 2);
			if (s.compareTo(compare) < 0) {
				return bsearch(s, t.subList(0, t.indexOf(compare)));
			} else if (s.compareTo(compare) > 0) {
				return t.indexOf(compare) + bsearch(s, t.subList(t.indexOf(compare) + 1, t.size())) + 1;
			} else {
				return t.indexOf(compare);
			}
		}

	}

	public static void main(String[] args) {
		// RUN THIS TO TEST downsample
		Picture p = new Picture("snowflake.jpg");
		p.show();
		downsample(p, 1).show();
		downsample(p, 2).show();
		downsample(p, 3).show();
	}

}