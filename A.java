import java.io.*;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String input = null;
		   int len = 0;
		   String[] strArray = null;
		   String password = null;
		   char[] charArray = null;
		   char temp;
		   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			   
		   try {
		   input = reader.readLine();		
		    
		   System.out.println("input : " + input);
		   strArray = input.split(" ");
		   len = Integer.parseInt(strArray[0]);
		   password = strArray[1];
		   
		   System.out.println("pass : " + password);
		   System.out.println("len : "+len);

		   if(len != password.length())
		   { 
		    System.out.println("Invalid String");
		   }
		   else
		   {

		    //String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{,}$";
                    // String pattern = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]))";
                    String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{" + len + ",})";
                 
  
		    boolean status = password.matches(PASSWORD_PATTERN);
            
		    if(status)
		    {	 
		      charArray = password.toCharArray();
		     
		      for(int i=0;((i<len)&&(i!= (len-1))); i+=2)
		      { 
		       temp = charArray[i];
		       charArray[i] = charArray[i+1];
		       charArray[i+1] = temp;
		      }
		      
		      System.out.println("Password : "+charArray);
		    }
		    else
		    {
		      System.out.println("Invalid String");
		    }
		   }
		 } 
		 catch (IOException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
	     }

	}

}

