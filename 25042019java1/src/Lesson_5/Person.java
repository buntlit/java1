package Lesson_5;

public class Person {
    private String fullName;
    private String position;
    private String email;
    private String tel;
    private int salary;
    public int age;

    public Person(String fullName, String position, String email, String tel, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }
public void info() {
        System.out.println(fullName + "  " + position + "  " + email + "  " + tel + "  " + salary + "  " + age);
    }
}
