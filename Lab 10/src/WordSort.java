import java.util.Scanner;

public class WordSort {

	public static void main(String[] args) {//start main
		Scanner input = new Scanner(System.in);//var dec
		boolean goodWord = true;
		String myWord = "";
		//prompt user
		System.out.println("How many words do you want to store?");
		int size = input.nextInt();
		String[] myArray = new String[size];//create array
		
		for(int i = 0; i < myArray.length; i++){//assign words to indecies of array
			while(goodWord){//runs until acceptable word is given
				System.out.println("Enter word number "+(i+1)+":");
				myWord = input.next();
				if(myWord.length() > 0){//dictate what is an acceptable word
					goodWord = false;
				}
				else{
					System.out.println("Invalid input!");//error message to user
				}
			}
			goodWord = true;//reset while loop
			myArray[i] = myWord;//finally assign value
		}
		
		System.out.println("Here is your unsorted array of words:");//self explanatory
		for(int i = 0; i < myArray.length; i++){
			System.out.print(myArray[i]+" ");//extra space for looks
		}
		System.out.println();
		
		double start = System.nanoTime();//start timer
		System.out.println("Starting bubble sort at "+start);
		
		String temp;//Start of sorting
		for(int i = 0; i < myArray.length-1; i++)//bubble sort
		{
		        for(int j = 0; j < myArray.length-1; j++)
			{
				if(myArray[j].length() > myArray[j+1].length())
				{
					temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
			}
		}
		double stop = System.nanoTime();//stop timer
		System.out.println("Finished bubble sort at "+stop);
		System.out.println();//space for looks
		
		System.out.println("Here is your sorted array of words:");//print sorted array
		for(int i = 0; i < myArray.length; i++){
			System.out.print(myArray[i]+" ");
		}
		System.out.println();//space for looks
		
		double elapsed = stop - start;//tell user time in both nano and regular seconds
		System.out.println("This sort took a total of " + elapsed + " nano seconds, or " + elapsed/1000000000.0 + " seconds");
	}

}
