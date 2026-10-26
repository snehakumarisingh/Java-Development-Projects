import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {

    static ArrayList<Student> students=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args){

        int choice;
        do{
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }while(choice!=4);
        sc.close();
    }

    public static void addStudent(){
        System.out.print("Enter student ID: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student name: ");
        String name=sc.nextLine();

        System.out.print("Enter student marks: ");
        double marks=sc.nextDouble();

        Student student=new Student(id,name,marks);
        students.add(student);

        System.out.println("Student added successfully!");
        System.out.println("Total students: "+students.size());
    }

    public static void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n===== Student Records =====");
        for(Student student:students){
            System.out.println("Student ID: "+student.getId());
            System.out.println("Student Name: "+student.getName());
            System.out.println("Student Marks: "+student.getMarks());
            System.out.println("---------------------------");
        }
    }

    public static void searchStudent(){

        System.out.print("Enter Student ID to search: ");
        int searchId=sc.nextInt();

        for(Student student:students){

            if(student.getId()==searchId){
                System.out.println("\nStudent found!");
                System.out.println("Student ID: "+student.getId());
                System.out.println("Student Name: "+student.getName());
                System.out.println("Student Marks: "+student.getMarks());
                return;
            }
        }
        System.out.println("Student not found.");
    }
}