import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
  private Socket socket          = null;
  private Scanner input  = null;
  private DataOutputStream out   = null;

  public Client(String address, int port) {
     try {
       socket = new Socket(address, port);
       System.out.println("Connected");

       input = new Scanner(System.in);
       out = new DataOutputStream(socket.getOutputStream());
     }
     catch(UnknownHostException u) {
       System.out.println(u);
     }
     catch(IOException i) {
       System.out.println(i);
     }
   
     String line = "";

     while(!line.equals("over")) {
       try {
          line = input.nextLine();
          out.writeUTF(line);
       }
       catch(IOException i) {
          System.out.println(i);
       }
     }

     try {
       input.close();
       out.close();
       socket.close();
     }
     catch(IOException i) {
       System.out.println(i);
     }
  }
 
  public static void main(String args[]) {
     Client client = new Client("127.0.0.1", 5000);
  }
}    
