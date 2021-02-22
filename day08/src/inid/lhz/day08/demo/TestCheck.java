package inid.lhz.day08.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 *
 * 当主方法执行后, 会自动自行被检测的所有方法(加了Check注解的方法), 判断方法是否有异常, 记录到文件中
 */
@SuppressWarnings("all")
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //获取类的字节码对象
        Calculator c = new Calculator();
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();

        int number = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        //判断方法上是否有check注解
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    //执行方法
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常
                    //记录到文件
                    number++;
                    bw.write(method.getName()+" 方法出现异常了");
                    bw.newLine();
                    bw.write("异常名称: "+e.getCause()+e.getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因: "+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-------------------------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现 "+number+" 次异常");

        bw.flush();
        bw.close();
    }
}
