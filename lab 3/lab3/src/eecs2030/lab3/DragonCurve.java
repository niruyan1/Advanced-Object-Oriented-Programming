package eecs2030.lab3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class DragonCurve {

  private static void dragon(List<Turtle> turtles, double length, int n) {
    if (n == 0) {
      for (Turtle t : turtles) {
        t.move(length);
      }
    } else {
      for (Turtle t : turtles) {
        t.turn(-45.0);
      }
      dragon(turtles, length / Math.sqrt(2.), n - 1);
      for (Turtle t : turtles) {
        t.turnLeft();
      }
      reverseDragon(turtles, length / Math.sqrt(2.), n - 1);
      for (Turtle t : turtles) {
        t.turn(45.0);
      }
    }
  }

  private static void reverseDragon(List<Turtle> turtles, double length, int n) {
    if (n == 0) {
      for (Turtle t : turtles) {
        t.move(length);
      }
    } else {
      for (Turtle t : turtles) {
        t.turn(-45.0);
      }
      dragon(turtles, length / Math.sqrt(2.), n - 1);
      for (Turtle t : turtles) {
        t.turnRight();
      }
      reverseDragon(turtles, length / Math.sqrt(2.), n - 1);
      for (Turtle t : turtles) {
        t.turn(45.0);
      }
    }
  }

  public static void main(String[] args) {
    List<Turtle> turtles = new ArrayList<Turtle>();
    turtles.add(new Turtle(new Point2(0.5, 0.5)));
    for (int i = 1; i < 4; i++) {
      Turtle u = new Turtle(turtles.get(i - 1));
      u.turnLeft();
      turtles.add(u);
    }
    turtles.get(1).setPenColor(Color.RED);
    turtles.get(2).setPenColor(Color.BLUE);
    turtles.get(3).setPenColor(Color.GRAY);
    dragon(turtles, 0.5, 12);
  }
}