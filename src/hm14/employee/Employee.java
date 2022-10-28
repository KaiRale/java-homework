package hm14.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: добавить конструктор, необходимы геттеры и сеттеры

    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 1) throw new IllegalArgumentException("The name must contains at least 1 letter.");
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company.length() < 1) throw new IllegalArgumentException("The company must contains at least 1 letter.");
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 10000)
            throw new IllegalArgumentException("You paupers, give me a normal amount of money." + salary);
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 14) throw new IllegalArgumentException("Go to school.");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}' + "\n";
    }

    // TODO: дописать реализацию метода для создания списка из объектов класса Employee.
    //  Объекты Employee создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп.
    //  num - количество объектов в списке
    public static List<Employee> employeeGenerator(int num) {
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        if (num <= 0) {
            return Collections.emptyList();
        }

        ArrayList<Employee> employees = new ArrayList<>();
        Random random = new Random();
        int minAge = 21, maxAge = 60, minSalary = 10000, maxSalary = 50000;

        // создание объектов, наполнение списка
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(
                    names[random.nextInt(names.length)],
                    companies[random.nextInt(companies.length)],
                    minSalary + random.nextInt(maxSalary - minSalary + 1),
                    minAge + random.nextInt(maxAge - minAge + 1)
            ));
        }

        return employees;
    }
}