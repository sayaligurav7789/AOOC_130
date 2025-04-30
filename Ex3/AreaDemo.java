package Ex3;

import java.util.Scanner;
abstract class Shape {
  double dim1;
  double dim2;

  abstract void area();
}

class Rectangle extends Shape{
    void area(){
        double ans = dim1 * dim2;
        System.out.println("Area of Rectangle: " + ans);
    }
}
class Triangle extends Shape{
    void area(){
        double ans = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + ans);
    }
}

public class AreaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle r = new Rectangle();
        System.out.print("Enter length of rectangle: ");
        r.dim1 = sc.nextDouble();
        System.out.print("Enter breadth of rectangle: ");
        r.dim2 = sc.nextDouble();
        r.area();

        Triangle t = new Triangle();
        System.out.print("Enter base of triangle: ");
        t.dim1 = sc.nextDouble();
        System.out.print("Enter height of triangle: ");
        t.dim2 = sc.nextDouble();
        t.area();

        sc.close();
    }
}
