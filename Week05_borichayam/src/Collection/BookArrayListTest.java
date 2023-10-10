package Collection;

import java.util.Scanner;

public class BookArrayListTest {
	public static void main(String[] args) {
		BookArrayList bAL = new BookArrayList();
		
		Book b1 = new Book(0001, "파우스트");
		Book b2 = new Book(0002, "황무지");
		Book b3 = new Book(0003, "변신");
		Book b4 = new Book(0004, "픽션들");
		Book b5 = new Book(0005, "톨스토이");
		
		bAL.addBook(b1);
		bAL.addBook(b2);
		bAL.addBook(b3);
		bAL.addBook(b4);
		bAL.addBook(b5);
		
		bAL.showAllBook();
		
		// 키보드로 위치와 책 ID, 책 제목을 입력 받아서 추가
		Scanner s = new Scanner(System.in);
		
		System.out.print("리스트 위치 : ");
		int index = s.nextInt();
		s.nextLine();
		System.out.print("책 ID : ");
		int id = s.nextInt();
		s.nextLine();
		System.out.print("책 제목 : ");
		String title = s.nextLine();
		
		Book b6 = new Book(id, title);
		bAL.insertBook(index, b6);
		
		bAL.showAllBook();
	}
}
