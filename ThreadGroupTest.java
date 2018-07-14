import java.lang.*;

class NewThread extends Thread {
   NewThread(ThreadGroup threadgroup, String threadName)
   {
     super(threadgroup, threadName);
     start();
   }
  
   public void run()
   {
     for(int i=0; i<1000; i++)
     {
      try
      {
       Thread.sleep(10);
      }
      catch(InterruptedException ex)
      {
        System.out.println("Exception encountered");
      }
     }
   }
 }
 
 public class ThreadGroupTest
 {
  public static void main(String arg[])
  {
    ThreadGroup group = new ThreadGroup("parent thread group");
    NewThread t1 = new NewThread(group,"one");
    System.out.println("starting one");
    NewThread t2 = new NewThread(group,"two");
    System.out.println("starting two");
   
    System.out.println("no active thread: "+ group.activeCount());
  }
 }
    
 
