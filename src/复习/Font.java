package 复习;

public class Font {
    String name;
    int age;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class Font1 extends Font {
    boolean isTrue;

}

class Font2 extends Font {
    int number;
}
