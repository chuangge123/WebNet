package URLDemo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        //拆解 url各个 部分输出可以看到 内容
        URL url = new URL("https://www.baidu.com/");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        //使用url 下载东西
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream file = new FileOutputStream("文件名");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            file.write(buffer,0,len);
        }
        file.close();
        inputStream.close();
        urlConnection.disconnect();


    }
}
