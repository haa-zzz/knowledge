package 复习;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Test {


    private static Font1 Font1;

    public static void main(String[] args) {

        HashSet<Font> styles = new HashSet<>();
        Font1 font1 = new Font1();
        font1.age = 1;
        Font2 font2 = new Font2();
        font2.age = 2;
        Font font = new Font();
        font.age = 3;
        styles.add(font1);
        styles.add(font2);
        styles.add(font);
        styles.removeIf( e -> e instanceof Font1);
        
    }
}