package inid.lhz.day07.Reflect;

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

import java.lang.reflect.Constructor;

public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        //0.获取Person的class对象
        Class<Person> personClass = Person.class;
        /*
            2. 获取构造方法们
                * Constructor<?>[] getConstructors()
                * Constructor<T> getConstructor(类<?>... parameterTypes)

                * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
                * Constructor<?>[] getDeclaredConstructors()
         */

        //Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor<Person> constructor1 = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor1);
        //创建对象
        Person person1 = constructor1.newInstance("张三", 23);
        System.out.println(person1);
        System.out.println("====================================");
        Constructor<Person> constructor2 = personClass.getConstructor();
        System.out.println(constructor2);
        //创建对象
        Person person2 = constructor2.newInstance();
        System.out.println(person2);
        System.out.println("====================================");
    }
}
