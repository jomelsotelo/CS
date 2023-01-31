/*
 * This is a phone directory program that reads names and phone numbers 
 * from a file called names.txt and stores them in a HashMap data structure.
 * @author Jomel
 * @version 1.0 March 2022
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Directory{
   public static HashMap<String, String> directory = new HashMap<String, String>();

/*
 * A class constructor that reads names and numbers from the file into the Hashmap called directory.
 * @param names
 */
   public Directory(String names) throws FileNotFoundException{ 
      String line;
      File file = new File(names);
      Scanner input = new Scanner(file);
      while(input.hasNextLine()){
         line = input.nextLine();
         String tokens[] = line.split(":"); 
         directory.put(tokens[0],tokens[1]);
      }
   }
   
/*
 * A method that gets the number from the given name otherwise return null.
 * Returns the value from the key in directory.
 * @param name
 */
   public String getPhoneNumber(String name){
      if(directory.containsKey(name)){
         return directory.get(name);
      }
      else{
         return "";
      }
   }
   
/*
 * Removes a directory entry.
 * @param name
 */
   public void delete(String name){ 
      directory.remove(name);
      System.out.println(name+" Removed");
   }
   
/*
 * Adds given name and number in the directory.
 * @param name
 * @param number
 */
   public void add(String name, String number){
      directory.put(name, number);
      System.out.println("Adding   "+name+" "+number);
   }
   
/*
 * Changes the number in the directory and replaces it with a new one.
 * @param name
 * @param number
 */
   public void change(String name, String number){ 
      directory.replace(name, number);
      System.out.println("Changing "+name+" "+number);
   }
   
/*
 * Prints out the name(key) and number(values) in the directory.
 */
   public void displayDirectory(){
      String key;
      String value;
      for(String i: directory.keySet()){
         key = i;
         value = directory.get(i);
         System.out.printf("%-15s%15s%3s\n",key,value,"i");
      }
   }

}

