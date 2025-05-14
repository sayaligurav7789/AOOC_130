package Ex6;

class OddNumberException extends Exception{
}

public class Oddcheck{
    static void checkEven(int num) throws OddNumberException{
        if (num % 2 != 0){
            throw new OddNumberException(); // Throw custom exception
        } else {
            System.out.println("You entered an even number.");
        }
    }

    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        try{
            checkEven(number);  
        } 
        catch (OddNumberException e){
            System.out.println("Custom Exception caught: Odd number is not allowed.");
        }
    }
}


