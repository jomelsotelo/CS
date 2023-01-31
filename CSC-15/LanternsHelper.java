/*
Name: Jomel Sotelo
Title: Programming Assignment 1
*/
public class LanternsHelper{

public static void  drawFigures(){
  drawTopHats(); // draw the first figure consisting of three lines
  System.out.println();
  drawRockets();//draw the rocket shaped figure
  drawLanterns(); // draw the lantern shaped figure
}
public static void drawTopHats(){

 //draw three lines by calling methods 
 // drawFiveStars, drawNineStars and drawThirteenStars
 drawFiveStars();
 drawNineStars();
 drawThirteenStars();
  
  
}
public static void drawRockets(){
  // making sure you use println statements to introduce blank lines for spacing, call appropriate methods to drawTopHat, MiddleBands, drawThirteenStars as many times and in the order needed to complete the diagram
  drawTopHats();
  drawMiddleBands();
  drawThirteenStars();
  drawTopHats();
  System.out.println();
}
public static void drawFiveStars(){
   // the first line has  four stars followed by 13 blank spaces followed by five stars followed by spaces and then another five stars
  System.out.println("    *****                  *****");
}
public static void drawNineStars(){
   // the second line has two spaces followed by 9 blank spaces then followed by another 9 stars
  System.out.println("  *********              *********");
}
public static void drawThirteenStars(){
  //the third line has no spaces followed by 13 stars followed by 5 blank spaces followed by another 13 stars
  System.out.println("*************          *************");
}
public static void drawMiddleBands(){

  // use the println statement to draw a pattern of * and five bars | separated by a single space. Repeat this pattern after 5 spaces
  System.out.println("* | | | | | *          * | | | | | *");
}
public static void drawLanterns(){
 // Use the tophat and drawLanternMiddle Method to draw the lantern
  drawTopHats();
  drawLanternMiddle();
}
public static void drawLanternMiddle(){
  // call the drawFiveStars() and drawMiddleBand() method as many times and in the order needed to draw the lanterns figure
  drawFiveStars();
  drawMiddleBands();
  drawMiddleBands();
  drawFiveStars();
  drawFiveStars();

}
}