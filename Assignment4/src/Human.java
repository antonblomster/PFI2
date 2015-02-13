
public class Human {
	
	private Dog dog;
	private String name;
	
	
	public Human(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void buyDog(Dog dog){
		this.dog = dog;
	}

	public String getInfo(){
		String info = "";
		
		if( dog != null){
		info = this.getName() + " äger en hund som heter " + dog.getName();
		
		
		}
		if(dog == null){
			info = this.getName() + " äger inte en hund ";
			
		}
		return info;
	
	}
}

