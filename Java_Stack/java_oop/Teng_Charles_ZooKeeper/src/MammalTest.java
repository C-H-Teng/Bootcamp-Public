
public class MammalTest {
	public static void main(String[] args) {
		Gorilla george = new Gorilla();
		
		// throw 3 things
		george.throwSomething();
		george.throwSomething();
		george.throwSomething();
		System.out.println("George's energy level after throwing things: " + george.displayEnergy());
		
		// eat 2 bananas
		george.eatBanana();
		george.eatBanana();
		System.out.println("George's energy level eating: " + george.displayEnergy());
		
		// climb once
		george.climb();
		System.out.println("George's energy level after climbing: " + george.displayEnergy());
	}
} // class end