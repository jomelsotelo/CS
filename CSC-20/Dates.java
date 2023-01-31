/*
Name: Jomel Sotelo
Title: Lab 7
*/
import java.util.*;

public class Dates{

public static void main(String[] args){
//declare variables
int month,day,year;
Scanner input = new Scanner(System.in);
System.out.println("Enter month, day and year");

//input and stores month,day, year
month = input.nextInt();
day = input.nextInt();
year = input.nextInt();

//checks if Valid
dateValid(dayValid(day,daysInMonth(month)), monthValid(month), yearValid(year), isLeapYear(year));
}

public static void dateValid(boolean dayValid, boolean monthValid, boolean yearValid, boolean isLeapYear){
   if(dayValid && monthValid && yearValid){
   System.out.println("Date is valid");
      if(isLeapYear){
         System.out.println("year is leap year");
      }
   }
   else{
      System.out.println("Date is invalid");
   }
}

public static int daysInMonth(int month){
   if(month==2){
      return 28;
   }
   else if(month==4 || month==6 || month==9 || month==11){
      return 30;
   }
   else{
      return 31;
   }
}

public static boolean dayValid(int day, int daysInMonths){
   boolean dayValid;
   if(day <= daysInMonths){
   dayValid = true;
   }
   else{
   dayValid = false;
   }
   return dayValid;
}

public static boolean monthValid(int month){
   boolean monthValid;
   if(month >=1 && month <= 12){
   monthValid = true;
   }
   else{
   monthValid = false;
   }
   return monthValid;
}

public static boolean yearValid(int year){
   boolean yearValid;
   if(year >= 1000 && year <= 1999){
   yearValid = true;
   }
   else{
   yearValid = false;
   }
   return yearValid;
}

public static boolean isLeapYear(int year){
   if(year%4==0){
      if(year%100==0){
         if(year%400==0){
            return true;
         }
         else{
            return false;
         }
      }
      else{
      return true;
      }
   }
   else{
      return false;
   }

}

}