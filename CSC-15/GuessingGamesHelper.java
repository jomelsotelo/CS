/*
Name: Jomel Sotelo
Title: Programming Asssignment 5
*/
import java.util.*;

public class GuessingGamesHelper{

//method collects the statistics and calls the printStatistics method after all the games are played
   public static void playGuessingGames(){
   
      Scanner input = new Scanner(System.in);
      Random r = new Random();
      int max = 100;
      
      int numOfGames = 0;
      int totalGuesses = 0;
      int bestGame=Integer.MAX_VALUE;
      
      boolean newGame = true;
      while(newGame==true){
         numOfGames++;
         int gameGuess = playGame(input, r, max);
         totalGuesses += gameGuess;
         newGame = playAgain(input);
         bestGame = Math.min(bestGame, gameGuess);
                  
      }
      printStatistics(numOfGames, totalGuesses, bestGame);
   }

//method which plays a single game and returns the number of guesses in the game
   public static int playGame(Scanner input, Random r, int max){
         System.out.println("I'm thinking of a number between 1 and "+max+"...");
         int randomNumber = r.nextInt(max)+1;
         boolean play = true;
         int numOfGuesses = 0;
         while(play==true){
         System.out.print("Your guess? ");
         int guess = input.nextInt();
         input.nextLine();
         
         if(guess < 1 || guess > 100){
            display("Invalid input.");
         }
         else if(guess > randomNumber){
            display("It's lower.");
            numOfGuesses++;
         }
         else if(guess < randomNumber){
            display("It's higher.");
            numOfGuesses++;
         }
         else if(guess == randomNumber){
            numOfGuesses++;
            if (numOfGuesses == 1) {
               System.out.println("You got it right in " + numOfGuesses + " guess!");
            } 
            else{
               System.out.println("You got it right in " + numOfGuesses + " guesses!");
            }  
            play = false;
            }
         }
      return numOfGuesses;
   }
//method prints the final statistics after all the games are played
   public static void printStatistics(int numOfGames, int totalGuesses,int bestGame){
      System.out.println("Overall results:");
      System.out.println("Total games = "+numOfGames);
      System.out.println("Total guesses = "+totalGuesses);
      double value = (double)totalGuesses/numOfGames;
      value = Math.round(value*10.0)/10.0;
      System.out.println("Guesses/game = "+value);
      System.out.println("Best game = "+bestGame);
   }
//method prints the given message
   public static void display(String message){
      System.out.println(message);
   }
//method gets the user response to play again or finish
   public static boolean playAgain(Scanner input){
      System.out.print("Do you want to play again? ");
      char response = getAnswer(input);
      
      if(response=='y'){
         return true;
      }
      else{
         return false;
      }
      
   }
//method gets a string input from user and return first character in lowercase
   public static char getAnswer(Scanner input){
      String response = input.next();
      char character = response.charAt(0);
      character = Character.toLowerCase(character);
      return character;
   }
}