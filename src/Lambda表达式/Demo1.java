package Lambda表达式;

public class Demo1 {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
            }
        });
        Thread t2 = new Thread(){
            public void run() {
                System.out.println("addfs");
            }
        };
        Thread t3 = new Thread(()->{
            System.out.println(false);

        });
        t1.run();
        t2.run();
        t3.run();
    }
}
