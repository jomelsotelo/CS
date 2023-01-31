/*
Name: Jomel Sotelo
Title: Programming Assignment 4
*/
import java.util.*;

public class BudgeterHelper{

//this method calculate the budget
public static void calculateBudget(){
   Scanner kb = new Scanner(System.in);
   displayOpeningMessage();
   double income = getTotalIncome(kb);
   int month = promptWhichMonth(kb);
   int days = daysInMonth(month);
   double expenses = getTotalExpenses(kb,days);
   displayTotalIncomeAndExpenses(income,expenses,days);
   double netIncome = calculateNetIncome(income,expenses);
   displayOutput(netIncome);
}

//this method displays a message and explains the program
public static void displayOpeningMessage(){
   System.out.println("This program asks for your monthly income and expenses, then tells you your net monthly income");
   System.out.println();
}

//this method asks user and returns month
public static int promptWhichMonth(Scanner kb){
   System.out.print("What is the month number? ");
   int month = kb.nextInt();
   return month;
}

//this method calcualtes the days in a month
public static int daysInMonth(int month){
switch(month){
case 2:
   return 28;
case 4:
   return 30;
case 6:
   return 30;
case 9:
   return 30;
case 11:
   return 30;
default:
   return 31;
}

}

//this method gets the total income from the user
public static double getTotalIncome(Scanner kb){
   System.out.print("How many categories of income? ");
   int count = kb.nextInt();
   double totalIncome = 0;
   for(int i=1; i<=count; i++){
      System.out.print("Next Income Amount? ");
      totalIncome += kb.nextDouble();
   }
   totalIncome = (double)Math.round(totalIncome*100.0)/100.0;
   return totalIncome;
}

//this method gets the total expeneses from the user
public static double getTotalExpenses(Scanner kb, int days){
   System.out.print("Enter 1 for montly or 2 for daily expenses ");
   int option = kb.nextInt();  
   System.out.print("How many categories of expenses? ");
   int count = kb.nextInt();
   double totalExpenses = 0;
   for(int i=1; i<=count; i++){
   System.out.print("Next Expense Amount? ");
      totalExpenses += kb.nextDouble();
   }
   if(option==2){
      totalExpenses *= days;
   }
   totalExpenses = (double)Math.round(totalExpenses*100.0)/100.0;
   return totalExpenses;
}

//this method displays the total income and total expenses
public static void displayTotalIncomeAndExpenses(double income, double expenses, int days){
   double perDayIncome = (income/days);
   perDayIncome = (double)Math.round(perDayIncome*100.0)/100.0;
   double perDayExpenses = (expenses/days);
   perDayExpenses =  (double)Math.round(perDayExpenses*100.0)/100.0;
   System.out.println("Total Income = "+income+"("+perDayIncome+" per day)");
   System.out.println("Total Expenses = "+expenses+"("+perDayExpenses+" per day)");
}

//this method calculates the net income
public static double calculateNetIncome(double income, double expenses){
   double netIncome = (income - expenses);
   netIncome = (double)Math.round(netIncome*100.0)/100.0;
   return netIncome;
}

//this method displays the net income
public static void displayOutput(double netIncome){
   if (netIncome>0){
      System.out.println("You earned "+netIncome+" more than you spent this month");
      System.out.println("You're a big saver");
}
else if(netIncome<0){
   netIncome = Math.abs(netIncome);
   System.out.println("You spent "+netIncome+" more than you earned this month");
   System.out.println("You're a big spender");
}
}

}
