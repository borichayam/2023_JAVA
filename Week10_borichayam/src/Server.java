import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket cs = null;
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner s = new Scanner(System.in);
		
		try {
			ss = new ServerSocket(5001);
			System.out.println("연결을 기다리고 있음");
			
			cs = ss.accept();
			out = new PrintWriter(cs.getOutputStream());
			
			in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			System.out.println("클라이언트와 연결되었음");
			
			while(true) {
				String msg = in.readLine();
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("클라이언트에서 연결을 종료하였음");
					break;
				}
				System.out.println("클라이언트가 보낸 문자열 : "+msg);
				
				System.out.print("클라이언트로 보낼 문자열을 입력하고 엔터키를 치세요 : ");
				String omsg = s.nextLine();
				out.write(omsg+"\n");
				out.flush();
			}
			
			out.close();
			cs.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
