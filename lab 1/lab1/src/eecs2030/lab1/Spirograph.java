package eecs2030.lab1;

import java.util.Scanner;

public class Spirograph {

    /**
     * The greatest common divisor of two positive integers computed using the
     * Euclidean algorithm.
     * 
     * @param p
     *            an integer greater than zero
     * @param q
     *            an integer greater than zero
     * @return the greatest common divisor of <code>p</code> and <code>q</code>
     */
    private static int gcd(int p, int q) {
        while (p != q) {
            if (p > q) {
                p = p - q;
            } else {
                q = q - p;
            }
        }
        return p;
    }

    /**
     * Computes the number of times that the small wheel must travel around the
     * large wheel to complete the hypotrochoid pattern.
     * 
     * <p>
     * Assume that <code>wheelRadius</code> is between 0 and 1; then we
     * approximate the value of <code>wheelRadius</code> as the fraction p / 100
     * where p is an integer value. The number of times that the small wheel
     * must travel around the large wheel is equal to p / gcd(p, 100) where
     * gcd(p, 100) is the greatest common divisor of p and 100.
     * 
     * @param wheelRadius
     *            the radius of the small wheel
     * @return the number of times that the small wheel must travel around the
     *         large wheel for a complete hypotrochoid
     */
    private static int numberOfRevolutions(double wheelRadius) {
        final int Q = 100;
        int p = (int) Math.round(wheelRadius * Q);
        int g = Spirograph.gcd(p, Q);
        return (p / g);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // ask the user for the small wheel radius
        System.out.print("Small wheel radius (between 0 and 1)? ");
        double wheelRadius = keyboard.nextDouble();

        // ask the user for the pencil radius
        System.out.print("Pencil radius (between 0 and wheel radius)? ");
        double pencilRadius = keyboard.nextDouble();

        // draw the hypotrochoid
        for (int t = 0; t < 360 * Spirograph.numberOfRevolutions(wheelRadius); t++) {
            Point2 p = SpiroUtil.hypo(wheelRadius, pencilRadius, t);
            SimpleDrawing.drawPoint(p);
        }

        keyboard.close();
    }

}