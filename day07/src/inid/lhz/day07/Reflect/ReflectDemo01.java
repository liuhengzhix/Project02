package inid.lhz.day07.Reflect;

import java.lang.reflect.Field;

public class ReflectDemo01 {
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
            1. 获取成员变量们
                * Field[] getFields() ：获取所有public修饰的成员变量
                * Field getField(String name)   获取指定名称的 public修饰的成员变量

                * Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
                * Field getDeclaredField(String name)
         */
        //1.Field[] getFields(): 获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=====================================");
        //2.Field getField(String name)   获取指定名称的 public修饰的成员变量
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p, "张三");
        System.out.println(p);
        System.out.println("==^=^====^=^====^=^====^=^====^=^====^=^==");

        //3.Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("==^=^====^=^====^=^====^=^====^=^====^=^==");
        //Field getDeclaredField(String name) 获取指定名称的 public修饰的成员变量
        Field d = personClass.getDeclaredField("name");

        d.setAccessible(true); //忽略访问权限修饰符的安全检查; 暴力检查(FBI open the door)

        Object value2 = d.get(p);
        System.out.println(value2);

    }
}
