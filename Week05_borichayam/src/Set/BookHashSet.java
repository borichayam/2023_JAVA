package Set;

import java.util.HashSet;
import java.util.Iterator;

import Collection.Book;

public class BookHashSet {
	private HashSet<Book> hs; // HashSet 선언
	
	// 생성자
	public BookHashSet() {
		hs = new HashSet<Book>(); // HashSet 생성
	}
	
	// book 추가
	public void addBook(Book book) {
		hs.add(book);
	}
	
	// book 제거
	public boolean removeBook(int bI) {
		Iterator<Book> ir = hs.iterator();
		
		while(ir.hasNext()) {
			Book b = ir.next(); // book을 하나씩 가져옴
			int tempId = b.getBookId(); // id 가져오기
			
			// id가 같다면 삭제
			if (tempId == bI) { 
				hs.remove(b);
				return true;
			}
		}
		System.out.println(bI+"가 존재하지 않습니다.");
		return false;
	}
	
	// book 전체 조회
	public void showAllBook() {
		for (Book b : hs) {
			System.out.println(b);
		}
		System.out.println();
	}
}
