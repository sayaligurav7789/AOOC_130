package Ex6.ExceptionHandlingDemo;

public class Calculator{
    public int divide(int a, int b) throws DivisionExcep{
        if (b == 0){
            throw new DivisionExcep("Cannot divide by zero!");
        }
        return a / b;
    }
}
