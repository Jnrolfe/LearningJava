import java.util.Scanner;

public class Lab6{

	public static void main(String[] args){
	//variable dec
	Scanner input = new Scanner(System.in);
	int userNum = 0;
	//while loop to keep questioning the user if input is wrong
	while(userNum <= 0){ 
		System.out.println("Input an array size:");
		userNum = input.nextInt();
		if(userNum <= 0){//message to user as to why they cannot move on
			System.out.println("It must be greater than zero!");
		}
	}
	//variable dec
	int[] nums = new int[userNum];
	int smallNum = 0;
	int bigNum = 0;
	int sum = 0;
	
	System.out.println("Now please enter "+userNum+" numbers");//prompt user
	for(int i = 0; i < nums.length; i++){
		int currentNum = 0;//variable dec
		System.out.println("Input a number into your array: ");
		currentNum = input.nextInt();//get user input
		if(i == 0){
			smallNum = currentNum;//set smallest number for comparison later
			bigNum = currentNum;//set largest number for comparison later
		}
		sum = sum + currentNum;//make a running total
		nums[i] = currentNum;//assign each spot in the array a variable
		if(currentNum > bigNum){//largest num comparison
			bigNum = currentNum;
		}
		else if(currentNum < smallNum){//smallest num comparison
			smallNum = currentNum;
		}
	}
	
	System.out.println("Here are all the numbers in your array:");
	for(int i = 0; i < nums.length; i++){
		int num = 0;
		num = nums[i];//assign each value of array
		System.out.println(num);//print assigned variable
	}
	
	double average = (double)sum/nums.length;//compute average
	//print all that has been computed
	System.out.println("The sum of all the values is: "+sum);
	System.out.println("The average of all the values is: "+average);
	System.out.println("The largest value is: "+bigNum);
	System.out.println("The smallest value is: "+smallNum);
	}//end main
}//end class
