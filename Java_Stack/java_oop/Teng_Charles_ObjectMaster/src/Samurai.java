
class Samurai extends Human {
	private static int count = 0;

	public Samurai() {
		super(200,3,3,3);
		count++;
	}
	
	// methods
	public void deathBlow(Human target) {
		System.out.println("You deal a deathblow to the target!");
		target.health = 0;
		this.health = this.health / 2;
		System.out.println("Your health is now: " + this.health);
	}

	public void medidate() {
		System.out.println("You meditate to recover.");
		this.health += this.health;
		System.out.println("Your current health: " + this.health);
	}

	public void howMany() {
		System.out.println("Amount of Samurai: " + count);
	}
}
