/*
Name: Jomel Sotelo
Title: 
*/
import java.util.*;

public class GuessTheNumberHelper{

//method which runs the game
public static void playGame(){
Scanner input = new Scanner(System.in);
boolean play = true;
while(play == true){
   Random number = new Random();
   int secretNumber = number.nextInt(100)+1;
   int numberOfTries = 0;
   boolean gameOver = false;
   while(gameOver == false){
   System.out.println("Enter a guess (1-100):");
      int guess = input.nextInt();
         if(guess < 1 || guess > 100){
            System.out.println("Invalid input.");
         }
         else if(guess > secretNumber){
            System.out.println("too high");
         }
         else if(guess < secretNumber){
            System.out.println("too low");
         }
         else if(guess == secretNumber){
            System.out.println("You Guessed It!");
            gameOver = true;
         }
      numberOfTries++;
}
System.out.println("Number of Tries "+numberOfTries);
System.out.println("Would you like to play again? Enter Y or N:");
input.nextLine();
String playAgain = input.nextLine();
play = playAgain(playAgain);
}
}

//method that reads users input to play or stop the game
public static boolean playAgain(String play){
if(play.equals("Y") || play.equals("y")){
return true;
}
else{
return false;
}
}

}