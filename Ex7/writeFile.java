package Ex7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    public static void main(String[] args) {
        String[] s = {"Sayali", "Jyoti", "Prachi"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Hello, World!");

            for(String name: s){
                writer.write("\n" + name);
            }
            writer.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
