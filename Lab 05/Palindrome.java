import java.util.Scanner;

public class Palindrome{

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int again = 1;
		
		while(again == 1){
			System.out.println("Please enter a No:");
			userNum = input.nextInt();
			if(isPalindrome(userNum)){
				System.out.println("The Number is a Palindrome.");
			}
			else{
				System.out.println("The Number is not a Palindrome.");
			}
			System.out.println();
			System.out.println("Want to try again?(y=1/n=0): ");
			again = input.nextInt();
		}
		System.out.println("Thank you!");
	}
	
	public static boolean isPalindrome(int x){
		if(reverse(x) == x){
			return(true);
		}
		else{
			return(false);
		}
	}
	
	public static int reverse(int x){
		
		int length;
		int num = x;
		int rev = 0;
		
		while (num > 0){
			digit = num%10;
			rev = rev*10 + digit;
			num = num/10;
		}
		return(rev);
		length = lengthOfNumber(x);
		System.out.println("The Length of the Number is: "+length);
		System.out.println("The Reverse of the Number is: "+rev);
	}
	
	public static int lengthOfNumber(int x){
		
		String numAsStr;
		int length;
		
		numAsStr = Integer.toString(x);
		length = String.length(numAsStr);
		return(length);
	}
}