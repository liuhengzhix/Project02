package inid.lhz.day03.demo03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
    文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”

    明确：
        数据源：客户端上传的文件
        目的地：服务器的硬盘d:\\
 */
public class FileUploadServerPro {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        /*
            让服务器一直处于监听状态(死循环accept方法)
            有一个客户端上传文件，就保存一个文件
         */

        while (true) {
            Socket socket = server.accept(); //侦听
            /*
                使用多线程技术，提高程序的效率
                有一个客户端上传文件，就开启一个线程，完成文件的上传
             */
            new Thread(() -> { //lambda表达式替代匿名内部类
                try {
                    InputStream is = socket.getInputStream();
                    byte[] bytes = new byte[1024 * 2];
                    int len;
                    File file = new File("D:\\upload");
                    //先判断文件夹存不存在
                    if (!file.exists()) {
                        boolean b = file.mkdirs();
                        System.out.println(b);
                    }
                    /*
                        自定义一个文件的命名规则：防止同名的文件被覆盖
                        规则：域名+毫秒值+随机数
                     */
                    String fileName = "inid_" + System.currentTimeMillis() + new Random().nextInt() + ".png";

                    FileOutputStream fos = new FileOutputStream(file + "\\" + fileName); //注意加上\\
                    while ((len = is.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }

                    //回传给客户端
                    OutputStream os = socket.getOutputStream();
                    os.write("上传成功".getBytes());

                    //释放资源
                    fos.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


            //服务器不用关闭
//        server.close();
        }
    }
}
