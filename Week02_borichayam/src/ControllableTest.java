
interface Controllable {
	void play();
	void stop();
}

class VideoPlayer implements Controllable {
	public void play() {
		System.out.println("song play!");
	}
	public void stop() {
		System.out.println("song stop!");
	}
}

public class ControllableTest {
	public static void main(String[] args) {
		VideoPlayer c = new VideoPlayer();
		
		c.play();
		c.stop();
	}
}
