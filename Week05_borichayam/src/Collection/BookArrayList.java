package Collection;

import java.util.ArrayList;

public class BookArrayList {
	// ArrayList 선언
	private ArrayList<Book> arrayL; 
	
	// Book형으로 선언한 ArrayList 생성
	public BookArrayList() {
		arrayL = new ArrayList<Book>();
	}
	
	// book 데이터 추가
	public void addBook(Book b) {
		arrayL.add(b);
	}
	
	// book 데이터 삭제
	public boolean removeBook(int bI) {
		for (int i=0; i < arrayL.size(); i++) {
			Book b = arrayL.get(i);
			int tempId = b.getBookId();
			
			if(tempId == bI) {
				arrayL.remove(i);
				
				return true;
			}
		}
		System.out.println(bI+"가 존재하지 않습니다.");
		
		return false;
	}
	
	// book 데이터 삽입
	public void insertBook(int in, Book book) {
		for (int i=0; i < arrayL.size(); i++) {
			if(i == in) {
				arrayL.add(in, book);
			}
		}
	}
	
	// book 데이터 출력
	public void showAllBook() {
		for (Book b : arrayL) {
			System.out.println(b);
		}
		System.out.println();
	}
}
