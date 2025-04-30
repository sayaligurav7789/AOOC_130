import java.util.Arrays;
import java.util.Scanner;

public class SortNum {
    public static void main(String[] args) {
        int[] arr = new int[10];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Entered list: " + Arrays.toString(arr));


        bubbleSort(arr);
        System.out.println("Sorted list: " + Arrays.toString(arr));
        sc.close();
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 1; j<= arr.length - i - 1; j++) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
