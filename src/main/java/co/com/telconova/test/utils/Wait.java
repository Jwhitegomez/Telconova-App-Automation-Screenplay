package co.com.telconova.test.utils;

public class Wait {
    public static void For(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while sleeping",e);
        }
    }
}