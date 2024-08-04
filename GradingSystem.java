public class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;

    public GradingSystem(int maxStudents, int maxGrades) {
        students = new Student[maxStudents];
        grades = new Grade[maxGrades];
        courseCredits = new int[maxGrades];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Student record system is full.");
        }
    }

    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Grade record system is full.");
        }
    }

    public void addCourseCredits(int courseID, int credits) {
        if (courseID >= courseCredits.length) {
            int[] temp = new int[courseID + 1];
            for (int i = 0; i < courseCredits.length; i++) {
                temp[i] = courseCredits[i];
            }
            courseCredits = temp;
        }
        courseCredits[courseID] = credits;
    }

    public double calculateGPA(int studentID) {
        double totalCredits = 0;
        double totalGradePoints = 0;
        for (Grade grade : grades) {
            if (grade != null && grade.getStudentID() == studentID) {
                int courseIndex = grade.getCourseID();
                totalCredits += courseCredits[courseIndex];
                totalGradePoints += gradeToPoints(grade.getGrade()) * courseCredits[courseIndex];
            }
        }
        return totalGradePoints / totalCredits;
    }

    private int gradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            default:
                return 0;
        }
    }

    public void printGradeReport(int studentID) {
        System.out.println("Grade Report for Student " + studentID);
        for (Grade grade : grades) {
            if (grade != null && grade.getStudentID() == studentID) {
                System.out.println("Course " + grade.getCourseID() + ": " + grade.getGrade());
            }
        }
        System.out.println("GPA: " + calculateGPA(studentID));
    }
}