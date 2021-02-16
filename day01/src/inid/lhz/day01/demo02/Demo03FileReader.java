package inid.lhz.day01.demo02;

import java.io.FileReader;
import java.io.IOException;

/*
    FileReader可以读取IDE默认编码格式(UTF-8) 的文件
    FileReader读取系统默认编码(中文GBK) 会产生乱码eee
 */
public class Demo03FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\bili\\GBK.txt");
        int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.println(len);
        }
        fr.close();
    }
}
