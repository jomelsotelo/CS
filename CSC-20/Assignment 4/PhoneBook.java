/*
 * This phone book class creates a phone book with all the contacts.
 * In a phone book the contacts are arranged in ascending order of first name or last 
 * name. In order to do this, there will be sorting algorithms such as bubble sort and selection sort. 
 * @author Jomel
 * @verison 1.0.0
 */
import java.util.*;
public class PhoneBook{
   public ArrayList<Contact> contacts;
   
/*   
 * Constructor for the phonebook containing ArrayList.
 */     
   public PhoneBook(){ 
      this.contacts = new ArrayList<Contact>();     
   }
           
/*
 * This method adds a contact to the array list.
 */
   public void add(Contact c){
      this.contacts.add(c);
   }
           
/* 
 * This method creates a printable string with the entire contact list.
 * @return prints list of all contacts
 */
   public String toString(){  
      String returnString = "";
      returnString += String.format("%-10s%-15s%-15s%-15s%s\n",
         "FirstName", "LastName", "HomeNumber", "OfficeNumber", "EmailAddress");
      for (int i = 0; i< contacts.size(); i++) {
         returnString += contacts.get(i);
      }
      return returnString;    
   }
           
/*
 * This method sorts phonebook by first name 
 * using the bubble sort algorithm which repeatedly swaps
 * the adjacent elements if they are in the wrong order.
 */
   public void bubbleSort(){
      int n = this.contacts.size();
      for (int i = 0; i < n-1; i++) {
         for (int j = 0; j < n-i-1; j++) {
            if (this.contacts.get(j).getFirstName().compareTo(this.contacts.get(j+1).getFirstName()) > 0)
            {
               Contact temp = this.contacts.get(j);
               this.contacts.set(j, this.contacts.get(j+1));
               this.contacts.set(j+1, temp);
            }
         }
      }
   }
         
/* 
 * This method sorts the list of last name
 * using the selections sort algorithm which
 * finds the minimum element in unsorted array
 * and swaps the found minimum element with the first element.
 */
   public void selectionSort(){
      int n = this.contacts.size();
      for (int i = 0; i < n-1; i++)
      {
         int min = i;
         for (int j = i+1; j < n; j++)
            if (this.contacts.get(j).getLastName().compareTo(this.contacts.get(min).getLastName()) < 0) {
               min = j;
            }
      
         Contact temp = this.contacts.get(min);
         this.contacts.set(min, this.contacts.get(i));
         this.contacts.set(i, temp);
      }
   }
   
/* 
 * This method sorts phone book by last 
 * using the selection sort algorithm.
 * @param name
 * @return true if the contact is found else false
 */
   public boolean binarySearch(String name){        
      this.selectionSort();
      int lowIndex = 0;
      int highIndex = this.contacts.size();
      int middleIndex = (lowIndex + highIndex)/2;
  
      while (lowIndex <= highIndex) {
         middleIndex = (lowIndex + highIndex)/2;
         if(this.contacts.get(middleIndex).getLastName().equals(name)) {
            return true;
         } else if (this.contacts.get(middleIndex).getLastName().compareTo(name) < 0) {
            lowIndex = middleIndex + 1;
         } else if (this.contacts.get(middleIndex).getLastName().compareTo(name) > 0) {
            highIndex = middleIndex - 1;
         }
      }
      return false;
   }
}