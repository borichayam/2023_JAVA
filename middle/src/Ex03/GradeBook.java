package Ex03;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Ex03.Student;

public class GradeBook {

		// ArrayList(Collection) 선언
		private ArrayList<Student> arrayL; 
		
		// Student형으로 선언한 ArrayList 생성
		public GradeBook() {
			arrayL = new ArrayList<Student>();
		}
		
		// 1. 학생들의 평균 점수를 계산하는 메소드
		public double AverageGrade() {
			double sum = 0;
			for (Student s : arrayL) {
				double n = s.setGrade();
				sum += n;
			}
			return sum/arrayL.size();
		}
		
		// 2. 특정 학번을 가진 학생의 정보를 검색하는 메소드
		public void SearchNum(int n) {
			for (Student s:arrayL) {
				if (s.setNum() == n) {
					s.toString();
					return;
				}
			}
		}
		
		// 3. 등록한 모든 학생의 정보를 출력하는 메서드
		public void showAllStudent() {
			int i = 1;
			for (Student s : arrayL) {
				System.out.println(i+". "+s);
				i++;
			}
			System.out.println();
		}
		
		/*
		// Student 데이터 추가
		public void addStudent(Student b) {
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
		}*/

}
