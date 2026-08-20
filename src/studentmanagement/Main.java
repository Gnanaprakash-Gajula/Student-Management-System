package studentmanagement;
import java.util.Scanner;
/* Main class is the entry point of the application.
 * It displays the menu, accepts user input,
 * and calls appropriate methods from StudentService. */
public class Main {
    public static void main(String[] args) {
        // Scanner is used to read input from the keyboard
        Scanner scanner = new Scanner(System.in);
        // Creating StudentService object
        StudentService service = new StudentService();
        // Variable used to control the menu loop
        boolean running = true;
        System.out.println("========================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================");
        // The menu keeps running until the user chooses Exit.
        while (running) {
            System.out.println("\n------------- MENU -------------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("--------------------------------");
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    // -----------------------------------------
                    // OPTION 1: ADD STUDENT
                    // -----------------------------------------
                    case 1:
                        System.out.println("\n----- ADD STUDENT -----");
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume leftover newline
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = scanner.nextDouble();
                        // Validate marks
                        if (marks < 0 || marks > 100) {
                            System.out.println("Invalid marks! Marks should be between 0 and 100.");
                            break;
                        }
                        // Create Student object
                        Student student = new Student(id, name, marks);
                        // Add student using StudentService
                        boolean added = service.addStudent(student);
                        if (added) {
                            System.out.println("Student added successfully!");
                        } else {
                            System.out.println("Student ID already exists!");
                        }
                        break;
                    // -----------------------------------------
                    // OPTION 2: VIEW ALL STUDENTS
                    // -----------------------------------------
                    case 2:
                        service.viewAllStudents();
                        break;
                    // -----------------------------------------
                    // OPTION 3: SEARCH STUDENT
                    // -----------------------------------------
                    case 3:
                        System.out.println("\n----- SEARCH STUDENT -----");
                        System.out.print("Enter Student ID: ");
                        int searchId = scanner.nextInt();
                        Student foundStudent = service.findStudentById(searchId);
                        if (foundStudent != null) {
                            System.out.println("\nStudent Found!");
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    // -----------------------------------------
                    // OPTION 4: UPDATE STUDENT
                    // -----------------------------------------
                    case 4:
                        System.out.println("\n----- UPDATE STUDENT -----");
                        System.out.print("Enter Student ID: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Marks: ");
                        double newMarks = scanner.nextDouble();
                        // Validate marks
                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println("Invalid marks! Marks should be between 0 and 100.");
                            break;
                        }
                        boolean updated = service.updateStudent(updateId,newName,newMarks);
                        if (updated) {
                            System.out.println("Student updated successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    // -----------------------------------------
                    // OPTION 5: DELETE STUDENT
                    // -----------------------------------------
                    case 5:
                        System.out.println("\n----- DELETE STUDENT -----");
                        System.out.print("Enter Student ID: ");
                        int deleteId = scanner.nextInt();
                        boolean deleted = service.deleteStudent(deleteId);
                        if (deleted) {
                            System.out.println("Student deleted successfully!"
                            );

                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    // -----------------------------------------
                    // OPTION 6: EXIT
                    // -----------------------------------------
                    case 6:
                        running = false;
                        System.out.println("\nThank you for using Student Management System!");
                        break;
                    // -----------------------------------------
                    // INVALID OPTION
                    // -----------------------------------------
                    default:
                        System.out.println("Invalid choice! Please select 1 to 6.");
                }
            } catch (Exception e) {
                /* Handles invalid input such as entering
                 * text instead of a number.*/
                System.out.println("Invalid input! Please enter the correct value."
                );
                // Clear invalid input from Scanner
                scanner.nextLine();
            }
        }
        // Close Scanner after the application ends
        scanner.close();
    }
}