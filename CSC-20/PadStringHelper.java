/*
Name: Jomel Sotelo
Title: Lab 6
*/
import java.util.*;
public class PadStringHelper{
public static void padString(){
   String word = getInputString();
   int length = getInputLength();
   String result = calculateResult(word, length);
   System.out.println("The resulting string is " + result);
}
public static String getInputString(){
   Scanner input = new Scanner(System.in);
   System.out.print("Please enter a string ");
   String word = input.nextLine();
   return word;
   }
public static int getInputLength(){
   Scanner input = new Scanner(System.in);
   System.out.print("Please enter the length of the result string ");
   int length = input.nextInt();
   return length;
   }
public static String calculateResult(String word, int length){
   int wordLength = word.length();
   for (int space = 1; space <= length - wordLength; space++) {
        word = "-" + word;
   }
   return word;
   }
}