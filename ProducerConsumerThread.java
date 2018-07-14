
import java.util.LinkedList;

public class ProducerConsumerThread
{
	final static PC pc = new PC();

 	public static void main(String args[]) throws InterruptedException
	{
	
		Thread t1 = new Thread(new Runnable()
		{
		  public void run()
		  {
			try{
			 pc.produce();
			}
			catch(InterruptedException ex)
			{
			 ex.printStackTrace();
			}
		  }	
		});

		Thread t2 = new Thread(new Runnable()
		{
		  public void run()
		  {      
			try{
			 pc.Consume();
			}
			catch(InterruptedException ex)
			{
			 ex.printStackTrace();
			}
		  } 
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}
}

class PC
{
	LinkedList<Integer> list = new LinkedList<>();
	int capacity=2;

	public void produce() throws InterruptedException
	{
		int value = 0;
		while(true)
		{
			synchronized(this)
			{
			if(list.size()==capacity) // means if Queue is full.
			{
				wait();
			}

			list.add(++value);
			System.out.println("added value : " + value);
		
			notify();
			Thread.sleep(1000);
   			}
		}
	}
	
	public void Consume() throws InterruptedException
	{
		int value = 0;
		while(true)
		{
			synchronized(this)
			{
			if(list.size()==0) // means if Queue is full.
			{
				wait();
			}

			int val = list.removeFirst();
			System.out.println("removed value : " + val);
		
			notify();
			Thread.sleep(1000);
			}
		}
	}
}				

