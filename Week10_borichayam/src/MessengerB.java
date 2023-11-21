import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessengerB {
	protected JTextField tF;
	protected JTextArea tA;
	DatagramSocket soc;
	DatagramPacket pac;
	InetAddress addr = null;
	final int iPort = 6000;
	final int uPort = 5000;
	
	public MessengerB() throws IOException {
		MyFrame f = new MyFrame();
		addr = InetAddress.getByName("127.0.0.1");
		soc = new DatagramSocket(iPort);
	}
	
	public void process() {
		while (true) {
			try {
				byte[] buf = new byte[256];
				pac = new DatagramPacket(buf, buf.length);
				soc.receive(pac);
				
				tA.append("RECIEVED : "+new String(buf)+"\n");
			}catch(IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
	
	class MyFrame extends JFrame implements ActionListener {
		public MyFrame() {
			super("MessengerB");
			
			tF = new JTextField(30);
			tF.addActionListener(this);
			
			tA = new JTextArea(10, 30);
			tA.setEditable(false);
			
			add(tF, BorderLayout.PAGE_END);
			add(tA, BorderLayout.CENTER);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent evt) {
			String s = tF.getText();
			byte[] buffer = s.getBytes();
			DatagramPacket pac;
			
			pac = new DatagramPacket(buffer, buffer.length, addr, uPort);
			
			try {
				soc.send(pac);
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			tA.append("SENT : "+s+"\n");
			tF.selectAll();
			tA.setCaretPosition(tA.getDocument().getLength());
		}
	}		 
	
	public static void main(String[] args) throws IOException {
		MessengerB m = new MessengerB();
		m.process();
	}

}
