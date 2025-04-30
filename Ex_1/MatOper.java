import java.util.Scanner;
public class MatOper {
    public static void main(String[] args) {
        int[][] M1 = new int[2][2];
        int[][] M2 = new int[2][2];
        int [][] result= new int[2][2];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the 1st matrix: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                M1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the elements of the 2nd matrix: ");
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                M2[i][j] = sc.nextInt();
            }
        }

        while(true) {
        System.out.println("Enter choice");
        System.out.println("1.Addition");
        System.out.println("2.Substraction");
        System.out.println("3.Multiplication");
        System.out.println("4.Transpose of Matrix");

        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        result[i][j] = M1[i][j] + M2[i][j];
                    }
                }
                System.out.println("Addition Result: ");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println();
                }
                
            break;
            
            case 2: 
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++){
                        result[i][j] = M1[i][j] - M2[i][j];
                    }
                }
                System.out.println("Substraction Result: ");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println();
                }

            break;

            case 3:
                    // Initialize result to 0 for multiplication
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            result[i][j] = 0;
                        }
                    }

                    // Performing matrix multiplication (dot product)
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {
                                result[i][j] += M1[i][k] * M2[k][j];
                            }
                        }
                    }

                    System.out.println("Multiplication Result: ");
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

            case 4:
            System.out.println("M1: ");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++){
                    System.out.print(M1[i][j] + " ");
                }
                System.out.println();
            }
                System.out.println("Transpose os M1: ");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++){
                        System.out.print(M1[j][i] + " ");
                    }
                    System.out.println();
                }

            System.out.println("M2: ");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++){
                    System.out.print(M2[i][j] + " ");
                }
                System.out.println();
            }
                System.out.println("Transpose os M2: ");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++){
                        System.out.print(M2[j][i] + " ");
                    }
                    System.out.println();
                }

            break;
            
        
            default:
                break;
        }
        }
        
    }

}
