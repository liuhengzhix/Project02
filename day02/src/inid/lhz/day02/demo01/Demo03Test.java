package inid.lhz.day02.demo01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    练习：序列化集合
        当我们想在文件中保存多个对象的时候
        可以把多个对象存储到一个集合中
        对集合进序列化和反序列化
    分析：
        1.定义一个存储Person对象的ArrayList集合
        2.往ArrayList集合中存储Person对象
        3.创建一个序列化流ObjectOutputStream对象
        4.使用ObjectOutputStream对象中的方法writeObject，对集合进行序列化
        5.创建一个反序列化ObjectInputStream对象
        6.使用objectInputStream对象中的方法readObject读取文件中保存的集合
        7.把Object类型的集合转换为ArrayList类型
        8.遍历ArrayList集合
        9.释放资源
 */
public class Demo03Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> people = new ArrayList<>();
        Collections.addAll(people, new Person("迪丽热巴", 18), new Person("古力娜扎", 28),
                new Person("马尔扎哈", 38));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\bili\\people.txt"));
        oos.writeObject(people);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\bili\\people.txt"));
        Object o = ois.readObject();
        ArrayList<Object> arr = (ArrayList<Object>) o;
        //集合覆写了toString方法可直接打印 [Person{name='迪丽热巴', age=18}, Person{name='古力娜扎', age=28}, Person{name='马尔扎哈', age=38}]
        //也可以遍历集合
        System.out.println(arr);
        ois.close();
        oos.close();
    }
}
