import java.util.*;
import java.io.*;

class Roster_Creation // Menu 1
{

    public courseRoster createRoster()
    {

        courseRoster course = new courseRoster(); 

        //Scanner Course_num = new Scanner(System.in); // Set course number
        //System.out.println("What is the course number? ");
        String CourseName = "CS401" ;
        course.setCourseNum(CourseName);
        
        course.setNum_of_Stu_Persite(0, 10);
        course.setNum_of_Stu_Persite(1, 5);
        course.setNum_of_Stu_Persite(2, 5);
        //for(int i = 0; i < 3; i++) // Set numbers of students in each site from input
        //{ 
        //    int n = i+1;
        //    Scanner Num = new Scanner(System.in); 
        //    System.out.println("How many students in site " + n + " ？");
        //    course.setNum_of_Stu_Persite(Num.nextInt(), i);
        //}

        //Scanner Assign = new Scanner(System.in); // Set numbers of Assignment from input
        //System.out.println("How many assignment in this course? ");
        course.setNum_of_Assign(10);

        //Scanner Pro = new Scanner(System.in); // Set numbers of project from input
        //System.out.println("How many project in this course? ");
        course.setNum_of_Pro(1);

        //Scanner Exam = new Scanner(System.in); // Set numbers of exam from input
        //System.out.println("How many exam in this course? ");
        course.setNum_of_Exam(2);
        
        course.overview(); // Print the class overview

        return course;
    }

}