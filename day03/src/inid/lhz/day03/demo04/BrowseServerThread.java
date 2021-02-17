package inid.lhz.day03.demo04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    创建BS版本TCP服务器;持续侦听版本,请求一次创建一个新线程
 */
public class BrowseServerThread {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            //开启线程
            new Thread(() -> {
                try {
                    InputStream is = socket.getInputStream();

                    //把is网络字节输入流对象,转换为字符缓冲输入流
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    //把客户端请求信息的第一行读取出来GET /day03/web/index.html HTTP/1.1
                    String line = br.readLine();
                    System.out.println(line); //打印请求的路径
                    //把读取的信息进行切割,只要中间部分/day03/web/index.html
                    String[] arr = line.split(" ");
                    //把路径前边的/去掉,进行截取/day03/web/index.html
                    String html = arr[1].substring(1);

                    //创建一个本地字节输入流, 构造方法中绑定要读取的html路径
                    FileInputStream fis = new FileInputStream(html);
                    //使用Socket中的方法getOutputStream获取网络字节输出流OutputStream对象
                    OutputStream os = socket.getOutputStream();
                    //写入HTTP协议响应头, 固定写法
                    os.write("HTTP/1.1 200 OK\r\n".getBytes());
                    os.write("Content-Type:text/html\r\n".getBytes());
                    //必须要写入空行,否则浏览器不解析
                    os.write("\r\n".getBytes());

                    //一读一写复制文件, 把服务读取的html文件回写到客户端
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while ((len = fis.read(bytes)) != -1) {
                        os.write(bytes, 0, len);
                    }

                    //释放资源
                    fis.close();
                    socket.close();
//                    System.out.println(Thread.currentThread().getName()); 打印当前线程名称
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //服务器不用关闭
//        server.close();
    }
}
