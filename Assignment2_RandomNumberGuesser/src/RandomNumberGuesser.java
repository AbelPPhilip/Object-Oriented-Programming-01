/*

* Class: CMSC203 CRN 21456

* Instructor: Ahmed Tarek 

* Description: The Random number generator program is a mini program that stores a random number and the user will have to guess it. 
* The number of guesses will be recorded and the number of options to guess will also decrease according to the user’s input. 
* The main Driver Class, Random Number Guesser will be using methods provided in the provided RNG class. 

* Due: 2/20/2021

* Platform/compiler:Eclipse IDE

* I pledge that I have completed the programming assignment independently.

I have not copied the code from a student or any source.

I have not given my code to any student.

Print your Name here: Abel Philip

*/
/**
 * @author abelp
 * @Date 09/20/2021
 * @Description: The Random number generator program is a mini program that stores a random number and the user will have to guess it. 
* The number of guesses will be recorded and the number of options to guess will also decrease according to the user’s input. 
* The main Driver Class, Random Number Guesser will be using methods provided in the provided RNG class. 
* @Info The methods used in the RandomNumberGuesser.java is taken from the RNG.java class which was already provided. 
 */
import java.util.Scanner;

public class RandomNumberGuesser {
	
	

	public static void main(String[] args) {//Start Main method
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);//Retrieve System in tool 
		int randNum, nextGuess, highGuess, lowGuess;//Declare important int variables 
		String tryAgain= "yes";//Declare and initializing the String variable that allows the continuity of the program
		//Start of While loop that contains the majority of the program
		while (tryAgain.equals("yes")){//As long as user inputs "yes" the program will continue running 
			randNum = RNG.rand(100);//Retrieving random number between 1 and 100. Method call from RNG.java
			highGuess = 100;
			lowGuess = 0;
			System.out.println("Random Number Guesser\n\nEnter your first guess");
			nextGuess = in.nextInt();
			while (randNum!=nextGuess) {//Start of while loop that runs as long as Random number is not equal to guessed number. 
				while (!(RNG.inputValidation(nextGuess, lowGuess, highGuess))) {//Start of input validation while loops. Runs until input is valid
					nextGuess = in.nextInt();
				}//end of input validation while loop 
			    System.out.println("Number of guesses is "+RNG.getCount());//general user info using method call to retrieve number of tries. 
			    //Start of if statements to resize number of options and provide user feedback
				if (nextGuess>randNum) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				}
				else {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
				nextGuess = in.nextInt();
			}//End of while loop, here the user must have guessed the number 
			System.out.println("Congratulations, you guessed correctly");
			System.out.println("Try again? (yes or no)");
			in.nextLine();//renew newline
			tryAgain = in.nextLine();
			if (tryAgain.equals("yes")) RNG.resetCount();//Method call to reset count
		}//End of while loop that also terminates the program and moves on to concluding works and close. 
		System.out.println("Thanks for Playing");
		System.exit(0);
		in.close();
		
	}//end of main method

}//end of RandomNumberGuesser.java class
