package inid.lhz.day04.demo04;

import java.util.function.Supplier;

/*
    练习:求数组元素最大值
    使用Supplier接口作为方法参数类型,通过Lambda表达式求出int数组中的最大值。
    提示:接口的泛型请使用java.Lang.Integer类。
 */
public class Demo02Test {
    //定义一个方法,用于获取int类型数组中元素的最大值,方法的参数传递Supplier接口,泛型使用Integer
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {1, -5, 6, 8, 64, 3, 6, 5};
        int maxValue = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("数组中的最大值是:"+maxValue);
    }
}
