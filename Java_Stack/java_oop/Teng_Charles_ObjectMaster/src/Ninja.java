
class Ninja extends Human {
	public Ninja() {
		super(100,3,10,3);
	}
	
	// methods
	public void steal(Human target) {
		System.out.println("You steal from the target!");
		target.health -= this.stealth;
		this.health += this.stealth;
		System.out.println("Target's current health: " + target.health);
		System.out.println("Your current health: " + this.health);
	}
	
	public void runAway() {
		System.out.println("You run away.");
		this.health -= 10;
		System.out.println("Your current health: " + this.health);
	}
}
