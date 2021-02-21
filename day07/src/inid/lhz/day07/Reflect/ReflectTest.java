package inid.lhz.day07.Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
@SuppressWarnings("all")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        /*
            不能改变类的任何代码,可以创建任意类的对象,可以执行任意方法
         */

        //1.加载配置文件
        //1.1创建properties对象
        Properties pro = new Properties();
        //1.2加载配置文件,转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader(); //返回一个类加载器对象,类加载器是将字节码(.class)文件加载进内存的东西
        InputStream ras = classLoader.getResourceAsStream("pro.properties");
        pro.load(ras);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class aClass = Class.forName(className);
        //4.创建对象 newInstance方法已过时
//        Object o = aClass.newInstance();
        Student stu = new Student();
        //5.获取方法对象
        Method eat = aClass.getMethod(methodName);
        //6.执行方法
        eat.invoke(stu);


    }

}
