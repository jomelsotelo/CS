/*
 * The car class constructs a chain of train carsin a linked list.
 * every car object in the list has the attributes of a factory name,
 * material name, a stop number, and a address to the next Car object in the list.
 * Other class are able to implement this class, and use it to utilize a linked list.
 * @author Jomel
 * @verison 1.0.0
 */
public class Car {
   public static String factory;
   public static int stop;
   public static String material;
   Car next;

/*
 * Car object that class on the regular constructor using default parameters.
 * The default parameter is set to "" for String, 0 for int, and null for another Car Object.
 */
   public Car(){
      this("",0,"",null);
   }

/*
 * This constructor set next to null for the next Car object and 
 * calls on the regular constructor using the given parameters.
 * Good for adding the last car on the list.
 * @param fact
 * @param s
 * @param m
 */
   public Car(String fact, int s, String m){
      this(fact,s,m,null);
   }

/*
 * Thi constructor creates the Car object with an address of the next Car object in the list
 * This is the main constructor and all of the other constructors call on this.
 * Good for adding Car objects in the middle of the list.
 * @param fact
 * @param s
 * @param m
 * @param next
 */ 
   public Car(String fact, int s, String m, Car next){
      this.factory = fact;
      this.stop = s;
      this.material = m;
      this.next = next;
   }

}
