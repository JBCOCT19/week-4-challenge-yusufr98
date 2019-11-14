package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner k = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Faculty> faculties = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Link> links = new ArrayList<>();
    private static Admin admin = new Admin("Admin", 0);
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args) {

        Student student = new Student("Yusuf", 0);
        Student student1 = new Student("Tony", 1);
        Student student2 = new Student("Pierz", 2);
        Collections.addAll(students, student,student1,student2);
        Faculty faculty = new Faculty("Victor", 0);
        Faculty faculty1 = new Faculty("Betty", 1);
        Faculty faculty2 = new Faculty("AJ", 2);
        Collections.addAll(faculties, faculty,faculty1,faculty2);
        Course java = new Course(0,"Java", "Learning Java/OOP", faculty.getId());
        Course data = new Course(1,"Data", "Math", faculty2.getId());
        Course html = new Course(2,"HTML/CSS", "website basics", faculty1.getId());
        Collections.addAll(courses, java,data,html);
        links.add(new Link(java.getId(), student.getId(),links.size()));
        links.add(new Link(java.getId(), student1.getId(),links.size()));
        links.add(new Link(html.getId(), student2.getId(),links.size()));

        System.out.println("Welcome to Yusuf's School System!");
        System.out.println("Would you like to login as a admin, faculty, or student(Only admin available on this version)?");
        String lc = k.nextLine();
        long id;
        boolean bool = false;
        do {
            if (lc.equalsIgnoreCase("admin")) {
                System.out.println("Welcome Admin");
                id = login(lc);
                administrate();
            } else if (lc.equalsIgnoreCase("faculty")) {
                System.out.println("Welcome Faculty");
                id = login(lc);
            } else if (lc.equalsIgnoreCase("student")) {
                System.out.println("Welcome Student");
                id = login(lc);
            } else {
                bool = true;
                System.out.println("Invalid option");
            }
        }while(bool);
    }
    public static void administrate(){
        boolean bool = true;
        do {
            System.out.println("Options:\n" +
                                "1 - Add Student\n" +
                                "2 - Add Faculty\n" +
                                "3 - Edit Student\n" +
                                "4 - Edit Faculty\n" +
                                "5 - Add Class\n" +
                                "6 - Edit Class\n" +
                                "7 - Enroll a Student\n" +
                                "8 - Hire a Faculty\n" +
                                "9 - View all Information\n" +
                                "Enter 0 to quit");
            System.out.print("> ");
            int choice = k.nextInt();
            k.nextLine();
            switch (choice){
                case 1: add("s"); break;
                case 2: add("f"); break;
                case 3: edit("s"); break;
                case 4: edit("f"); break;
                case 5: add("c"); break;
                case 6: edit("c"); break;
                case 7: link("s"); break;
                case 8: link("f"); break;
                case 9: displayAll(); break;
                case 0: bool = false; break;
                default:
                    System.out.println("Invalid option");break;
            }
        } while (bool);
    }
    public static void link(String s){
        boolean bool = true;
        System.out.println();
        do {
            System.out.print("Enter course ID: ");
            int cid = k.nextInt();
            if(s.equals("s") && cid < courses.size()){
                System.out.print("Enter Student ID: ");
                int sid = k.nextInt();
                if(sid < students.size()) {
                    links.add(new Link(cid, sid, links.size()));
                    System.out.println(students.get(sid).getName() + " was enrolled in " + courses.get(cid).getName());
                    bool = false;
                }
            }
            else if(s.equals("f") && cid < courses.size()){
                System.out.print("Enter Faculty ID: ");
                int fid = k.nextInt();
                if(fid < faculties.size()) {
                    courses.get(cid).setFid(fid);
                    System.out.println(faculties.get(fid).getName() + " was assigned to " + courses.get(cid).getName());
                    bool= false;
                }
            }
            if(bool){
                System.out.println("Invalid choice, please try again.");
            }
        } while(bool);
    }
    public static void edit(String s){
        boolean bool = true;
        System.out.println();
        String name;
        do {
            System.out.print("Enter ID of item you want to change: ");
            int id = k.nextInt();
            k.nextLine();
            if(s.equals("s")){
                if(id < students.size()){
                    System.out.print("Enter the new name of the student: ");
                    students.get(id).setName(k.next());
                    bool = false;
                }
            }
            else if(s.equals("f")){
                if (id < faculties.size()){
                    System.out.print("Enter the new name of the faculty: ");
                    faculties.get(id).setName(k.next());
                    bool = false;
                }
            }
            else{
                if (id < courses.size()){
                    System.out.print("Enter the new course name: ");
                    courses.get(id).setName(k.nextLine());
                    System.out.print("Enter the new course description: ");
                    courses.get(id).setDescription(k.nextLine());
                    bool = false;
                }
            }
            if(bool){
                System.out.println("Invalid ID");
            }
        } while(bool);
    }
    public static void add(String s){
        String name;
        if(s.equals("s")){
            System.out.print("Enter the name of the student you wish to add: ");
            name = k.next();
            students.add(new Student(name, students.size()));
        }
        else if(s.equals("f")){
            System.out.print("Enter the name of the faculty you wish to add: ");
            name = k.next();
            faculties.add(new Faculty(name, faculties.size()));
        }
        else{
            System.out.print("Enter the name of the course you wish to add: ");
            name = k.nextLine();
            System.out.print("Enter the course description: ");
            String des = k.nextLine();
            courses.add(new Course(courses.size(), name, des));
        }
    }
    public static void displayAll(){
        System.out.println("All Students: ");
        for(Student s : students){
            System.out.println(s.toString());
        }
        System.out.println("All Faculty: ");
        for(Faculty f : faculties){
            System.out.println(f.toString());
        }
        System.out.println("All Classes: ");
        for(Course c : courses){
            System.out.println(c.toString());
        }
    }
    public static long login(String s){

        long id = 0;
        boolean bool = true;
        do {
            System.out.print("Email: ");
            String email = k.nextLine();
            System.out.print("Password: ");
            String pass = k.nextLine();
            if (s.equalsIgnoreCase("admin")) {
                if (email.equalsIgnoreCase(admin.getUserEmail()) && pass.equalsIgnoreCase(admin.getUserPassword())) {
                    bool = false;
                }
            }
            else if (s.equalsIgnoreCase("faculty")) {
                for(int i = 0 ; i < faculties.size(); i++) {
                    if (email.equalsIgnoreCase(faculties.get(i).getUserEmail()) && pass.equalsIgnoreCase(faculties.get(i).getUserPassword())) {
                        bool = false;
                        id = i;
                        break;
                    }
                }
            }
            else{
                for(int i = 0 ; i < students.size(); i++) {
                    if (email.equalsIgnoreCase(students.get(i).getUserEmail()) && pass.equalsIgnoreCase(students.get(i).getUserPassword())) {
                        bool = false;
                        id = i;
                        break;
                    }
                }
            }
            if(bool){
                System.out.println("Invalid login. Please try again.");
            }
        }while(bool);
        System.out.println("You have successfully logged in!");
        return id;
    }
}
