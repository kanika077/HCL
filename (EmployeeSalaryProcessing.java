
import java.util.Scanner;

abstract class Employee {
    private int employeeId;
    private String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class ContractEmployee extends Employee {
    int workingDays;
    double dailyRate;

    public ContractEmployee(int id, String name,
                            int workingDays, double dailyRate) {
        super(id, name);
        this.workingDays = workingDays;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateSalary() {
        return workingDays * dailyRate;
    }
}

public class EmployeeSalaryProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int type = sc.nextInt();
        int id = sc.nextInt();
        String name = sc.next();

        Employee emp;

        if (type == 1) {
            double salary = sc.nextDouble();
            emp = new FullTimeEmployee(id, name, salary);
        } else {
            int days = sc.nextInt();
            double rate = sc.nextDouble();
            emp = new ContractEmployee(id, name, days, rate);
        }

        System.out.println("Employee ID: " + emp.getEmployeeId());
        System.out.println("Employee Name: " + emp.getEmployeeName());
        System.out.printf("Salary: %.2f%n", emp.calculateSalary());

        sc.close();
    }
}
