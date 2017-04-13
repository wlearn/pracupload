/*
 * Design the Triangle Class in java and implement its appropriate methods. A
 * Triangle is defined by the x- and y-coordinates of its three corner points.
 *
 * a) To take the input from user (Keyboard) of all three vertices in form of
 *      (x, y) coordinates and find the lengths of all sides.
 * b) To find the Area of the Triangle
 * c) To find the Perimeter of the triangle.
 * d) Based on the length of the sides of the Triangle, also specifies that
 *      which type of triangle belonging to among Equilateral,
 *      Isosceles or Scalene Triangle.
 *
 *      document:       Assignment.java
 *      last modified:  7th April 2017
 *      authors:
 *
 *
 *
 *
*/
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

class Point {
    public double x,y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double a, double b) {
        x = a;
        y = b;
    }
}

class Triangle {
    public Point A = new Point();
    public Point B = new Point();
    public Point C = new Point();

    public Triangle() {
        A.x = 0; A.y = 0;
        B.x = 0; B.y = 0;
        C.x = 0; C.y = 0;
    }

    public Triangle(Point P,Point Q, Point R) {
        A.x = P.x; A.y = P.y;
        B.x = Q.x; B.y = Q.y;
        C.x = R.x; C.y = R.y;
    }

    public double length(Point A, Point B) {
        // D^2 = (x1-x2)^2 + (y1-y2)^2
        return Math.sqrt(Math.pow(A.x-B.x,2) + Math.pow(A.y-B.y,2));
    }

    public double perimeter() {
        // Simple addition
        return length(A,B) + length(B,C) + length(A,C);
    }

    public double area() {
        double s = perimeter()/2;
        double a = length(B,C);
        double b = length(A,C);
        double c = length(A,B);

        // Heron's formula
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    public void type() {
/*
	double a = Math.round(1000000 * length(B,C)) / 1000000;
        System.out.println("BC = " + Double.toString(a) + " units");
        double b = Math.round(1000000 * length(A,C)) / 1000000;
        System.out.println("AC = " + Double.toString(b) + " units");
        double c = Math.round(1000000 * length(A,B)) / 1000000;
        System.out.println("AB = " + Double.toString(c) + " units");
*/
        DecimalFormat df = new DecimalFormat("#.####");
        double c = length(A,B);
        System.out.println("AB = " + df.format(c) + " units");
        double a = length(B,C);
        System.out.println("BC = " + df.format(a) + " units");
        double b = length(A,C);
        System.out.println("AC = " + df.format(b) + " units");

        if (a == b && b == c)
            System.out.println("This is an Equilateral Triangle!");
        else if (a == b || b == c || c == a)
            System.out.println("This is an Isosceles Triangle!");
        else
            System.out.println("This is a Scalene Triangle!");
    }
}

public class Assignment {
    public static void main(String[] args) {
        // Create 3 objects of Point class
        Point[] P = new Point[3];

        // Create a new Scanner 'in'
        Scanner in = new Scanner(System.in);

        // Input the Coordinates of the Triangle
        for (int i=0; i<3; i++) {
            System.out.print("Enter the Coordinates of Point ");
            System.out.print(Integer.toString(i+1) + ": ");
            P[i] = new Point(in.nextDouble(), in.nextDouble());
        }

        // Check whether the Coordinates are valid to create Triangle
        // Sum of any two sides of a Triangle is
        // always greater than the third side
/*
        double a = Math.round(1000000 * Math.sqrt(Math.pow(P[1].x-P[2].x,2) +
        Math.pow(P[1].y-P[2].y,2))) / 1000000;
        double b = Math.round(1000000 * Math.sqrt(Math.pow(P[0].x-P[2].x,2) +
        Math.pow(P[0].y-P[2].y,2))) / 1000000;
        double c = Math.round(1000000 * Math.sqrt(Math.pow(P[1].x-P[0].x,2) +
        Math.pow(P[1].y-P[0].y,2))) / 1000000;
        if(!( ((a+b)>c) && ((b+c)>a) && ((a+c)>b) )) {
            System.out.println("Invalid sides of Triangle!");
            System.exit(0);
        }
*/

	double a = Math.sqrt(Math.pow(P[1].x-P[2].x,2) +
        Math.pow(P[1].y-P[2].y,2));
        double b = Math.sqrt(Math.pow(P[0].x-P[2].x,2) +
        Math.pow(P[0].y-P[2].y,2));
        double c = Math.sqrt(Math.pow(P[1].x-P[0].x,2) +
        Math.pow(P[1].y-P[0].y,2));
        if(!( ((a+b)>c) && ((b+c)>a) && ((a+c)>b) )) {
            System.out.println("Invalid sides of Triangle!");
            System.exit(0);
        }

        // If it is not Invalid, Create a new Triangle 'T'
        Triangle T = new Triangle(P[0], P[1], P[2]);
        System.out.println("************************************************");

	    DecimalFormat df = new DecimalFormat("#.####");
        // Print Perimeter of the Triangle
        System.out.println("Perimeter = " +
        df.format(T.perimeter()) + " units");

        // Print Area of the Triangle
        System.out.println("Area = " +
        df.format(T.area()) + " sq. units");

        // Print type of the Triangle
        T.type();
    }
}
