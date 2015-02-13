/** File Name: HangMan.java 
	Author: James Rolfe 
    KUID: 2630058
	Email Address: jamesnrolfe@gmail.com
	Homework Assignment Number: 4
	Description: This class takes in a word as a parameter and then turns in into question marks. Then
	it will display to the user necessary information to play a standard game of "Hang Man". 
	Last Changed: 12-09-2104
*/
public class HangMan {
//variable declarations
	private final String secret_word; 
	private char[] disguised_word = null;//set to null because size not available yet
	private int guessCount;
	private int missesCount;
	private int MAX_MISSES_ALLOWED;
	private char[] missedMarkers = null;//same as "disguised_word"
	private static int gamesPlayed = 0;//static allows it to be shared across all HangMan objects
	private boolean winningFullWord = false;
	//pre-cnd: take a valid String parameter
	//post-cnd: assign values to variables
	public HangMan(String word){//constructor for HangMan object
		secret_word = word;
		disguised_word = new char[word.length()];//make the length correctly
		missedMarkers = new char[7];//make the length correct
		for (int i = 0; i < word.length(); i++){
			if (word.charAt(i) != ' '){//check for spaces in the secret word
				disguised_word[i] = '?';
			}
			else{
				disguised_word[i] = ' ';
			}
		}
		for (int i = 0; i < 7; i++){//fill the missedMarkers array
			missedMarkers[i] = 'O';
		}
		initialize();//reset method
	}
	//pre-cnd: must take value character as parameter NOT string
	//post-cnd: relays info of whether guess is correct and changes private variables accordingly
	public boolean guessCharacter(char c){
		boolean goodguess = false;//initialize var
		guessCount++;
		String sec_word_lower = secret_word.toLowerCase();//makes case-insensitive
		for(int i = 0; i < sec_word_lower.length(); i++){//check each char of secret word
			if (c == sec_word_lower.charAt(i) || c == secret_word.charAt(i)){//check if correct
				goodguess = true;
				disguised_word[i] = secret_word.charAt(i);//if goodguess change disguised word
			}
		}
		if(goodguess){
			return true;
		}
		else{
			missesCount++;
			return false;
		}
	}
	//pre-cnd: none
	//post-cnd: checks variables then returns boolean accordingly
	public boolean isGameOver(){
		if(isFound() || (missesCount == MAX_MISSES_ALLOWED)){//check if either game ending cnd
			return true;
		}
		else{
			return false;
		}
	}
	//pre-cnd: none
	//post-cnd: checks variables then returns boolean accordingly
	public boolean isFound(){
		String tester = new String(disguised_word);//create new var to check equivalence
		if(tester.equals(secret_word) || winningFullWord){
			return true;
		}
		else{
			return false;
		}
	}
	//pre-cnd: none
	//post-cnd: creates new variable to return String or checks variable to return String
	public String getDisguisedWord(){
		String output = new String(disguised_word);//make new variable for returning
		if(winningFullWord){//check is winning word is guessed, then trip the game over cnd
			return secret_word;
		}
		return output;
	}
	//pre-cnd: none
	//post-cnd: returns private variable value
	public int getGuessCount(){
		return guessCount;
	}
	//pre-cnd: none
	//post-cnd: returns private variable value
	public int getMissesCount(){
		return missesCount;
	}
	//pre-cnd: none
	//post-cnd: changes private variable then creates new variable to return a String
	public String getMissedMarker(){
		for(int i = 0; i < missesCount; i++){
			missedMarkers[i] = 'X';//change misses count accordingly
		}
		String output = new String(missedMarkers);//create new var for returning
		return output;
	}
	//pre-cnd: none
	//post-cnd: returns variable value
	public int getGamesPlayed(){
		return gamesPlayed;
	}
	//pre-cnd: none
	//post-cnd: changes value of variable
	public void winningFullWord(){
		winningFullWord = true;
	}
	//pre-cnd: none
	//post-cnd: changes private variable values 
	private void initialize(){//private method requirement
		guessCount = 0;//initialize >>
		missesCount = 0;
		MAX_MISSES_ALLOWED = 7;
		gamesPlayed++;//keep track of each played game
	}
}
