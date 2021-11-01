
public class SecondThread implements Runnable {

    private static Integer second = 56;
    public static Boolean increase = false;
    @Override
    public void run() {
        while (true) {
            second++;
            if (second == 60) {
                second = 0;
                increase = true;
            }
            System.out.println("Giây hiện tại: " + second);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
