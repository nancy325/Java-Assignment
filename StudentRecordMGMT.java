import java.util.Scanner;
public class StudentRecordMGMT {
    public static void main(String[] args) {
        StudentRecordSystem studentRecordSystem = new StudentRecordSystem(100);
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add new student record");
            System.out.println("2. Display student record");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = input.nextInt();
                    input.nextLine(); // Consume newline left-over
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    System.out.print("Enter student department: ");
                    String department = input.nextLine();
                    System.out.print("Enter student age: ");
                    int age = input.nextInt();
                    input.nextLine(); // Consume newline left-over
                    Student student = new Student(studentID, name, age, department);
                    studentRecordSystem.addStudent(student);
                    System.out.println("Student record added successfully.");
                    break;
                case 2:
                    System.out.print("Enter student ID to fetch: ");
                    int fetchID = input.nextInt();
                    input.nextLine(); // Consume newline left-over
                    Student fetchedStudent = studentRecordSystem.getStudent(fetchID);
                    if (fetchedStudent != null) {
                        System.out.println("Student details:");
                        System.out.println(fetchedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }
}