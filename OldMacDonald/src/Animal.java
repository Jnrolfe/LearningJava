
public class Animal {
	//variable dec, private so they can't be changed
	private String animal;
	private String sound;
	
	public void setType(String ani){
		animal = ani;//method to set type
	}
	
	public void setSound(String noise){
		sound = noise;//method to set sound
	}
	
	public String getType(){
		return animal;//self explanatory
	}
	
	public String getSound(){
		return sound;//"
	}
}
