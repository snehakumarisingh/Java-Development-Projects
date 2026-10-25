import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {

    static ArrayList<Student> students=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("===== Student Management System =====");
        addStudent();
        viewStudents();
        searchStudent();
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
