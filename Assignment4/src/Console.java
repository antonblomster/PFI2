
public class Console {

	public static void main(String[] args) {
		Human human; 
		Dog dog;
		
		human = new Human("John");
		
		human.buyDog(dog = new Dog("Pricken"));
		
		System.out.println(human.getName() + " har en hund som heter " + dog.getName());
		
		
	}
}
