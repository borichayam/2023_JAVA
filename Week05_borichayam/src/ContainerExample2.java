
class Container2<K, V> {
	private K key;
	private V value;
	
	public void set(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
public class ContainerExample2 {

	public static void main(String[] args) {
		Container2<String, String> c1 = new Container2<String, String>();
		c1.set("홍길동", "도적");
		String name1 = c1.getKey();
		String job = c1.getValue();
		
		Container2<String, Integer> c2 = new Container2<String, Integer>();
		c2.set("홍길동", 35);
		String name2 = c2.getKey();
		int age = c2.getValue();
		
		System.out.println("c1 - key 변수 : "+name1+", value 변수 : "+job);
		System.out.println("c2 - key 변수 : "+name2+", value 변수 : "+age);
	}

}
