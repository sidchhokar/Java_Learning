public class Sid
{
public static void main(String [] arg)
	{
		//call a test method from here.
	System.out.print(add("testString"));
	}

public static int add(final String numbers)
{
 int returnValue = 0;
 String[] numbersArray = numbers.split(",");
 if(numbersArray.length > 2) {
     throw new RuntimeException("Up to 2 numbers seperated by comma (,) are followed");
}
else
{
 for(String number : numbersArray) {
	if(!number.trim().isEmpty()) {
           returnValue += Integer.parseInt(number);
	}
  }

return returnValue;
}
}
}	
