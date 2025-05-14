package Ex7;

import java.io.*;
import java.util.Scanner;

public class FileManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (args.length == 0) {
            System.out.println("Please provide a file name as a command line argument.");
            return;
        }
        
        String filename = args[0];
        
        // Check if the file exists
        File file = new File(filename);
        
        // If the file exists, display its contents
        if (file.exists()) {
            displayFileContents(file);

            System.out.print("Do you want to add data to the end of the file? (Yes/No): ");
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("Yes")) {
                appendDataToFile(file);
            }
        } else {
            // If the file does not exist, create it and allow user to input data
            try {
                file.createNewFile();
                System.out.println("File created successfully: " + filename);
                appendDataToFile(file);
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private static void displayFileContents(File file) {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            System.out.println("\nFile contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void appendDataToFile(File file) {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            System.out.println("Enter the data you want to append (type 'exit' on a new line to stop):");
            String userInput;
            
            // Keep reading lines from the user until "exit" is entered
            while (true) {
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                bw.write(userInput);
                bw.newLine(); 
            }
            System.out.println("Data has been appended to the file.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
