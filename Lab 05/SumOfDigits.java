import java.util.Scanner;

public class SumOfDigits{

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int userNum;
		int answer;
		int again = 1;
		
		while(again == 1){
			System.out.println("Please enter a No:");
			userNum = input.nextInt();
			answer = addDigits(userNum);
			System.out.println("The sum of the digits is: "+answer);
			System.out.println();
			System.out.println("Want to try again?(y=1/n=0):");
			again = input.nextInt();
		}
		System.out.println("Thank you!");
	}
	
	public static int addDigits(int x){
		
		int total = 0;
		int n = 0;
		
		while(x >= 1){
			n = x%10;
			total = total + n;
			x = x/10;
		}
		return(total);
	}
}