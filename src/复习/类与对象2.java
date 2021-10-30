package 复习;

public class 类与对象2 {
    public static void main(String[] args){
        //静态初始化块最先执行只执行一次
        //ABab2ab2
        A ab = new B();
        ab.say();
        ab = new B();
        ab.say();
    }

}
class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
    void say() {
        System.out.print("1");
    }
}
class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
    void say() {
        System.out.print("2");
    }
}