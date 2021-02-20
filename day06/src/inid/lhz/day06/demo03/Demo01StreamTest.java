package inid.lhz.day06.demo03;

import java.util.ArrayList;
import java.util.Collections;

/*
    练习:集合元素处理(传统方式)
        现在有两个ArrayList集合存储队伍当中的多个成员姓名, 要求使用传统的for循环(或增强for循环) 依次进行以下若干操作步骤：
            1.第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
            2.第一个队伍筛选之后只要前3个人; 存储到一个新集合中
            3.第二个队伍只要姓张的成员姓名;  存储到一个新集合中
            4.第二个队伍筛选之后不要前2个人; 存储到一个新集合中
            5.将两个队伍合并为一个队伍;     存储到一个新集合中
            6.根据姓名创建Person对象:     存储到一个新集合中
            7.打印整个队伍的Person对象信息
 */
public class Demo01StreamTest {
    public static void main(String[] args) {
        //一队
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "迪丽热巴", "宋远桥", "苏星河", "石破天", "石中玉", "老子", "庄子", "洪七公");
        ArrayList<String> string1 = new ArrayList<>();
        ArrayList<String> string2 = new ArrayList<>();
        for (String s : list1) {
            if (s.length() == 3) {
                string1.add(s);
            }
        }
        for (int i = 0; i < 3; i++) {
            string2.add(string1.get(i));
        }

        //二队
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "古力娜扎", "张无忌", "赵丽颖", "张三丰", "尼古拉斯赵四", "张天爱", "张二狗");

        ArrayList<String> string3 = new ArrayList<>();
        ArrayList<String> string4 = new ArrayList<>();
        for (String s : list2) {
            if (s.startsWith("张")) {
                string3.add(s);
            }
        }
        for (int i = 2; i < string3.size(); i++) {
            string4.add(string3.get(i));
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(string2); //将string2集合加入到list集合
        list.addAll(string4); //将string4集合加入到list集合

        //6.根据姓名创建Person对象:     存储到一个新集合中
        ArrayList<Person> people = new ArrayList<>();
        for (String s : list) {
            people.add(new Person(s));
        }
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
