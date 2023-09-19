
public class DVDPlayersTest {
	public static void main(String[] args) {
		DVDPlayers a = new DVDPlayers();
		Players b = new DVDPlayers();
		ExPlayers c = new DVDPlayers();
		
		System.out.println("DVDPlayer형 변수 a");
		a.play();
		a.stop();
		a.slow();
		
		System.out.println("Player형 변수 b");
		b.play();
		b.stop();
		
		System.out.println("ExPlayer형 변수 c");
		c.play();
		c.stop();
		c.slow();
	}

}
