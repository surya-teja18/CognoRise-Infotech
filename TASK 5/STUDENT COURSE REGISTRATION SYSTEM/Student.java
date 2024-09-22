import java.util.ArrayList;

public class Student {
    private String studentID;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        if (course.isSpaceAvailable()) {
            registeredCourses.add(course);
            course.addStudent(this);
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent(this);
        }
    }

    public void displayRegisteredCourses() {
        System.out.println("Courses registered by " + name + ":");
        for (Course course : registeredCourses) {
            course.displayCourseDetails();
        }
    }
}
