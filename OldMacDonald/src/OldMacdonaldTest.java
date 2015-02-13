import java.util.Scanner;

public class OldMacdonaldTest {

	public static void main(String[] args){ 
		 //Create an animal and an OldMacDonald object
		 Animal animalA = new Animal();
		 OldMacDonald md = new OldMacDonald();
		 Scanner input = new Scanner(System.in);

		 //Talk to the user to obtain animal type and sound
		 System.out.println("Input an animal:");
		 String x = input.next();
		 System.out.println("What sound does a "+x+" make:");
		 String y = input.next();
		 //Tell the animal what type it is and what sound it makes
		 animalA.setSound(y);
		 animalA.setType(x);
		 
		 //Tell OldMacDonald which animal to sing about
		 md.set_animal(animalA);

		 //Tell OldMacDonald to sing
		 md.sing();

		}
}
