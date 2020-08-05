package UDP.Client;

import java.io.IOException;
import java.net.*;

//不需要连接服务器
public class UdpClientDemo01 {
    //1.建立一个Socket
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket();
        //2.创建包
        String msg="您好啊世界";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9000;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3.接收包
        socket.send(packet);

        //4.关闭流
        socket.close();

    }


}
