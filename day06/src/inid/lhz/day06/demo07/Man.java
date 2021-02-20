package inid.lhz.day06.demo07;

/*
    定义子类
 */
public class Man extends Human{
    //子类重写父类sayHello的方法

    @Override
    public void sayHello() {
        System.out.println("Hello 我是Man!");
    }

    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        //关键来了:调用一下method方法
        /*method(() -> {
            Human h = new Human();
            h.sayHello();
        });*/

        /*
            使用super引用类的成员方法
            super是已经存在的
            父类的成员方法sayHello也是已经存在的
            所以我们可以直接使用super引用父类的成员方法
            优化后的; 就是把父类的方法引用到Greetable的抽象方法重写中了
         */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
        new Man().sayHello();
    }
}
