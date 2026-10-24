import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {

    static ArrayList<Student> students=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("===== Student Management System =====");
        addStudent();
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
}
