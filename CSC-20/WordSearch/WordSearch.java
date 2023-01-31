import java.util.*;
import java.io.*;

public class WordSearch{

   public static void main(String [] args){
      String [] needles = new String[6];
      String [] haystack = new String[8];
      fillArray(needles,haystack);
      Arrays.sort(needles);
      searchNeedle(needles,haystack);
   }
         
   public static void fillArray(String[] needles, String[] haystack){
      try{
         Scanner input = new Scanner(new File(C:\Users\Saviour\Desktop\Java Programs\WordSearch));
         while(input.hasNextLine()){
            int index = 0;
            while(index < needles.length){
               needles[index] = input.nextLine();
               index++;
            }
            index=0;
            input.nextLine();
            while(index < haystack.length){
               haystack[index] = input.nextLine();
               index++;
            }
         }
      }
      catch(FileNotFoundException e){
         System.out.println("Error: Data file Not Found");
      }
   }

   
   public static void searchNeedle(String[] needles, String[] haystack){
      for(int i=0; i<needles.length; i++){
         int counter = 0;
         int row = 0;
         int column = 0;
      
         for(int r=0;r<haystack.length;r++){
            int found = haystack[r].indexOf(needles[i]);
            if(found>=0){
               row=r;
               column=found;
               counter++;
            }
         }
      
         if(counter==1){
            print(needles[i],row+1,column+1);
         }
         else if(counter==0){
            System.out.println("*"+needles[i]+" was not found*");
         }
      
      }
   }

   public static void print(String word, int row, int column){
      System.out.println("word \""+word+"\" was found at row "+row+" and column "+column+".");
   }

}