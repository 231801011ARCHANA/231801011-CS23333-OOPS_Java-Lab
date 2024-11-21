import java.util.Scanner;

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Grading System");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Display All Grades");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter grade for Subject 1: ");
                    float subject1 = scanner.nextFloat();
                    System.out.print("Enter grade for Subject 2: ");
                    float subject2 = scanner.nextFloat();
                    System.out.print("Enter grade for Subject 3: ");
                    float subject3 = scanner.nextFloat();
                    System.out.print("Enter grade for Subject 4: ");
                    float subject4 = scanner.nextFloat();
                    System.out.print("Enter grade for Subject 5: ");
                    float subject5 = scanner.nextFloat();
                    StudentOperations.addStudent(name, subject1, subject2, subject3, subject4, subject5);
                    break;

                case 2:
                    StudentOperations.displayGrades();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
