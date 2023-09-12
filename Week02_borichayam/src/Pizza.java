class Circle {
	protected int radius;
	public Circle(int r) {
		radius = r;
	}
}
public class Pizza extends Circle {
	protected String name;
	
	public Pizza(String n, int r) {
		super(r);
		this.name = n;
	}
	
	public void print() {
		System.out.println("피자의 종류 : "+name+", 피자의 크기 : "+radius);
	}
	
	public static void main(String[] args) {
		Pizza obj = new Pizza("Pepperoni", 20);
		obj.print();
	}

}
