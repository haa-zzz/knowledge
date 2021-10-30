package 复习;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
/*
    利用LocalDate显示当前月的日历(2020/7/13)
        Mon Tue Wed Thu Fri Sat Sun
                  1   2   3   4   5
          6   7   8   9  10  11  12
         13* 14  15  16  17  18  19
         20  21  22  23  24  25  26
         27  28  29  30  31
 */
public class 类与对象 {

    public static void main(String[] args){
        LocalDate date = LocalDate.now();       //从默认时区的系统时钟获取当前日期
        int month = date.getMonthValue();        //获取当前月份
        int today = date.getDayOfMonth();        //获取当前日期

        date = date.minusDays(today-1);           //减去指定天数，产生一个新的LocalDate副本（这里获取第一天）
        DayOfWeek weekday = date.getDayOfWeek();    //获取星期
        int value = weekday.getValue();             //将获取到的星期几转换成int数
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i = 1; i < value; i++){
            System.out.print("    ");
        }
        while(date.getMonthValue()==month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else
                System.out.print(" ");
            date = date.plusDays(1);               //加上指定天数，产生一个新的LocalDate副本
            if(date.getDayOfWeek().getValue()==1){
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue()!=1){
            System.out.println();
        }


    }

}
