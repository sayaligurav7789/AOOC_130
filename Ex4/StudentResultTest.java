package Ex4;

import java.util.Scanner;

// a. Student class
class Student {
    int rollNo;

    void setRollNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
    }

    int getRollNo() {
        return rollNo;
    }
}

// b. Test class inherits Student
class Test extends Student {
    int sub1, sub2;

    void setMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Subject 1: ");
        sub1 = sc.nextInt();
        System.out.print("Enter marks for Subject 2: ");
        sub2 = sc.nextInt();
    }

    void getMarks() {
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
    }
}

// c. Sports interface
interface Sports {
    int sMarks = 25; // fixed sports marks

    void set(); // abstract method
}

// d. Result class inherits Test and implements Sports
class Result extends Test implements Sports {
    int total;

    public void set() {
        total = sub1 + sub2 + sMarks;
    }

    void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Roll Number: " + getRollNo());
        getMarks();
        System.out.println("Sports Marks: " + sMarks);
        System.out.println("Total Marks: " + total);
    }
}

// e. Test application
public class StudentResultTest {
    public static void main(String[] args) {
        Result student = new Result();

        student.setRollNo();   // gets roll number from user
        student.setMarks();    // gets subject marks from user
        student.set();         // calculates total marks
        student.displayResult(); // displays result
    }
}

