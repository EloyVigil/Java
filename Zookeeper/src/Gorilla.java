
public class Gorilla {
	Mammals gorilla = new Mammals();
	
	public void throwSomething() {
		System.out.println("The gorilla has thrown a tree! and energy has gone down by 5 points");
		gorilla.energyLevel -= 5;
		System.out.println("The gorilla energy is now at" + gorilla.displayEnergy());
	}
	
	public void eatBananas() {
		System.out.println("The gorilla is very satisfied with the bananas, and increased thier energy by 10.");
		gorilla.energyLevel += 10;
		System.out.println("The gorilla energy is now at" + gorilla.displayEnergy());
	}
	
	public void climb() {
		System.out.println("The gorilla has just climbed a skyscraper! and thier energy has gone down by 10.");
		gorilla.energyLevel -= 10;
		System.out.println("The gorilla energy is now at" + gorilla.displayEnergy());
	}
}
