import java.util.*;
/*
 * This is a helper class which creates a menu for user to interact with a train.
 * It as multiple options the user can choose from and calls on method from the Train.java 
 * to execute these methods.
 * @author Jomel
 * @verison 1.0.0
 */

public class TrainHelper {
   private static Scanner scan;
   private static Train train;
   
/*
 * Method that creates the menu in which the user can enter the options
 * and should call a certain method based on the options.
 * @throws InputMismatchException
 */
	public static void trainMenu() {
      train = new Train("car.txt");
      scan = new Scanner(System.in);
      boolean running = true;
      
      while(running){
      menu();
      System.out.println("Please Enter your choice: ");
      String choice = scan.nextLine().toUpperCase();
      
      switch(choice){
      case "A":
      createCar();
      break;
      case "R":
      delete();
      break;
      case "D":
      train.displayTrainCars();
      break;
      case "S":
      search();
      break;
      case "M":
      merge();
      break;
      case "Q":
      running = false;
      break;
      default:
      throw new InputMismatchException("\nIncorrect Input.\n");
      }

      }
      System.out.println("Good Bye!");
	}
   
/*
 * Method which prints out the types of options.
 */
   public static void menu(){
      System.out.println("Train Depot Menu Options");
      System.out.println("Enter A to Attach a train car");
      System.out.println("Enter R to Detach car at factory");
      System.out.println("Enter D to Display all the train cars");
      System.out.println("Enter S to Search a train car");
      System.out.println("Enter M to Merge two train cars");
      System.out.println("Enter Q to Quit");
   }
   
/*
 * Method which displays the existing cars 
 * and the new cars and calls on the displayTrainCars in the train class.
 */
   public static void merge(){
   System.out.println("\nDisplaying The Existing Cars");
   train.displayTrainCars();
   System.out.println("\nDisplaying The New Cars");
   train.merge("update.txt");
   }
   
/*
 * Method which tells the user to enter the factory name
 * and searches the factory name through the method search in the Train Class.
 */
   public static void search(){
   System.out.print("\nEnter The Factory Name You Want to Search: ");
   String facName = scan.nextLine();
   System.out.println();
   train.search(facName);
   }
   
/*
 * Method which ask the users for the factory name to delete,
 * and calls a Train Class method to find the Cars with factory name and deletes them.
 */
   public static void delete(){
     System.out.print("\nPlease enter the Factory Name you wish to Detach: ");
     String name = scan.nextLine();
     System.out.println();
     train.detach(name);
   }
   
/*
 * Method which asks the user for a factory name, stop number, 
 * and mateiral, and creates the car.
 */
   public static void createCar(){
   String factory, stop, material;
   System.out.print("\nPlease enter the Factory Name: ");
   factory = scan.nextLine();
   System.out.print("Please enter the Stop Number: ");
   stop = scan.nextLine();
   System.out.print("Please enter the Material Name: ");
   material = scan.nextLine();
   System.out.println("\nAdding a new car - "+factory+" "+stop+" "+material+"\n");
   }
}
