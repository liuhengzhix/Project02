package inid.lhz.day04.demo03;

/*
    例如java.Lang.Runnable接口就是一个函数式接口
    假设有一个startThread方法使用该接口作为参数,那么就可以使用Lambda进行传参。
    这种情况其实和Thread类的构造方法参数为Runnable没有本质区别。
 */
public class Demo01Runnable {
    //定义一个方法startThread,参数使用Runnable函数式接口
    public static void startThread(Runnable run) {
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //调用startThread方法,参数是函数式接口可以使用匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->"+"线程启动了");
            }
        });

        //lambda优化
        startThread(() -> System.out.println(Thread.currentThread().getName()+"-->"+"线程启动了"));
    }
}
