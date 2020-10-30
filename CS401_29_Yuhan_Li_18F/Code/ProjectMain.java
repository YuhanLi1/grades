import java.util.Scanner;
import java.util.*;
import java.io.*;


class ProjectMain
{
    public static void main(String[] args) 
    {
        Scanner MenuNum = new Scanner(System.in); // Select Menu
    
        boolean quit = false;

        ArrayList<grade> grades = new ArrayList<grade>();

        courseRoster course = new courseRoster();

        do 
        {
            System.out.println(" "); 
            System.out.println("You are in main Menu");
            System.out.println("-------------------------------");
            System.out.println("1. Roster Creation");
            System.out.println("2. Grade Input");
            System.out.println("3. Record Search");
            System.out.println("4. Show List");
            System.out.println("5. Change record");
            System.out.println("6. Statistic");
            System.out.println("7. Exit");
            System.out.println("-------------------------------");
            System.out.println(" "); 

            System.out.println("Which menu you want to access? ");

            int MenuChoice = MenuNum.nextInt();

            switch (MenuChoice) 
                {


                case 1:
                    System.out.println(" ");   
                    System.out.println("You are in Menu 1");
                    System.out.println(" ");  
                    
                    String CourseName = "CS401" ;
                    course.setCourseNum(CourseName);        
                    course.setNum_of_Stu_Persite(0, 10);
                    course.setNum_of_Stu_Persite(1, 5);
                    course.setNum_of_Stu_Persite(2, 5);
                    course.setNum_of_Assign(10);
                    course.setNum_of_Pro(1);
                    course.setNum_of_Exam(2);
                    System.out.println("-------------------------------");
                    course.overview(); // Print the class overview
                    System.out.println("-------------------------------");

                    break;

                case 2:
                    try
                    {
                        System.out.println(" ");   
                        System.out.println("You are in Menu 2");
                        System.out.println(" ");   

                        Scanner inFile = new Scanner(new File("src//grades.txt")); 
                        ArrayList<String> inputData = new ArrayList<String>();
                        
                        //Read data line by line
                        while(inFile.hasNext())
                        {
                            String[] columns = inFile.nextLine().split("/t");
                            String data = columns[columns.length-1];
                            inputData.add(data);
                        }
                        int size = inputData.size();
                        //Creat grade object array with inputed data
                        for(int i=0; i < size; i++)
                        {
                            grade student = new grade();
                            String[] temp = inputData.get(i).split(" ");
                            student.setfirstN(temp[0]);
                            student.setlastN(temp[1]);
                            student.setSID(Integer.parseInt(temp[2]));
                            student.setCourse_num(temp[3]);
                            student.setSize(Integer.parseInt(temp[4]));
                            //student.setNum_of_Assignment(10);
                            for(int j = 5; j < size-3; j++)
                            {
                                int score = Integer.parseInt(temp[j]);
                                student.setAssignGrade(j-4, score);
                            }
                            student.setProGrade(Integer.parseInt(temp[15]));
                            student.setMidGrade(Integer.parseInt(temp[16])); 
                            student.setFinalGrade(Integer.parseInt(temp[17]));
                            grades.add(student);
                        }
                        System.out.println(" ");
                        System.out.println("-------------------------------");
                        System.out.println("Data has been input successful. ");
                        System.out.println("-------------------------------");
                        for(grade grade_idx1 : grades) 
                        {
                            grade_idx1.Overview();
                        }
                        System.out.println("-------------------------------");
                        
                    }
                    catch (FileNotFoundException fnfe)
                    {
                        System.out.println("The path is wrong.");
                    } 
                    break;

                case 3:
                    boolean quitmenu3 = false;
                    do 
                    {
                        System.out.println(" ");       
                        System.out.println("You are in Menu 3");
                        System.out.println(" ");
                        System.out.println("-------------------------------");                        
                        System.out.println(
                            "1.  Search by first name \r\n" + 
                            "2.  Search by last name \r\n" + 
                            "3.  Search by SID \r\n" + 
                            "4.  Traveling list \r\n" + 
                            "5.  Main Menu \r\n" );
                        System.out.println("-------------------------------");
                        System.out.println("Which function in Menu 3 you want to access? ");
                    
                    Scanner sca=new Scanner(System.in);
                    int str=sca.nextInt();
                    ArrayList<grade> found = new ArrayList<grade>();
                    
                    switch(str)
                    {
                        
                    case 1:

                        System.out.println(" ");
                        System.out.println("1. Search by first name");
                        System.out.println("Please input the first name: \n");
                        System.out.println(" ");

                        Scanner catch1=new Scanner(System.in);
                        String target1=catch1.nextLine();

                        for(grade grade_idx : grades) 
                        {
                            if(target1.contentEquals(grade_idx.getfirstN()))
                                found.add(grade_idx);
                        }            		 	
 
                        for (int i = 0; i < found.size() - 1; i++) {
                            for (int j = 1; j < found.size() - i; j++)
                            {
                                grade tempp;
                                if(found.get(j - 1).getfirstN().compareTo(found.get(j).getfirstN()) == 0) 
                                {
                                    if(found.get(j - 1).getlastN().compareTo(found.get(j).getlastN()) == 0) 
                                    {
                                        if(found.get(j - 1).getSID()>(found.get(j).getSID()))
                                        {
                                            tempp = found.get(j - 1);
                                            found.set((j - 1), found.get(j));
                                            found.set(j, tempp); 
                                        }
                                    }
                                    else if(found.get(j - 1).getlastN().compareTo(found.get(j).getlastN()) > 0)
                                        {
                                            tempp = found.get(j - 1);
                                            found.set((j - 1), found.get(j));
                                            found.set(j, tempp); 
                                        }
                                }
                                else if (found.get(j - 1).getfirstN().compareTo(found.get(j).getfirstN()) > 0) 
                                { 
                                    tempp = found.get(j - 1);
                                    found.set((j - 1), found.get(j));
                                    found.set(j, tempp);                                     
                                }
                            }
                        }//bubblesort 
                        
                        System.out.println("The information is sorted as follow :");
                        for(grade grade_idx1 : found) 
                        {
                            grade_idx1.Overview();
                        }
                        System.out.println(" ");
                        break;
                    
                    case 2:
                        System.out.println(" ");
                        System.out.println("2. Search by last name");
                        System.out.println("   Please input the last name: \n");
                    
                        
                        Scanner catch2 = new Scanner(System.in);
                        String target2 = catch2.nextLine();
                        
                        System.out.println(target2);
                        for(grade grade_idx : grades) 
                        {
                            if(target2.contentEquals(grade_idx.getlastN()))
                                found.add(grade_idx);
                        }   
                        
                        for (int i = 0; i < found.size() - 1; i++) {
                            for (int j = 1; j < found.size() - i; j++)
                                {
                                    grade tempp;
                                    if(found.get(j - 1).getfirstN().compareTo(found.get(j).getfirstN()) == 0) 
                                    {
                                        if(found.get(j - 1).getlastN().compareTo(found.get(j).getlastN()) == 0) 
                                        {
                                            if(found.get(j - 1).getSID()>(found.get(j).getSID()) )
                                            {
                                                tempp = found.get(j - 1);
                                                found.set((j - 1), found.get(j));
                                                found.set(j, tempp); 
                                            }
                                        }
                                        else if(found.get(j - 1).getlastN().compareTo(found.get(j).getlastN()) > 0)
                                            {
                                                tempp = found.get(j - 1);
                                                found.set((j - 1), found.get(j));
                                                found.set(j, tempp); 
                                            }
                                    }
                                    else if (found.get(j - 1).getfirstN().compareTo(found.get(j).getfirstN()) > 0) 
                                    { 
                                    tempp = found.get(j - 1);
                                    found.set((j - 1), found.get(j));
                                    found.set(j, tempp);                                     
                                    }
                                }
                            }//bubblesort
                        
                        System.out.println("The information is sorted as follow :");
                        for(grade grade_idx1 : found) 
                        {
                        	grade_idx1.Overview();    
                        }
                        System.out.println(" ");
                        break;
                    
                    case 3:
                        System.out.println(" ");
                        System.out.println("3. Search by SID");
                        System.out.println("   Please input the SID: \n");
                        
                        Scanner catch3=new Scanner(System.in);
                        int target3=catch3.nextInt();
                        
                        System.out.println(target3);
                        for(grade grade_idx : grades) 
                        {
                            if(target3==grade_idx.getSID())
                                found.add(grade_idx);
                        } 
                        
                        System.out.println("The information is sorted as follow :");
                        for(grade grade_idx1 : found) 
                        {
                        	grade_idx1.Overview();    
                        }
                        System.out.println(" ");
                        
                        break;

                    case 4:

                        DLL dll = new DLL(); 
                        for(grade grade_idx : grades)
                        {	dll.push(grade_idx); }
                        System.out.println("4. Traveling list:");
                        System.out.println("   Please use the SID to locate the current situation:\n");
                        Scanner catch4=new Scanner(System.in);
                        int target4=catch4.nextInt();

                        for(grade grade_idx : grades) {
                            if(target4==grade_idx.getSID())
                                System.out.println("The curent location is: " + grade_idx.getfirstN() +" "+ grade_idx.getlastN() +" "+ grade_idx.getSID());
                        } 
                        
                        System.out.println("Output number of Students(type in the positive integer): ");      			
                        Scanner menu4=new Scanner(System.in);
                        int number=menu4.nextInt();       		
                        System.out.println("Decide the direction(choose - or + ) : ");
                        Scanner menu5=new Scanner(System.in);
                        String x =menu5.nextLine();
                        String o ="-";
                        String p ="+";
                        if(x.equals(p))
                                dll.printlistfor(dll.head,number,target4); 
                        else if(x.equals(o))	
                                dll.printlistbak(dll.head,number,target4); 	
                        else
                            System.out.println("The direction type wrong");
                        
                        System.out.println(" ");
                                
                        break;
                        
                    case 5:

                        quitmenu3 = true;

                        break;
                    
                    default:

                        System.out.println("Imput mistake.");
                
                        break;
                    
                        }

                    } while (!quitmenu3);

                    break;

                case 4:

                    boolean Menu4quit = false;

                    Scanner Menu4Choice = new Scanner(System.in);

                    do
                    {
                        System.out.println(" ");
                        System.out.println("You are in Menu 4");
                        System.out.println(" ");
                        System.out.println("-------------------------------");
                        System.out.println("0. Scoring Weight per item");
                        System.out.println("1. Sorted list by last name");
                        System.out.println("2. Ranking by total score");
                        System.out.println("3. Ranking by homework average");
                        System.out.println("4. Ranking by project score");
                        System.out.println("5. Ranking by grade");
                        System.out.println("6. Main Menu");
                        System.out.println("-------------------------------");
                        System.out.println(" ");
                        System.out.println("Which function in Menu 4 you want to access? ");

                        int FunctionChoice = Menu4Choice.nextInt();

                        switch(FunctionChoice)
                        {
                            case 0:

                                for (int i = 0; i < course.getTotal_Num_of_Stu(); i++)
                                {
                                    grades.get(i).setWeight();
                                    grades.get(i).setTotalAssignGrade();
                                    grades.get(i).setAverageAssignGrade();
                                    grades.get(i).setTotalGrade();
                                    grades.get(i).setGrade();
                                }
                                System.out.println(" ");
                                System.out.println("Weight has been set successful.");
                                System.out.println(" ");
                                break;

                            case 1:

                                RankingLastname LA = new RankingLastname();
                                Collections.sort(grades, LA);
                                System.out.println(" ");
                                for (grade g : grades)
                                {
                                    System.out.println(g.getlastN() + " " + g.getfirstN() + " " + g.getSID() + " " + g.getSite() + " " + g.getAverageAssignGrade() + " " + g.getProGrade() + " " + g.getMidGrade() + " " + g.getFinalGrade() + " " + g.getTotalGrade() + " " + g.getGrade());
                                }
                                System.out.println(" ");
                                break;

                            case 2:

                                RankingTotalScore TS = new RankingTotalScore();
                                Collections.sort(grades, TS);
                                System.out.println(" ");
                                for (grade g : grades)
                                {
                                    System.out.println(g.getlastN() + " " + g.getfirstN() + " " + g.getSite() + " " + g.getTotalGrade());
                                }
                                System.out.println(" ");
                                break;

                            case 3:

                                RankingAverageAssign RA = new RankingAverageAssign();
                                Collections.sort(grades, RA);
                                System.out.println(" ");
                                for (grade g : grades)
                                {
                                    System.out.println(g.getlastN() + " " + g.getfirstN() + " " + g.getSite() + " " + g.getAverageAssignGrade());
                                }
                                System.out.println(" ");
                                break;

                            case 4:

                                RankingProjectScore PS = new RankingProjectScore();
                                Collections.sort(grades, PS);
                                System.out.println(" ");
                                for (grade g : grades)
                                {
                                    System.out.println(g.getlastN() + " " + g.getfirstN() + " " + g.getSite() + " " + g.getProGrade());
                                }
                                System.out.println(" ");
                                break;

                            case 5:

                                RankingGrade G = new RankingGrade();
                                Collections.sort(grades, G);
                                System.out.println(" ");
                                for (grade g : grades)
                                {
                                    System.out.println(g.getlastN() + " " + g.getfirstN() + " " + g.getSite() + " " + g.getGrade());
                                }
                                System.out.println(" ");
                                break;
                            case 6:

                                Menu4quit = true;
            
                                break;
            
                            default:
            
                                System.out.println("Invalid choice.");
                        }

                    }while (!Menu4quit);

                    break;

                case 5:
                    boolean quitmenu5 = false;
                    do 
                    {       
                        System.out.println("You've chosen Menu 5");
                        System.out.println("-------------------------------");   
                        System.out.println( "1. Add record");
                        System.out.println( "2. Remove record" );
                        System.out.println( "3. Change record ");
                        System.out.println( "4. Main Menu" );
                        System.out.println( "-------------------------------");
                        System.out.println("Which menu you want to access? ");
                    
                        Scanner sca=new Scanner(System.in);
                        int menu5=sca.nextInt();
                    
                        switch(menu5)
                        {
                            case 1:
                                System.out.println("1.  Add record");
                                System.out.println("Please input the information you want to add: ");
                                Scanner inFile = new Scanner(System.in);
                                ArrayList<String> inputData = new ArrayList<String>();
                                    String columns = inFile.nextLine();
                                    String data = columns;
                                    inputData.add(data);
                                    //System.out.println(data);           
                                int size = inputData.size();
                                for(int i=0; i < size; i++)
                                {
                                    grade student = new grade();
                                    String[] temp = inputData.get(i).split(" ");
                                    student.setfirstN(temp[0]);
                                    student.setlastN(temp[1]);
                                    student.setSID(Integer.parseInt(temp[2]));
                                    student.setCourse_num(temp[3]);
                                    student.setSize(Integer.parseInt(temp[4]));
                                    //student.setNum_of_Assignment(10);
                                    for(int j = 5; j < 15; j++)
                                    {
                                        int score = Integer.parseInt(temp[j]);
                                        student.setAssignGrade(j-4, score);
                                    }
                                    student.setProGrade(Integer.parseInt(temp[15]));
                                    student.setMidGrade(Integer.parseInt(temp[16])); 
                                    student.setFinalGrade(Integer.parseInt(temp[17]));
                                    grades.add(student);
                                }
                            
                                for (grade g : grades)
                                {
                                	g.Overview();                                
                                } 			
        
                                break;
                            
                            case 2:
                                System.out.println("2.  Remove record");
                                System.out.println("Please type the SID of the student you want to remove (a double-digit number):");
                                Scanner sca2=new Scanner(System.in);
                                int target=sca2.nextInt();
        
                                for (int i = 0; i < grades.size() ; i++)
                                {
                                    if(target==grades.get(i).getSID()) 
                                        {
                                        grades.remove(i);
                                        }
                                };
                                for (grade g : grades)
                                {
                                	g.Overview();     
                                	} 			
        
                                
                                break;
                            
                            case 3:
                                System.out.println("3.  Change record");
                                System.out.println("Please type the SID of the student you want to change record: ");
                                Scanner sca3=new Scanner(System.in);
                                int target3=sca3.nextInt();
                                int numb=0;
                                for (int i = 0; i < grades.size() ; i++)
                                {
                                    if(target3==grades.get(i).getSID()) 
                                        {
                                            numb=i;
                                        }
                                };	
                                System.out.println("The infomation of the student you want to change is: \n" );
                                grades.get(numb).Overview();
        
                                
                                
                                System.out.println("Please type the type of grade and the new score: ");
                                String line = "";
                                Scanner sca4=new Scanner(System.in);
                                    line = sca4.nextLine(); 
                                        System.out.println(line);
                                        String name = line.substring(0,line.indexOf(' '));
                                        int scoreChange = Integer.valueOf(line.substring(line.indexOf(' ') + 1, line.length()));              
                                        
                                
                                if (name.contentEquals("ProGrade"))
                                {
                                    grades.get(numb).setProGrade(scoreChange);
                                    System.out.println("The current imformation is :");
                                   grades.get(numb).Overview();
                                }
                                else if(name.contentEquals("MidGrade"))
                                {
                                    grades.get(numb).setMidGrade(scoreChange);
                                    System.out.println("The current imformation is :");
                                    grades.get(numb).Overview();}
                                else if(name.contentEquals("FinalGrade"))
                                {
                                    grades.get(numb).setFinalGrade(scoreChange);
                                    System.out.println("The current imformation is :");
                                    grades.get(numb).Overview();}
                                else
                                {
                                    System.out.print("The type of grades are wrong. ");
                                }  
                                    break;
                            case 4:
                                quitmenu5=true;
                                break;
                        } 
                    }while (!quitmenu5);

                    break;
                case 6:

                    boolean Menu6quit = false;

                    Scanner Menu6Choice = new Scanner(System.in);

                    do
                    {
                        System.out.println(" ");
                        System.out.println("You are in Menu 6");
                        System.out.println(" ");
                        System.out.println("1. Average Score of Class");
                        System.out.println("2. Percentage of Grade");
                        System.out.println("3. Main Menu");
                        System.out.println(" ");
                        System.out.println("Which function in Menu 6 you want to access? ");

                        int M6Choice = Menu6Choice.nextInt();

                        switch(M6Choice)
                        {
                            case 1:
                                int sumAssign_1 = 0;
                                int sumAssign_2 = 0;
                                int sumAssign_3 = 0;
                                int sumProject_1 = 0;
                                int sumProject_2 = 0;
                                int sumProject_3 = 0;
                                int sumMid_1 = 0;
                                int sumMid_2 = 0;
                                int sumMid_3 = 0;
                                int sumFinal_1 = 0;
                                int sumFinal_2 = 0;
                                int sumFinal_3 = 0;
                                int sumTotal_1 = 0;
                                int sumTotal_2 = 0;
                                int sumTotal_3 = 0;

                                for (grade g : grades)
                                {
                                    if(g.getSite() == 1)
                                    {
                                        sumAssign_1 += g.getTotalAssignGrade();
                                        sumProject_1 += g.getProGrade();
                                        sumMid_1 += g.getMidGrade();
                                        sumFinal_1 += g.getFinalGrade();
                                        sumTotal_1 += g.getTotalGrade();
                                    }
                                    else if(g.getSite() == 2)
                                    {
                                        sumAssign_2 += g.getTotalAssignGrade();
                                        sumProject_2 += g.getProGrade();
                                        sumMid_2 += g.getMidGrade();
                                        sumFinal_2 += g.getFinalGrade();
                                        sumTotal_2 += g.getTotalGrade();
                                    }
                                    else
                                    {
                                        sumAssign_3 += g.getTotalAssignGrade();
                                        sumProject_3 += g.getProGrade();
                                        sumMid_3 += g.getMidGrade();
                                        sumFinal_3 += g.getFinalGrade();
                                        sumTotal_3 += g.getTotalGrade();
                                    }
                                }
                                double AveAssign_1 = ((double)sumAssign_1)/100;
                                double AveAssign_2 = ((double)sumAssign_2)/50;
                                double AveAssign_3 = ((double)sumAssign_3)/50;
                                double AveAssign = ((double)(sumAssign_1 + sumAssign_2 + sumAssign_3))/200;
                                
                                double AveProject_1 = ((double)sumProject_1)/10;
                                double AveProject_2 = ((double)sumProject_2)/5;
                                double AveProject_3 = ((double)sumProject_3)/5;
                                double AveProject = ((double)(sumProject_1 + sumProject_2 + sumProject_3))/20;

                                double AveMid_1 = ((double)sumMid_1)/10;
                                double AveMid_2 = ((double)sumMid_2)/5;
                                double AveMid_3 = ((double)sumMid_3)/5;
                                double AveMid = ((double)(sumMid_1 + sumMid_2 + sumMid_3))/20;

                                double AveFinal_1 = ((double)sumFinal_1)/10;
                                double AveFinal_2 = ((double)sumFinal_2)/5;
                                double AveFinal_3 = ((double)sumFinal_3)/5;
                                double AveFinal = ((double)(sumFinal_1 + sumFinal_2 + sumFinal_3))/20;

                                double AveTotal_1 = ((double)sumTotal_1)/10;
                                double AveTotal_2 = ((double)sumTotal_2)/5;
                                double AveTotal_3 = ((double)sumTotal_3)/5;
                                double AveTotal = ((double)(sumTotal_1 + sumTotal_2 + sumTotal_3))/20;

                                System.out.println("Statistics per class");
                                System.out.println("===============================");
                                System.out.println("Average of Homework:       " + AveAssign);
                                System.out.println("Average of Project:        " + AveProject);
                                System.out.println("Average of Midterm:        " + AveMid);
                                System.out.println("Average of Final:          " + AveFinal);
                                System.out.println("Average of Total Score:    " + AveTotal);
                                System.out.println("  ");

                                System.out.println("Statistics per Site");
                                System.out.println("-------------------------------");
                                System.out.println("Class Site:                 01");                           
                                System.out.println("Average of Homework:       " + AveAssign_1);
                                System.out.println("Average of Project:        " + AveProject_1);
                                System.out.println("Average of Midterm:        " + AveMid_1);
                                System.out.println("Average of Final:          " + AveFinal_1);
                                System.out.println("Average of Total Score:    " + AveTotal_1);
                                System.out.println("  ");
                                System.out.println("Class Site:                 02");                           
                                System.out.println("Average of Homework:       " + AveAssign_2);
                                System.out.println("Average of Project:        " + AveProject_2);
                                System.out.println("Average of Midterm:        " + AveMid_2);
                                System.out.println("Average of Final:          " + AveFinal_2);
                                System.out.println("Average of Total Score:    " + AveTotal_2);
                                System.out.println("  ");
                                System.out.println("Class Site:                 03");                           
                                System.out.println("Average of Homework:       " + AveAssign_3);
                                System.out.println("Average of Project:        " + AveProject_3);
                                System.out.println("Average of Midterm:        " + AveMid_3);
                                System.out.println("Average of Final:          " + AveFinal_3);
                                System.out.println("Average of Total Score:    " + AveTotal_3);
                                                        
                                break;
                         
                            case 2:
                            
                                int sumA = 0;
                                int sumB = 0;
                                int sumC = 0;
                                int sumE = 0;
                            
                                for(grade g:grades)
                                {
                                    if(g.getGrade() == "A")
                                    {
                                        sumA = sumA + 1;
                                    }
                                    else if(g.getGrade() == "B")
                                    {
                                        sumB =  sumB + 1;
                                    }
                                    else if(g.getGrade() == "C")
                                    {
                                        sumC = sumC + 1;
                                    }
                                    else
                                    {
                                        sumE = sumE + 1;
                                    }
                                }

                                double PercentA = ((double) sumA)/20*100;
                                double PercentB = ((double) sumB)/20*100;
                                double PercentC = ((double) sumC)/20*100;
                                double PercentE = ((double) sumE)/20*100;

                                System.out.println(" ");
                                System.out.println("A        " + PercentA + "%");
                                System.out.println("B        " + PercentB + "%");
                                System.out.println("C        " + PercentC + "%");
                                System.out.println("E        " + PercentE + "%");
                            
                                break;
                        
                            case 3: 

                                Menu6quit = true;
            
                                break;
    
                            default:
    
                                System.out.println("Invalid choice.");
                        }
                    }while (!Menu6quit);
                    
                    break;

                case 7:

                    quit = true;

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (!quit);



    }

}