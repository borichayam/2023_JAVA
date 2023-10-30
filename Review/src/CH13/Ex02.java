package CH13;

class Container2<K, V> {
	K name;
	V value;
	
	public void set(K n, V v) {
		this.name = n;
		this.value = v;
	}
	public K getKey() {
		return name;
	}
	public V getValue() {
		return value;
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Container2<String, String> c1 = new Container2<String, String>();
		c1.set("홍길동", "도적");
		String n1 = c1.getKey();
		String job = c1.getValue();
		
		Container2<String, Integer> c2 = new Container2<String, Integer>();
		c2.set("홍길동", 35);
		String n2 = c2.getKey();
		int age = c2.getValue();
		
		System.out.println("c1 : "+n1+", "+job);
		System.out.println("c2 : "+n2+", "+age);
	}

}
