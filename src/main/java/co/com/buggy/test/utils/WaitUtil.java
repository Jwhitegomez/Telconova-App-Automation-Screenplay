package co.com.buggy.test.utils;

public class WaitUtil {
    public static void WaitFor(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while sleeping",e);
        }
    }
}