import java.lang.*;

class NewThread extends Thread
{
 NewThread(ThreadGroup group,String threadName)
 {
   super(group,threadName);
   start();
 }
 
 public void run() {
 for (int i = 0; i < 1000; i++) 
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ex) 
            {
                System.out.println("Exception encounterted");
            }
        }
        System.out.println(Thread.currentThread().getName() + 
            " finished executing");
    }
} 
public class ThreadGroupTest1 
{
    public static void main(String arg[]) throws InterruptedException
    {
        // creating the thread group
        ThreadGroup gfg = new ThreadGroup("gfg");
 
        ThreadGroup gfg_child = new ThreadGroup(gfg, "child");
 
        NewThread t1 = new NewThread(gfg,"one");
        System.out.println("Starting one");
        NewThread t2 = new NewThread(gfg,"two");
        System.out.println("Starting two");
 
        // checking the number of active thread
        System.out.println("number of active thread group: "
                           + gfg.activeGroupCount());
        System.out.println("number of thread:" + gfg.activeCount());

        //t1.join();
        //t2.join();
        //gfg.destroy();

        gfg.interrupt();
    }
} 
