public class courseRoster
{
    private String Course_num;
    private int Num_of_Site = 3; // Numbers of site
    private int [] Size_of_Persite = new int [Num_of_Site]; // Create a list of Num_of_Site
    private int Num_of_Stu_Persite01; // Numbers of student per site 01
    private int Num_of_Stu_Persite02; // Numbers of student per site 02
    private int Num_of_Stu_Persite03; // Numbers of student per site 03 
    private int Num_of_Assign; // Numbers of assignment
    private int Num_of_Pro; // Numbers of project 
    private int Num_of_Exam; // Numbers of exam

    public String getCourseNum() // Return numbers of assignment
    {
        return Course_num;
    }

    public void setCourseNum(String course) // Set numbers of assigment
    {
        this.Course_num = course;
    }

    public int getNum_of_Stu_Persite(int n) // Return numbers of students in each site
    {
        if(n == 0)
        {
            return Num_of_Stu_Persite01;
        }
        if(n == 1)
        {
            return Num_of_Stu_Persite02;
        }
        if(n == 2)
        {
            return Num_of_Stu_Persite03;
        }
        return -1;
    }

    public void setNum_of_Stu_Persite(int n, int num) // Set numbers of students in ecan site
    {
        if(n == 0)
        {
            this.Num_of_Stu_Persite01 = num;
            Size_of_Persite[0] = Num_of_Stu_Persite01;
        }
        if(n == 1)
        {
            this.Num_of_Stu_Persite02 = num;
            Size_of_Persite[1] = Num_of_Stu_Persite02;
        }
        if(n == 2)
        {
            this.Num_of_Stu_Persite03 = num;
            Size_of_Persite[2] = Num_of_Stu_Persite03;
        }
    }

    public int getTotal_Num_of_Stu() // Return total numbers of students in this class
    {
        return Num_of_Stu_Persite01 + Num_of_Stu_Persite02 + Num_of_Stu_Persite03;
    }

    public int getNum_of_Assign() // Return numbers of assignment
    {
        return Num_of_Assign;
    }

    public void setNum_of_Assign(int num) // Set numbers of assigment
    {
        this.Num_of_Assign = num;
    }

    public int getNum_of_Pro() // Return numbers of project
    {
        return Num_of_Pro;
    }

    public void setNum_of_Pro(int num) // Set numbers of project
    {
        this.Num_of_Pro = num;
    }

    public int getNum_of_Exam() // Return numbers of exam
    {
        return Num_of_Exam;
    }

    public void setNum_of_Exam(int num) // Set numbers of exam
    {
        this.Num_of_Exam = num;
    }

    public void overview() // Print the class overview
    {
        System.out.println("The course number is " + getCourseNum());
        System.out.println("Numbers of site is " + Num_of_Site);
        System.out.println("Numbers of students in site 01 is " + getNum_of_Stu_Persite(0));
        System.out.println("Numbers of students in site 02 is " + getNum_of_Stu_Persite(1));
        System.out.println("Numbers of students in site 03 is " + getNum_of_Stu_Persite(2));
        System.out.println("Numbers of total class size is " + getTotal_Num_of_Stu());
        System.out.println("Numbers of Assignment is " + getNum_of_Assign());
        System.out.println("Numbers of project is " + getNum_of_Pro());
        System.out.println("Numbers of exam is " + getNum_of_Exam());
    }
}