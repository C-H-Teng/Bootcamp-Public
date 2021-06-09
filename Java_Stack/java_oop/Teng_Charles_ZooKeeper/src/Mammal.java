
public class Mammal {
	protected int energy = 100;
	
	// constructor
	public Mammal() {
		this(100);
	}
	
	public Mammal(int energy) {
		this.energy = energy;
	}
	
	// methods
	public int displayEnergy() {
		return this.energy;
	}
} // class end