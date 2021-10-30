package 源码;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList源码 {
    /*
    ArrayList的数据结构是基于数组实现的，底层是动态数组，
    参考博客：%84%E5%8F%82%E6%95%B0%EF%https://www.cnblogs.com/ruoli-0/p/13714389.html#:~:text=ArraysSupport.newLength%E5%87%BD%E6%95%B0%E7%9A%84%E4%BD%9C%E7%94%A8%E6%98%AF%E5%88%9B%E5%BB%BA%E4%B8%80%E4%B8%AA%E5%A4%A7%E5%B0%8F%E4%B8%BAoldCapacity%20%2B%20max%EF%BC%88minimum%20growth%EF%BC%8C%20preferred,growth%EF%BC%89%E7%9A%84%E6%95%B0%E7%BB%84%E3%80%82%20minCapacity%E6%98%AF%E4%BC%A0%E5%85%A5%E7%9ABC%8C%E6%88%91%E4%BB%AC%E4%B8%8A%E9%9D%A2%E7%9C%8B%E8%BF%87%EF%BC%8C%E5%AE%83%E7%9A%84%E5%80%BC%E6%98%AF%E5%BD%93%E5%89%8D%E5%AE%B9%E9%87%8F%EF%BC%88%E8%80%81%E5%AE%B9%E9%87%8F%EF%BC%89%2B1%EF%BC%8C%E9%82%A3%E4%B9%88minCapacity%20-%20oldCapacity%E7%9A%84%E5%80%BC%E5%B0%B1%E6%81%92%E4%B8%BA1%EF%BC%8Cminimum%20growth%E7%9A%84%E5%80%BC%E4%B9%9F%E5%B0%B1%E6%81%92%E4%B8%BA1%E3%80%82
     - 　ArrayList是非线程安全的。
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3,3);
        list.size();
        int value = list.get(0);
        list.remove(1);
        // 获取迭代器
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
