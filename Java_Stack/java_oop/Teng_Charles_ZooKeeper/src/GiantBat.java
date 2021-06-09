class GiantBat extends Mammal {
	// methods
	public void eatHuman() {
		this.energy += 25;
		System.out.println("The sound of...nevermind, you don't want to know.");
	}

	public void fly() {
		this.energy -= 50;
		System.out.println("Sound of a bat taking off.");
	}

	public void attackTown() {
		this.energy -= 100;
		System.out.println("Sound of a town on fire.");
	}
}
