package inid.lhz.day06.demo02;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_skip:用于跳过元素
    如果希望跳过前几个元素, 可以使用skip方法获取一个截取之后的新流:
    Stream<T> skip(Long n);
        如果流的当前长度大于n,则跳过前n个;否则将会得到一个长度为0的空流。
 */
public class Demo07Stream_skip {
    public static void main(String[] args) {
        String[] arr = {"懒羊羊", "沸羊羊", "慢羊羊", "光头强", "灰太狼"};
        Stream.of(arr).skip(3).forEach(System.out::println);
        Stream.of(arr).skip(3).skip(1).forEach(System.out::println);
        Stream.of(arr).skip(3).limit(1).forEach(System.out::println);
        System.out.println("两个\"坚强\"的男人");
    }
}
