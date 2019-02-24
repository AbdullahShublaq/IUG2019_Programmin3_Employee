/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondyear2_.employee_programming3;

/**
 *
 * @author Abdullah Shublaq
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    /**
     * @param args the command line arguments
     */
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here

        Employee employees[] = new Employee[1];

        //        showInCommandLine(employees);
        //        sortBySalary(employees);
        //        showInCommandLine(employees);
        //        sortByName(employees);
        //        showInCommandLine(employees);
        //        readByScanner(employees);
        //        showInCommandLine(employees);
        readByJOptionPane(employees);
        showInJOptionPane(employees);
        addBonusToAll(employees, 15);
        showInCommandLine(employees);
    }

    private static void sortBySalary(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if (employees[j].getSalary() > employees[i].getSalary()) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    private static void sortByName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                int compare = employees[j].getName().compareTo(employees[i].getName());
                if (compare < 0) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    private static void showInCommandLine(Employee[] employees) {
        System.out.println("==================");
        System.out.printf("%-9s%-15s%-13s\n", "Name", "Department", "Salary");
        for (Employee employee : employees) {
            System.out.printf("%-9s%-15s%-10.2f\n",
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getSalary());
        }
        System.out.println("Number Of Employee is : " + Employee.count);
    }

    private static void showInJOptionPane(Employee[] employees) {
        String output = "";
        int count = 0;
        for (Employee employee : employees) {
            count++;
            output += "Employee" + count + " : \n";
            output += "     Name : " + employee.getName() + "     \n";
            output += "     Department : " + employee.getDepartment() + "     \n";
            output += "     Salary : " + employee.getSalary() + "     \n";
            output += "----------\n";
        }
        output += "Number Of Employee is : " + Employee.count;
        JOptionPane.showMessageDialog(null, output);
    }

    private static void readByScanner(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter Data...");
            Employee emp = new Employee();

            //name input
            System.out.print("Enter the name : ");
            emp.setName(in.nextLine());
            //departnment input
            System.out.print("Enter the Department : ");
            emp.setDepartment(in.nextLine());
            //salary input
            System.out.print("Enter hte salary : ");
            emp.setSalary(Integer.parseInt(in.nextLine()));

            employees[i] = emp;
        }
    }

    private static void readByJOptionPane(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter Data...");

            Employee emp = new Employee();
            //name input
            emp.setName(JOptionPane.
                    showInputDialog(null, "Name", "Employee", JOptionPane.INFORMATION_MESSAGE));
            //departnment input
            emp.setDepartment(JOptionPane.
                    showInputDialog(null, "Department", "Employee", JOptionPane.INFORMATION_MESSAGE));
            //salary input
            emp.setSalary(Integer.parseInt(JOptionPane.
                    showInputDialog(null, "Salary", "Employee", JOptionPane.INFORMATION_MESSAGE)));

            employees[i] = emp;
        }
    }

    private static void addBonusToAll(Employee[] employees, double bonus) {
        for (int i = 0; i < employees.length; i++) {
            double salary = employees[i].getSalary();
            employees[i].setSalary(salary, bonus);
        }
    }
}
