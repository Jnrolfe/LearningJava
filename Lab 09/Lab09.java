import java.util.Scanner;

public class Lab09 {
	
	public static void main(String[] args){
		//object dec
		Scanner input = new Scanner(System.in);
		ArrayHelper ArrayHelp = new ArrayHelper();
		//prompt user
		System.out.println("How many rows?:");
		int x = input.nextInt();
		System.out.println("How many columns?:");
		int y = input.nextInt();
		//create temp array
		int[][] my2DArray = new int[x][y];
		//enter values to temp array
		for(int i = 0; i < my2DArray.length; i++){
			for(int j = 0; j < my2DArray[i].length; j++){
				System.out.println("Enter a value for position ("+i+","+j+"):");
				my2DArray[i][j] = input.nextInt();
			}
		}
	//print array in given format
	System.out.println("Here is your array:");
	ArrayHelp.print2DArray(my2DArray);
	//print values to user
	for(int i = 0; i < my2DArray.length; i++){
		System.out.println("row "+i+": sum = "+ArrayHelp.arraySum(my2DArray[i])+", avg = "+ArrayHelp.arrayAvg(my2DArray[i]));
	}
	//print to user*
	System.out.println("The sum for the entire array is: "+ArrayHelp.arraySum2D(my2DArray));
	System.out.println("The average for the entire array is: "+ArrayHelp.arrayAvg2D(my2DArray));
	ArrayHelp.transpose(my2DArray);
	}
}
