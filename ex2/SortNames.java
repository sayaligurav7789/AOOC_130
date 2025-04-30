package ex2;

import java.util.Arrays;
import java.util.Scanner;

public class SortNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 names: ");
        String[] names = new String[10];

        for(int i = 0; i < names.length; i++){
            names[i] = sc.nextLine();
        }
        System.out.println("Unsorted Names: " + Arrays.toString(names));

        boolean swapped;

        for(int i = 0; i < names.length - 1; i++){
            swapped = false;
            for(int j = 1; j <= names.length - i - 1; j++){
                if(names[j].compareTo(names[j-1]) < 0){
                    String temp = names[j];
                    names[j] = names[j - 1];
                    names[j - 1] = temp;

                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        
        System.out.println("Sorted Names" + Arrays.toString(names));
    }
}
