
/**
 * 死锁模型
 * 当程序开始执行时，创建两个线程，分别执行不同的 synchronized 方法块；并且都在Thread.sleep(1000);处停下来，
 * 此时线程1持有DeanLock.class在等待Object.class的持有权，线程2持有Object.class在等待DeanLock.class的持有权，
 * 双方都相互等待，就形成了死锁的僵局。
 */
public class DeanLock {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (DeanLock.class) {
                    System.out.println("thread is block obj1");
                    Thread.sleep(1000);
                    synchronized (Object.class) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (Object.class) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (DeanLock.class) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
