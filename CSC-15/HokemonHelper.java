import java.util.*;
import java.io.*;

public class HokemonHelper{
   //Fills the creatures array by reading information from the file and returning the array.
   public static Hokemon[] getData(String file){
      Hokemon[] creatures = new Hokemon[8];
      int i=0;
      try{
         Scanner input = new Scanner(new File(file));
         while(input.hasNextLine()){
            String line = input.nextLine();
            Scanner data = new Scanner(line);
            creatures[i] = new Hokemon(data.next(),data.next(),data.nextInt());
            i++;
         }
         input.close();
      }
      catch(FileNotFoundException e){
         System.err.println(e);
      }
      return creatures;
   }
   
   //Inputs a hokemon object and returns a string containing the name, type, age, 
   //the location of the hokemon, and list of friends of the hokemon
   public static String getBio(Hokemon[] creatures){
      String list = "";
      for(Hokemon hokemon: creatures){
         String friends = "";
         String name = hokemon.getName();
         String type = hokemon.getType();
         int age = hokemon.getAge();
         for(Hokemon checkfriends: creatures){
            if(hokemon.areFriends(checkfriends)&&!hokemon.equals(checkfriends)){
               friends += checkfriends.getName()+" ";
            }
         }
         list += "I am "+ name+ ": Type "+type +": Age "+age+", I live in the "+hokemon.liveIn()+".\nMy friends are: "+friends+"\n";
      }
      return list;
   }
}