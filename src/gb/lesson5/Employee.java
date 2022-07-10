package gb.lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Full name: " + fullName + "\nPosition: " + position + "\nE-mail: " + email + "\nTelephone number: " + telephoneNumber + "\nSalary: " + salary + "\nAge: " + age + "\n");
    }

    public int getAge() {
        return age;
    }
}
