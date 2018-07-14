import java.lang.*;

public class ThreadLocalTest {
 public static void main(String[] args) {
  NewThread t1 = new NewThread("thread-0");
  NewThread t2 = new NewThread("thread-1"); 
 }
}

class NewThread extends Thread {
  private static ThreadLocal<
  Integer> local = new ThreadLocal<Integer>() {
    protected Object initialValue(){
      return new Integer(15);
  }
  public void set(Object obj) {
   local.set(obj);   
  }
   
  };
  
  //private static int question = 15;

 NewThread(String name) {
  super(name);
  start();
 }

 public void run()
 {
  for(int i = 0; i<2; i++) {
   System.out.println(getName() + " " + local.get());
   local.set(new Integer(10)); 
  }
 }
}

  
