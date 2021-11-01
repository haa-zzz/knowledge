
import java.util.LinkedList;

/**
 * 生产者消费者模型
 */
public class ProducerAndConsumer {
    //通过synchronized实现
    public void fun() {
        LinkedList<Integer> list = new LinkedList<>();      //产品缓存区
        int MAX_PRODUCE = 5;        //缓存区大小
        new Thread(() -> {    //生产者线程
            while (true) {
                synchronized (list) {
                    while (list.size() > MAX_PRODUCE) {     //缓存区满的话，释放锁资源，等待消费者消费后被唤醒
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.addLast(1);        //生产一个产品
                    System.out.println("生产者生产了一个产品，目前剩余" + list.size());
                    list.notify();             //唤醒消费者线程，可以来消费了
                }
            }
        }).start();
        new Thread(() -> {        //消费者线程
            while (true) {
                synchronized (list) {        //消费者 申请产品缓存区 资源
                    while (list.isEmpty()) {       //如果现在还没有产品，释放锁，进入线程等待池中等代被唤醒
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.pollLast();
                    System.out.println("消费者消费了一个产品，目前剩余" + list.size());
                    list.notify();      //唤醒消费者线程
                }
            }
        }).start();
    }
}
