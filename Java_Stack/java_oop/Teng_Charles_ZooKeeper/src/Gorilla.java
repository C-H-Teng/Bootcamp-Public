
class Gorilla extends Mammal {
	// methods
	public void eatBanana() {
		this.energy += 10;
		System.out.println("The gorilla ate a banana.");
	}

	public void throwSomething() {
		this.energy -= 5;
		System.out.println("The groilla threw something at someone.");
	}

	public void climb() {
		this.energy -= 10;
		System.out.println("The gorilla climbed a tree.");
	}
} // class end