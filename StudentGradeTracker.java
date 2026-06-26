import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Grade Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(name, marks));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Student Records Found.");
                    } else {
                        System.out.println("\nStudent Records:");
                        for (Student s : students) {
                            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No Data Available.");
                    } else {

                        int total = 0;
                        int highest = students.get(0).marks;
                        int lowest = students.get(0).marks;

                        for (Student s : students) {
                            total += s.marks;

                            if (s.marks > highest)
                                highest = s.marks;

                            if (s.marks < lowest)
                                lowest = s.marks;
                        }

                        double average = (double) total / students.size();

                        System.out.println("\n===== Grade Summary =====");
                        System.out.println("Total Students : " + students.size());
                        System.out.println("Average Marks  : " + average);
                        System.out.println("Highest Marks  : " + highest);
                        System.out.println("Lowest Marks   : " + lowest);
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}