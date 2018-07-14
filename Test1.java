
public class Test1
{
  public static boolean checkInstance(String classString, Object obj) throws ClassNotFoundException
  {
   return Class.forName(classString).isInstance(obj);
  }

  public static void main(String args[]) throws ClassNotFoundException
  {
   Integer i = new Integer(5);
   boolean b = checkInstance("java.lang.Integer",i);
   System.out.println("return : "+b);
   b = checkInstance("java.lang.String",i);
   System.out.println("return : "+b);
   b = checkInstance("java.lang.Number",i);
   System.out.println("return : "+b);
  }
}
   
