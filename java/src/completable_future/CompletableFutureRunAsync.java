package completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureRunAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testRunAsync();
    }

    public static void testRunAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Thread 1: My heart");
            computeSomething();
            System.out.println("Thread 1: Done");
        });
        System.out.println("Thread main : Running");
        completableFuture.get();
    }

    public static String computeSomething() {
        try {
            System.out.println("Computing ... ");
            Thread.sleep(3000);
            System.out.println("Compute completed ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Future's Result";
    }
}
