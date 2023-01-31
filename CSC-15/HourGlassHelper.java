/*
Name: Jomel Sotelo
Assignment: 2
*/
public class HourGlassHelper{
//class Constants
public static final int size = 6;
public static final int times = 1;

//draws the 3 main components
public static void drawHourGlasses(){
drawTop();
drawLine();
drawTop();
}

//draws the middle component
public static void drawLine(){
   for(int repeat=1; repeat<=times; repeat++){
      drawTopTriangle();
      drawBottomTriangle();        
   }
}

//draws the top component
public static void drawTopTriangle(){
   for(int line=1; line<=(size/2); line++){
            System.out.print("|");
            for(int spaces=1; spaces<line; spaces++){
               System.out.print(" ");
            }
            System.out.print("\\");
            for(int dot=1; dot<=size-(line*2);dot++){
               System.out.print(".");   
            }
            System.out.print("/");
            for(int spaces=1; spaces<line; spaces++){
                  System.out.print(" ");
            }
            System.out.println("|");
   }
}

//draws the bottom component
public static void drawBottomTriangle(){
   for(int line=(size/2); line>=1; line--){
            System.out.print("|");
            for(int spaces=line; 1<spaces; spaces--){
               System.out.print(" ");
            }
            System.out.print("/");
            for(int dot=size-(line*2); dot>=1; dot--){
               System.out.print(".");   
            }
            System.out.print("\\");
            for(int spaces=line; 1<spaces; spaces--){
                  System.out.print(" ");
            }
            System.out.println("|");
   }
}

//draws the outer layers
public static void drawTop(){
   System.out.print("+");
      for(int i=0; i<size; i++){
         System.out.print("-");
      }
   System.out.println("+");
}

}