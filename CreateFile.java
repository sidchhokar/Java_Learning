import java.io.*;

public class CreateFile
{
 
 public static void main(String args[]) throws Exception
 {
  File file = new File("/home/sid/code/javaCode/log1.txt");
  File newFile = new File("/home/sid/code/javaCode/logging2.txt");
  BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
  writer.append("appending strings.");
  writer.flush();
  writer.close();
  if(file.renameTo(newFile))
  {
   System.out.println("\n\t it is working.");
  } 
  else
  {
   System.out.println("file not renamed");
  } 
 }
}

