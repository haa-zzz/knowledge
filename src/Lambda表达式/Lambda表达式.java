package Lambda表达式;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

interface La{
    void run();
   // void fun(int a);
}

//作用一：代替匿名内部类创建对象
public class Lambda表达式 {
    public static void f(La l){
        l.run();
    }
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(10,new Comparator<Integer>() {
        @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(01);
            }
        });
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(10,(o1,o2)->
             o2.compareTo(o1)
        );//和上面的作用相同
        pq2.offer(1);
        pq2.offer(3);
        pq2.offer(2);
        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }
        f(new La(){                             //如下两端代码作用相同
            public void run() {
                System.out.println(123);
            }
        });
       // f(()->System.out.println(this.getClass().getName()));


    }
    public void fun(){
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(
                str -> {
                    System.out.println(this.getClass().getName());
                    return str.toLowerCase();
                }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
    }


}
