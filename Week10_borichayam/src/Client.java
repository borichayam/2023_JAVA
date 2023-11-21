import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket cs = null;
		BufferedReader in = null;
		PrintWriter out = null;
		final Scanner s = new Scanner(System.in);
		
		try {
			cs = new Socket("localhost", 5001);
			out = new PrintWriter(cs.getOutputStream());
			in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

			String msg;
			
			while(true) {
				System.out.print("서버로 보낼 문자열을 입력하고 엔터키를 치세요 : ");
				msg = s.nextLine();
				
				if(msg.equalsIgnoreCase("quit")) {
					out.println(msg);
					out.flush();
					break;
				}
				out.println(msg);
				out.flush();
				
				msg = in.readLine();
				System.out.println("서버로부터 온 메시지 : "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			cs.close();
		}
	}

}
