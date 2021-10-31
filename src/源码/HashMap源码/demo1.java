package 源码.HashMap源码;

import java.util.HashMap;

public class demo1 {
    /*
    hashMap简单使用
    1.简介
        HashMap是基于哈希表的Map接口实现，是以key-value储形式存在，即主要用来存放键值对。HashMap的实现是不同步的，这意味着它不是线程安全的。
          允许使用null作为key、value。此外，HashMap中的映射不是有序的。
        在JDK1.8之前的HashMap由数组+链表 组成， 数组时HashMap的主体，链表主要是为解决哈希冲突(两个对象调用HashCode()方法计算的哈希码
        值一样导致数组索引相同)而存在的，在JDK1.8以后在解决冲突时有了较大的变化，当链表长度大于阈值(红黑树的边界值，默认为8)并且当前数组长度大于
        64时，此时此索引位置上的所有数据改为使用红黑树存储

     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(1, 200);
        map.put(3, 300);
        map.get(1);
        //map.remove();
        int h;
        Object key = 0.1;
        h = key.hashCode();
        System.out.println(map);

    }

    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
