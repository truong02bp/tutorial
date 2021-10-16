package completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testSupplyAsync();
    }
    public static void testSupplyAsync() throws ExecutionException, InterruptedException {
        String hello = "Hello";
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return computeSomething(hello);
        });
        System.out.println("Thread main : Running");
        System.out.println(completableFuture.get());
    }

    public static String computeSomething(String hello) {
        try {
            System.out.println("Computing ... ");
            Thread.sleep(3000);
            System.out.println("Compute completed ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hello + " Future's Result";
    }
}
