package ex2;

import java.util.Scanner;

class Area {
    int length;
    int breadth;

    void setDim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        length = sc.nextInt();
        System.out.print("Enter breadth: ");
        breadth = sc.nextInt();
        sc.close();
    }

    void getArea() {
        int area = length * breadth;
        System.out.println("Area of rectangle: " + area);
    }

    public static void main(String[] args) {
        Area rect = new Area();
        rect.setDim();     
        rect.getArea();    
    }
}

