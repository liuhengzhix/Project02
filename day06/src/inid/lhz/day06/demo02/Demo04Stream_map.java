package inid.lhz.day06.demo02;

import java.util.stream.Stream;

/*
    如果需要将流中的元素映射到另一个流中, 可以使用map方法.
    <R> Stream<R> map(Function<? super T, ? extends R>mapper);
    该接口需要一个Function函数式接口参数, 可以将当前流中的T类型数据转换为另一种R类型的流.
    Function中的抽象方法:
        R apply(T t);
 */
public class Demo04Stream_map {
    public static void main(String[] args) {
        //获取一个String类型的Stream流
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        //使用map方法, 把字符串类型的整数, 转换(映射)为Integer类型的整数
        /*
             方法引用是java8的新特性之一, 可以直接引用已有Java类或对象的方法或构造器。方法引用与lambda表达式结合使用, 可以进一步简化代码。
             java8方法引用有四种形式：

             静态方法引用　　　　　　　:　 　ClassName :: staticMethodName
             构造器引用　　　　　　　　:　 　ClassName :: new
             类的任意对象的实例方法引用:　 　ClassName :: instanceMethodName
             特定对象的实例方法引用　　:　 　object :: instanceMethodName
             lambda表达式可用方法引用代替的场景可以简要概括为: 【lambda表达式的主体仅包含一个表达式, 且该表达式仅调用了一个已经存在的方法。】
             方法引用的通用特性: 【方法引用所使用方法的入参和返回值与lambda表达式实现的函数式接口的入参和返回值一致。】
         */
        Stream<Integer> stream2 = stream1.map(Integer::parseInt);
        stream2.forEach(System.out::println);
    }
}
