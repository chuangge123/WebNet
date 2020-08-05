package Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true){
            //接收数据包
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            socket.receive(packet);
            //断开连接
            byte[] data=packet.getData();
            String datas=new String(data,0,data.length);
            System.out.println(datas);
            if(datas.equals("bye")){
                break;
            }
        }
    }
}
