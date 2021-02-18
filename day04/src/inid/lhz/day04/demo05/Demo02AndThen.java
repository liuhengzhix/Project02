package inid.lhz.day04.demo05;

import java.util.function.Consumer;

/*
    Consumer接口的默认方法andThen
    作用:需要两个Consumer接口,可以把两个Consumer接口组合到一起,在对数据进行消费
    例如:
        Consumer<String>con 1
        Consumer<String>con 2
        String s=“hello“;
        con1.accept(s);
        con2.accept(s);
        连接两个Consumer接口再进行消费
        con1.andThen(con2).accept(s) 谁写前边谁先消费
 */
public class Demo02AndThen {
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(s);
//        con2.accept(s);
        //使用andThen方法,把两个Consumer接口连到一起. 和上面的两行效果一样
        con1.andThen(con2).accept(s); //con1连接con2,先执行con1消费数据,再执行con2消费数据
    }

    public static void main(String[] args) {
        //调用method方法,传递一个字符串,两个lambda表达式
        method("Hello", t -> {
            //字符串转大写
            System.out.println(t.toUpperCase());
        }, t -> {
            //转小写
            System.out.println(t.toLowerCase());
        });
    }
}
