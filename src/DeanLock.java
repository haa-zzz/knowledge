
public class DeanLock {
    /*
    当程序开始执行时，创建两个线程，分别执行不同的synchronized 方法块；并且都在Thread.sleep(1000);处停下来，
    此时当线程1先sleep结束后；准备用Main.class开 synchronized 这把锁进入 synchronized (Main.class) 方法块，但是发现线程2还没有苏醒，
    所以 线程1就等着线程2执行完毕，释放出 Main.class 钥匙，这时候 线程2苏醒了，准备拿String.class 这把钥匙，
    去开synchronized 这把锁，进入synchronized (String.class) 方法块；但是发现线程1 也在等着 线程2释放 Main.class钥匙，所以就导致
    线程1等着线程2 释放 Main.class钥匙， 线程2等着线程1 释放 String.class 这把钥匙，所以这个程序就僵持住了，成了一个死锁的程序；
     */
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
