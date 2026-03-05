import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    void display() {
        System.out.println(id + " | " + name + " | " + salary + " | " + department);
    }
}

public class EmployeeFilter {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        // Adding 10 Employees
        employees.add(new Employee(1, "Arun", 25000, "HR"));
        employees.add(new Employee(2, "Bala", 40000, "IT"));
        employees.add(new Employee(3, "Charan", 35000, "Finance"));
        employees.add(new Employee(4, "David", 28000, "IT"));
        employees.add(new Employee(5, "Ezhil", 50000, "HR"));
        employees.add(new Employee(6, "Farooq", 32000, "Finance"));
        employees.add(new Employee(7, "Ganesh", 45000, "IT"));
        employees.add(new Employee(8, "Hari", 27000, "HR"));
        employees.add(new Employee(9, "Imran", 38000, "Finance"));
        employees.add(new Employee(10, "Jeeva", 60000, "IT"));

        // Print employees with salary > 30000
        System.out.println("----- Employees with Salary > 30000 -----");
        for (Employee emp : employees) {
            if (emp.salary > 30000) {
                emp.display();
            }
        }

        // Group by Department
        System.out.println("\n----- Employees Grouped by Department -----");

        String[] departments = {"HR", "IT", "Finance"};

        for (String dept : departments) {
            System.out.println("\nDepartment: " + dept);
            for (Employee emp : employees) {
                if (emp.department.equals(dept)) {
                    emp.display();
                }
            }
        }

        // Sort employees by name
        System.out.println("\n----- Employees Sorted by Name -----");

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }
        });

        for (Employee emp : employees) {
            emp.display();
        }
    }
}