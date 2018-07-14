import java.util.Scanner;
 
class DemoAssert
{
    public static void main( String args[] )
    {
        int value = 20;
        assert value >= 20 : " Underweight";
        System.out.println("value is "+value);
    }
}
