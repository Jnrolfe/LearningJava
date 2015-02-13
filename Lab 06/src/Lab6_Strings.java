import java.util.Scanner;

public class Lab6_Strings{

	public static void main(String[] args){
	//variable dec
	Scanner input = new Scanner(System.in);
	int userNum = 0;
	//prompt user until valid value for array is received
	while(userNum <= 0){ 
		System.out.println("Input an array size for your words array:");//prompt user
		userNum = input.nextInt();//get input
		if(userNum <= 0){
			System.out.println("It must be greater than zero!");//message to user as to why there is failure
		}
	}
	//variable dec
	String[] words = new String[userNum];
	String smallWord = ("");
	String bigWord = ("");
	
	System.out.println("Now please enter "+userNum+" words");
	for(int i = 0; i < words.length; i++){//run the length of the array
		String currentWord = ("");//variable dec
		System.out.println("Input a word: ");
		currentWord = input.next();//get input
		if(i == 0){//assign first word as to have something valid to compare to later
			smallWord = currentWord;
			bigWord = currentWord;
		}
		words[i] = currentWord;//assign word to spot in array
		if(currentWord.length() > bigWord.length()){//make length comparison
			bigWord = currentWord;
		}
		else if(currentWord.length() < smallWord.length()){//same^
			smallWord = currentWord;
		}
	}
	//print all to necessary computations to user
	System.out.println("The longest word is: "+bigWord);
	System.out.println("The shortest word is: "+smallWord);
	}//end main
}//end class
