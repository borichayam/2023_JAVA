package CH13;

class Container<T> {
	T a;
	
	public void set(T a) {
		this.a = a;
	}
	public T get() {
		return a;
	}
}

public class Ex01 {

	public static void main(String[] args) {
		Container<String> c1 = new Container<String>();
		c1.set("홍길동");
		String str = c1.get();
		
		Container<Integer> c2 = new Container<Integer>();
		c2.set(6);
		int value = c2.get();
		
		System.out.println(str+"  "+value);
	}

}
