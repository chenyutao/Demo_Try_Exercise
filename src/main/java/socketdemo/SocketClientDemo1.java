package socketdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author: chenyutao
 * @date: 2021/8/8 8:09 下午
 */
public class SocketClientDemo1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8081);
        try {
            System.out.println("Tcp客户端启动");
            OutputStream outputStream = socket.getOutputStream();
            String data = "客户端发送的数据";
            outputStream.write(data.getBytes());
            outputStream.flush();
            System.out.println("客户端发送数据完毕");
            socket.shutdownOutput();
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int len = inputStream.read(bytes);
            String result = new String(bytes,0,len);
            System.out.println("服务器反馈:"+result);
            socket.shutdownInput();
        } finally {
            socket.close();
        }
    }
}
