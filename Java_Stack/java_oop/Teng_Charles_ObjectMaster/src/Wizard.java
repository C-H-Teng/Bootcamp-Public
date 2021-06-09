class Wizard extends Human {
	public Wizard() {
		super(50,3,3,8);
	}

	// methods
	public void heal(Human target) {
		System.out.println("You heal the target for " + this.intelligence);
		target.health += this.intelligence;
		System.out.println("Target's current health: " + target.health);
	}
	
	public void fireball(Human target) {
		System.out.println("You shoot a fireball at the target!");
		target.health -= this.intelligence * 3;
		System.out.println("Target's current health: " + target.health);
	}
}