package inid.lhz.day07.demo02;

/*
    JDK中预定义的一些注解
        *@Override:检测被该注解标注的方法是否是继承自父类(接口)的
        *@Deprecated:该注解标注的内容, 表示已过时
        *@Suppress Warnings:压制警告
 */
@SuppressWarnings("all")
public class AnnoDemo02 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show01() {
        //有缺陷
    }

    @MyAnno(age = 2, name = "asdf")
    public void show02() {
        //替代show01方法
    }

    public void demo() {
        show01();
    }
}
