package lesson4.homework;

public class Employee {

    private static int idCount = 0;

    private int id;
    private String name;
    private String position;
    private String phoneNumber;
    private float salary;
    private int age;

    public Employee(String name, String position, String phoneNumber, float salary, int age) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

        this.id = ++idCount;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
}
