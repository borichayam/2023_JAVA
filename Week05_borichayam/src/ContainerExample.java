
class Container<T> {
	private T data;
	
	public void set(T data) {
		this.data = data;
	}
	public T get() {
		return data;
	}
}

public class ContainerExample {
	public static void main(String[] args) {
		Container<String> c1 = new Container<String>();
		c1.set("홍길동");
		String str = c1.get();
		
		Container<Integer> c2 = new Container<Integer>();
		c2.set(6);
		int value = c2.get();
		
		System.out.println("String 변수 : "+str+"\nInteger 변수 : "+value);
	}

}
