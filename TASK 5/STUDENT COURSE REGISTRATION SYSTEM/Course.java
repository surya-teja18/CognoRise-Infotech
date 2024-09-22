import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;
    private String schedule;
    private ArrayList<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean isSpaceAvailable() {
        return enrolledStudents < capacity;
    }

    public void addStudent(Student student) {
        if (isSpaceAvailable()) {
            registeredStudents.add(student);
            enrolledStudents++;
        }
    }

    public void removeStudent(Student student) {
        if (registeredStudents.contains(student)) {
            registeredStudents.remove(student);
            enrolledStudents--;
        }
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void displayCourseDetails() {
        System.out.println(courseCode + " - " + title + " (" + enrolledStudents + "/" + capacity + ")");
        System.out.println("Description: " + description);
        System.out.println("Schedule: " + schedule);
    }
}
