package 复习;

import java.io.File;
import java.io.IOException;

public class 文件 {
    public static void main(String[] args) throws IOException {
        File file = new File("aaa.txt");
        file.createNewFile();
    }

}
