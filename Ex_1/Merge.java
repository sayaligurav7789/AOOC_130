//merge two sorted arrays
import java.util.Scanner;
public class Merge {
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;

        Scanner sc = new Scanner(System.in);

        //first array
        System.out.println("Enter Size of First Array: ");
        int s1 = sc.nextInt();
        
        arr1 = new int[s1];
        System.out.println("Enter First Array: ");
        for(int i = 0; i < s1; i++) {
            arr1[i] = sc.nextInt();
        }

        //second array
        System.out.println("Enter Size of Second Array: ");
        int s2 = sc.nextInt();
    
        arr2 = new int[s2];
        System.out.println("Enter Second Array: ");
        for(int i = 0; i < s2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("First Array: " + java.util.Arrays.toString(arr1));
        System.out.println("Second Array: " + java.util.Arrays.toString(arr2));

        int[] ans = merge(arr1, arr2);
        System.out.println("Merged Array: " + java.util.Arrays.toString(ans));

        sc.close();
    }

    //Merging two arrays
    public static int[] merge(int[] first, int[] second) {
        int[] mix = new int [first.length + second.length];
        
        int i = 0; 
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }
            else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        
        //for remaining elements
        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
