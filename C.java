import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

      public static void main(String[] args) {
	// TODO Auto-generated method stub
	String input = null;
	String numberString = null;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
	   input = reader.readLine();
		
           int stringLength = input.length();
           if(!Character.isDigit(input.charAt(stringLength-1)))
           {
             //check here only that whether it contains any number either.
             numberString = input.replaceAll("\\D+","");
             if(numberString.equals(""))
             {
 		System.out.println("None");
             }
             else
             {
              System.out.println("1invalid string");
 	     }
           }
           else
           {
         	numberString = input.replaceAll("\\D+","");
         	int num = Integer.parseInt(numberString);
         	String actualString = input.replaceAll("\\d+", "");
         	if(actualString.length() != num)
         	{
         		System.out.println("2invalid String");
         	}
         	else
         	{
         		System.out.println("3valid string");
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

