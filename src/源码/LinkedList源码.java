package 源码;

import java.util.LinkedList;

public class LinkedList源码 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addFirst(2);
        list.addLast(3);
        list.add(1, 3);
        list.get(0);
        list.getFirst();
        list.getLast();
        list.offer(0);
        list.peek();
        list.poll();
        list.remove(Integer.valueOf(2));
        list.remove();
    }

}
