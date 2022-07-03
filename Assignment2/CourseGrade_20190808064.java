/*
 * @author Ali Çolak
 * 11.11.2020
 */
import java.util.Scanner;

public class CourseGrade_20190808064 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int totalWeight = 0;
        
        System.out.println("********* Category Information Entry *********\n");
        
        System.out.print("Name of Category 1 :  ");
        String category1 = capitalize( scanner.nextLine() );
        
        System.out.print("Quantity of " + category1 + " : ");
        int quantity = scanner.nextInt();
        
        while ( !validQuantity(quantity) ) {
            
            System.out.print("Quantity of " + category1 + " : ");
            
            quantity = scanner.nextInt();
            
        }
        
        System.out.print("Percent of " + category1 + " : ");
        int weight = scanner.nextInt();
        
        while ( !validWeight(weight, totalWeight) ) {
            
            System.out.print("Percent of " + category1 + " : ");
            
            weight = scanner.nextInt();
            
        }
        
        totalWeight += weight;
        
        scanner.nextLine();
        
        System.out.print("Name of Category 2 :  ");
        String category2 = capitalize(scanner.nextLine());
        
        System.out.print("Quantity of " + category2 + " : ");
        int quantity2 = scanner.nextInt();
        
        while ( !validQuantity(quantity2) ) {
            
            System.out.print("Quantity of " + category2 + " : ");
            quantity2 = scanner.nextInt();
            
        }
        
        System.out.print("Percent of " + category2 + " : ");
        int weight2 = scanner.nextInt();
        
        while ( !validWeight(weight2, totalWeight) ) {
            
            System.out.print("Percent of " + category2 + " : ");
            weight2 = scanner.nextInt();
            
        }
        
        totalWeight += weight2;
        
        scanner.nextLine();
        
        System.out.print("Name of Category 3 :  ");
        String category3 = capitalize(scanner.nextLine());
        
        System.out.print("Quantity of " + category3 + " : ");
        int quantity3 = scanner.nextInt();
        
        while ( !validQuantity(quantity3) ) {
            
            System.out.print("Quantity of " + category3 + " : ");
            quantity3 = scanner.nextInt();
            
        }
        
        System.out.print("Percent of " + category3 + " : ");
        int weight3 = scanner.nextInt();
        
        while ( !validWeight(weight3, totalWeight) ) {
            
            System.out.print("Percent of " + category3 + " : ");
            weight3 = scanner.nextInt();
            
        }
        
        totalWeight += weight3;
        
        scanner.nextLine();
        
        System.out.print("Name of Category 4 :  ");
        String category4 = capitalize(scanner.nextLine());
        
        System.out.print("Quantity of " + category4 + " : ");
        int quantity4 = scanner.nextInt();
        
        while ( !validQuantity(quantity4) ) {
            
            System.out.print("Quantity of " + category4 + " : ");
            quantity = scanner.nextInt();
            
        }
        
        System.out.print("Percent of " + category4 + " : ");
        int weight4 = scanner.nextInt();
        
        while ( !validWeight(weight4, totalWeight) ) {
            
            System.out.print("Percent of " + category4 + " : ");
            weight4 = scanner.nextInt();
            
        }
        
        totalWeight += weight4;
        
        
        System.out.println("\n");
        
        
        if ( totalWeight != 100 ) {
            System.out.println("ERROR: The values sum to " + totalWeight +
                    " but should sum to 100.");
            
        } else {
            
            System.out.println("********** Student Grades Entry **********\n");
            
            double grade1 = categoryGrade ( quantity , category1 );
            double avarege1 = categoryAvarage ( grade1 , weight ) ;
            
            double grade2 = categoryGrade ( quantity2 , category2 );
            double avarege2 = categoryAvarage ( grade2 , weight2 );
            
            double grade3 = categoryGrade ( quantity3 , category3 );
            double avarege3 = categoryAvarage( grade3 , weight3 );
            
            double grade4 = categoryGrade ( quantity4 , category4 );
            double avarege4 = categoryAvarage ( grade4 , weight4 );
            
            
            double grade = avarege1 + avarege2 + avarege3 + avarege4 ;
            
            System.out.println("\n");
            
            System.out.println("*********** Student Results ***********\n");
            System.out.println(category1 + " : " + grade1);
            System.out.println(category2 + " : " + grade2);
            System.out.println(category3 + " : " + grade3);
            System.out.println(category4 + " : " + grade4);
            
            if (grade >= 0 && grade <= 100) {
                
                System.out.print("The student "+status(grade)+" CSE101 with a "+
                        "score of a " +grade+",GPA points of "+gpaPoints(grade)
                        +" and a  grade letter of " + gradeLetter(grade));
            }
            
        }
        
    }
    
    public static double categoryAvarage( double grade , int weight ){
        
        return (grade / 100) * weight;
        
    }
    
    public static double categoryGrade ( int quantity , String category ) {
        
        Scanner scanner = new Scanner (System.in) ;
        
        double totalNote =0 ;
        
        for ( int i = 0 ; i < quantity ; i++ ) {
            
            System.out.print( category + (i + 1) + " : " );
            
            double note = scanner.nextDouble();
            totalNote += note;
            
        }
        
        return totalNote / quantity ;
        
    }

    public static String status ( double total ) {

        if (total < 46 && total >= 0)
            return "failed";
        else if (total < 60)
            return "conditionally passed";
        else if (total < 100)
            return "passed";
        else
            return "";

    }

    public static double gpaPoints ( double total ) {

        if (total < 35 && total >= 0)
            return 0.0;
        else if (total < 46)
            return 0.5;
        else if (total < 53)
            return 1.0;
        else if (total < 60)
            return 1.5;
        else if (total < 67)
            return 2.0;
        else if (total < 74)
            return 2.5;
        else if (total < 81)
            return 3.0;
        else if (total < 88)
            return 3.5;
        else if (total < 100)
            return 4.0;
        else
            return 0.0;

    }

    public static String gradeLetter( double total ) {

        if (total < 35 && total >= 0)
            return "FF";
        else if (total < 46)
            return "FD";
        else if (total < 53)
            return "DD";
        else if (total < 60)
            return "DC";
        else if (total < 67)
            return "CC";
        else if (total < 74)
            return "CB";
        else if (total < 81)
            return "BB";
        else if (total < 88)
            return "BA";
        else if (total < 100)
            return "AA";
        else
            return "";
        
    }

    public static boolean validWeight ( int weight , int totalWeight ) {

        return weight >= 0 && weight + totalWeight <= 100;

    }

    public static boolean validQuantity (int quantity) {

        return quantity > 0;

    }
    
    
    public static String capitalize(String category) {
        
        return  category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
        
    }
    
}