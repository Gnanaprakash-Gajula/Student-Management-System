package studentmanagement;
import java.util.ArrayList;
import java.util.List;
/* StudentService class contains the business logic
 * of the Student Management System.*/
public class StudentService {
    // ArrayList is used to store multiple Student objects.
    private List<Student> students = new ArrayList<>();
    /* Adds a new student to the ArrayList.
     * Returns true if the student is successfully added.
     * Returns false if the student ID already exists.*/
    public boolean addStudent(Student student) {
        // Check whether the student ID already exists
        if (findStudentById(student.getStudentId()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }
    // Displays all students stored in the ArrayList.
    public void viewAllStudents() {
        // Check whether there are no students
        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }
        System.out.println("\n========== STUDENT LIST ==========");
        // Enhanced for loop is used to display every student
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("==================================");
    }
    /* Searches for a student using Student ID.
     * Returns the Student object if found.
     * Returns null if the student does not exist.*/
    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
    /* Updates the name and marks of an existing student.
     * Returns true if the student was found and updated.
     * Returns false if the student was not found.*/
    public boolean updateStudent(int studentId, String newName, double newMarks) {
        Student student = findStudentById(studentId);
        if (student == null) {
            return false;
        }
        // Update student details using setter methods
        student.setStudentName(newName);
        student.setMarks(newMarks);
        return true;
    }
    /* Deletes a student using Student ID.
     * Returns true if the student was deleted.
     * Returns false if the student was not found.*/
    public boolean deleteStudent(int studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }
}