/**
 * @author Ali Çolak
 */

/**
 * 11.11.2020
 */
import java.util.Scanner;

public class CourseGrade {
    
    public static void main(String[] args) {
        
        //Name : Ali Çolak     Date :25.10.2020
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the grading weight(percent) in the  " +
                "for the following categories : ");
        
        System.out.print("Quizzes :");
        int quizzesPercent = Math.abs( scanner.nextInt() );
        
        System.out.print("Homework :");
        int homeworkPercent = Math.abs( scanner.nextInt() );
        
        System.out.print("Midterm Exam :");
        int midTermExamPercent = Math.abs( scanner.nextInt() );
        
        System.out.print("Final Exam :");
        int finalExamPercent = Math.abs( scanner.nextInt() );
        
        int totalPercent = quizzesPercent + homeworkPercent + midTermExamPercent
                +  finalExamPercent;
        
        if( totalPercent == 100 ){
            
            System.out.println("Please enter what Ali Çolak earned for each" +
                    " category :");
            
            System.out.print("Quizzes :");
            double quizzesNote = scanner.nextDouble()/100*quizzesPercent;
            
            System.out.print("Homework :");
            double homeworkNote = scanner.nextDouble()/100*homeworkPercent;
            
            System.out.print("Midterm Exam :");
            double midTermExamNote = scanner.nextDouble()/100*midTermExamPercent;
            
            System.out.print("Final Exam :");
            double finalExamNote = scanner.nextDouble()/100*finalExamPercent;
            
            double totalNote = quizzesNote + homeworkNote + midTermExamNote +
                    finalExamNote;
            if( totalNote < 35 && totalNote >= 0 )
                System.out.println("Ali Çolak failed CSE101 with a score  of a "
                        +totalNote+", GPA pob  ints of 0.0, and a grade " +
                        "letter of"
                        +" FF ");
            else if( totalNote < 46 ) 
                System.out.println("Ali Çolak failed CSE101 with a score  of a "
                        +totalNote+", GPA points of 0.5, and a grade letter of "
                        +"FD ");
            else if( totalNote < 53 )
                System.out.println("Ali Çolak conditionally passed CSE101 with "
                        +" a score  of a "+totalNote+", GPA points of 1.0, " +
                        "and a grade letter of DD ");
            else if( totalNote < 60 )
                System.out.println("Ali Çolak conditionally passed CSE101 with "
                        +"a score  of a "+totalNote+", GPA points of 1.5, and a"
                        +" grade letter of DC ");
            else if( totalNote < 67 )
                System.out.println("Ali  Çolak  passed CSE101 with a score  of "
                        + "a "+totalNote+", GPA points of 2.0, and a grade letter"
                        + " of CC ");
            else if( totalNote < 74 )
                System.out.println("Ali Çolak  passed CSE101 with a score  of" +
                        " a "+totalNote+", GPA points of 2.5, and a grade " +
                        "letter of CB ");
            else if( totalNote < 81 )
                System.out.println("Ali Çolak  passed CSE101 with a score  of" +
                        " a "+totalNote+", GPA points of 3.0, and a grade " +
                        "letter of BB ");
            else if( totalNote < 88 )
                System.out.println("Ali Çolak  passed CSE101 with a score  " +
                        "of a "+totalNote+", GPA points of 3.5, and a grade " +
                        "letter of BA ");
            else if( totalNote <= 100 )
                System.out.println("Ali Çolak  passed CSE101 with a score  " +
                        "of a "+totalNote+", GPA points of 4.0, and a grade " +
                        "letter of AA ");
            
        } else
            System.out.println("ERROR: The values sum to "+totalPercent+
                    " but should sum to 100.");
    }
    
}