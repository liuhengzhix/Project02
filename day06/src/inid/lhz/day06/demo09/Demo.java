package inid.lhz.day06.demo09;

/*
    类的构造器引用(构造方法)引用
 */
public class Demo {
    //定义一个方法,参数传递姓名和PersonBuilder接口,方法中通过姓名创建对象
    public static void printName(String name, PersonBuiilder p) {
        Person person = p.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        /*
            使用方法引用优化Lambda表达式
            构造方法new Person(String name) 已知
            创建对象已知new
            就可以使用Person引用new创建对象
         */
        printName("迪丽热巴", Person::new);
    }
}
