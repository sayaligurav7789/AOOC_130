public class Prime {
    public static void main(String[] args) {
            
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }
    
            int num = Integer.parseInt(args[0]);
    
            if (num <= 1) {
                System.out.println(num + " is not a prime number.");
                return;
            }
    
            boolean isPrime = true;
    
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
    
            if (isPrime) {
                System.out.println(num + " is a prime number.");
            } 
            else {
                System.out.println(num + " is not a prime number.");
            }
    }
}
