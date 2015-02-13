import java.util.Scanner;
public class RPN_Calculator {

	public static void main(String[] args){
		double numOne = 0;
		double numTwo = 0;
		double carry = 0;
		String op;
		boolean stop = true;
		Scanner input = new Scanner(System.in);
		
		System.out.println("start");
		numOne = input.nextDouble();
		while(stop){
			numTwo = input.nextDouble();
			//if (numTwo == null){//search for no input
				//stop = false;
			//}
			op = input.next();
			System.out.println(numOne);
			System.out.println(numTwo);
			if(op == "+"){//something is causing this to not work IF STATEMENT
				carry = numOne + numTwo;
			}
			else if(op == "-"){
				carry = numOne - numTwo;
			}
			else if(op == "*"){
				carry = numOne*numTwo;
			}
			carry = numOne + numTwo;
			numOne = carry;
			System.out.println(carry);
		}
		//System.out.println(carry);
	}

}
