//Name: Jomel Sotelo
//Date: 12/11/21
//Program: Creating Hokemon's

import java.util.Arrays;
public class HokemonMain {
   //main which calls getData and prints out the bios of all the hokemons
   public static void main(String[] args){
      Hokemon [] creatures = HokemonHelper.getData("data.txt");
      System.out.println(Arrays.toString(creatures));
      System.out.println();
      System.out.println(HokemonHelper.getBio(creatures));
   }
}