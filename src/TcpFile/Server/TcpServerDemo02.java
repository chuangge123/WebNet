package TcpFile.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        //1.创建一个socket 服务端
        ServerSocket serverSocket=new ServerSocket(9000);
        //2.创建端口监听
        Socket socket = serverSocket.accept();
        //3.获取socket通道中的输入流
        InputStream is=socket.getInputStream();
        //4.文件输出
        FileOutputStream file=new FileOutputStream(new File("C:\\late\\WebNet\\src\\TcpFile\\Server\\receive.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
             file.write(buffer,0,len);
        }
        //返回服务器接收状态，通知客户端。
        OutputStream os = socket.getOutputStream();
        os.write("我接收完毕".getBytes());

        file.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
