import java.util.Random;//use rand in example

public class Dice {
//var dec
	private int numSides;
	Random randNum = new Random();//use rand in example
	//dice method
	public Dice(int sides){
		numSides = sides;
	}
//roll method
	public int roll(){
		return randNum.nextInt(numSides)+1;//add one because computer counts from zero
	}
}//end class
