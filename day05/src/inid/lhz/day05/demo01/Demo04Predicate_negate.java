package inid.lhz.day05.demo01;

import java.util.function.Predicate;

/*
    需求:判断一个字符串长度是否大于5
        如果字符串的长度大于5, 那返回false
        如果字符串的长度不大于5, 那么返回true
    所以我们可以使用取反符号!对判断的结果进行取反

    Predicate接口中有一个方法negate, 也表示取反的意思
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }
 */
public class Demo04Predicate_negate {
    public static boolean checkString(String s, Predicate<String> pre) {
//        return !pre.test(s);
        //升级⬆
        return pre.negate().test(s);
    }

    public static void main(String[] args) {
        String str = "negate";

        //lambda表达式
        boolean b = checkString(str, s -> str.length() < 5);
        System.out.println(b);
    }
}
