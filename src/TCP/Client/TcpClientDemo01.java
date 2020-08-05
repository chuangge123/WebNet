package TCP.Client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo01 {
    public static void main(String[] args) {
        //客户端编写逻辑
        Socket socket=null;
        OutputStream os=null;
        try {
            //1.首先要知道服务器地址
            InetAddress SeverIp = InetAddress.getByName("127.0.0.1");
            //2.知道端口号
            int port=9999;
            //3.建立一个socket连接
            socket = new Socket(SeverIp,port);
            //4.发送消息-IO流
            os = socket.getOutputStream();
            os.write("您好，来老虎由".getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
