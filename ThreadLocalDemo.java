import java.lang.*;

public class ThreadLocalDemo {

public static void main(String[] args) {

  ThreadLocal<String> gfg = new ThreadLocal<String>();   
  gfg.set("Geeks");
  System.out.println("" + gfg.get());
  gfg.set("geeks but out option");
  System.out.println("" + gfg.get());

 }
}
