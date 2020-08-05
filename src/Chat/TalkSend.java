package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {
   DatagramSocket socket;
   BufferedReader reader;
   private int fromport;
   private String toip;
   private int toport;

    public TalkSend(int fromport, String toip, int toport) {
        this.fromport = fromport;
        this.toip = toip;
        this.toport = toport;
        try{
            socket=new DatagramSocket(fromport);
            reader=new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
                e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            while (true){
                String data = reader.readLine();
                byte[] datas =data.getBytes();
                DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toip,this.toport));
                socket.send(packet);
                if(data.equals("bye")){
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
