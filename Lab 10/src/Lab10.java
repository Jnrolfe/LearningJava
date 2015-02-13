import java.util.Scanner;
import java.util.Random;

public class Lab10 {

	public static void main(String[] args) {
		BubbleSort SortBubbly = new BubbleSort();//var dec
		Scanner input = new Scanner(System.in);
		Random myRandomInstance = new Random();
		//prompt user for needed parameters
		System.out.println("How many random numbers would you like to in your array?");
		int size = input.nextInt();
		int[] myArray = new int[size];
		System.out.println("Would you like to sort the array in ascending or descending order? (0 for ascending, 1 for descending):");
		int choice = input.nextInt();//used later to chose instance
		
		System.out.println();//space for looks
		System.out.println("Here is your unsorted array:");//assign values in array
		for(int i = 0; i < myArray.length; i++){
			myArray[i] = myRandomInstance.nextInt(256);//possible values of 0-255
		}
		//print unsorted array
		for(int i = 0; i < myArray.length; i++){
			System.out.print(myArray[i]+" ");
		}
		System.out.println();
		
		System.out.println();//spaces for looks ^^
		double start = System.nanoTime();//start timer
		System.out.println("Starting sort at "+start);
		//decide which instance to call
		if(choice == 0){
			SortBubbly.ascending(myArray);
		}
		
		if(choice == 1){
			SortBubbly.descending(myArray);
		}
			
		double stop = System.nanoTime();//stop timer
		System.out.println("Stoping sort at "+stop);
		//print sorted array
		System.out.println();
		System.out.println("Here is your sorted array:");
		for(int i = 0; i < myArray.length; i++){
			System.out.print(myArray[i]+" ");
		}
		System.out.println();//spaces for looks
		System.out.println();
		
		double elapsed = stop - start;//report total time
		System.out.println("This sort took a total of " + elapsed + " nano seconds, or " + elapsed/1000000000.0 + " seconds");
	}
}
