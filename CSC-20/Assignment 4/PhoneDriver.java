/*
 * This phone driver class carry out the following operations such as creating the phone book,
 * reading data from the file ContactDetails.txt into a contact object and adds them to the phone book
 * array list. This class also prints out a menu with options.
 * @author Jomel
 * @verison 1.0.0
 */
import java.util.*;
import java.io.*;
public class PhoneDriver{

/*
 * The main driver of the phone book which carrys out the following operation
 * of creating phonebook, reading file, as well as creating a menu and printing
 * out results.
 * @throws FileNotFoundException
 */
   public static void main(String[] args) throws FileNotFoundException {
      String dataFile = "ContactDetails.txt";
      PhoneBook phoneBook = new PhoneBook();
      File fileObj = new File(dataFile);
      Scanner reader = new Scanner(fileObj);
      String inline;
      String firstName; String lastName; long homeNumber; long officeNumber; String emailAddress;
      while (reader.hasNextLine()) {
         try {
            inline = reader.nextLine();
            String tokens[] = inline.split(",");
            firstName = tokens[0];
            lastName = tokens[1];
            if (tokens[2].equals("-")) {
               homeNumber = 0;
            } else {
               homeNumber = Long.parseLong(tokens[2]);
            }
         
            if (tokens[3].equals("-")) {
               officeNumber = 0;
            } else {
               officeNumber = Long.parseLong(tokens[3]);
            }
            emailAddress = tokens[4];
            Contact newContact = new Contact(firstName, lastName, homeNumber, officeNumber, emailAddress);
            phoneBook.add(newContact);
         } catch (Exception E) {
            E.printStackTrace();
            System.out.println("There is an error with the contact");
         }
      }
      phoneBookMenu(phoneBook);
   }

/* 
 * This method prints out the phone book menu and the options.
 * @param phoneBook
 */
   public static void phoneBookMenu(PhoneBook phoneBook) {
      boolean quit = false;
      Scanner input = new Scanner(System.in);
      while (!quit) {
         System.out.println("\nPhone Book Menu Options");
         System.out.println("A. Print Phonebook");
         System.out.println("B. Sort phone book by first name");
         System.out.println("C. Sort phone book by last name");
         System.out.println("D. Search contact by last name");
         System.out.println("Q. to Quit");
         String option = input.nextLine().toLowerCase();
         switch(option) {
            case "a":
               System.out.print(phoneBook.toString());
               break;
            case "b":
               phoneBook.bubbleSort();
               System.out.print(phoneBook.toString());
               break;
            case "c":
               phoneBook.selectionSort();
               System.out.print(phoneBook.toString());
               break;
            case "d":
               System.out.print("Enter the last name to search: ");
               boolean found = phoneBook.binarySearch(input());
               if (found) {
                  System.out.println("Contact found");
               } else {
                  System.out.println("Contact not found");
               }
               break;
            case "q":
               System.out.println("Good Bye!");
               quit = true;
               return;
            default:
               System.out.println("Invalid option, try again.");
         }
      }
   }

/*
 * This is a helper method which inputs the 
 * string into binary search from the user.
 * @return input
 */
   public static String input() {
      Scanner input = new Scanner(System.in);
      return input.nextLine();
   }
}