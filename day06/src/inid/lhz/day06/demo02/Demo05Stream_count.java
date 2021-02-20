package inid.lhz.day06.demo02;

import java.util.ArrayList;
import java.util.Collections;

/*
    Stream流中的常用方法_count: 用于统计Stream流中元素的个数
    Long count();
    count方法是一个终结方法, 返回值是一个Long类型的整数
    所以不能再继续调用Stream流中的其他方法了
 */
public class Demo05Stream_count {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        long count = list.stream().count();
        System.out.println(count);
    }
}
