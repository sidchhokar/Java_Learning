import java.lang.*;
class NewThread extends Thread
{
  NewThread(ThreadGroup threadgroup, String name){
   super(threadgroup,name);
   start();
  }

  public void run()
  {
    for(int i=0; i<10; i++) {
      try {
        Thread.sleep(10);
      }
      catch(InterruptedException ex) {
        System.out.println("Exception encountered.");
      }
    }
  }
}

public class ThreadGroupTest2 {
 public static void main(String arg[]) throws InterruptedException {
 
 ThreadGroup group = new ThreadGroup("Parent thread");
 ThreadGroup groupchild = new ThreadGroup(group,"child group");
 NewThread t1 = new NewThread(group,"one");
 System.out.println("starting one.");
 NewThread t2 = new NewThread(group,"two");
 System.out.println("starting two");

 //t1.join();
 //t2.join();

 groupchild.destroy();
 System.out.println(groupchild.getName() + " destroyed.");
 group.destroy();
 System.out.println(group.getName() + " destroyed.");
 }
}
