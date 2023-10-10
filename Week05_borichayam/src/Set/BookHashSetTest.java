package Set;

import Collection.Book;

public class BookHashSetTest {
	public static void main(String[] args) {
		BookHashSet bHS = new BookHashSet();
		
		Book b7 = new Book(111, "해리포터");
		Book b8 = new Book(222, "반지의 제왕");
		Book b9 = new Book(333, "트와일라잇");
		
		bHS.addBook(b7);
		bHS.addBook(b8);
		bHS.addBook(b9);
		bHS.showAllBook();
		
		Book b10 = new Book(111, "브레이킹던");
		bHS.addBook(b10);
		bHS.showAllBook(); // 중복의 기준x -> 중복 제거 안됨
	}
}
