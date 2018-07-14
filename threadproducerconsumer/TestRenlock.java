import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class worker implements Runnable
{
  String name;
  ReentrantLock re;
  public worker(ReentrantLock rl, String n) {
    re = rl;
    name = n;
  }
  
  public void run() {
   boolean done = false;
   while(!done) {
   boolean ans = re.tryLock();
    
   if(ans) {
     try {
       Date d = new Date();
       SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
       System.out.println("task name: " + name + ", outer lock acquired at " +       ft.format(d)+ ", doing outer work");
       Thread.sleep(1500);
       re.lock(); // getting inner lock
       try {
         d = new Date();
         ft = new SimpleDateFormat("hh:mm:ss");
         System.out.println("task name: "+ name + 
         " inner lock acquired at " +
         ft.format(d) +
         ", doing inner work");
         System.out.println("Lock Hold Count: "+ re.getHoldCount());
         Thread.sleep(1500);
       }
       catch(InterruptedException e) {
          e.printStackTrace();
       }
       finally {
         System.out.println("task name: " + name +
         " releasing inner lock");
         re.unlock();
       }
       System.out.println("Lock Hold Count: "+ re.getHoldCount());
       System.out.println("task name: " + name + " work done");
   
       done = true;
     }
     catch(InterruptedException ex) {
       ex.printStackTrace();
     }
     finally {
       System.out.println("task name "+ name +
       "releasing outer lock");
       re.unlock();
       System.out.println("Lock Hold Count "+ re.getHoldCount());
     }
    }
    else {
      System.out.println("task name "+ name + "waiting for lock"); 
      try {
          Thread.sleep(1000);
      }
      catch(InterruptedException ex) {
         ex.printStackTrace();
      }
    }
   }
  }
 }

public class TestRenlock {
 static final int MAX_T =2 ;
 public static void main(String args[]) {
   ReentrantLock rel = new ReentrantLock();
   ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
   Runnable w1 = new worker(rel,"job1");
   Runnable w2 = new worker(rel,"job2");
   Runnable w3 = new worker(rel,"job3");
   Runnable w4 = new worker(rel,"job4");
   pool.execute(w1);
   pool.execute(w2);
   pool.execute(w3);
   pool.execute(w4);
   pool.shutdown();
  }
 }
