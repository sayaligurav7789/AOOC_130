import java.io.*;
import java.net.*;
import java.util.*;
class tcpclient {
public static void main(String args[]) {
try {
    Socket s1 = new Socket("127.0.0.1", 1520);

    InputStream is = s1.getInputStream();
    OutputStream os = s1.getOutputStream();
  
    DataInputStream dis = new DataInputStream(is);
    DataOutputStream dos = new DataOutputStream(os);
    // Scanner to read input from user
    Scanner sc = new Scanner(System.in);
    String str;
        do {
        // Take input from user and send to server
            System.out.print("Enter message to send: ");
            str = sc.nextLine();
            dos.writeUTF(str); // Send string to server
            // Receive and print response from server
            System.out.println("Waiting for server response..");
            str = dis.readUTF();
            System.out.println("Server replied: " + str);
        } 
        while (!str.equalsIgnoreCase("STOP"));
            s1.close(); 
} 
catch (Exception e) {
    System.out.println("Client Error: " + e.getMessage());
}
}
}