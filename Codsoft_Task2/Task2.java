import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        grading g = new grading();

    }
}
class grading{
    grading(){
        Scanner sc = new Scanner(System.in);
        int total_subject=0;

        System.out.println("Enter the total number of subject");
        total_subject=sc.nextInt();
        
        String [] subject_name=new String[total_subject];
        int [] subject_marks = new int[total_subject];
        
        int total_marks = 100*total_subject;
        char [] grade = new char[total_subject];
        int average_marks=0;
        float average_percentage=0;
        int total_obtained_marks=0;
        int i =0;
        char final_grade = ' ';
        while(i<total_subject){
            System.out.println("Enter the name of subject "+(i+1));
            subject_name[i]=sc.next();
            System.out.println("Enter the marks of subject "+(i+1));
            subject_marks[i]=sc.nextInt();
            if(subject_marks[i]>100){
                System.out.println("Invalid input");
                continue;
            } else if (subject_marks[i]<0) {
                System.out.println("Invalid input");
                continue;
            } else {
                if(subject_marks[i]>=90 && subject_marks[i]<=100){
                    grade[i]='A';
                } else if (subject_marks[i]>=80 && subject_marks[i]<90) {
                    grade[i]='B';
                } else if (subject_marks[i]>=70 && subject_marks[i]<80) {
                    grade[i]='C';
                } else if (subject_marks[i]>=60 && subject_marks[i]<70) {
                    grade[i]='D';
                } else if (subject_marks[i]>=50 && subject_marks[i]<60) {
                    grade[i]='E';
                } else if (subject_marks[i]>=0 && subject_marks[i]<50) {
                    grade[i]='F';
                }
                total_obtained_marks+=subject_marks[i];
                
            }
            i++;
        }
        average_marks=total_obtained_marks/total_subject;
        average_percentage=(float)total_obtained_marks/total_marks*100;
        if(average_percentage>=90 && average_percentage<=100){
            final_grade ='A';
        } else if (average_percentage>=80 && average_percentage<90) {
            final_grade='B';
        } else if (average_percentage>=70 && average_percentage<80) {
            final_grade='C';
        } else if (average_percentage>=60 && average_percentage<70) {
            final_grade='D';
        } else if (average_percentage>=50 && average_percentage<60) {
            final_grade='E';
        } else if (average_percentage>=0 && average_percentage<50) {
            final_grade='F';
        }
        System.out.println("Subject\t\tMarks\t\tGrade");
        for(i=0;i<total_subject;i++){
            System.out.println(subject_name[i]+" \t\t "+subject_marks[i]+" \t\t "+grade[i]);
        }
        System.out.println("Average marks: "+average_marks);
        System.out.println("Average percentage: "+average_percentage);
        System.out.println("Final grade: "+final_grade);
        if(final_grade=='F'){
            System.out.println("Result: Fail");
        } else {
            System.out.println("Result: Pass");
        }
    }
}
