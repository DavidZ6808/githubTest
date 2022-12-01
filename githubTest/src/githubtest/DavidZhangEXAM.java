//David Zhang
//June 20
//Final Exam - Times.txt
package davidzhangexam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class DavidZhangEXAM {


    public static void loadArray( String[][] table){
        try{
            File f = new File("src/DavidZhangEXAM/times.txt");
            Scanner s = new Scanner(f);
            for (int row = 0; row < table.length; row++){
                for (int col = 0; col < table[row].length; col++){
                    if (col == 0){
                    table[row][col] = s.nextLine();
                    }else{
                    table[row][col] = formatMinute(s.nextLine());    
                    }
                }
            }
            
            
        }catch(FileNotFoundException e){
            System.out.println("Error: "+e);
        }
    }
    
    public static String formatMinute(String minute){
        int minutes, seconds, total;
        minutes = Integer.parseInt(minute.substring(0,1));
        seconds = Integer.parseInt(minute.substring(2,4));
        total = minutes*60 + seconds;
        return total+"";
    }
    
    public static void printArray( String[][] table, String [] week){
       String finalTable = "\t\t";
       for (int i = 0; i<week.length; i++){
           finalTable += week[i] + "\t";
       }
       finalTable += "\n";
       
       for (int row = 0; row < table.length; row++){
                for (int col = 0; col < table[row].length; col++){
                    if (col == 0){
                        finalTable += table[row][col] + "\t\t";
                    }else{
                    finalTable += table[row][col] + "\t";
                    }
                }
                finalTable += "\n";
            } 
       System.out.println(finalTable);
    }
    
    
    public static void printResult(String[][] table, int day , String[] week){
        DecimalFormat whole = new DecimalFormat("#,##0");
        DecimalFormat oneD = new DecimalFormat("#,##0.0");
        int highIndex, lowIndex;
        double average; 
        double numArray[] = new double[52];
            for (int col = 0; col < numArray.length; col++){
                numArray[col] = Double.parseDouble(table[col][day]);
            }
        highIndex = highIndex(numArray);
        lowIndex = lowIndex(numArray);
        average = average(numArray);
        System.out.println(week[day-1]+"\t"+whole.format(numArray[lowIndex])+"\t\t"+whole.format(numArray[highIndex])+"\t\t"+oneD.format(average));
        
        
        
        
        
        
    } 
    
    public static int highIndex( double[] numArray){
        int highIndex = 0;
        double highNum = -1;
        for (int i = 0 ; i < numArray.length; i++){
            if (numArray[i] > highNum){
                highIndex = i;
                highNum = numArray[i];
            }
        }
        return highIndex;
        
    }

    public static int lowIndex( double[] numArray){
        int lowIndex = 0;
        double lowNum = 99999999;
        for (int i = 0 ; i < numArray.length; i++){
            if (numArray[i] < lowNum){
                lowIndex = i;
                lowNum = numArray[i];
            }
        }
        return lowIndex;
        
    }
    
    public static double average( double[] numArray){
        double sum = 0;
        for (int i = 0; i< numArray.length; i++){
            sum += numArray[i];
        }
        return sum/(numArray.length);
    }
    
    
    public static void main(String[] args) {
        System.out.println("*********************************************************************");
        System.out.println("*********************RUNNING THE RUNNING REPORT**********************");
        System.out.println("*********************************************************************");
        String table[][] = new String[52][8];
        String weekDays[] = {"Mon","Tues","Wed","Thurs","Fri","Sat","Sun"};
        loadArray(table);
        printArray(table, weekDays);
        System.out.println("***********************************************\n\t\tANALIST RESULTS\nDay\tBEST TIME\tWORST TIME\tAVG TIME\n***********************************************");
        for (int i = 1; i<8; i++){
            printResult(table, i, weekDays);
        }
        
        
        
        
    }
    
}
