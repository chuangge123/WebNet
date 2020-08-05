package ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestNetAddress {
    public static void main(String[] args) {
        //由于InetAddress 没有构造器，所以我们只能通过静态方法将其返回。
        //查询网站地址
        try {
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);

            System.out.println(inetAddress1.getAddress());
            System.out.println(inetAddress1.getCanonicalHostName());
            //常用方法
            System.out.println(inetAddress1.getHostAddress());//查看ip
            System.out.println(inetAddress1.getHostName());//查看域名或电脑名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //查询本机地址
        try {
            InetAddress inetAddress2 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
