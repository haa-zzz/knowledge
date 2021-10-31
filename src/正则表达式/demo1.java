package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
一：正则表达式的简介
正则表达式是一个强大的字符串处理工具，可对字符串进行查找，提取，分割，替换等操作
用途：
（1）验证邮箱
（2）识别手机号银行卡号
（3）互联网网络爬虫
……
匹配


 */
public class demo1 {
    public static void main(String[] args) {
        String str = "ashduyhu12300008888" + "qyweuyc12166668888" + "efiunv17722334455";
        Pattern p = Pattern.compile("((12\\d)|(17\\d))\\d{8}"); //吧正则表达式编译为Pattern对象

        Matcher m = p.matcher(str);
        while (m.find()) {            //如果正则表达式中包含与目标字符串匹配的子串，返回true
            System.out.println(m.group());      //返回上一次与Pattern匹配的子串
        }
        String str2 = "To be or not to be,this is a question";
        Matcher m1 = Pattern.compile("\\w+").matcher(str2);
        while (m1.find()) {
            System.out.println(m1.group() + "起始位置" + m1.start() + "结束位置" + m1.end());
        }
        Matcher m2 = Pattern.compile("(t|b)\\w*").matcher(str2);
        while (m2.find()) {
            System.out.println(m2.replaceAll("girl"));          //用所给字符串替换原字符串

        }


    }
}
