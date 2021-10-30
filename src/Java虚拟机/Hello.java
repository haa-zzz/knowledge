package Java虚拟机;

public class Hello {
    class Inner{
        int c = 3;
    }
    public static void main(String[] args) {
        int i = 0;
        int a = i++;
        int b = ++i;

        System.out.println(a);
        System.out.println(b);
    }
}
