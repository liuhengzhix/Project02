package inid.lhz.day06.demo02;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_filter: 用于对Stream流中的数据进行过滤
    Stream<T>filter(Predicate<? super T> predicate);
    filter方法的参数Predicate是一个函数式接口, 所以可以传递Lambda表达式, 对数据进行过滤
    Predicate中的抽象方法;
        boolean test(T t);
 */
public class Demo03Stream_filter {
    public static void main(String[] args) {
        //创建Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "周芷若", "赵敏", "张无忌");
        //使用filter方法过滤,返回stream流
        Stream<String> stream1 = stream.filter(name -> name.startsWith("张"));
        //打印过滤后的stream
        stream1.forEach(s -> System.out.println(s));

        /*
            Stream流属于管道流, 只能被消费(使用)一次
            第一个Stream流调用完毕方法, 数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕, 就会关闭了
            所以第一个Stream流就不能再调用方法了
            IllegalStateException: stream has already been operated upon or closed
         */
        stream.forEach(s -> System.out.println(s));
    }
}
