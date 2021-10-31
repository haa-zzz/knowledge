package 复习;

public enum 枚举类 {
    //方法一
    //SMALL,MEDIUM,LARGE,EXTRA_LARGE;
    //方法二
    /*
    SMALL("S"), MEDIUM("M");
    private String abb;
    private 枚举类(String s) {             //枚举的构造器总是私有的，可以省略private
        this.abb = s;
    }
    public String getAbb(){
        return this.abb;
    }

     */
    //方法三：
    SMALL("S") {
        public void show() {

        }
    }, MEDIUM("M") {
        public void show() {

        }
    };
    private String abb;

    private 枚举类(String s) {             //枚举的构造器总是私有的，可以省略private
        this.abb = s;
    }

    public String getAbb() {
        return this.abb;
    }

    public abstract void show();
}
