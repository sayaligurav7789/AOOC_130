package Ex6;
import Ex6.ExceptionHandlingDemo.Calculator;
import Ex6.ExceptionHandlingDemo.DivisionExcep;
import java.util.Scanner;

public class Handle{
    public static void main(String[] args){
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        try{
            int result = calc.divide(a, b);
            System.out.println("Result: " + result);
        } 
        catch (DivisionExcep e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
