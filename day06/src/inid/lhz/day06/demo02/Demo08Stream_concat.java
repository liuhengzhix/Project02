package inid.lhz.day06.demo02;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_concat: 用于把流组合到一起
    如果有两个流, 希望合并成为一个流, 那么可以使用Stream接口的静态方法concat
    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 */
public class Demo08Stream_concat {
    public static void main(String[] args) {
        //创建Stream流
        Stream<String> stream1 = Stream.of("张三丰", "张翠山", "周芷若", "赵敏", "张无忌");
        Stream<String> stream2 = Stream.of("懒羊羊", "沸羊羊", "慢羊羊", "光头强", "灰太狼");

        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(System.out::println);
    }
}
