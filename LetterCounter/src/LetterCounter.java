//it wasn't explicitly stated that we need to print to the user what is being stored in their file
//so I made it print to the user just in case ...
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class LetterCounter {

	public static void main(String[] args) {
		//var dec
		Scanner input = new Scanner(System.in);
		String filename = "";
		FileReader myFileReader = null;
		BufferedReader myBufferedReader = null;
		int[] myCountArray = new int[58];
		int goodFile = 0;
		String outFile = "";
		boolean caseSens = false;
		int[] myCountArrayNS = new int[26];//are for non-case sensitive analysis
		boolean pass = true;
		
		while(pass){//only allow user to pass if he/she gives a good answer
			System.out.println("Do you want the analysis to be case sensitive?");
			System.out.println("(enter 1 for yes, 0 for no)");
			int caseSensNum = input.nextInt();
			if(caseSensNum == 1 || caseSensNum == 0){
				pass = false;
				if(caseSensNum == 1){
					caseSens = true;
				}
			}
			else{
					System.out.println("Try again.");//print error message to user
				}
			System.out.println();//for looks
		}
		
		while(goodFile == 0){//in loop if bad filename given
			System.out.println("Enter a file name:");
			filename = input.next();
			System.out.println("Enter an out file name:");
			outFile = input.next();
			try {
				myFileReader = new FileReader(filename);
				myBufferedReader = new BufferedReader(myFileReader);			
				FileWriter myFileWriter = new FileWriter(outFile);
				BufferedWriter out = new BufferedWriter(myFileWriter);
				//tell user what's going on
				System.out.println("Reading from "+filename);
				System.out.println();
				String line;
				while( (line = myBufferedReader.readLine()) != null){
					System.out.println(line);
					for(int i = 0; i < line.length(); i++){
						int letterAsNum = (line.charAt(i));
						int readyNum = letterAsNum - 65;//push the numbers back to zero
						if(readyNum < 0 || (readyNum > 25 && readyNum < 32) || readyNum > 58){
							//do nothing
							//excludes all non-letters
						}
						else{
							myCountArray[readyNum]++;//add value to array if letter shows
							//array is now full of "how many times each letter happened at index corresponding to letter"
						}
					}
				}
				goodFile = 1;//break while loop
				myBufferedReader.close();//close stream
				
				System.out.println();
				if(caseSens == true){
					for(int i = 0; i < myCountArray.length; i++){
						if(i > 25 && i < 32){
							//do nothing
							//discard non-letters
						}
						else{
							System.out.println((char) (i+65) + " = " + myCountArray[i]);//print to user to show contents of file
							out.write((char) (i+65) + " = " + myCountArray[i]);//write to file
						}
					}
				}
				else{//same ^ modified for non case sensitive
					for(int i = 0; i < 26; i++){
						myCountArrayNS[i] = myCountArray[i] + myCountArray[i+32];//add both uppercase and lowercase values
					}
					for(int i = 0; i < myCountArrayNS.length; i++){
						System.out.println((char) (i+97) + " = " + myCountArrayNS[i]);//print only lowercase
					}
				}
				
				out.close();//close stream
				System.out.println();
				System.out.println("Results stored in "+outFile);//print to user
			}
			catch (Exception e){
				System.out.println(e.getMessage()); //print what went wrong
			}
			
			if(caseSens){
				int mostNum = myCountArray[0];//var dec, temp storage dec
				int[] most = new int[58];
				for(int i = 0; i < myCountArray.length - 1; i++){//doesn't need to compare first with first
					if(i > 25 && i < 32){
						//do nothing
						//discards all non-letters
					}
					else{
						if(myCountArray[i+1] > mostNum){
							mostNum = myCountArray[i+1];//store most value
						}
					}
				}
				for(int i = 0; i < myCountArray.length; i++){
					if(myCountArray[i] == mostNum ){
						most[i] = 1;//set most flag
					}
				}
				System.out.print("The letters that occurred the most with case sensitivity are/is: ");
				for(int i = 0; i < 58; i++){
					if(most[i] == 1){//find and print most flag
						System.out.print((char) (i+65) +" ");
					}
				}
			}
			else{//same^ modified for non case sensitive
				int mostNum = myCountArrayNS[0];//array configured for non case sensitive
				int[] most = new int[26];
				for(int i = 0; i < myCountArrayNS.length - 1; i++){
						if(myCountArrayNS[i+1] > mostNum){
							mostNum = myCountArrayNS[i+1];
						}
				}
				for(int i = 0; i < myCountArrayNS.length; i++){
					if(myCountArrayNS[i] == mostNum ){
						most[i] = 1;
					}
				}
				System.out.print("The letters that occurred the most without case sensitivity are/is: ");
				for(int i = 0; i < 26; i++){
					if(most[i] == 1){
						System.out.print((char) (i+97) +" ");//print lowercase
					}
				}
			}
		}
	
	}

}
