
public class Dog extends Mammal{

	private boolean happy;
	
	public Dog(String latinName, int gestationTime, boolean happy){
		super(latinName, gestationTime);
		this.happy = happy;
	}
	
	public Dog(String latinName, int gestationTime, boolean happy, String friendlyName){
		super(latinName, gestationTime);
		super.setFriendlyName(friendlyName);
		this.happy = happy;
	}
	
	public boolean isHappy(){
		return happy;
	}
	public String getInfo(){
		String happy;
		if (this.happy != true){
			happy = "isn't";
		}
		else{
			happy = "is";
		}
		return "The dog, " + "\"" + getFriendlyName() + "\"" + ", latin: " + "\"" + getLatinName() + "\"" + " nurses for " + getGestationTime() + " month(s) and " + happy + " happy.";
	}
}
