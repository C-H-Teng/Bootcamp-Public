
public class HumanTest {

	public static void main(String[] args) {
		Samurai Musashi = new Samurai();
		Samurai Kato = new Samurai();
		Ninja Hanzo = new Ninja();
		Wizard Harry = new Wizard();
		
		// samurai methods
		Musashi.howMany();
		Musashi.attack(Kato);
		Kato.deathBlow(Hanzo);
		Kato.medidate();
		
		// wizard methods
		Harry.heal(Hanzo);
		Harry.fireball(Kato);
		
		// ninja methods
		Hanzo.steal(Kato);
		Hanzo.runAway();
	}

}
