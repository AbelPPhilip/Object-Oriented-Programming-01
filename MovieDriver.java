/**
 * @author Abel P.
 * Name: Abel Philip
 * Date:9/25/2021
 * Class: CMSC 203
 * Instructor: Ahmed Tarek 
 * Description: This program utilizes the data element class Movie.java 
 *              The MovieDriver creates Movie Objects and receives user inputs
 *              The movie name, rating and the tickets sold are then printed out. 
 * 
 */
import java.util.*;
public class MovieDriver {//Start of MovieDriver Class


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        
        char response = 'y';//Variable to determine loops 
        
        while (response!='n') {//As long as user doesn't input 'n' the loop continues
        	Movie a = new Movie();//New Movie object is created
            System.out.println("Enter name of a movie");
            a.setTitle(in.nextLine());//Receives movie title from user
            System.out.println("Enter the rating of the movie");
            a.setRating(in.nextLine());//Receives movie rating from user
            System.out.println("Enter the number of tickets sold for this movie");
            a.setSoldTickets(in.nextInt());//Receives no. of movie tickets sold
            System.out.println(a);//prints out the complete information of the movie 
            System.out.println("Do you want to enter another? (y or n)");
            response = in.next().charAt(0);//Receives char input from user to determine continuity of loop
            in.nextLine();//Continues new line 
            
        }
        System.out.println("Goodbye");
        in.close();//Scanner close
        System.exit(0);//Exits System
	}//End of main method 

}//End of MovieDriver Class
