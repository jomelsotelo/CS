/*
Name: Jomel Sotelo
Date: 9/24/2021
Title: Lab 4
*/

public class SongSotelo{
   public static final int bottles = 10;
   
   public static void lyrics(){
   int temp;
   int result = bottles;
      for(int i=bottles; i>1; i--){
         System.out.println(i+" bottles of the Juice on the wall, "+i+" bottles of juice");
       temp=i;
       temp--;
         System.out.println("Take one down and pass it around, "+temp+" bottles of juice on the wall.");
      }
      //last 3 lines
      System.out.println("1 bottles of the Juice on the wall, 1 bottles of juice");
      System.out.println("Take one down and pass it around, no more bottles of juice on the wall.");
      result--;
      System.out.println("Go to the store and buy some more, "+result+" bottles of juice on the wall.");
   }
   //calls lyrics method
   public static void main(String[] args){
   lyrics();
   }
}