/*
 * This Smart String list class tests out whether it's element are sorted.
 * We will use algorithms such as selection sort and binary search.
 * @author Jomel
 */
public class SmartStringList{
   private int capacity;
   private boolean sorted;
   
/*
 * Constructs a list of given max capacity
 */
   public SmartStringList(int capacity){
      this.capacity = capacity;
      List<String> list = new ArrayList<>(capacity);
      sorted = true;
   }

/*
 * This method adds given String to end of list.
 */
   public void add(String s){
      if(capacity == list.size()){
         System.out.println("Size of list reached its capacity, so can't add more data.");
         return;
      }
      list.add(s);
      if(list.size() > 1 && sorted){
         sorted = list.get(0).compareToIgnoreCase(list.get(list.size() - 1)) <= 0;
      }
   }              
/*
 * This method returns the String at index i.  
 */ 
   public String get(int i){
      if(i >= list.size()){
         throw new ArrayIndexOutOfBoundsException("Index greater than list capacity.");
      }
      return list.get(i);
   }
         
/*
 * This method returns the position of the given value or -1 if not found.
 */
   public int indexOf(String s){
      if(sorted){
         int low = 0, high = list.size()-1;
         while (low <= high){
            int mid = low + (high-low)/2;
            int comp = list.get(mid).compareToIgnoreCase(s);
            if(comp == 0){
               return mid;
            }
            if(comp < 0){
               low = mid + 1;
            }
            else{
               high = mid - 1;
            }
         }
      }
      else{
         for(int i=0; i<list.size(); i++){
            if(list.get(i).compareToIgnoreCase(s) == 0){
               return i;
            }
         }
      }
      return -1;
   }          
/*
 * This method puts the list in sorted order.
 */
   public void sort(){
      if(!sorted) {
         int n = list.size();
         for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
               if (list.get(j).compareToIgnoreCase(list.get(min)) < 0) {
                  min = j;
               }
            }
            String temp = list.get(min);
            list.set(min, list.get(i));
            list.set(i, temp);
         }
      }
      sorted = true;
   }

}