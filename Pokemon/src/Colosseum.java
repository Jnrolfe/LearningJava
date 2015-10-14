import java.util.Scanner;

public class Colosseum {
//start main
	public static void main(String[] args) {
//var dec
		Scanner input = new Scanner(System.in);
		Pokemon Player1 = new Pokemon();
		Pokemon Player2 = new Pokemon();
		Dice d2 = new Dice(2);//new dice
		boolean playAgain = false;
		boolean tie = false;
		
		do{//while loop for repeatability
			int x = d2.roll();//roll each time
			if(Player1.isDead){//only if Player1 pokemon is dead, true by default
				Player1.statResetAtt = true;//reset stats
				Player1.statResetDef = true;
				Player1.statResetHP = true;
				System.out.println("Player 1 Build your Pokemon!");
				System.out.println("============================");
				Player1.userBuild();
				System.out.println();
				Player1.castedAttSpell = false;//reset spells each round
				Player1.castedDefSpell = false;
			}
			if(Player2.isDead){//SAME AS BEFORE JUST FOR PLAYER 2"
				Player2.statResetAtt = true;
				Player2.statResetDef = true;
				Player2.statResetHP = true;
				System.out.println("Player 2 Build your Pokemon!");
				System.out.println("============================");
				Player2.userBuild();
				System.out.println();
				Player2.castedAttSpell = false;
				Player2.castedDefSpell = false;
			}
			if(!Player1.isDead && playAgain){//if player 1 wins and player 2 wants to play against player 1's pokemon
				Player1.setHP(Player1.hpSaved);//set values same as entered before
				Player1.setAtt(Player1.attSaved);
				Player1.setDef(Player1.defSaved);
				Player1.setName(Player1.nameSaved);
				if(Player1.castedAttSpell){//reset spells
					Player1.castedAttSpell = false;
				}
				if(Player1.castedDefSpell){
					Player1.castedDefSpell = false;
				}
			}
			if(!Player2.isDead && playAgain){//SAME AS BEFORE JUST FOR PLAYER 2"
				Player2.setHP(Player1.hpSaved);
				Player2.setAtt(Player1.attSaved);
				Player2.setDef(Player1.defSaved);
				Player2.setName(Player1.nameSaved);
				if(Player2.castedAttSpell){
					Player2.castedAttSpell = false;
					Player2.setAtt(Player1.getAtt());
				}
				if(Player2.castedDefSpell){
					Player2.castedDefSpell = false;
					Player2.setDef(Player1.getDef());
				}
			}
			System.out.println("Player 1 will roll a D2, to decide who goes first.");//let user know what's going on
			System.out.print("Player 1 rolls a ");
			if (x == 1){//decide by roll
				System.out.println("1 and will go first!");
			}
			else{
				System.out.println("2 and will go second.");
			}
		
			System.out.println();// spacing for looks
		
				point: {if (x == 1){//designate loop to break later (loop for player1 goes first)
					for(int i = 0; i < 10; i++){//only play 10 rounds
						System.out.println();
						System.out.println("Round "+ (i+1) +"!");//display round number
						System.out.println();
						if(i%2 == 0){//decide who attacks who
							if(Player1.attack(Player2)){//activates attack sequence
								tie = false;//reset tie variable in case someone dies
								break point;//end if someone dies
							}
							if(Player2.attack(Player1)){
								tie = false;//''                      ''
								break point;
							}
						}
						else{
							if(Player2.attack(Player1)){
								tie = false;//same''
								break point;
							}
							if(Player1.attack(Player2)){
								tie = false;//same''
								break point;
							}
						}	
					}
					System.out.println("Both fighters are left standing, it's a draw!");//if draw let user know
					tie = true;//change tie variable to indicate a tie happened
				}
				else{//ENTIRE LOOP THE SAME JUST FOR PLAYER 2 GOING FIRST INSTEAD OF PLAYER 1!!!!!
					for(int i = 0; i < 10; i++){
						System.out.println();
						System.out.println("Round "+ (i+1) +"!");
						System.out.println();
						if(i%2 == 0){
							if(Player2.attack(Player1)){
								tie = false;
								break point;
							}
							if(Player1.attack(Player2)){
								tie = false;
								break point;
							}
						}
						else{
							if(Player1.attack(Player2)){
								tie = false;
								break point;
							}
							if(Player2.attack(Player1)){
								tie = false;
								break point;
							}
						}
					}
					System.out.println("Both fighters are left standing, it's a draw!");
					tie = true;
				}

			}//END SAMENESS''
			System.out.println();//space for looks
			System.out.println("Would you like to play again?(enter 1 for yes, 0 for no)");//prompt user when over
			int again = input.nextInt();
			if(again == 1){
				playAgain = true;//iff user wants to play again
			}
			else{
				playAgain = false;
			}
			if((Player1.isDead) && (playAgain) && !tie){//tests tie and play again and if they died last
				System.out.println("Player 2 won, would Player 1 like to play again against Player 2's pokemon?");
				System.out.println("(enter 1 for yes, 0 for no)");//prompt user
				int Player1Yes = input.nextInt();
				if(Player1Yes == 1){
					Player2.isDead = false;//tell which pokemon stats should be saved
				}
				else{
					Player2.isDead = true;
				}
			}
			if((Player2.isDead) && (playAgain) && !tie){//SAME''
				System.out.println("Player 1 won, would Player 2 like to play again against Player 1's pokemon?");
				System.out.println("(enter 1 for yes, 0 for no)");
				int Player2Yes = input.nextInt();
				if(Player2Yes == 1){
					Player1.isDead = false;//SAME''
				}
				else{
					Player1.isDead = true;
				}
			}
		}while(playAgain);//can loop forever!
		}//end main
}//end class
