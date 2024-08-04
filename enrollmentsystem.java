import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private int courseId;
    private String courseName;
    private int credits;

    public Course(int courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return courseName + " (" + credits + " credits)";
    }
}

class Enrollment {
    private String studentId;
    private List<Course> courses;

    public Enrollment(String studentId) {
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    public void enroll(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Student " + studentId + " enrolled in course " + course.getCourseName());
        } else {
            System.out.println("Student " + studentId + " is already enrolled in course " + course.getCourseName());
        }
    }

    public void drop(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            System.out.println("Student " + studentId + " dropped course " + course.getCourseName());
        } else {
            System.out.println("Student " + studentId + " is not enrolled in course " + course.getCourseName());
        }
    }

    public void viewEnrollments() {
        if (!courses.isEmpty()) {
            System.out.println("Student " + studentId + " is enrolled in the following courses:");
            for (Course course : courses) {
                System.out.println("- " + course.toString());
            }
        } else {
            System.out.println("Student " + studentId + " is not enrolled in any courses.");
        }
    }
}

public class enrollmentsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(new Course(253, "Maths", 3));
        availableCourses.add(new Course(251, "Java", 4));
        availableCourses.add(new Course(261, "DSA", 3));

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Enrollment studentEnrollment = new Enrollment(studentId);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Enroll in a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View enrolled courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nAvailable courses:");
                    for (Course course : availableCourses) {
                        System.out.println(course.getCourseId() + ": " + course.getCourseName());
                    }
                    System.out.print("Enter course ID to enroll: ");
                    int enrollCourseId = scanner.nextInt();
                    Course enrollCourse = getCourseById(availableCourses, enrollCourseId);
                    if (enrollCourse != null) {
                        studentEnrollment.enroll(enrollCourse);
                    } else {
                        System.out.println("Invalid course ID.");
                    }
                    break;
                case 2:
                    studentEnrollment.viewEnrollments();
                    System.out.print("Enter course ID to drop: ");
                    int dropCourseId = scanner.nextInt();
                    Course dropCourse = getCourseById(availableCourses, dropCourseId);
                    if (dropCourse != null) {
                        studentEnrollment.drop(dropCourse);
                    } else {
                        System.out.println("Invalid course ID.");
                    }
                    break;
                case 3:
                    studentEnrollment.viewEnrollments();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Course getCourseById(List<Course> courses, int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }
}
