package CH06;
class Circle {
	protected int radius;
	
	public Circle(int r) {
		radius = r;
	}
}
class Pizza extends Circle {
	public String menu;
	
	public Pizza(String m, int r) {
		super(r);
		this.menu = m;
	}
	
	public void print() {
		System.out.println("피자의 종류 : "+menu+"\n피자의 크기 :"+radius);
	}
}

public class Ex01 {

	public static void main(String[] args) {
		Pizza obj = new Pizza("Pepperoni", 20);
		
		obj.print();
	}

}
