package lt.saltyjuice.dragas.uniqued;

public class Student implements Comparable<Student> {

    public Float getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    private final Float score;
    private final String name;

    public Student(String name, Float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return getScore().compareTo(o.getScore());
    }


}
