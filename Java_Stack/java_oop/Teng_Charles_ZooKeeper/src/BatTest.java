
public class BatTest {
	public static void main(String[] args) {
		GiantBat dracula = new GiantBat();
		dracula.setEnergy(300);

		// attack 3 towns
		dracula.attackTown();
		dracula.attackTown();
		dracula.attackTown();
		System.out.println("Dracula's energy level after attacking: " + dracula.displayEnergy());

		// eat 2 humans
		dracula.eatHuman();
		dracula.eatHuman();
		System.out.println("Dracula's energy level after eating: " + dracula.displayEnergy());

		// fly twice
		dracula.fly();
		dracula.fly();
		System.out.println("Dracula's energy level after flying: " + dracula.displayEnergy());
	}
}
