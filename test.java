import java.util.Arrays;
 
public class test
{
    public static void main(String[] args)
    {        
        int intArr[] = {10,20,15,22,35};
        double doubleArr[] = {10.2,15.1,2.2,3.5};
	
	Arrays.sort(intArr);
	Arrays.sort(doubleArr);

	System.out.println("index of 5 : " + Arrays.binarySearch(intArr,5));
	System.out.println("index of 1.5 : " + Arrays.binarySearch(doubleArr,1.5));
	
	}
}

