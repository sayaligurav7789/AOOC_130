package Ex3;

import java.util.Scanner;

public class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    void inputDetails(Scanner sc) {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter address: ");
        address = sc.nextLine();
        System.out.print("Enter salary: ");
        salary = sc.nextDouble();
        sc.nextLine(); // consume newline
    }

    void generateReport() {
        System.out.println("\nEmployee: " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Address: " + address);
        System.out.println("Salary: $" + salary);
        System.out.println("Bonus: $" + calculateBonus());
    }

    double calculateBonus() {
        return salary * 0.1;
    }
}

class Manager extends Employee {
    Manager() {
        jobTitle = "Manager";
    }

    @Override
    double calculateBonus() {
        return salary * 0.15;
    }

    void manageProjects() {
        System.out.println(name + " is managing a project.");
    }
}

class Developer extends Employee {
    Developer() {
        jobTitle = "Developer";
    }

    @Override
    double calculateBonus() {
        return salary * 0.12;
    }

    void developSoftware() {
        System.out.println(name + " is developing software.");
    }
}

class Programmer extends Employee {
    Programmer() {
        jobTitle = "Programmer";
    }

    void writeCode() {
        System.out.println(name + " is writing code.");
    }
}

class Employeedemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Enter Manager Details");
            System.out.println("2. Enter Developer Details");
            System.out.println("3. Enter Programmer Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Manager m = new Manager();
                    m.inputDetails(sc);
                    m.generateReport();
                    m.manageProjects();
                    break;
                case 2:
                    Developer d = new Developer();
                    d.inputDetails(sc);
                    d.generateReport();
                    d.developSoftware();
                    break;
                case 3:
                    Programmer p = new Programmer();
                    p.inputDetails(sc);
                    p.generateReport();
                    p.writeCode();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
