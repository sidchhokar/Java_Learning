class A { int a; }
class B {int b;}

public class Test
{
 public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
 {
  Object obj = Class.forName(args[0]).newInstance();
  System.out.println("object of class : " + obj.getClass().getName());
 }
}
