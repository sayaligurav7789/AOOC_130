package Ex4;

import java.util.Scanner;

interface Shape {
    void area();
}

class Rectangle implements Shape {
    public void area() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();
        double result = length * breadth;
        System.out.println("Area of Rectangle: " + result);
    }
}

class Triangle implements Shape {
    public void area() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base of triangle: ");
        double base = sc.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = sc.nextDouble();
        double result = 0.5 * base * height;
        System.out.println("Area of Triangle: " + result);
    }
}

public class AreaDemo {
    public static void main(String[] args) {
        Shape rect = new Rectangle();
        rect.area();

        Shape tri = new Triangle();
        tri.area();
    }
}
