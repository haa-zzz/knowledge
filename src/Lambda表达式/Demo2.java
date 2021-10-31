package Lambda表达式;

interface Converter {
    Integer convert(String from);
}

interface MyTest {
    String test(String a, int b, int c);
}

interface YourTest {
    Demo2 win();
}

public class Demo2 {
    public static void main(String[] args) {
        //吧from转换为int
        Converter c1 = from -> Integer.valueOf(from);
        Converter c11 = Integer::valueOf;
        //返回第一个子串的开始位置
        Converter c2 = from -> "abcdef".indexOf(from);
        Converter c22 = "abcdef"::indexOf;
        //截取字符串a
        MyTest m1 = (a, b, c) -> a.substring(b, c);
        MyTest m2 = String::substring;

        YourTest y1 = () -> new Demo2();
        YourTest y2 = Demo2::new;
    }
}
