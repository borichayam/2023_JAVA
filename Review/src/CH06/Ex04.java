package CH06;

interface Controllable {
	void play();
	void stop();
}

class VideoPlayer implements Controllable {
	
	public void play() {
		System.out.println("비디오플레이어 재생 : 지기장쟞기깆닥");
	}
	public void stop() {
		System.out.println("비디오플레이어 멈춤 : ...");
	}
}

public class Ex04 {

	public static void main(String[] args) {
		VideoPlayer c = new VideoPlayer();
		
		c.play();
		c.stop();
	}

}
