/** File Name: GameDriver.java
	Author: James Rolfe
    KUID: 2630058
	Email Address: jamesnrolfe@gmail.com
	Homework Assignment Number: 4
	Description: This class is made just to interface with the "HangMan.java" class. It will allow
	the user to provide input to the HangMan class and will display all of the HangMan class'es data
	in an visually pleasing way.
	Last Changed: 12-09-2014
*/

import java.util.Scanner;

public class GameDriver {
	//pre-cnd: none
	//post-cnd: HangMan game is played with user input, does NOT start with big bang, Prof. Gibbons
	//said this was fine in lecture
	public static void main(String[] args) {
		//var dec
		Scanner input = new Scanner(System.in);
		boolean again = false;
		boolean usedGuess = false;
		
		do{//start loop
			usedGuess = false;
			again = false;
			System.out.println("Enter a secret word:");//grab word from user
			String sec_word = input.next();
			HangMan game = new HangMan(sec_word);//create new object and construct
		
			for(int i = 0; i < 100; i++){//clear screen
				System.out.println();
			}
		
			System.out.println("Welcome to the Hangman Game!");
			System.out.println("----------------------------");
			System.out.println();
			while(!game.isGameOver()){
			System.out.println("Guess this: "+game.getDisguisedWord());
			System.out.println("Guesses so far: "+game.getGuessCount());
			System.out.println("Misses: "+game.getMissedMarker());
			System.out.print("Enter your guess character: ");
			if(!usedGuess){//169 requirement
				System.out.print("or guess the complete word!");
				String guess = input.next();
				if(guess.length() > 1){//check length to see if user was guessing the word
					if(guess.equals(sec_word)){
						game.winningFullWord();//if guessed correctly, set off win cnd
					}
					else if(guess.length() < sec_word.length() || guess.length() > sec_word.length()){
						System.out.println("Incorrect! The length of the word is "+sec_word.length());
					}
					else{
						System.out.println("Incorrect!");
					}
					usedGuess = true;//dont allow user to guess again
				}
				else{
					if (game.guessCharacter(guess.charAt(0))){
						System.out.println(guess.charAt(0)+" is in the secret word!");
					}
					else{
						System.out.println(guess.charAt(0)+" is not in the secret word. Death draws closer.");
					}
				}
			}
			else{//when user has used guess
				char guess = input.next().charAt(0);//grab first char only
				if (game.guessCharacter(guess)){//inform user
					System.out.println(guess+" is in the secret word!");
				}
				else{
					System.out.println(guess+" is not in the secret word. Death draws closer.");
				}
			}
			if(game.isGameOver()){//see if game is over
				System.out.println("Game Over!");
				if(game.isFound()){//see if user won
					System.out.println("Congratulations! You guessed the secret word: "+game.getDisguisedWord());
				}
				else{
					System.out.println("You died!");
				}
				System.out.println("Do you want to play again? (yes/no):");//prompt user
				String another = input.next();//grab user input
				if(another.toLowerCase().equals("yes") || another.toLowerCase().equals("y")){
					again = true;//check input
				}
				else{
					System.out.println("Thanks for playing "+game.getGamesPlayed()+" game(s) of Hang Man!");//print info to user
				}
			}
			}
		}while(again);
	}

}
