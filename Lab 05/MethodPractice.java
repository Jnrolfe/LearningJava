import java.util.Scanner;

public class MethodPractice{
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int a;
		int b;
		int largerNum;
		double radius;
		double circum;
		String str;
		int copies;
		
		System.out.println("Input two numbers:");
		a = input.nextInt();
		b = input.nextInt();
		largerNum = chooseGreater(a,b);
		System.out.println("The larger number is "+largerNum);
		System.out.println();
		
		System.out.println("Input a radius: ");
		radius = input.nextDouble();
		circum = circumference(radius);
		System.out.println("The circumference is: "+circum);
		System.out.println();
		
		System.out.println("Input a string: ");
		str = input.next();
		System.out.println("How many times do you want to print it?:");
		copies = input.nextInt();
		printWord(str,copies);
		
	}
	public static int chooseGreater(int a, int b){
		if( a > b){
			return(a);
		}
		else{
			return(b);
		}
	}
	public static double circumference(double radius){
		double pi = 3.14159;
		double answer = 0;
		if( radius < 0){
			return("0.0");
		}
		else{
			answer = 2*pi*radius;
			return(answer);
		}
	}
	public static void printWord(String word, int timesToPrint){
		for(int i = 0; i < timesToPrint; i++){
			System.out.println(word);
		}
	}
}