package TcpFile.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo2 {
    public static void main(String[] args) throws IOException {
        Socket socket=null;
        OutputStream os=null;
        FileInputStream file=null;

        try {
            //1.创建一个socket连接
            socket=new Socket(InetAddress.getByName("127.0.0.1"),9000);
            //2.创建一个输出流
            os = socket.getOutputStream();
            //3.创建文件流
                 //读取文件
            file = new FileInputStream(new File("C:\\late\\WebNet\\src\\TcpFile\\Client\\1.jpg"));
                //写出文件(写出到socket 通道中。)
            byte[] buffer = new byte[1024];
            int len;
            while ((len=file.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //走到这需要关闭下socket的输出流,否则会传给下面的input
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //确定服务器接收完毕
            //首先 接收socket 发来的东西
            InputStream is=socket.getInputStream();
            //创建一个输出流
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            //开辟一段内存
            byte[] buffer2 = new byte[1024];
            int len2;
            //将socket收到的东西 读取到内存
            while ((len2=is.read(buffer2))!=-1){
                //通过输出流 输出内存东西。
                baos.write(buffer2,0,len2);
            }
            System.out.println(baos.toString());
            baos.close();
            is.close();
            file.close();
            os.close();
            socket.close();

        }
    }
}
