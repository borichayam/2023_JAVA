import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile1 {
	public static void main(String[] args) {
		
		byte list[] = {100,20,30,40,50,60};
		
		try (FileOutputStream out = new FileOutputStream("src\\test.bin")) {
			for (byte b : list) 
				out.write(b);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
