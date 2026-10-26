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
    
            choice=readInt("Enter your choice: ");

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

        int id=readInt("Enter student ID: ");

        for(Student student:students){
            if(student.getId()==id){
                System.out.println("A student with this ID already exists!");
                return;
            }
        }

        String name;

        do{
            System.out.print("Enter student name: ");
            name=sc.nextLine();
            if(name.isEmpty()){
                System.out.println("Name cannot be empty!");
            }
        }while(name.isEmpty());

        double marks=readDouble("Enter student marks: ");
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

        int searchId=readInt("Enter student ID to search: ");

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

    public static int readInt(String message){

        while(true){
            System.out.print(message);
            String input=sc.nextLine().trim();

            try{
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    public static double readDouble(String message){

        while(true){
            System.out.print(message);
            String input=sc.nextLine().trim();

            try{
                return Double.parseDouble(input);
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}