import java.io.*;

public class FileRedirect
{
 public static void main(String args[]) throws FileNotFoundException
 {
  PrintStream prntStrm = new PrintStream(new File("A.txt"));
  PrintStream console = System.out;
  System.out.println("This should also be written to console.");
  System.setOut(console);
  System.out.println("this would also be printed on console.");
  System.setOut(prntStrm);
  System.out.println("Now,this would be written to a file.");

  }
}
