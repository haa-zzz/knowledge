package Java虚拟机;

public class SynchronizedTest {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
