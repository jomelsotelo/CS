import java.util.*;

public class FishMain{
public static void main(String[] args){
//1
Fish oneFish = new Fish("Shark", 10.3, 100.0);
//2
Fish twoFish = new Fish("Dolphin", 5.56, 230.45);
//3
Fish threeFish = new Fish("Whale", 12.92, 1012.23);
//4
Fish fourFish = new Fish("Salmon", 2.34, 20.23);
 
//5
System.out.println("Printing oneFish");
System.out.println(oneFish.toString());
System.out.println("Printing twoFish");
System.out.println(twoFish.toString());
System.out.println("Printing threeFish");
System.out.println(threeFish.toString());
System.out.println("Printing fourFish");
System.out.println(fourFish.toString());

//6
System.out.println("Comparing fish lengths oneFish and threeFish");
if(oneFish.biggerThan(threeFish)){
System.out.println("OneFish is Bigger than ThreeFish");
}
else{
System.out.println("ThreeFish is Bigger than OneFish");
}

//7
System.out.println("Making oneFish grow by 5");
oneFish.grow(5);

//8
System.out.println("Again Comparing fish lengths oneFish and threeFish");
if(oneFish.biggerThan(threeFish)){
System.out.println("Now OneFish is Bigger than ThreeFish");
}
else{
System.out.println("ThreeFish is Bigger than OneFish");
}

//9
System.out.println("Comparing fish distance from shore twoFish and fourFish");
if(twoFish.furtherFrom(fourFish)){
System.out.println("Two Fish is Further From Shore than Four Fish");
}
else{
System.out.println("Four Fish is Further From Shore than Two Fish");
}

System.out.println("Making fourFish move by 300");
fourFish.move(300);

System.out.println("Again Comparing fish distances from shore twoFish and fourFish");
if(twoFish.furtherFrom(fourFish)){
System.out.println("Two Fish is Further From Shore than Four Fish");
}
else{
System.out.println("Four Fish is Further From Shore than Two Fish");
}

//10
System.out.println("Creating a fish array called fishArray to contain four fish");
Fish[] fishArray = new Fish[4];

//11
System.out.println("Assigning the four fish to the array");
fishArray[0] = oneFish;
fishArray[1] = twoFish;
fishArray[2] = threeFish;
fishArray[3] = fourFish;

//12
System.out.println("Printing the Fish Array");
for(int i=0; i<fishArray.length; i++){
System.out.println(fishArray[i].toString());
}

}
}

