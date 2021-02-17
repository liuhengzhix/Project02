package inid.lhz.day03.demo02;

import java.io.*;
import java.net.Socket;

/*
    文件上传案例的客户端:读取本地文件,上传到服务器,读取服务器回写的数据

    明确:
        数据源:"D:\bili\素材\取外卖.png"
        目的地:服务器
 */
public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888); //绑定服务器ip地址和端口号
        OutputStream os = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\bili\\素材\\取外卖.png"));//绑定本地文件地址
        byte[] bytes = new byte[1024 * 2];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            //将读的文件字节流写到socket当中上传到服务器
            os.write(bytes, 0, len);
        }
        /*
            解决:上传完文件,给服务器写一个结束标记
            void shutdownOutput() 禁用此套接字的输出流。
            对于TCP套接字,任何以前写入的数据都将被发送,并且后跟TCP的正常连接终止序列。
         */
        socket.shutdownOutput();

        //接收服务器回传
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        //释放资源
        bis.close();
        socket.close();
    }
}
