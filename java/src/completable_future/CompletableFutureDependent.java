package completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDependent {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Running");
        CompletableFuture<Integer> credit = ApiUtils.getUser().thenCompose(ApiUtils::getCreditByUser);
        System.out.println("Wait");
        System.out.println(credit.get());
        System.out.println("Done");
    }

}

class User {
    int id;

    public User(int id) {
        this.id = id;
    }
}

class UserService {
    public static User getUser(int id) {
        return new User(id);
    }
}

class CreditService {
    public static Integer getByUser(User user) {
        return user.id + 5;
    }
}

class ApiUtils {
    public static CompletableFuture<User> getUser() {
        return CompletableFuture.supplyAsync(() -> {
            return UserService.getUser(5);
        });
    }
    public static CompletableFuture<Integer> getCreditByUser(User user) {
        return CompletableFuture.supplyAsync(() -> {
           return CreditService.getByUser(user);
        });
    }
}