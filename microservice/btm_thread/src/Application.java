public class Application {

    public static void main(String[] args) {
        Thread secondThread = new Thread(new SecondThread());
        Thread minuteThread = new Thread(new MinuteThread());
        Thread hourThread = new Thread(new HourThread());
        secondThread.start();
        minuteThread.start();
        hourThread.start();
    }
}
