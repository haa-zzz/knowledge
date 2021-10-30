package Java虚拟机;

public class VolatileTest {
    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {

        final VolatileTest volatileTest = new VolatileTest();
        for(int i=0;i<3;i++){

            new Thread(() -> {
                for(int j=0;j<30;j++)
                    volatileTest.increase();
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(volatileTest.inc);
    }
}