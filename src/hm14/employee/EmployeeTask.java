package hm14.employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.employeeGenerator(50);
        System.out.println(employeeList);
        // TODO 1: отсортировать список по имени
        Comparator<Employee> nameComparator = new NameComparator();
        employeeList.sort(nameComparator);

        // TODO 2: отсортировать список по имени и зп
        Comparator<Employee> salaryComparator = new SalaryComparator();
        employeeList.sort(nameComparator.thenComparing(salaryComparator));

        // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        Comparator<Employee> ageComparator = new AgeComparator();
        Comparator<Employee> companyComparator = new CompanyComparator();
        employeeList.sort(
                nameComparator
                        .thenComparing(salaryComparator)
                        .thenComparing(ageComparator)
                        .thenComparing(companyComparator)
        );

        // test for git
    }
}
