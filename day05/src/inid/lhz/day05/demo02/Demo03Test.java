package inid.lhz.day05.demo02;

import java.util.function.Function;

/*
    练习:自定义函数模型拼接
    题目
    请使用Function进行函数模型的拼接, 按照顺序需要执行的多个函数操作为;
        String str = "赵丽颖,20";

    分析:
    1.将字符串截取数字年龄部分, 得到字符串;
        Function<String, String>"赵丽颖,20" -> "20"
    2.将上一步的字符串转换成为int类型的数字;
        Function<String, Integer>"20" -> 20
    3.将上一步的int数字累加100, 得到结果int数字;
        Function<Integer, Integer>20 -> 120

 */
public class Demo03Test {
    public static int change(String str, Function<String, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.andThen(fun2).apply(str);
    }

    public static void main(String[] args) {
        String str2 = "赵丽颖,20";
        int change = change(str2, st -> {
            String[] split = str2.split(",");
            return Integer.parseInt(split[1]);
        }, sr -> sr + 100); //sr是上一个fun1的返回值
        System.out.println(change);
    }
}
