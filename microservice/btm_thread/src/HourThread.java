
public class HourThread implements Runnable {

    public static Integer hour = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (MinuteThread.increase) {
                if (MinuteThread.increase) {
                    hour++;
                    System.out.println("Giờ hiện tại: " + hour);
                    MinuteThread.increase = false;
                }
            }
        }
    }
}
