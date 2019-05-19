package Lesson_5;

public class MainClass {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван", "инженер", "ivivan@mailbox.com", "89231231265", 30000, 30);
        persArray[1] = new Person("Петров Петр", "сварщик", "petrpetrov@mailbox.com", "89543231564", 25000, 50);
        persArray[2] = new Person("Сидоров Сергей", "директор", "sidsergey@mailbox.com", "89241563541", 50000, 45);
        persArray[3] = new Person("Смирнова Юлия", "бухгалтер", "smirnovayu@mailbox.com", "89941145151", 30000, 25);
        persArray[4] = new Person("Зайцева Ирина", "главный бухгалтер", "irinazayceva@mailbox.com", "89541132562", 40, 39);

        for (Person c : persArray) {
            if (c.age >= 40) c.info();
        }
    }
}
