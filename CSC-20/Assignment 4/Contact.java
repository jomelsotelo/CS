/*
 * This Contact class is used to create individual contacts.
 * Individual contact information is added to the contact class. Then these contacts are added to the Phone 
 * books array list. It contains information such as the first name, last name, numbers, and email address.
 * @author Jomel
 * @verison 1.0.0
 */
public class Contact{
/* Initalizes the first Name, last Name, 
 * home Number, office Number, email Address
 */
   private String firstName;
   private String lastName;
   private long homeNumber;
   private long officeNumber;
   private String emailAddress;
   
/* Constructor for a contact
 * @param firstName
 * @param lastName
 * @param homeNumber
 * @param officeNumber
 * @param emailAddress
 */
   public Contact(String firstName, String lastName, long homeNumber, long 
   officeNumber, String emailAddress){
      this.firstName = firstName;
      this.lastName = lastName;
      this.homeNumber = homeNumber;
      this.officeNumber = officeNumber;
      this.emailAddress = emailAddress;
   }

/* Getter method for first name.
 * @return firstname 
 */
   public String getFirstName() {
      return this.firstName;
   }

/* Getter method for last name.
 * @return lastname 
 */
   public String getLastName() {
      return this.lastName;
   }

/* Getter method for home number.
 * @return homenumber 
 */
   public long getHomeNumber() {
      return this.homeNumber;
   }

/* Getter method for office number.
 * @return officenumber 
 */
   public long getOfficeNumber() {
      return this.officeNumber;
   }

/* Getter method for email address.
 * @return emailaddress 
 */
   public String getEmailAddress() {
      return this.emailAddress;
   }


/* Setter method for first name.
 * @param firstName
 */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

/* Setter method for last name.
 * @param lastName
 */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

/* Setter method for home number.
 * @param homeNumber
 */
   public void setHomeNumber(long homeNumber) {
      this.homeNumber = homeNumber;
   }

/* Setter method for office number.
 * @param officeNumber
 */
   public void setOfficeNumber(long officeNumber) {
      this.officeNumber = officeNumber;
   }

/* Setter method for email address.
 * @param emailAddress 
 */
   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

/*
 * This method returns contact as a string 
 */
   public String toString() {
      String home;
      String work;
      if (this.homeNumber == 0) {
         home = "-";
      } else {
         home = Long.toString(this.homeNumber);
      }
      if (this.officeNumber == 0) {
         work = "-";
      } else {
         work = Long.toString(this.officeNumber);
      }
      return String.format("%-10s%-15s%-15s%-15s%s\n", this.firstName, this.lastName, home, work,this.emailAddress);
   }
}