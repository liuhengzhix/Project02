package inid.lhz.day06.demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    使用Stream流的方式, 遍历集合, 对集合中的数据进行过滤
    Stream流是JDK1.8之后出现的
    关注的是做什么, 而不是怎么做
 */
public class Demo02Stream {
    public static void main(String[] args) {
        //创建一个List集合存储姓名
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        //对List集合中的元素进行过滤, 只要以张开头的元素, 存储到一个新的集合中
        //对listA集合进行过滤, 只要姓名长度为3的人, 存储到一个新集合中
        //stream方法可以把集合转换为Stream流
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length()==3)
                .forEach(name -> System.out.println(name));
    }
}
