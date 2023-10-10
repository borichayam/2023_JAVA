package Array;

public class Book {
	private String bookName;
	private String author;
	
	// 생성자
	public Book() {};
	public Book(String bN, String a) {
		this.bookName = bN;
		this.author = a;
	}
	
	// get, set 메소드
	public void setBookName(String bN) {
		this.bookName = bN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setAuthor(String a) {
		this.author = a;
	}
	public String getAuthor() {
		return author;
	}
	
	// 책 정보 출력 메소드
	public void showBookInfo() {
		System.out.println(bookName+", "+author);
	}
}
