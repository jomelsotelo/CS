import java.io.*;
import java.util.*;
/*
 * The Train class uses the Car class to work and manage the train linked list. This class
 * has multiple methods which allows to attach or detach a train Car object. The user is also
 * able to display the current train and search using factory name. There is a sort method to 
 * organize the cars based on their stops. The merge method will take a file with additional factories
 * and will be added to the Train object.
 * @author Jomel
 * @verison 1.0.0
 */

public class Train {
   private Car front;

/*
 * Initializes a Train object that sets the beginning of the Train to null.
 */
   public Train(){
      this.front=null;
   }
   
/*
 * Initializes a Train object while taking a String parameter which is the name of the file.
 * This will reads each train car details from the file into the LinkedList.
 * @param carFile
 */
   public Train(String carFile){
      Scanner file = null;
      try{
         file = new Scanner(new File(carFile));
      }
      catch(FileNotFoundException e){
         System.out.println("\nFile Was Not Found!\n");
      }
      String [] info;
      String line;
      while(file.hasNextLine()){
         line = file.nextLine();
         info = line.split(",");
         attach(info[0],Integer.valueOf(info[1]),info[2]);
      }
   
      file.close();
      sort();
   }
 
/*
 * This method removes a car given factoryName.
 * This should delete the node in the LinkedList. 
 * @param factoryName
 */
   public void detach(String factoryName) {
      if(this.front == null){
         return;
      }
      Car current = this.front, prev = null;
      if(current !=null && current.factory.equalsIgnoreCase(factoryName)){
         this.front = front.next;
         return;
      }
      while(current != null && current.factory != factoryName){
         prev = current;
         current = current.next; 
      }
      prev.next = current.next;
      detach(factoryName);
   }

/*
 * This method takes three of the parameters and reads through 
 * the list and add a new car(node) to the LinkedList.
 * @param factoryName
 * @param stopNumber
 * @param mateiralName
 */
   public void attach(String factoryName, int stopNumber, String materialName) {
      if(this.front == null){
         this.front = new Car(factoryName, stopNumber, materialName);
      }
      else{
         Car current = this.front;
         while(current.next != null){
            current = current.next;
         }
         current.next = new Car(factoryName, stopNumber, materialName);
      }
      sort();
   }

/*
 * This method searches for cars that correspond the given factory name. It will then loop
 * through every item until it finds the Car with the factory name.
 * @param factoryName
 */
   public void search(String factoryName) {
      List<String> cars = getCars(factoryName);
      StringBuilder material = new StringBuilder();
      for(String a : cars){
         material.append(" ").append(a);
      }
      System.out.println("The material in the car is "+material);
   }

/*
 * This method takes a String factory name as parameter. A while loop is used to iterate
 * through the list and locate all of the Cars until it finds one with the factory name. The Cars 
 * material should be returned in a list if found.
 * @param factoryName
 */       
   public List<String> getCars(String factoryName) {
      List<String> car = new LinkedList<>();
      Car current = this.front;
      if(current.factory.equalsIgnoreCase(factoryName)){
      car.add(current.material);
      }
      for(; current.next!=null; current=current.next){
         if(current.factory.equalsIgnoreCase(factoryName)){
            car.add(current.material);
         }
      }
      return car;
   }

/*
 * This method displays all the train cars in sorted order.
 */ 
   public void displayTrainCars() {
      sort();
      Car current = this.front;
      if(this.front == null){
         System.out.println("\nThis Trains Is Empty\n");
         return;
      }
      while(current.next != null){
         String factory = current.factory;
         int stop = current.stop;
         String material = current.material;
         System.out.printf("%-15s%10s%10s\n",factory,stop,material);
         
         current = current.next;
      }
   }
  
/*
 * This method reads from update.txt and merges it with the new train car. 
 * Merge two LinkedLists and should maintain the sorted order.
 * @param update
 */
   public void merge(String update) {
      Scanner file = null;
      String[] info = null;
      String displayNew = null;
      String line = null;
   
      try{
         file = new Scanner(new File(update));
      }
      catch(FileNotFoundException e){
         System.out.println("File Was Not Found!");
      }
      while(file.hasNextLine()){
         line = file.nextLine();
         info = line.split(",");
         attach(info[0],Integer.valueOf(info[1]),info[2]);
      }
      System.out.println();
      sort();
   }
   
/*
 * A method which sort the Train linked list for ease of understanding the information 
 * and organization. Uses index temp Car object which is used to compare the stop values
 * of the Cars in the list.
 */
   public void sort(){
      Car current = this.front, index = null;
      int temp;
      String tempFactory, tempMaterial;
   
      if(this.front == null){
         return;
      }
      else{
         while(current !=null){
            index = current.next;
            while(index != null){
               if(current.stop>index.stop){
                  temp = current.stop;
                  tempFactory = current.factory;
                  tempMaterial = current.material;
               
                  current.stop = index.stop;
                  current.factory = index.factory;
                  current.material = index.material;
               
                  index.stop = temp;
                  index.factory = tempFactory;
                  index.material = tempMaterial;
               }
               index = index.next;
            }
            current = current.next;
         }
      }
   
   }

}
