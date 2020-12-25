package lesson4.homework;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Программист", "+7(999)-123-23-23", 100000, 35);
        employees[1] = new Employee("Сидорова Екатерина Ивановна", "Бухгалтер", "+7(999)-123-23-24", 95000, 45);
        employees[2] = new Employee("Петрова Мария Евгеньевна", "Программист", "+7(999)-123-23-25", 70000, 22);
        employees[3] = new Employee("Федоров Федор Федорович", "Инженер", "+7(999)-123-23-26", 65000, 42);
        employees[4] = new Employee("Кузнецов Иван Иванович", "Ассистент", "+7(999)-123-23-27", 30000, 19);

        System.out.println(employees[2].getShortInfo());
        System.out.println(employees[4].getShortInfo());

        System.out.println("Сотрудники старше 40 лет:");
        for (Employee employee: employees) {
            if (employee.getAge() >= 40) {
                System.out.println(employee.getFullInfo());
            }
        }

        salaryIncrease(employees, 10000);
        System.out.println(employees[1].getFullInfo());

        System.out.println(employees[3].getShortInfo() + ", id: " + employees[3].getId());
        System.out.println(employees[0].getShortInfo() + ", id: " + employees[0].getId());

        Employee newEmployee = new Employee("Колыванов Иван Иванович", "Руководитель", "+7(999)-123-23-29", 150000, 39);
        System.out.println(newEmployee.getId());
    }

    public static void salaryIncrease(Employee[] employees, int increaseRate) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 35) {
                employees[i].setSalary(increaseRate);
            }
        }
    }
}
