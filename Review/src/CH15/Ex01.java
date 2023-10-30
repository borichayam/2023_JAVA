package CH15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex01 {

	public static void main(String[] args) throws IOException {
		File f1 = new File("input.txt");
		File f2 = new File("output.txt");
		char charCounter = 0;
		
		BufferedReader in = (new BufferedReader (new FileReader(f1)));
		PrintWriter out = (new PrintWriter (new FileWriter(f2)));
		int ch;
		
		while ((ch = in.read()) != -1) {
			if(Character.isLowerCase(ch)){
				ch=Character.toUpperCase(ch);
			}
			out.write(ch);
		}
		
		in.close();
		out.close();
	}

}
