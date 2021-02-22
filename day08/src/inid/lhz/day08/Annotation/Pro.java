package inid.lhz.day08.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述需要执行的类名,和方法名
 */
@Target({ElementType.TYPE}) //元注解定义只能在类上使用
@Retention(RetentionPolicy.RUNTIME) //定义存活周期
public @interface Pro {
    String className();

    String methodName();

    /*
        其实就是在内存中生成了一个该注解接口的子类实现对象
        public class ProImpl implements Pro(){
            public String className(){
                return "inid.lhz.day08.Annotation.Person01";
            }

            public String methodName(){
                return "show";
            }
        }
     */
}
