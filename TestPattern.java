

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

public static void main(String[] args) {
     // TODO Auto-generated method stub
     String pattern = "[1-9]|[1-9][0-9]{1,8}|[1-3][0-9]{1-9}|4[01][0-9]{8}|42[0-8][0-9]{7}|429[0-3][0-9]{6}|4294[0-8][0-9]{5}|42949[0-5][0-9]{4}|429496[0-6][0-9]{3}|4294967[01][0-9]{2}|42949672[0-8][0-9]|429496729[0-5]";
     Scanner scan = new Scanner(System.in);
     String input = scan.nextLine();
     Pattern p = Pattern.compile(pattern);
     Matcher m = p.matcher(input);
     System.out.println("output: "+m.matches());     
 }
                    
}
