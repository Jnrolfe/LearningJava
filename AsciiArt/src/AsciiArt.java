/**File Name: AsciiArt.java 
	Author: James Rolfe 
        KUID: 2630058
	Email Address: jamesnrolfe@gmail.com
	Homework Assignment Number: 2
	Description: This code will take an integer from standard source then print a art scaled to the
	  			 size of the integer. There are also 3 different art choices the user can decide from;
	  			 stripes, checkerboard, and double diagonal. 
	Last Changed: 10-02-14 
*/

import java.util.Scanner;

public class AsciiArt {

public static void main(String[] args) {
		//variable dec
		Scanner input = new Scanner(System.in);
		int size = 0;
		int selection = 0;
		double i = 0;
		double j = 0;
		//prompt user and get input
		System.out.println("Choose one of the following patterns by typing the corresponding number:");
		System.out.println("1) Stripes");
		System.out.println("2) Checker Board");
		System.out.println("3) Double Diagonal (aka the X)");
		selection = input.nextInt();
		if(selection < 1||selection > 3){ //if user makes bad choice end with error message
			System.out.println("Error.");
		}
		else {
			System.out.println("Input a size (must be larger than 1)");
			size = input.nextInt();
			//stripes	
			if(selection == 1){
				for(i=0;i<size;i++){
					System.out.print((int)i+" ");//print row number
					for(j=0;j<size;j++){
						if(j%2 == 0){//if col is even, print star 
							System.out.print("* ");
						}
						else{
							System.out.print("  ");
						}
					}
					System.out.println();
				}
			}
			//checkerboard
			else if(selection == 2){
				for(i=0;i<size;i++){
					System.out.print((int)i+" ");//print row number
					for(j=0;j<size;j++){
						if(i%2 == 0){//if col is even
							if(j%2 == 0){//if row is even
								System.out.print("* ");
							}
							else{
								System.out.print("  ");
							}
						}
						else{
							if(j%2 == 0){
								System.out.print("  ");
							}
							else{//if row is odd
								System.out.print("* ");
							}
					}
				}
					System.out.println();
			}
		}
			//double diagonal
			 else if(selection == 3){
			 	for(int r = 0; r < size; r++){//same as others above
			 	System.out.print(r + " ");//print row number and space
			  		for(int s = 0; s < size; s++){//same as others above
			  			if(r == s || s == (size-1)-r){//print if row=col or col=size-row
			  				System.out.print("* ");
			  			}
			  			else{
			  				System.out.print("  ");//col spaces
			  			}
			  		}
			   	System.out.println("  ");//row spaces
			   	}
			  }
			}	
			
	}//end class
		

}//end main
