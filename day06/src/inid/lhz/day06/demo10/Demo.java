package inid.lhz.day06.demo10;

/*
    数组的构造器引用
 */
public class Demo {
    /*
        定义一个方法
        方法的参数传递创建数组的长度和ArrayBuiLder接口
        方法内部根据传递的长度使用ArrayBuiLder中的方法创建数组并返回
     */
    public static int[] creat(int length, ArrayBuilder ab) {
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        /*
            使用方法引用优化Lambda表达式
            已知创建的就是int[] 数组
            数组的长度也是已知的
            就可以使用方法引用
            int[] 引用new, 根据参数传递的长度来创建数组
         */
        int[] creat = creat(5, int[]::new);
        System.out.println(creat.length);
    }
}
