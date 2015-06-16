
public class Main {

	public static void main(String[] args) {

		Cat cat = new Cat();
		Dog dog = new Dog();
		Lion lion = new Lion();

		cat.makeSound();
		cat.purr();
		dog.makeSound();
		lion.makeSound();
		lion.purr();

	}
}

class Animal {
	protected String m_description = null;
	protected String m_sound = "...";
	protected void makeSound() {
		System.out.println(m_sound);
	}
}

class Cat extends Animal {

	Cat() {
		m_sound = "Meow!";
		m_description = "Condescending, bothersome, and furry.";
	}
	
	protected void purr() {
		
		System.out.println("Purrrrrr");
		
	}
}

class Dog extends Animal {

	Dog() {
		m_sound = "Woof!";
		m_description = "Lovable, naive, and kinda stupid.";
	}
}

class Lion extends Cat {
	
	Lion() {
		m_sound = "Roar!";
		m_description = "Large, furry, and pretty dangerous.";
	}
	
}