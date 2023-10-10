package Collection;

public class Book {
	private int bookId;
	private String bookName;
	
	// 생성자
	public Book(int bI, String bN) {
		this.bookId = bI;
		this.bookName = bN;
	}
	
	// get, set 메소드
	public void setBookId (int bI) {
		this.bookId = bI;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookName(String bN) {
		this.bookName = bN;
	}
	public String setBookName() {
		return bookName;
	}
	
	// 출력 메소드
	public String toString() {
		return bookName+" 도서의 아이디는 "+bookId+"입니다.";
	}
}
