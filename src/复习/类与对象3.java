package 复习;
/*
public class Outer{
    private String name = "小明"；
    public class Inner{
        private String name = "小红"；
        //1.写出打印出小红名字的语句
        //2.写出打印出小明名字的语句
    }
    public static void main(String[] args){
    //3.实例化Inter
    }
}
 */
public class 类与对象3 {

    private String name = "小明";
    public class Inner{
        private String name = "小红";
        //1.写出打印出小红名字的语句
        public void print(){
            System.out.println(name);
            System.out.println(new 类与对象3().name) ;
        }
        //2.写出打印出小明名字的语句
    }
    public static void main(String[] args){
        //3.实例化Inter
        类与对象3.Inner inner  = new 类与对象3().new Inner();
        inner.print();
    }
}
