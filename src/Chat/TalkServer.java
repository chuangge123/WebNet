package Chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkServer implements Runnable {
    DatagramSocket socket;
    private int port;
    private String msgFrom;

    public TalkServer(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                //准备接收
                byte[] container = new byte[1024];
                DatagramPacket packet= new DatagramPacket(container,0,container.length);
                socket.receive(packet);//阻塞式接收包裹

                //断开连接
                byte[] data=packet.getData();
                String recieveData= new String(data,0,data.length);
                System.out.println(msgFrom+":"+recieveData);
                if(recieveData.equals("bye")){
                    break;
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
