package Ex3;

import java.util.Scanner;
class Student{
    int roll_no;
}
class Test extends Student{
    int sub1, sub2;
}
class Result extends Test{
    void display(){
        System.out.println("\nRoll No: " + roll_no);
        System.out.println("Marks - Subject 1: " + sub1 + ", Subject 2: " + sub2);
        System.out.println("Total Marks: " + (sub1 + sub2));
    }
}
public class MultiIn{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Result student = new Result();
        System.out.print("Enter Roll No: ");
        student.roll_no = sc.nextInt();
        System.out.print("Enter Marks for Subject 1: ");
        student.sub1 = sc.nextInt();
        System.out.print("Enter Marks for Subject 2: ");
        student.sub2 = sc.nextInt();
        student.display();
        sc.close();
    }
}

