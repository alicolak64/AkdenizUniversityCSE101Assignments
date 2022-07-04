/*
 * @author Ali Çolak
 * 17.12.2020
 */

import java.util.Scanner;

public class CourseGrade_20190808064 {

    public static void main(String[] args) {
        
        String[] category = {"QUIZ", "homework", "Midterm", "FiNaL"};
        int[] quantity = {4,3,1,1};
        int[] weight = {10, 20, 30,40};
        
        
        courseGrade(category, quantity, weight);
        
    }
    

    public static int displayMenu(String[] menu, Scanner a) {
        
        System.out.println("Please enter a choice below : ");
        
        for (String x : menu)
            System.out.print(x);
        
        return a.nextInt();
        
    }

    public static void courseGrade(String[] category,int[]quantity,int[]weight){
        
        int totalWeight = 0;
        
        for (int i : quantity) {
            
            if (!validQuantity(i)) {
                
                System.out.println("ERROR : Invalid quantity entered ");
                
                System.exit(1);
                
            }
            
        }
        
        for (int i : weight) {
            
            if (!validWeight(i, totalWeight)) {
                
                System.out.println("ERROR : Invalid weight entered ");
                
                System.exit(1);
                
            } else
                totalWeight+=i;
            
        }
        
        if (totalWeight != 100) {
            
            System.out.println("ERROR : Invalid weight entered ");
            
            System.exit(1);
            
        }
        
        Scanner scanner = new Scanner(System.in);
        
        double totalNote ;
        double[][] categoryNote = new double[category.length][];
        
        for ( int i = 0 ; i < category.length ; i++ ) {
            
            double [] tempArray = new double[quantity[i]];
            
            for ( int j = 0 ; j < quantity[i] ; j++ ) {
                
                double note =0;
                tempArray[j] = note;
                
            }
            
            categoryNote[i] = x;
            
        }
        
        double[] categoryNoteSum = new double[category.length];
        double[] averages = new double[category.length];
        
        String[] menu = {"1 - Enter all grades \n", "2 - Change a single " +
               "grade\n" , "3 - Display grade information\n" , "0 - to Exit\n"};
        
        capitalize(category);
        
        System.out.println("Welcome to our university grade system. ");
        
        int selectedOption;
        
        do {
            
            selectedOption = displayMenu(menu, scanner);
            
            if ( selectedOption == 1 ) {
                
                for ( int i = 0 ; i < category.length ; i++ ) {
                    
                    double [] tempArray = new double[quantity[i]];
                    
                    for ( int j = 0; j < quantity[i] ; j++ ) {
                        
                        System.out.print("Please enter grade for " + category[i]
                                + " " + (j + 1) + " >>");
                        
                        double note = scanner.nextDouble();
                        
                        tempArray[j] = note;
                        
                    }
                    
                    categoryNote[i] = tempArray;
                    
                }
                
            } else if (selectedOption == 2) {
                
                System.out.println("Please enter the category : ");
                
                for ( int i = 0 ; i < category.length ; i++ )
                    System.out.println((i + 1) + " - " + category[i]);
                
                System.out.println("0 - to Exit ");
                
                int selectedCategory = scanner.nextInt();
                
                if (selectedCategory > 0 && selectedCategory <= category.length) {
                    
                    System.out.print("Please enter which " + category[x - 1] +
                            " " +"you would like to change" + " " + "(1-" +
                            categoryNote[x - 1].length + ") >>");
                    
                    int selectedNote = scanner.nextInt();
                    
                    if ( selectedNote >= 1 && selectedNote <= categoryNote[x - 1].length ) {
                        
                        System.out.println("The current grade for " + category
                                [x - 1] + " " + y + " is " + categoryNote[x - 1]
                                [y - 1]);
                        
                        System.out.print("Please enter the new grade value " +
                                ">> ");
                        
                        double note = scanner.nextDouble();
                        
                        categoryNote[x - 1][y - 1] = note;
                        
                    } else
                        System.out.println("Invalid choice");
                    
                } else if ( x != 0 )
                    System.out.println("Invalid choice");
                
            } else if ( selectedOption == 3 ) {
                
                totalNote = 0;
                
                average(category,categoryNote,quantity,
                        categoryNoteSum,averages);

                for ( int i = 0 ; i < category.length ; i++ )
                    totalNote += (averages[i] / 100) * weight[i];
                
                System.out.println("Category Information : ");
                
                for ( int i = 0; i < category.length ; i++ )
                    System.out.println(category[i] + " : " + averages[i]);
                
                System.out.println("Overall Grade : " + totalNote);
                System.out.println("Grade Letter : " + gradeLetter(totalNote));
                System.out.println("GPA Points : " + gpaPoints(totalNote));
                System.out.println("Status : " + status(totalNote));
                
            } else if (selectedOption == 0) {
                
                System.out.println("Thank you for using our system.Have a " +
                        "nice day.");
                
            } else
                System.out.println("Invalid choice ");
            
        } while (selectedOption != 0);
    }

    public static void average(String [] category ,double[][] categoryNote,
                               int [] quantity,
                               double [] categoryNoteSum,double []averages) {
        
        for ( int i = 0 ; i < category.length ; i++ ) 
            categoryNoteSum[i] = 0;
        
        for ( int i = 0 ; i < category.length ; i++ ) {
            
            for (double note : categoryNote[i]) {
                
                categoryNoteSum[i] += note;
            }
            
            averages[i] = categoryNoteSum[i] / quantity[i];
        }
        
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
    

    public static void capitalize ( String[] array ) {
        
        for (int i = 0; i < array.length; i++) {
            
            array[i] = array[i].substring(0, 1).toUpperCase() +
                    array[i].substring(1).toLowerCase();
            
        }
        
    }
    
}