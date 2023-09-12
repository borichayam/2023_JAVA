class Sports{
	String getName() {
		return "아직 결정되지 않음";
	}
	int getPlayer() {
		return 0;
	}
}
class Soccer extends Sports{
	public String name;
	public int number;
	
	public Soccer() {
		this.name = "축구";
		this.number = 11;
	}
	
	String getName() {
		return name;
	}
	int getPlayer() {
		return number;
	}
}
public class SoccerTest {

	public static void main(String[] args) {
		Soccer obj = new Soccer();
		
		System.out.println("경기이름 : "+obj.getName());
		System.out.println("경기자수 : "+obj.getPlayer());
	}

}
