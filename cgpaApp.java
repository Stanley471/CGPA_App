import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class cgpaApp {
        int n;
        int totalCredits = 0;
        double CGPA = 0;
        double weightedSum = 0;     
        char grades;
        String name,regNo;
    public static void main(String args[]) {
        //Creating objects
        Scanner stanley = new Scanner(System.in);
        DateTimeFormatter Stanf = DateTimeFormatter.ISO_LOCAL_DATE;
        FileWriter stan;
        cgpaApp stanv = new cgpaApp();
        //Creating variables
        
    
        
        //Greet message and name input
        System.out.printf("=====================%nThis is a CGPA Calculator%nWARNING!!!%nThe results of this calculation would be saved in a txt file on your computer%n--------%nDeveloped by Stanley Obimma%n");
        System.out.println("====================");
        System.out.print("Enter Your name: ");
        stanv.name = stanley.next();
        System.out.println("Enter your matric number: ");
        stanv.regNo = stanley.next();
        //Initializing n
        System.out.print("Enter number of courses: ");
        stanv.n = stanley.nextInt();
        //Creating Arrays
        double weighted[] = new double[stanv.n];
        int credits[] = new int[stanv.n];
        int gradepoints[] = new int[stanv.n]; 
        
        //Looping for user input
        for(int i=0;i<stanv.n;i++){
            System.out.println("====================");
            System.out.printf("<===Course %d===> %n",i+1);
            
            System.out.print("Enter credit: ");
            credits[i] = stanley.nextInt();
            System.out.print("Enter grade: ");
            stanv.grades = Character.toUpperCase(stanley.next().charAt(0));
            switch (stanv.grades) {
                case 'A':
                    gradepoints[i] = 5;
                    break;
                case 'B':
                    gradepoints[i] = 4;
                    break;
                case 'C':
                    gradepoints[i] = 3;
                    break;
                case 'D':
                    gradepoints[i] = 2;
                    break;
                case 'E':
                    gradepoints[i] = 1;
                    break;
                case 'F':
                    gradepoints[i] = 0;
                    break;
                default:
                    System.out.printf("Invalid grade%nPlease input details on course %d",i+1);
                    i--;
                    break;
            }
            weighted[i] = gradepoints[i] * credits[i]; 
            }
        for(double weight: weighted){
            stanv.weightedSum += weight;
        }
        for(int credit:credits){
            stanv.totalCredits += credit;
        }
        stanv.CGPA = stanv.weightedSum/stanv.totalCredits;
        System.out.println("============================");
        System.out.printf("Your CGPA is %.2f%n",stanv.CGPA);
        System.out.println("============================");
        System.out.println("Do you want to save the file?(Reply with yes or no)");
        System.out.println("============================");
        String reply = stanley.next();
        reply = reply.toLowerCase();
        //Saving File
        if("yes".equals(reply)){
        try{
            stan = new FileWriter(stanv.name+".txt");
            stan.write(String.format("==========CGPA REPORT=========%nName: %s%nMatric No.: %s%nCGPA: %.2f%n============== ", stanv.name,stanv.regNo, stanv.CGPA));
            stan.write(String.format("This result was calculated by Stanley Obimma at:%n%s", Stanf ));
            stan.close();
            System.out.printf("Result saved successfully at %s.txt",stanv.name);
        }
        catch (IOException e){
            System.out.print("File not saved");

        }
        }
        else if("no".equals(reply))
        {
            System.out.print("Thanks for using us...Goodbye!!!");
        }
       
       
        
        
    }
}
