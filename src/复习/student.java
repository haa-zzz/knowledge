package 复习;

public class student implements Comparable<student> {
    private String name;
    private int number;

    public student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(student o) {
        return o.getName().compareTo(this.getName());
    }
}
