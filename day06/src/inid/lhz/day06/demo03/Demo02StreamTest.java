package inid.lhz.day06.demo03;

import java.util.stream.Stream;

/*
            升级版
            1.第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
            2.第一个队伍筛选之后只要前3个人; 存储到一个新集合中
            3.第二个队伍只要姓张的成员姓名;  存储到一个新集合中
            4.第二个队伍筛选之后不要前2个人; 存储到一个新集合中
            5.将两个队伍合并为一个队伍;     存储到一个新集合中
            6.根据姓名创建Person对象:     存储到一个新集合中
            7.打印整个队伍的Person对象信息
 */
public class Demo02StreamTest {
    public static void main(String[] args) {
        Stream<String> limit = Stream.of("迪丽热巴", "宋远桥", "苏星河", "石破天", "石中玉", "老子", "庄子", "洪七公")
                .filter(s -> s.length() == 3)
                .limit(3);
        Stream<String> skip = Stream.of("古力娜扎", "张无忌", "赵丽颖", "张三丰", "尼古拉斯赵四", "张天爱", "张二狗")
                .filter(s -> s.startsWith("张"))
                .skip(2);

        //5.将两个队伍合并为一个队伍;     存储到一个新集合中
        //6.根据姓名创建Person对象:     存储到一个新集合中
        Stream<Person> personStream = Stream.concat(limit, skip).map(Person::new);
        personStream.forEach(System.out::println);
    }
}
