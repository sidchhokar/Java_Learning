import java.io.*;
import java.net.*;

class Client extends Thread
{
		Socket client;
		Client()
		{
			try {
				client = new Socket("127.0.0.1",11000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}

		public void run()
		{
			try{
				OutputStream out = client.getOutputStream();
					DataOutputStream data = new DataOutputStream(out);
				while(true)
				{	
					data.writeUTF("Hello from : " + client.getLocalSocketAddress());				 					
				}
				
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}


		}

		public static void main(String args[])
		{
			Client obj = new Client();
			obj.start();
		}

}

