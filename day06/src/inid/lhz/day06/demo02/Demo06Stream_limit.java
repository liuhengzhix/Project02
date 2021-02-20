package inid.lhz.day06.demo02;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_Limit:用于截取流中的元素
    Limit方法可以对流进行截取, 只取用前n个. 方法签名：
    Stream<T>Limit(Long maxSize);
        参数是一个Long型, 如果集合当前长度大于参数则进行截取; 否则不进行操作
    Limit方法是一个延迟方法, 只是对流中的元素进行截取, 返回的是一个新的流, 所以可以继续调用Stream流中的其他方法
 */
public class Demo06Stream_limit {
    public static void main(String[] args) {
        String[] arr = {"懒羊羊","沸羊羊","慢羊羊","光头强","灰太狼"};
        //Limit方法是一个延迟方法, 只是对流中的元素进行截取, 返回的是一个新的流, 所以可以继续调用Stream流中的其他方法
        Stream.of(arr).limit(3L).forEach(System.out::println);
    }
}
