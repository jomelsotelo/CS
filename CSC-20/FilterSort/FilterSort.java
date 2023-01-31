import java.io.*;
import java.util.*;
/**
 * Program that reads tokens from file data.txt and prints the integer
 * tokens found in it to the screen in increasing order.
 *
 * @author Jomel Sotelo 
 */

public class FilterSort{
    /**
     * Allocates and returns an integer array twice the size of the one
     * supplied as a parameter. The first half of the new array will
     * be a copy of the supplied array and the second half of the new
     * array will be zeros.
     *
     * @param arr the array to be copied
     * @return array twice the size of <tt>arr</tt> with its initial
     *         elements copied from <tt>arr</tt>
     * @throws NullPointerException if <tt>arr</tt> is null.
     */
    public static int[] doubleArrayAndCopy(int[] arr) {
      int [] temp = new int[arr.length*2];
      for(int i=0; i<arr.length; i++){
         temp[i] = arr[i];
      }
      return temp;
    }
    
    public static void main(String[] args) {
    int[] data = new int[8];
    try {    
    Scanner file = new Scanner(new File("data.txt"));
    int index = 0;
    while(file.hasNext()){
      
      if(file.hasNextInt()){
         data[index] = file.nextInt();
      }
      else{
         file.next();
      }
      index++;
      if(index>=data.length){
         data = doubleArrayAndCopy(data);
      }
    }
      
    if(index==0){
      System.out.println("There is no data in file"); 
    }
    else{
      Arrays.sort(data);
      for(int i=0; i<data.length; i++){
         System.out.println(data[i]);
      }
    }
    }
     catch(FileNotFoundException e){
       System.out.println("Error: Data file not found");
     }
 }
}