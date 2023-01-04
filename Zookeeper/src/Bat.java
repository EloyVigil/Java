
public class Bat extends Mammals {
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("WHOOOSH WHHHOOOOOOOSSHHH");
		this.energyLevel -= 50;
		System.out.println("The bats energy is now at " + super.displayEnergy());
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("The bats energy is now at " + super.displayEnergy());
	}
	
	public void attackTown() {
		System.out.println("THE WHOLE TOWN IS ON FIRE!!!!!");
		this.energyLevel -= 100;
		System.out.println("The bats energy is now at " + super.displayEnergy());
	}

	
	
}
