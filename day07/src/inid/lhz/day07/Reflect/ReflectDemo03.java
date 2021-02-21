package inid.lhz.day07.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo03 {
    /*
        * Class对象功能：
        * 获取功能：
		1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取指定名称的 public修饰的成员变量

			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)
		2. 获取构造方法们
			* Constructor<?>[] getConstructors()
			* Constructor<T> getConstructor(类<?>... parameterTypes)

			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			* Constructor<?>[] getDeclaredConstructors()
		3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)

		4. 获取全类名
			* String getName()
     */

    public static void main(String[] args) throws Exception {
        //0.获取Person的class对象
        Class<Person> personClass = Person.class;
        /*
            3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */
        Method eat1 = personClass.getMethod("eat");
        Person p1 = new Person();
        //执行方法
        eat1.invoke(p1);


        Method eat2 = personClass.getMethod("eat", String.class); //String.class字节码文件别忘了
        Person p2 = new Person();
        //执行方法
        eat2.invoke(p2,"饺子");
        System.out.println("=================================");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        String className = personClass.getName();
        System.out.println(className);
    }
}
