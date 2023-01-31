//Name: Jomel Sotelo
//Date: 12/11/21
//Program: Creating Hokemon's

public class Hokemon{

   private String name;
   private String type;
   private int age;
   // all of the info in the UML

   //default constructor.
   public Hokemon(){
      this.name="";
      this.age=0;
      this.type="";
   }

   //constructor with attributes
   public Hokemon(String name, String type, int age){
      this.name=name;
      this.age=age;
      this.type=type;
   }

   //getters and setters for the hokemon.
   public String getName(){
      return name;
   }

   public String getType(){
      return type;
   }

   public int getAge(){
      return age;
   }

   public void setName(String name){
      this.name = name;
   }

   public void setType(String type){
      this.type = type;
   }

   public void setAge(int age){
      this.age = age;
   }
   
   //Prints out the name, type and age.
   public String toString(){
      return "\n"+"Name "+name+": Type "+type+": Age "+age;
   }

   //Returns the home of the hokemon.
   public String liveIn(){
      if(this.type.equals("Dwarf")){
         return "Mountain";
      }
      else if(this.type.equals("Elf")){
         return "Dale";
      }
      else if(this.type.equals("Fairy")){
         return "Forest";
      }
      else{
         return "Shire";
      }
   }

   //Checks to see if the current hokemon object is a friend of the other and returns true or false.
   public boolean areFriends(Hokemon other){
   
      if(this.type.equals(other.type)){
         return true;
      }
      else if((this.type.equals("Dwarf")&&other.type.equals("Elf"))||(this.type.equals("Elf")&&other.type.equals("Dwarf"))){
         return true;
      }
      else if((this.type.equals("Hobbit")&&other.type.equals("Fairy"))||(this.type.equals("Fairy")&&other.type.equals("Hobbit"))){
         return true;
      }
      else{
         return false;
      }
   
   }

}