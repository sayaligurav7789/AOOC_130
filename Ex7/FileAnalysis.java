package Ex7;

import java.io.*;

public class FileAnalysis{

    public static void main(String[] args){
        String filename = "D:\\AOOC-130\\Ex7\\sample.txt";  
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            int vowelCount = 0;
            int wordCount = 0;
            int aCount = 0;

            while ((line = br.readLine()) != null){

                for (char c : line.toCharArray()){
                    if (isVowel(c)) {
                        vowelCount++;
                    }
                    if (c == 'a' || c == 'A'){
                        aCount++;
                    }
                }
                
                // Count words in the line using a regular expression
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Total vowels: " + vowelCount);
            System.out.println("Total words: " + wordCount);
            System.out.println("Number of times 'a' appears: " + aCount);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
