import java.io.*;
import java.util.Scanner;

/**
 * @author Ali Çolak
 * 07.01.2020
 */
public class CourseGrade_20190808064 {
    
    public static void main(String[] args) {
        
        String fileName = args[0]+"_CourseDetails.txt";
        String fileName2 = args[0]+"_StudentScores.txt";
        
        int categoryCount = countCategory(fileName);
        
        String[] categories = new String[categoryCount];
        
        int[] quantities = new int[categoryCount];
        
        int[] weights = new int[categoryCount];
        
        getCategory(categories, quantities, weights, fileName);
        
        int totalWeight = 0;
        
        boolean condition = true;
        
        for ( int quantity : quantities ) {
            
            if ( quantity <= 0 ) {
                
                try (PrintWriter writer = new PrintWriter(new FileWriter
                        (args[0]+"_log.txt",true))) {
                    
                    writer.write("ERROR: Course details - invalid quantity" +
                            " -does not quantity value be negative\n");
                    
                    condition=false;
                    
                } catch (IOException e) {
                    
                    e.printStackTrace();
                    
                }
                
            }
            
        }
        
        for ( int weight : weights ) {
            
            if (weight < 0) {
                
                try (PrintWriter writer = new PrintWriter(new FileWriter
                        (args[0]+"_log.txt",true))) {
                    
                    writer.write("ERROR: Course details - invalid weight" +
                            " - does not weight value be negative\n");
                    
                    condition=false;
                    
                } catch (IOException e) {
                    
                    e.printStackTrace();
                    
                }
                
            }
            
            totalWeight += weight;
            
        }
        
        if (totalWeight != 100) {
            
            try (PrintWriter writer = new PrintWriter(new FileWriter
                    (args[0]+"_log.txt",true))) {
                
                writer.write("ERROR: Course details - invalid weight" +
                        " - does not sum to 100 \n");
                
                condition=false;
                
            } catch (IOException e) {
                
                e.printStackTrace();
                
            }
            
        }
        
        if(!condition) 
            System.exit(1);
        
        
        int studentCount = countCategory(fileName2);
        
        int count = 0;
        
        String [] students = new String[studentCount];
        double [] grades = new double[studentCount];
        
        File file = new File(fileName2);
        
        try {
            
            Scanner reader = new Scanner(file);
            
            outLoop:
            while ( reader.hasNextLine() ) {
                
                String line = reader.nextLine();
                
                String [] array = line.split(" ");
                
                students[count] = array[0];
                
                double note = 0;
                int count2 = 0;
                int count3 = 0;
                
                for ( int k = 0 ; k < categoryCount ; k++ ) {
                    
                    count3 += quantities[k];
                    
                }
                
                if ( count3 != ( array.length - 1 ) ) {
                    
                    grades[count] = -1;
                    
                    count++;
                    
                    continue outLoop;
                    
                }
                
                for ( int i = 0 ; i < categoryCount ; i++ ) {
                    
                    double catnote = 0;
                    
                    for ( int j = 0 ; j < quantities[i] ; j++ ) {
                        
                        double tempNote = Double.parseDouble(array[count2 + 1]);
                        
                        if ( tempNote < 0 || tempNote > 100 )  {
                            
                            grades[count] = -1;
                            
                            count++;
                            
                            continue outLoop;
                            
                        }
                        
                        catnote += tempNote;
                        
                        count2++;
                        
                    }
                    
                    note += ( ( catnote / quantities[i] ) / 100 ) * weight[i] ;
                    
                }
                
                grades[count] = note;
                
                count++;
                
            }
            
            reader.close();
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
            
        }
        
        writeGrades( students , grades , args[0] );
        
    }
    

    public static void writeGrades( String[] students, double[] grades,
                                   String basefileName) {
        
        for ( int i = 0 ; i < students.length ; i++ ) {
            
            if ( grades[i] != -1 ) {
                
                try (PrintWriter writer = new PrintWriter(new FileWriter
                        (basefileName+"_StudentGrades.txt",
                                true))) {
                    
                    writer.write(students[i] + " " + grades[i] + " "
                            + gradeLetter(grades[i]) + " " + gpaPoints(grades[i])
                            + " " + status(grades[i]) + "\n");
                    
                } catch ( IOException e ) {
                    
                    e.printStackTrace();
                    
                }
                
            }
            
            if ( grades[i] == -1 ) {
                
                try {
                    
                    PrintWriter writer = new PrintWriter(new FileWriter
                            (basefileName+"_log.txt", true));
                    
                    writer.write("Error: Student " + students[i] + " - " +
                            "cannot calculate due to invalid grade entered\n");
                    
                    
                    writer.close();
                    
                } catch ( IOException e ) {
                    
                    e.printStackTrace();
                    
                }
                
            }
            
        }
        
    }

    public static void getCategory ( String[] categories , int[] quantities ,
                                   int[] weights , String fileName) {
        
        int index = 0;
        
        File file = new File(fileName);
        
        try {
            
            Scanner reader = new Scanner(file);
            
            while ( reader.hasNextLine() ) {
                
                String line = reader.nextLine();
                
                String[] array = line.split(" ");
                
                categories[index] = array[0];
                quantities[index] = Integer.parseInt(array[1]);
                weights[index] = Integer.parseInt(array[2]);
                
                index++;
                
            }
            
            reader.close();
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
            
        }
        
    }
    

    public static int countCategory( String fileName ) {
        
        int counter = 0;
        
        File file = new File(fileName);
        
        try {
            
            Scanner reader = new Scanner(file);
            
            while (reader.hasNextLine()) {
                
                reader.nextLine();
                counter++;
                
            }
            
            reader.close();
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
            
        }
        
        return counter;
        
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
    
}
