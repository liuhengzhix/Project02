package inid.lhz.day03.demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”

    明确：
        数据源：客户端上传的文件
        目的地：服务器的硬盘d:\\
 */
public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept(); //侦听
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024 * 2];
        int len;
        File file = new File("D:\\upload");
        //先判断文件夹存不存在
        if (!file.exists()){
            boolean b = file.mkdirs();
            System.out.println(b);
        }
        FileOutputStream fos = new FileOutputStream(file+"\\取外卖.png"); //注意加上\\
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        //回传给客户端
        OutputStream os = socket.getOutputStream();
        os.write("上传成功".getBytes());

        //释放资源
        server.close();
        fos.close();
        socket.close();
    }
}
