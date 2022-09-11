package gb.lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "+79231231212", 50000, 30);
        employeeArray[1] = new Employee("Petrov Petr", "Manager", "petrpetrov@mailbox.com", "+79269413476", 60000, 40);
        employeeArray[2] = new Employee("Sidorov Sidr", "Cleaner", "sidrsidorov@mailbox.com", "+79113487591", 30000, 57);
        employeeArray[3] = new Employee("Pupkin Vasiliy", "Driver", "vasyavasya@mailbox.com", "+7999922444", 50000, 41);
        employeeArray[4] = new Employee("Morozov Moroz", "Director", "morozov@mailbox.com", "+79165247596", 120000, 63);

        for (Employee employeeArrays : employeeArray) {
            if (employeeArrays.getAge() > 40) {
                employeeArrays.info();
            }
        }
    }
}
