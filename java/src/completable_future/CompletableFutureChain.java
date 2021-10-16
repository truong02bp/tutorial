package completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureChain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 5;
        int b = 10;
        CompletableFuture<Void> sum = CompletableFuture.supplyAsync(() -> {
            return sum(a, b);
        }).thenApply(result -> {
            System.out.println("Sum " + result);
            return mul(result, 10);
        }).thenRun(() -> {
            System.out.println("Done ");
        });

        CompletableFuture<Void> mul = CompletableFuture.supplyAsync(() -> {
            return mul(a, b);
        }).thenAccept(result -> {
            System.out.println("Mul: " + result);
        });

        sum.get();
        System.out.println("Exist");
    }

    private static Integer sum(int a, int b) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    private static Integer mul(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a * b;
    }

}
