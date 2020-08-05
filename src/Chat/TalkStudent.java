package Chat;

public class TalkStudent {
    //开启两个线程
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkServer(8888,"teacher")).start();
    }
}
