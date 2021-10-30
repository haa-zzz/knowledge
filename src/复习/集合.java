package 复习;

import java.util.*;

public class 集合 {
    public static void main(String[] args) {
        //知识点一：


        //方法一:类implements  Comparable接口，重写CompareTo方法
        Set<student> s = new TreeSet<>();
        s.add(new student("zhang", 23));
        s.add(new student("asi", 24));
        s.add(new student("ba", 30));
        System.out.println(s);
        //方法二
        Set<String> s1 = new TreeSet<>((o1, o2) -> o1.length() - o2.length());
        s1.add("qweerer");
        s1.add("1233");
        s1.add("wweerrtttyyyuu");
        System.out.println(s1);

        //知识点二：
        //用Collections.sort可对list集合进行自定义排序
        List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("aaa");
        list.add("bcv");
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(list, (o1,o2)->o1.compareTo(o2));

        //知识点三
        //Queue集合
        //PrioritrQueue是Queue的实现类，是一个优先级队列
        //ArrayDeque常用来当栈使用
        ArrayDeque<Integer> stack = new ArrayDeque();
        stack.push(1);
        stack.push(2);
        stack.push(3);					//入栈操作
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.pop()); 	//栈顶元素出栈
        System.out.println(stack);

    }


}
