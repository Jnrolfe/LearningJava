
public class OldMacDonald {
	
	Animal AnimalAA = new Animal();//initialize new object
	
	public void set_animal(Animal animal){
		AnimalAA = animal;//copy object's qualities to in class object
	}
	
	public void sing(){//sing song to user
		System.out.println("Let's sing!");
		System.out.println("Old MacDonald had a farm, EE-I-EE-I-O");
		System.out.println("And on the farm he had a "+AnimalAA.getType()+" EE-I-EE-I-O");
		System.out.println("With a "+AnimalAA.getSound()+"-"+AnimalAA.getSound()+" here, and a "+AnimalAA.getSound()+"-"+AnimalAA.getSound()+" there,");
		System.out.println("Here a "+AnimalAA.getSound()+" , there a "+AnimalAA.getSound()+" , everywhere a "+AnimalAA.getSound()+"-"+AnimalAA.getSound()+",");
		System.out.println("Old MacDonald had a farm, EE-I-EE-I-O");
	}
}
