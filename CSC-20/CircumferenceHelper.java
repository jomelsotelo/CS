/*
Name: Jomel Sotelo
Date: 10/1/2021
Title: Lab 5
*/
import java.util.*;
import java.lang.Math;

public class CircumferenceHelper{

public static void calculateThreeCircumferences(){
System.out.println("This program calculates the radius and circumference of a circle 3 times");
System.out.println("-------------------------------------------------------------------------");
for(int i=1; i<=3; i++){

Scanner input = new Scanner(System.in);
System.out.print("Please enter integer input for Point 1: x1 ");
int x1 = input.nextInt();
System.out.print("Please enter integer input for Point 1: y1 ");
int y1 = input.nextInt();
System.out.print("Please enter integer )input for Point 2: x2 ");
int x2 = input.nextInt();
System.out.print("Please enter integer input for Point 2: y2 ");
int y2 = input.nextInt();
double radius = calculateDistance(x1,y1,x2,y2);
double circumference = computeCircumference(radius);
radius = Math.round(radius*100.0)/100.0;
circumference = Math.round(circumference*100.0)/100.0;
displayCircumference(radius, circumference);
}

}

public static double calculateDistance(int x1, int y1, int x2, int y2){
double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
return distance;
}
public static double computeCircumference(double radius){
double circumference = Math.PI * 2 * radius;
return circumference;

}

public static void displayCircumference(double radius, double circumference){
System.out.println("Radius: "+radius);
System.out.println("Circumference: "+circumference);
}
}