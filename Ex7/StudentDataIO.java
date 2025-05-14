package Ex7;

import java.io.*;
import java.util.Scanner;
public class StudentDataIO{
        public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Weight (in kg): ");
        float weight = scanner.nextFloat();

        System.out.print("Enter Height (in cm): ");
        float height = scanner.nextFloat();
        scanner.nextLine(); 

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        String filename = "studentData.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))){
            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeUTF(phone);
            System.out.println("\nData written to file successfully.");
        } 
        catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))){
            System.out.println("\nReading data from file:");
            System.out.println("Name: " + dis.readUTF());
            System.out.println("Age: " + dis.readInt());
            System.out.println("Weight: " + dis.readFloat() + " kg");
            System.out.println("Height: " + dis.readFloat() + " cm");
            System.out.println("City: " + dis.readUTF());
            System.out.println("Phone: " + dis.readUTF());
        } 
        catch (IOException e){
            System.out.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}
