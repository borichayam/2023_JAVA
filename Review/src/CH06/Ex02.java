package CH06;

class Sports {
	
	String getName() {
		return "아직 결정되지 않음";
	}
	
	int getPlayers() {
		return 0;
	}
}

class Soccer extends Sports{
	String name = "축구";
	int player = 11;
	
	String getName() {
		return name;
	}
	int getPlayers() {
		return player;
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Soccer obj = new Soccer();
		
		System.out.println("경기이름 : "+obj.getName());
		System.out.println("경기자수 : "+obj.getPlayers());
	}

}
