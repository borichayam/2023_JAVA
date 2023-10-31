package middle;

class Student {
    private String name;
    private String num;
    private String grade;

    public Student(String name, String num, String grade) {
        this.name = name;
        this.num = num;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n전화번호: " + phoneNumber + "\n주소: " + address;
    }
}

public class Ex03 {

	public static void main(String[] args) {
		
	}

}
