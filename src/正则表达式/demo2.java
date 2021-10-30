package 正则表达式;

public class demo2 {
    public static void main(String[] args){
        String str = "To be or not to be,this is a question";
        String s = "b\\w*";
        boolean b1 = str.matches(s);     //判断该字符串是否匹配指定的正则表达式
        String str1 = str.replaceAll(s,"haha");       //将匹配的子串替换掉
        String s1 = " ";
        String[] arr  = str.split(s1);      //以s1为分隔符做分割
        System.out.println(arr[1]);

    }
}
