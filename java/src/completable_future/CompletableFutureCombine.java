package completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 5;
        int b = 10;
        System.out.println("Start");
        CompletableFuture<Integer> sumThread = CompletableFuture.supplyAsync(() -> {
            System.out.println("Sum");
            return sum(a,b);
        });

        CompletableFuture<Integer> mulThread = CompletableFuture.supplyAsync(() -> {
            System.out.println("Mul");
            return mul(a,b);
        });

        CompletableFuture<Integer> combine = sumThread.thenCombine(mulThread , (sum, mul) -> {
            return mul - sum;
        });

        System.out.println("Running");
        System.out.println(combine.get());
        System.out.println("End");
    }

    private static Integer sum(int a, int b) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    private static Integer mul(int a, int b) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a * b;
    }
}
