package inid.lhz.day06.demo09;

/*
    定义一个创建Person对象的函数式接口
 */
@FunctionalInterface
public interface PersonBuiilder {
    //定义一个方法, 根据传递的姓名,创建Person对象并返回Person对象
    Person builderPerson(String name);
}
