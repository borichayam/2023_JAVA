package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInform {

	public static void main(String[] args) throws IOException {
		int n;
		String search;
		String num, name, tel, email;
		
		
		Scanner s = new Scanner(System.in);
		PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
		
		while(true) {
			System.out.println("번호 : ");
			num = s.next();
			System.out.println("이름 : ");
			name = s.next();
			System.out.println("전화번호 : ");
			tel = s.next();
			System.out.println("이메일 : ");
			email = s.next();
			System.out.println("입력 끝났으면 1, 계속하려면 0 : ");
			n = s.nextInt();
			
			in.print(num + ", "+name+", "+tel+", "+email+"\n");
			in.flush();
			if(n == 1)
				break;
		}
		
		System.out.println("출력할 번호 입력 : ");
		n = s.nextInt();
		
		String line = null;
		File f = new File("user.txt");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
			boolean found = false;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(", ");
                if (parts.length > 0 && parts[0].equals(Integer.toString(n))) {
                    System.out.println("전화번호: " + parts[2]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("해당 번호를 찾을 수 없습니다.");
            }
			
		}
	}
}
