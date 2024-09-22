import java.util.HashMap;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private static HashMap<String, Course> courseDatabase = new HashMap<>();
    private static HashMap<String, Student> studentDatabase = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();

        while (true) {
            System.out.println("--- Course Registration System ---");
            System.out.println("1. List Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerForCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    viewRegisteredCourses();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void initializeData() {
        // Adding some courses
        courseDatabase.put("C101", new Course("C101", "Java Programming", "Learn the basics of Java.", 30, "Mon/Wed 10:00 AM - 11:30 AM"));
        courseDatabase.put("C102", new Course("C102", "Data Structures", "Understand data structures in-depth.", 25, "Tue/Thu 12:00 PM - 1:30 PM"));
        courseDatabase.put("C103", new Course("C103", "Database Systems", "Learn about relational databases.", 20, "Fri 2:00 PM - 4:00 PM"));

        // Adding some students
        studentDatabase.put("S001", new Student("S001", "John Doe"));
        studentDatabase.put("S002", new Student("S002", "Jane Smith"));
    }

    private static void listCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            course.displayCourseDetails();
            System.out.println();
        }
    }

    private static void registerForCourse() {
        System.out.print("Enter student ID: ");
        String studentID = sc.nextLine();
        Student student = studentDatabase.get(studentID);

        if (student == null) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.print("Enter course code to register: ");
        String courseCode = sc.nextLine();
        Course course = courseDatabase.get(courseCode);

        if (course == null) {
            System.out.println("Invalid course code.");
            return;
        }

        if (course.isSpaceAvailable()) {
            student.registerForCourse(course);
            System.out.println(student.getName() + " has been registered for " + course.getTitle());
        } else {
            System.out.println("Course is full. Cannot register.");
        }
    }

    private static void dropCourse() {
        System.out.print("Enter student ID: ");
        String studentID = sc.nextLine();
        Student student = studentDatabase.get(studentID);

        if (student == null) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.print("Enter course code to drop: ");
        String courseCode = sc.nextLine();
        Course course = courseDatabase.get(courseCode);

        if (course == null) {
            System.out.println("Invalid course code.");
            return;
        }

        student.dropCourse(course);
        System.out.println(student.getName() + " has dropped the course " + course.getTitle());
    }

    private static void viewRegisteredCourses() {
        System.out.print("Enter student ID: ");
        String studentID = sc.nextLine();
        Student student = studentDatabase.get(studentID);

        if (student == null) {
            System.out.println("Invalid student ID.");
            return;
        }

        student.displayRegisteredCourses();
    }
}
