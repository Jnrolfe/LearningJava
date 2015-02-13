import java.util.Scanner;

public class Palindrome {
	
public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int again = 1;
		
		while(again == 1){
			System.out.println("Please enter a No:");
			int userNum = input.nextInt();
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
		
		int num = x;
		int rev = 0;
		int digit;
		int l = 0;
		
		while (num > 0){
			digit = num%10;
			rev = rev*10 + digit;
			num = num/10;
		}
		
		l = lengthOfNumber(x);
		System.out.println("The Length of the Number is: "+l);
		System.out.println("The Reverse of the Number is: "+rev);
		return(rev);
	}
	
	public static int lengthOfNumber(int x){
		 
		String numAsStr;
		
		numAsStr = Integer.toString(x);
		return(numAsStr.length());
	}
}
