
public class Human {
	protected int health;
	protected int strength;
	protected int stealth;
	protected int intelligence;
	
	public Human() {
		this(100,3,3,3);
	}
	
	public Human(int health, int strength, int stealth, int intelligence) {
		this.health = health;
		this.strength = strength;
		this.stealth = stealth;
		this.intelligence = intelligence;
	}


	// methods
	public void attack(Human target) {
		System.out.println("You attack the target!");
		target.health -= this.strength;
		System.out.println("The target's remaining health is: " + target.health);
	}
}
