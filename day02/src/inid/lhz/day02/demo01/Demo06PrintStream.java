package inid.lhz.day02.demo01;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
    可以改变输出语句的目的地(打印流的流向)
    输出语句,默认在控制台输出
    使用System.setOut方法改变输出语句的目的地改为参数中传递的打印流的目的地
        static void setOut(PrintStream out)
        重新分配“标准"输出流。
 */
public class Demo06PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我在控制台输出");

        PrintStream ps = new PrintStream("D:\\bili\\目的地.txt");
        System.setOut(ps);
        System.out.println("我在目的地输出");
        ps.close();
    }
}
