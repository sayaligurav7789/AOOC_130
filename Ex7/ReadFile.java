package Ex7;

import java.io.*;

public class ReadFile {
    public static void main(String[] args){
      
        String filePath = "D:\\Demo.txt"; 
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

            reader.close();
            isr.close();
            fis.close();
        } 
        catch (IOException e){
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
