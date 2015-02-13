import java.util.Scanner;
public class Lab07 {

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int x = 0;
		
		do{
			System.out.println("Input an array size:");
			x = input.nextInt();
		} while(x < 0);
		
		double[] firstArray = new double[x]; 
		System.out.println("Now please enter "+ x +" numbers");
		
		for( int i = 0; i < x; i++){
			System.out.println("Input a number into your array: ");
			double y = input.nextDouble();
			firstArray[i] = y;
		}
		
		System.out.println("Here are all the numbers in your array:");
		printArray(firstArray);
		
		int z = 0;
		System.out.println();
		
		do{
			System.out.println("Input a new array size:");
			z = input.nextInt();
		} while(z < 0);
	
		double[] secondArray = arrayResize(firstArray, z);
		
		if(z > x){
			System.out.println("You need to add "+ (z-x) +" values");
			for(int i = 0; i < (z-x); i++){
				System.out.println("Input a number to add to your array:");
				secondArray[x + i] = input.nextDouble();
			}
		}
		System.out.println("Here are all the numbers in your new array:");
		printArray(secondArray);
	
		System.out.println();
		System.out.println("Enter a value to count:");
		double num = input.nextDouble();
		int times = count(secondArray, num);
		if(times == 1){
			System.out.println(num + " occurs " + times + " time in the new array.");
		}
		else{
			System.out.println(num + " occurs " + times + " times in the new array.");
		}
	}

	public static void printArray(double[] arr){
		int len = arr.length;
		
		for( int i = 0; i < len; i++){
			if( i == 0){
				System.out.print("[");
			}
			System.out.print(arr[i]);
			if(i == len - 1){
				System.out.print("]");
				System.out.println();
			}
			else{
				System.out.print(", ");
			}
		}
		if(arr.length == 0){
			System.out.println("[]");
		}
	}
	
	public static double[] arrayResize(double[] oldArray, int newSize){
		double[] newArray = new double[newSize];
		
		for( int i = 0; i < newSize; i++){
			if(i < oldArray.length){
				newArray[i] = oldArray[i];
			}
			else{
				newArray[i] = 0.0;
			}
		}
		
		return newArray;
	}
	
	public static int count(double[] arr, double value){
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if (arr[i] == value){
				count = count + 1;
			}
		}
		return count;
	}
}
