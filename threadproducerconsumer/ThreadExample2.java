import java.util.Scanner;

public class ThreadExample2
{
 public static void main(String[] args) throws InterruptedException
 {
  final PC pc = new PC();
  
  Thread t1 = new Thread(new Runnable()
  {
    public void run()
    {
      try
      {
        pc.produce();
      }
      catch(InterruptedException ex) {
        ex.printStackTrace();
      }
    } 
  });

  Thread t2 = new Thread(new Runnable()
  {
    public void run()
    {
       try {
         pc.consume();
       }
       catch(InterruptedException ex) {
        ex.printStackTrace();
       }
    }
  });

 t1.start();
 t2.start();
 
 t1.join();
 t2.join();
}

public static class PC
{
  public void produce() throws InterruptedException
  {
     synchronized(this)
     {
       System.out.println("producer thread running.");
       wait();
       System.out.println("Resumed");
     }
  }

  public void consume() throws InterruptedException
  {
    Thread.sleep(1000);
    Scanner s = new Scanner(System.in);
    synchronized(this)
    {
      System.out.println("waiting for return key");
      s.nextLine();
      System.out.println("Return key pressed.");
      notify();
      Thread.sleep(2000);
    }
  }
}

}
  
