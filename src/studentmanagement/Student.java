package studentmanagement;
/* Student class represents a student in our application.
 * It contains the data related to a student.  */
public class Student {
    // Instance variables to store student information
    private int studentId;
    private String studentName;
    private double marks;
    /* Parameterized constructor.
     * It is used to initialize student details when an object is created. */
    public Student(int studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }
    // Getter method to return student ID
    public int getStudentId() {
        return studentId;
    }
    // Getter method to return student name
    public String getStudentName() {
        return studentName;
    }
    // Setter method to update student name
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    // Getter method to return student marks
    public double getMarks() {
        return marks;
    }
    // Setter method to update student marks
    public void setMarks(double marks) {
        this.marks = marks;
    }
    // This method calculates the grade based on the marks.
    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } 
        else if (marks >= 80) {
            return "A";
        } 
        else if (marks >= 70) {
            return "B";
        } 
        else if (marks >= 60) {
            return "C";
        } 
        else if (marks >= 50) {
            return "D";
        } 
        else {
            return "F";
        }
    }
    /* toString() is overridden to display student details
     * in a readable format.*/
    @Override
    public String toString() {
        return "Student ID: " + studentId
                + " | Name: " + studentName
                + " | Marks: " + marks
                + " | Grade: " + calculateGrade();
    }
}