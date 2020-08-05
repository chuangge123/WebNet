package TCP.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSeverDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        Socket accept =null;
        InputStream is=null;
        ByteArrayOutputStream byteArrayOutputStream=null;

        try {
            //我自己要有个地址(即运行机器的9999端口监听)
            serverSocket = new ServerSocket(9999);
            //监听等待连接
            //这个Socket 即为socket客户端对象。
            accept = serverSocket.accept();
            //读取客户端消息
            is = accept.getInputStream();


/*           1.直接读取 该方法，无法传送中文。
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                String msg = new String(buffer, 0, len);
                System.out.println(msg);
            }*/


            //2.管道流方案
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //最后要关闭流
        finally {
            //一节一节从小到大关闭
            if(byteArrayOutputStream!=null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
