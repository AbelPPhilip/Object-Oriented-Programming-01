/*

* Class: CMSC203

* Instructor: Ahmed Tarek  

* Description: This program is intented to aid users in identifying the problem with 
their internet connection by suggesting a sequence of solutions according to the inputs provided by the user. The End soltuion is to contact the user's ISP. 
* Due: 9/12/2021

* Platform/compiler: Eclipse IDE

* I pledge that I have completed the programming assignment independently.

I have not copied the code from a student or any source.

I have not given my code to any student.

Print your Name here: Abel P. Philip 

*/
import java.util.Scanner;

public class WIFIDiagnosis {

	public static void main(String[] args) { //Driver Class that runs the main code
		// TODO Auto-generated method stub
		System.out.println("If you have a problem with internet connectivity, this WIFI Diagnosis might work.\n First step: reboot your computer");
		Scanner input = new Scanner(System.in); //Scanner Variable to input if the user is having WIFI connection issues 
		String response = input.nextLine(); //Scanner Variable to input if the user is having WIFI connection issues 
		if (response.equals("No")) {
			System.out.println("Second Step: Reboot your router");
			if (failed()) { //Call of failed() method
				System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
				if (failed()) {//Call of failed() method
					System.out.println("Fourth Step: Move your computer closer to your router");
					if (failed()) {//Call of failed() method
						System.out.println("Fifth step: contact your ISP\nMake sure your ISP is hooked up to your router");
					}else System.out.println("Moving your computer closer to the router seemed to work");
				}else System.out.println("Checking the router cables seemed to work");
			} else System.out.println("Rebooting your computer seemed to work");	
		} else System.out.println("Rebooting your computer seemed to work");//Summary of solutions
		System.exit(0);
	}//end of main
	public static boolean failed() {//failed() method to allow reduction of total lines and repetition
		Scanner local = new Scanner(System.in); //Local scanner variable
		System.out.println("Now are you able to connect with the internet? (Yes/No)");
		String in = local.nextLine();
		if (in.equals("Yes")) {
			return false;//Shows that the user's connection has been recovered
		}else return true;//shows that the user's connection is still faulty
	}//end of failed() method 

}
