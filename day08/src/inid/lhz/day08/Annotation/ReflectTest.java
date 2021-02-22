package inid.lhz.day08.Annotation;

import java.lang.reflect.Method;

/**
 * 框架类
 */
@SuppressWarnings("all")
@Pro(className = "inid.lhz.day08.Annotation.Person01", methodName = "show")
public class ReflectTest {
    @MyAnno3
    public static void main(String[] args) throws Exception {
        /*
            不能改变类的任何代码,可以创建任意类的对象,可以执行任意方法
         */

        Class<Integer> integerClass = int.class;
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上面的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法(也是属性),获取返回值
        String className = an.className();
        String methodName = an.methodName();

        //3.加载该类进内存
        Class aClass = Class.forName(className);
        //4.创建对象 newInstance方法已过时
        Object o = aClass.newInstance();
        //5.获取方法对象
        Method method = aClass.getMethod(methodName);
        //6.执行方法
        method.invoke(o);
    }

}
