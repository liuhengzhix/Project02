package inid.lhz.day04.demo02;

/*
    lambda优化日志
    使用Lambda优化日志案例
    Lambda的特点:延迟加载 (满足条件的才执行,不满足条件的不会执行)
    Lambda的使用前提,必须存在函数式接口
 */
public class Demo02Lambda {
    //定义打印日志的方法
    public static void showLog(int level, MessageBuilder mb) {
        //如果是1级则调用MessageBuilder接口中的方法
        if (level == 1) {
            System.out.println(mb.builderMessage()); //打印方法的返回值
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        showLog(1,() -> {
            //返回拼接好的字符串
            return msg1+msg2+msg3;
        });

        /*
            使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中
            只有满足条件,日志的等级是1级
                才会调用接口MessageBuilder中的方法builderMessage
                才会进行字符串的拼接
            如果条件不满足,日志的等级不是1级
                那么MessageBuilder接口中的方法builderMessage也不会执行
                所以拼接字符串的代码也不会执行
            所以不会存在性能的浪费
         */
    }
}
