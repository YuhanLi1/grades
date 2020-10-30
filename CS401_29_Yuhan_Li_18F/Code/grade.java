import javax.lang.model.util.ElementScanner6;

class grade extends courseRoster
{

    private String firstN; // First name
    private String lastN; // Last name
    private int SID; // Student ID
    private String Course_num; // Class number
    private int site; // Site
    private int [] assignGrade  = new int [20]; // Assignment grade
    private int totalAssignGrade;
    private float averageAssignGrade;
    private int proGrade; // Project grade
    private int midGrade; // Midterm exam grade
    private int finalGrade; // Final exam grade
    private float totalGrade;
    private String Grade;
    private int weightFinal;
    private int weightMid;
    private int weightAssign;
    private int weightProject;
    private int weightOther;


    public String getfirstN() // Return first name
    {
        return firstN;
    }

    public void setfirstN(String name) // Set first name
    {
        this.firstN = name;
    }

    public String getlastN() // Return last name
    {
        return lastN;
    }

    public void setlastN(String name) // Set last name
    {
        this.lastN = name;
    }

    public int getSID() // Return SID
    {
        return SID;
    }

    public void setSID(int SID) // Set SID
    {
        this.SID = SID;
    }

    public String getCourse_num() // Return course number
    {
        return Course_num;
    }

    public void setCourse_num(String courseNum) // Set course number
    {
        this.Course_num = courseNum;
    }

    public int getSite() // Return size
    {
        return site;
    }

    public void setSize(int site) // Set size
    {
        this.site = site;
    }

    public int getProGrade() // Return project grade
    {
        return proGrade;
    }

    public void setProGrade(int score) // Set project grade
    {
        this.proGrade = score;
    }

    public int getMidGrade() // Return midterm grade
    {
        return midGrade;
    }

    public void setMidGrade(int score) // Set midterm grade
    {
        this.midGrade = score;
    }

    public int getFinalGrade() // Return final grade
    {
        return finalGrade;
    }

    public void setFinalGrade(int score) // Set final grade
    {
        this.finalGrade = score;
    }

    public int  getAssignGrade(int i) // Return certain assignment grade
    {
        return assignGrade[i-1];
    }

    public void setAssignGrade(int i, int score) // Set assignment grade
    {
        this.assignGrade[i-1] = score;
    }

    public void setTotalAssignGrade()
    {
        for(int i = 0; i < 10; i++)
        {
            this.totalAssignGrade += assignGrade[i];
        }
    }

    public int getTotalAssignGrade()
    {
        return this.totalAssignGrade;
    }

    public void setAverageAssignGrade()
    {
        for(int i = 0; i < 10; i++)
        {
            this.averageAssignGrade = this.totalAssignGrade/10;
        }
    }

    public float getAverageAssignGrade()
    {
        return this.averageAssignGrade;
    }

    public void setWeight()
    {
        this.weightAssign = 20;

        this.weightAssign = 20;

        this.weightFinal = 30;

        this.weightMid = 30;

        if((this.weightAssign + this.weightProject + this.weightMid + this.weightFinal) < 100)
        {
            this.weightOther = 100 - this.weightAssign - this.weightProject - this.weightMid - this.weightFinal;
        }

    }

    public void setTotalGrade()
    {
        this.totalGrade = this.weightMid * this.getMidGrade()/100 + this.weightFinal * this.getFinalGrade()/100 + this.weightAssign * this.getTotalAssignGrade()/100 + this.getProGrade();
    }

    public float getTotalGrade()
    {
        return totalGrade;
    }

    public void setGrade()
    {
        if(this.totalGrade > 90)
        {
            this.Grade = "A";
        }
        else if(this.totalGrade >= 80)
        {
            this.Grade = "B";
        }
        else if(this.totalGrade >= 70)
        {
            this.Grade = "C";
        }
        else
        {
            this.Grade = "E";
        }
    }

    public String getGrade()
    {
        return Grade;
    }

   public void Overview()
    {
        System.out.println(getfirstN() + " " + getlastN() + " " + getSID()+ " " + getCourse_num() +" "+ getSite() +" " + 
    getAssignGrade(1) +" "+ getAssignGrade(2) +" "+ getAssignGrade(3) +" "+ getAssignGrade(4) +" "+ 
        		getAssignGrade(5) +" "+ getAssignGrade(6) +" "+ getAssignGrade(7) +" "+ getAssignGrade(8) +" "+ 
    getAssignGrade(9) +" "+ getAssignGrade(10) +" "+ getProGrade() +" "+ getMidGrade() +" "+ getFinalGrade() 
    );
    }

}