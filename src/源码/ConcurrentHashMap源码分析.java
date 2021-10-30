package 源码;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap源码分析 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> concurrent = new ConcurrentHashMap<>();

        concurrent.put(1,2);
        concurrent.get(1);
    }

}
