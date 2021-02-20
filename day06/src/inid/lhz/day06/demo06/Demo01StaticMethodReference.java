package inid.lhz.day06.demo06;

/*
    通过类名引用静态成员方法
    类已经存在, 静态成员方法也已经存在
    就可以通过类名直接引用静态成员方法
 */
public class Demo01StaticMethodReference {
    //定义一个方法, 方法的参数传递要计算绝对值的整数,和函数式接口calcable
    public static int method(int num, Calcable cal) {
        return cal.calcAbs(num);
    }

    public static void main(String[] args) {
        /*
            使用方法引用优化Lambda表达式
            Math类是存在的
            abs计算绝对值的静态方法也是已经存在的
            所以我们可以直接通过类名引用静态方法
         */
        System.out.println(method(-1024, Math::abs));
    }
}
