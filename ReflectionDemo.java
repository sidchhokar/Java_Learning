import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

class Test
{
 private String s;

 public Test()
 {
  s = "GeeksforGeeks"; }

 public void method1()
 {
  System.out.println("method1, The string is " + s);
 }

 public void method2(int n) 
 {
  System.out.println("method2, The number is "+n);
 }

 private void method3()
 { 
  System.out.println("private method3 invoked");
 }
}

class ReflectionDemo
{
 public static void main(String args[]) throws Exception
 {
  Test obj = new Test();
 
  Class cls = obj.getClass();
  System.out.println("The name of class is " + cls.getName());

  Constructor constructor = cls.getConstructor();
  System.out.println("The name of constructor is : "+constructor.getName());
  
  System.out.println("public methods of the class are: ");
	
  Method[] methods = cls.getMethods();

  for(Method method : methods)
  { 
   System.out.println("method name :" + method.getName());
  }
  
  Method methodCall1 = cls.getDeclaredMethod("method2",int.class);
 
  methodCall1.invoke(obj,19);

  Field field = cls.getDeclaredField("s");
  
  field.setAccessible(true);

  field.set(obj,"JAVA");
  
  Method method3 = cls.getDeclaredMethod("method3");
  method3.setAccessible(true);
  method3.invoke(obj);
 }
}

  
  
