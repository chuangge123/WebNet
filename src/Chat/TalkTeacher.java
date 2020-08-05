package Chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(6564,"localhost",8888)).start();
        new Thread(new TalkServer(9999,"学生"));

    }
}
