public class MinuteThread implements Runnable {

    public static Integer minute = 58;
    public static Boolean increase = false;

    @Override
    public void run() {
        while (true) {
            synchronized (SecondThread.increase) {
                if (SecondThread.increase) {
                    minute++;
                    if (minute == 60) {
                        minute = 0;
                        increase = true;
                    }
                    System.out.println("Phút hiện tại: " + minute);
                    SecondThread.increase = false;
                }
            }
        }
    }
}
