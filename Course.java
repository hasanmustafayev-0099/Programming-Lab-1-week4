
package javaapplication;

import java.util.ArrayList;
import java.util.List;

public class Course {
    
public String courseName;
    public int capacity;
    public ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Enrolled Students: " + enrolledStudents.size());
        System.out.print("Enrolled Students: ");
        if (enrolledStudents.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < enrolledStudents.size(); i++) {
                System.out.print(enrolledStudents.get(i).name);
                if (i < enrolledStudents.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
