
package javaapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        System.out.println("Please enter how many course will you create (at least 3):");
        int courseNum = sc.nextInt();
        while (courseNum < 3) {
            System.out.println("Course number cant be lower than 3. enter correct size:");
            courseNum = sc.nextInt();
        }

        for (int i = 1; i <= courseNum; i++) {
            System.out.println("Please enter the course name : " + i);
            String courseName = sc.next();
            System.out.println("Please enter the capacity of course : " + i);
            int capacity = sc.nextInt();
            Course cs = new Course(courseName, capacity);
            courses.add(cs);
        }

        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("- " + courses.get(i).courseName + " (Capacity: " + courses.get(i).capacity + ")");
        }

        while (true) {
            System.out.println("\nmenu : ");
            System.out.println("1. add student");
            System.out.println("2. view all courses and exit");
            int choice = sc.nextInt();

            if (choice == 2) {
                break;
            }

            if (choice == 1) {
                System.out.println("enter student id:");
                String id = sc.next();
                System.out.println("enter the student name :");
                String name = sc.next();
                System.out.println("enter the course name :");
                String cName = sc.next();

                Course targetCourse = null;
                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).courseName.equalsIgnoreCase(cName)) {
                        targetCourse = courses.get(i);
                        break;
                    }
                }

                if (targetCourse == null) {
                    System.out.println("No course found with that name.");
                } else if (targetCourse.enrolledStudents.size() >= targetCourse.capacity) {
                    System.out.println("This course is full. Registration failed.");
                } else {
                    boolean alreadyRegistered = false;
                    for (int i = 0; i < targetCourse.enrolledStudents.size(); i++) {
                        if (targetCourse.enrolledStudents.get(i).ID.equals(id)) {
                            alreadyRegistered = true;
                            break;
                        }
                    }

                    if (alreadyRegistered) {
                        System.out.println("This student is already registered for this course.");
                    } else {
                        Student s = new Student(id, name);
                        targetCourse.enrolledStudents.add(s);
                        System.out.println("Registration successful.");
                    }
                }
            }
        }

        System.out.println("\n--- All Courses ---");
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).displayCourseInfo();
            System.out.println();
        }
    }
}