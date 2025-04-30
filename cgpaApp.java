package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class Main{
    static Scanner Stan = new Scanner(System.in);
    static FileWriter Stanf;
    static int option,n, i,credits[];
    static String name, regNo, reply;
    static char grades;
    static double gradepoints[], weighted[],weightedSum,CGPA,totalCredits;
    static boolean hasData = false;
    public static void main(String[] args) {
        System.out.printf("Welcome to Stanley's CGPA calculator%n=======************======%nSelect from one of the options below%n");
        do {
            System.out.println("=======************======");
            System.out.println("1. Calculate CGPA");
            System.out.println("2. Export CGPA to file");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            option = Stan.nextInt();
            switch (option) {
                case 1:
                    CalculateCGPA();
                    break;
                case 2:
                    exportFile();
                    break;
                case 3:
                    System.out.println("Goodbye from Stanley");
                    break;
                default:
                    System.out.println("Invalid input pls try again");
            }
        } while (option != 3);

    }
    static void CalculateCGPA(){
        System.out.print("Enter Your name: ");
        name = Stan.next();
        System.out.print("Enter your matric number: ");
        regNo = Stan.next();
        System.out.print("Enter number of courses: ");
        n = Stan.nextInt();
        weighted = new double[n];
        credits = new int[n];
        gradepoints = new double[n];
        loopInput();
        for(double weight: weighted){
            weightedSum += weight;
        }
        for(int credit:credits){
            totalCredits += credit;
        }
        CGPA = weightedSum/totalCredits;
        System.out.println("============================");
        System.out.printf("Your CGPA is %.2f%n",CGPA);
        System.out.println("============================");
        hasData = true;
    }
    static void loopInput() {
        for (i = 0; i < n; i++) {
            System.out.println("====================");
            System.out.printf("<===Course %d===> %n", i + 1);

            System.out.print("Enter credit: ");
            credits[i] = Stan.nextInt();
            System.out.print("Enter grade: ");
            grades = Character.toUpperCase(Stan.next().charAt(0));
            calGrades();
            weighted[i] = gradepoints[i] * credits[i];
        }
    }
    static void calGrades(){
        switch (grades) {
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
                System.out.printf("Invalid grade%nPlease input details on course %d", i + 1);
                i--;
                break;
        }
    }
    static void exportFile(){
        if(hasData){
            try{
                Stanf = new FileWriter(name+".txt");
                Stanf.write(String.format("==========CGPA REPORT=========%nName: %s%nMatric No.: %s%nCGPA: %.2f%n============== ", name,regNo,CGPA));
                Stanf.write(String.format("This result was calculated by Stanley Obimma at:%n%s", Stanf ));
                Stanf.close();
                System.out.printf("Result saved successfully at %s.txt",name);
            }
            catch (IOException e){
                System.out.print("File not saved");

            }
        }
        else
        {
            System.out.println("No data to export!!!");
        }
    }
}
