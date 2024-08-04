public class GradingSystemMGTM {
    public static void main(String[] args) {
        GradingSystem gradingsystem = new GradingSystem(10, 20);

        // Add students
        gradingsystem.addStudent(new Student(101, "Alice"));
        gradingsystem.addStudent(new Student(102, "Bob"));

        // Add course credits
        gradingsystem.addCourseCredits(1001, 3);
        gradingsystem.addCourseCredits(1002, 4);

        // Add grades
        gradingsystem.addGrade(new Grade(101, 1001, 'A'));
        gradingsystem.addGrade(new Grade(101, 1002, 'B'));
        gradingsystem.addGrade(new Grade(102, 1001, 'B'));
        gradingsystem.addGrade(new Grade(102, 1002, 'A'));

        // Print grade reports
        gradingsystem.printGradeReport(101);
        gradingsystem.printGradeReport(102);
    }
}