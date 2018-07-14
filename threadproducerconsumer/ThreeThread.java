import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ThreeThread {
  
  public static void main(String args[]) throws InterruptedException {
   Scanner scan = new Scanner(System.in);
   String value = scan.nextLine();
   System.out.println("value: "+ value);
   Semaphore sem1 = new Semaphore(1);
   Semaphore sem2 = new Semaphore(0);
   Semaphore sem3 = new Semaphore(0);
   Data obj = new Data(value);
   Thread1 t1 = new Thread1(obj, sem1, sem2);
   Thread2 t2 = new Thread2(obj, sem2, sem3);
   Thread3 t3 = new Thread3(obj, sem3, sem1);
   
   t1.start();
   t2.start();
   t3.start();

   t1.join();
   t2.join();
   t3.join();   
  }
}

class Data {
 String value;
 int i = 0;
 char ch[];
 
 Data(String val) {
  this.value = val;
  ch = value.toCharArray();  
 }
  
 public void processData() {  
     System.out.println(" : "+ch[i]);
   
 }
}


class Thread1 extends Thread
{
  Data dataObj;
  Semaphore semThread1;
  Semaphore semThread2;

  Thread1(Data obj,Semaphore semThread1,Semaphore semThread2) {
   this.dataObj = obj;
   this.semThread1 = semThread1;
   this.semThread2 = semThread2;
  }

  public void run() {
    while(true) {
      try {
        semThread1.acquire();
      }
      catch(InterruptedException ex) {
        ex.printStackTrace();
      }
      if(dataObj.i < dataObj.value.length()) {
        System.out.print(""+ Thread.currentThread().getName());
        dataObj.processData();
        dataObj.i++;
      }
      else {
        semThread2.release();
        break;
      }      
      semThread2.release(); 
    }
  }
}

class Thread2 extends Thread
{
  Data dataObj;
  Semaphore semThread2;
  Semaphore semThread3;

  Thread2(Data obj,Semaphore semThread2,Semaphore semThread3) {
   this.dataObj = obj;
   this.semThread2 = semThread2;
   this.semThread3 = semThread3;
  }

  public void run() {
    while(true) {
      try { 
        semThread2.acquire();
      }
      catch(InterruptedException ex) {
        ex.printStackTrace();
      } 
      if(dataObj.i < dataObj.value.length()) {
        System.out.print(""+ Thread.currentThread().getName());
        dataObj.processData();
        dataObj.i++;
      }
      else {
        semThread3.release();
        break;
      }      
      semThread3.release(); 
    }
  }
}

class Thread3 extends Thread
{
  Data dataObj;
  Semaphore semThread3;
  Semaphore semThread1;

  Thread3(Data obj,Semaphore semThread3,Semaphore semThread1) {
   this.dataObj = obj;
   this.semThread3 = semThread3;
   this.semThread1 = semThread1;
  }

  public void run() { 
    while(true) {
      try {
        semThread3.acquire();
      }
      catch(InterruptedException ex) {
        ex.printStackTrace();
      }
      if(dataObj.i < dataObj.value.length()) {
        System.out.print(""+ Thread.currentThread().getName());
        dataObj.processData();
        dataObj.i++;
      }
      else {
        semThread1.release();
        break;
      }      
      semThread1.release(); 
    }
  }
}
