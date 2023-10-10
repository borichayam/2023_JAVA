package Set;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("ccc");
		hs.add("zzz");
		hs.add("aaa");
		hs.add("bbb");
		hs.add("ddd");
		hs.add("ccc");
		
		System.out.println(hs); // 중복 제거됨
	}
}
