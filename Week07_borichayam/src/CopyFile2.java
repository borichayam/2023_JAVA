import java.io.FileInputStream;
import java.io.IOException;

public class CopyFile2 {
	public static void main(String[] args) {

		byte list[] = new byte[6];
		try (FileInputStream out = new FileInputStream("src\\test.bin")) {
			out.read(list);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for (byte b:list)
			System.out.print(b+" ");
		System.out.println();
	}
}
