package Java虚拟机;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    private static final Callable<String> callable = new MyCallable();
    private static final FutureTask<String> futureList = new FutureTask<>(callable);
    public static void main(String[] args) {
        Thread thread = new Thread(futureList,"有返回值的线程");
        thread.start();
        try {
            try {
                System.out.println(futureList.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}
