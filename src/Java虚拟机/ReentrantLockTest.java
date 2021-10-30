package Java虚拟机;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);  // true：公平锁
        lock.lock();
        try {
            // todo
        } finally {
            lock.unlock();
        }
    }
}
