import java.util.*;
import java.io.*;

public class PersonalityTestHelper{ 
   static final int SIZE=9;
   static final int FOUR=4;
   static final int SEVEN =7;
   static final int SEVENTY=70;

  //Creates an array and runs the methods.
   public static void runPersonalityTest() throws FileNotFoundException{
      String [] names = new String[SIZE];
      String [] responses = new String[SIZE];
      populateArray(names,responses);
      configurePersonality(names,responses);
   }
  
  //reads the txt file and puts the strings into the array
   public static void populateArray(String[] names,String [] responses) throws FileNotFoundException{
      Scanner input = new Scanner(new File("personality.txt"));
      int i=0;
      while (input.hasNextLine()) {
         names[i] = input.nextLine();
         responses[i] = input.nextLine();
         i++; 
      }
   }

 // use the names array and responses to extract for each person, the number of 'B' responses for each of the personality traits.
   public static void configurePersonality(String[] names,String []responses){
      String [] results = new String[SIZE];
      for (int i=0;i<SIZE;i++){
         int [] percentages = new int [FOUR];
         results[i]=processResponse(responses[i],percentages);
         displayResults(names[i],percentages,results[i]);
      }
   }


   public static void displayResults(String name,int [] percentages, String result){
      System.out.println(name+" : "+"["+percentages[0]+", "+percentages[1]+", "+percentages[2]+", "+percentages[3]+"]"+" = "+result);
   }

// use the percentage to determine for each personailty type, the appropriate letter
   public static String processBs(double  percentage, int typeNumber){
      if (percentage<50){
         switch (typeNumber){
            case 0: 
               return "E"; 
            case 1: 
               return "S"; 
            case 2: 
               return "T";
            case 3: 
               return "J"; 
         }
      }
      else if (percentage>50){
         switch (typeNumber){
            case 0: 
               return "I"; 
            case 1: 
               return "N"; 
            case 2: 
               return "F";
            case 3: 
               return "P"; 
         }
      }
      else if (percentage==50){
         return "X";
      }
      return null;
   }

//calculate the percentage by diving the number of 'B's by the total number of valid responses (ie A and B exclude -)
   public static double processNumbers(int numbersOfBs, int total){
      return  Math.round(100.0*numbersOfBs/(total*1.0));
   }

// take in the string containing 70 responses for a given name and calculate the percentages of 'B' for each of the 4 traits
   public static String processResponse(String response, int [] percentages){
      response=response.toUpperCase();
      int [] numbersOfB = new int[FOUR];
      double percentage=0;
      int total=0;
      
      for (int i=0;i<=SEVENTY-SEVEN;i+=SEVEN){
         if (response.charAt(i)=='B')
            numbersOfB[0]++;
         if (response.charAt(i)=='-')
            total--;
         total++;
      }
      percentage=processNumbers(numbersOfB[0],total);
      String EI = processBs(percentage, 0);
      percentages[0]= (int) percentage;
      total=0;
   
      for (int i=1;i<=SEVENTY-SEVEN+1;i+=SEVEN){
         if (response.charAt(i)=='B')
            numbersOfB[1]++;
         if (response.charAt(i)=='-')
            total--;
         if (response.charAt(i+1)=='B')
            numbersOfB[1]++;
         if (response.charAt(i+1)=='-')
            total--;
         total+=2;
      }
      percentage=processNumbers(numbersOfB[1],total);
      String SN = processBs(percentage,1);
      percentages[1]= (int) percentage;
      total=0;
   
      for (int i=3;i<=SEVENTY-SEVEN+3;i+=SEVEN){
         if (response.charAt(i)=='B')
            numbersOfB[2]++;
         if (response.charAt(i)=='-')
            total--;
         if (response.charAt(i+1)=='B')
            numbersOfB[2]++;
         if (response.charAt(i+1)=='-')
            total--;
         total+=2;
      }
      percentage=processNumbers(numbersOfB[2],total);
      String TF = processBs(percentage,2);
      percentages[2]= (int) percentage;
      total=0;
   
      for (int i=5;i<=SEVENTY-SEVEN+5;i+=SEVEN){
         if (response.charAt(i)=='B')
            numbersOfB[3]++;
         if (response.charAt(i)=='-')
            total--;
         if (response.charAt(i+1)=='B')
            numbersOfB[3]++;
         if (response.charAt(i+1)=='-')
            total--;
         total+=2;
      }
      percentage=processNumbers(numbersOfB[3],total);
      String JP = processBs(percentage,3);
      percentages[3]= (int) percentage;
      total=0;
   
      String personality=EI+SN+TF+JP;
      return personality;
   }

}