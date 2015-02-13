/**File Name: AsciiArt.java 
	Author: James Rolfe 
        KUID: 2630058
	Email Address: jamesnrolfe@gmail.com
	Homework Assignment Number: 2
	Description: This code will take an integer from standard input then create two nxn matrices 
				 scaled to that integer. One matrix will be a standard square matric, the other will
				 be the transpose of that matrix.
	Last Changed: 10-02-14 
*/

import java.util.Scanner;

public class SquareMatrix {

	public static void main(String[] args) {
		//variable dec
		Scanner input = new Scanner(System.in);
		int userNum = 0;
		//prompt and get user input
		System.out.println("Enter the Size of the Square Matrix:");
		userNum = input.nextInt();
		
		int userNumSqrd = userNum*userNum;//find total number of entries in SQUARE matrix
		//Square Matrix
		System.out.println("Square Matrix:");
		for(int i = 1; i <= userNumSqrd; i++){
			System.out.print(i); //print number
				if(i % userNum == 0){ //how to decide if new row is needed
					System.out.println();
				}
				else{
					System.out.print(" ");//space inbetween numbers
				}
		}
		//Transpose Start
		System.out.println("Transpose");
		int j = 1; //variable dec 
		int a = 1; //variables used for counting in the loop
		for(int i = 1; i <= userNumSqrd; i++){ //same as Square Matrix
			if(a > userNum){//resets a count each new row
				a = 1;
			}
			int x = j + (a - 1)*(userNum); //calculate number
			System.out.print(x);
			
			if(i % userNum == 0){//same as Square Matrix
				System.out.println();//new row
				j++;//initial number progression for each new row
			}
			else{
				System.out.print(" ");
			}
			a++; //multiplier progression
		}
	}//end main

}//end class
