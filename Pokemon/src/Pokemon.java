import java.util.Scanner;

public class Pokemon {
//var dec ... a lot of var dec!
	Scanner input = new Scanner(System.in);
	private int hp = 0;//initial stats
	private int att = 0;
	private int def = 0;
	private String name;
	private Dice d20 = new Dice(20);//dice for rolling
	private Dice d6 = new Dice(6);
	private int attackBonus = 0;//bonuses
	private int defenseBonus = 0;
	public boolean castedAttSpell;//whether or not a spell has been casted
	public boolean castedDefSpell;
	private String select;//selection for later
	public boolean isDead = true;//who died?
	public int hpSaved = 0;//for when a pokemon wants to be replayed
	public int attSaved = 0;
	public int defSaved = 0;
	public String nameSaved;
	public boolean statResetHP;//for when a pokemon does NOT want to be replayed
	public boolean statResetDef;
	public boolean statResetAtt;
	
	public Pokemon(){
		
	}
	
	public boolean attack(Pokemon opponent){//attack method
		//start by asking user what the pokemon should do
		if(!castedAttSpell || !castedDefSpell){//take options away if they have been used
			System.out.print("Should "+name+" cast");
			if(!castedAttSpell){//take option away
				System.out.print(" an attack spell?");
			}
			if(!castedDefSpell){//take option away	
				System.out.print(" a defense spell?");
			}
			System.out.println(" or attack normally?");//normal attack always available
			System.out.println();
			if(!castedAttSpell){
				System.out.println("Type \"A\" for attack spell.");//tell user how to respond
			}
			if(!castedDefSpell){
				System.out.println("Type \"D\" for defense spell.");
			}
			System.out.println("Type \"N\" for attack normally.");
			select = input.next();//accept user response
		}
		else{
			select = "N";//default to normal attack
		}
		
		if(select.equals("A")||select.equals("a")){//ignores case
			System.out.println(name+" uses an attack spell, "+name+" has permanently buffed its attack by 5!");
			att = att + 5;
			System.out.println(name+" now has an attack level of "+att);
			castedAttSpell = true;//tells me they have used spell
		}
		else if(select.equalsIgnoreCase("D")){//found the correct method this time hahaha
			System.out.println(name+" uses a defense spell, "+name+" has permanently buffed its defense by 5!");
			def = def + 5;
			System.out.println(name+" now has a defense level of "+def);
			castedDefSpell = true;//tells me they have used a spell
		}
		else {
			System.out.println(name + " is attacking " + opponent.getName());//tells user who is attacking who
			attackBonus = d20.roll();//roll bonuses and print to user
			System.out.println(name + " rolls an attack bonus of " + attackBonus);
			defenseBonus = d20.roll();
			System.out.println(opponent.getName() + " rolls a defense bonus of " + defenseBonus);
			if (opponent.getDef()+defenseBonus < att+attackBonus){//if attack goes through
				System.out.println("The attack hits dealing 3-D6 damage!");
				int rollOne = d6.roll();//attack damage
				int rollTwo = d6.roll();
				int rollThree = d6.roll();
				int damage = rollOne + rollTwo + rollThree;//attack damage sum
				System.out.println("The rolls are "+rollOne+", "+rollTwo+", and "+rollThree+" totaling: "+damage+" damage!" );
				opponent.setHP(opponent.getHP() - damage);//subtract damage from opponent HP
				if(opponent.getHP() <= 0){//death condition
					System.out.println(opponent.getName()+" has been defeated!");
					isDead = false;//lets me know who died
					return true;
				}
				else{
					System.out.println(opponent.getName()+" has "+opponent.getHP()+" hit points left");//print to user if pokemon didnt die
				}
			}
			else{
				System.out.println("The attack missed!");//if attack didnt go through
			}
		}
		return false;//return condition
	}

	public void userBuild(){//start building the pokemon
		
		System.out.println("Please name your Pokemon:");//prompt user
		name = input.next();
		nameSaved = name;//save name if pokemon wants to be used again
		System.out.println("How many hit points will it have? (1-50)");
		while(hp < 1 || hp > 50 || statResetHP){//fulfil conditions to move on
			hp = input.nextInt();
			hpSaved = hp;//''
			statResetHP = false;//lets go of statresest condition, shouldnt matter once they make it to this point
			if(hp < 1 || hp > 50){
				System.out.println("Sorry the hit points must be between 1 and 50");//print error message
			}
		}
		System.out.println("Split fifty points between attack level and defense level");//SAME AS ABOVE
		System.out.println("Enter your attack level (1-49):");
		while(att < 1 || att > 49 || statResetAtt){
			att = input.nextInt();
			attSaved = att;//''
			statResetAtt = false;
			if(att < 1 || att > 49){
				System.out.println("Sorry. The attack level must be between 1 and 49:");//end sameness
			}
		}
		final int x = 50 - att;//finds appropriate range, for some reason has to be a 'final'???
		System.out.println("Enter your defense level (1-"+x+"):");
		while (def < 1 || def > x || statResetDef){//move on only if conditions met
			def = input.nextInt();//all same as other loops dealing with stats ''
			defSaved = def;
			statResetDef = false;
			if(def < 1 || def > x){
				System.out.println("Sorry. The defense level must be between 1 and "+x+":");//''
			}
		}
	}
	//METHODS BELOW ARE ALL FOR DATA RETRIEVAL and to be able to SET DATA FROM OUTSIDE CLASS!!!''
	public int getHP(){
		return hp;
	}
	
	public int getAtt(){
		return att;
	}

	public int getDef(){
		return def;
	}

	public String getName(){//''
		return name;
	}

	public void setHP(int input){
		hp = input;
	}

	public void setAtt(int input){//''
		att = input;
	}

	public void setDef(int input){
		def = input;
	}

	public void setName(String input){//''
		name = input;
	}

}//end class
