/*
Name: Jomel Sotelo
Title: Programming Assignment 3
Function: Encryption Machine
*/
import java.util.*;

public class EncryptionMachineMainHelper{

//class constant which will help with the algorithms.
public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
public static final int shift = 3;

//method which displays the introduction and the user inputs.
public static void displayBanner(){
Scanner input = new Scanner(System.in);
System.out.println("Welcome to the CSC 15 Encryption Machine");
System.out.println("The program lets you encrypt a message");
System.out.println("with a key for your recipient to decrypt!");
System.out.println();
System.out.println("Encrypted messages use a shared keyword to decrypt.");

System.out.print("  Enter key: ");
String key = input.nextLine();
System.out.println("    "+"\""+key+"\" has been encrypted to: "+encryptWord(key));

System.out.print("How many words is your message? ");
int words = inputNumberOfWords();
for(int i=1; i<=words; i++){
inputWord();
}
System.out.println("Message fully encrypted. Happy secret messaging!");
}

//shifts the letter in the parameter by the class constant "shift" and returns the value.
public static int encryptLetter(char letter){
int encryptedLetters = (alphabet.indexOf(letter)+shift)%alphabet.length();
return encryptedLetters;
}

//changes the word in the parameter into a new encrypted word using the encryptedLetter method.
public static String encryptWord(String word){
String encryptedWord = "";
for(int i = 0; i<word.length(); i++){
encryptedWord += (char)(alphabet.charAt(encryptLetter(word.charAt(i))));
}
return encryptedWord;
}

//inserts the users input and loops how many times the user will input a word.
public static int inputNumberOfWords(){
Scanner input = new Scanner(System.in);
int words = input.nextInt();
return words;
}

//inserts the users input and prints an encrypted version of the message.
public static void inputWord(){
Scanner input = new Scanner(System.in);
System.out.print("  Next word: ");
String word = input.nextLine();
System.out.println("    "+"\""+word+"\" has been encrypted to: "+encryptWord(word));
}

}