package Ex03;

public class Student {
	private String name;
    private int num;
    private double grade;

    public Student(String name, int num, double grade) {
        this.name = name;
        this.num = num;
        this.grade = grade;
    }
    
    // get, set 메소드
 	public void setName (String name) {
 		this.name = name;
 	}
 	public String getName() {
 		return name;
 	}
 	public void setNum(int num) {
 		this.num = num;
 	}
 	public int setNum() {
 		return num;
 	}
 	public void setGrade(double g) {
 		this.grade = g;
 	}
 	public double setGrade() {
 		return grade;
 	}
 	
 	// 출력 메소드
 	public String toString() {
 		return name+", "+num+", "+grade;
 	}
}
